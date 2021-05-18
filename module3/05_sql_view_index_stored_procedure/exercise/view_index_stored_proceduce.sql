-- Bước 1: Tạo cơ sở dữ liệu demo
create database if not exists demo;
use demo;
-- drop database demo;

-- Bước 2: Tạo bảng Products với các trường dữ liệu sau:
create table products (
	id int primary key,
    p_code varchar(10),
    p_name varchar(45),
    p_price int,
    p_amount int,
    p_description varchar(45),
    p_status bool
);

insert into products values
(1, "SS-010", "Samsung10", 100, 80, "new", 1),
(2, "IP-007", "Iphone7", 70, 50, "new", 0),
(3, "SS-0A7", "SamsungA7", 50, 40, "new", 0),
(4, "IP-012", "Iphone12", 220, 180, "new", 1),
(5, "SS-020", "Samsung20", 230, 180, "new", 1)
;
-- Bước 3:
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create unique index products_index
on ind_p_code1 (p_code);

alter table products
add unique index ind_p_code2 (p_code);
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index composite_index
on ind_p_name_price1 (p_name, p_price);

alter table products
add index  ind_p_name_price2 (p_name, p_price);
-- Sử dụng câu ệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
-- So sánh câu truy vấn trước và sau khi tạo index
explain select *
from products 
where p_code = "IP-012";

alter table products drop index ind_p_code2;

-- Bước 4:
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view v_thong_tin as
	select p_code, p_name, p_price, p_status
    from products;
    
-- Tiến hành sửa đổi view
update v_thong_tin
set p_price = 200
where p_code = "IP-012";
-- Tiến hành xoá view
delete from v_thong_tin
where p_code = "IP-012";
    
-- Bước 5:
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter // 
create procedure ps_products ()
begin 
	select * from products;
end; //
delimiter ;

call ps_products();
-- Tạo store procedure thêm một sản phẩm mới
delimiter // 
create procedure insert_products (
	inp_id int,
    inp_code varchar(10),
    inp_name varchar(45),
    inp_price int,
    inp_amount int,
    inp_description varchar(45),
    inp_status bool)
begin 
	insert into products values
    (inp_id,
    inp_code,
    inp_name,
    inp_price,
    inp_amount,
    inp_description,
    inp_status);
end; //
delimiter ;

call insert_products(6, "SS-021", "Samsung21", 250, 200, "new", 1) 

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure edit_p_name (
	inp_id int,
    inp_code varchar(10),
    inp_name varchar(45),
    inp_price int,
    inp_amount int,
    inp_description varchar(45),
    inp_status bool)
begin
	update products
    set p_code = inp_code, 
		p_name = inp_name,
        p_price = inp_price,
        p_amount = inp_amount,
        p_description = inp_description,
        p_status = inp_status
    where id = inp_id;
end; //
delimiter ;

call edit_p_name (1, "Ss10", "Samsung10", 80, 80, "newlive", 1);

-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure del_products (inp_id int)
begin
	delete from products
    where id = inp_id;
end; //
delimiter ;

call del_products (1);

select * from v_thong_tin;
select * from products;