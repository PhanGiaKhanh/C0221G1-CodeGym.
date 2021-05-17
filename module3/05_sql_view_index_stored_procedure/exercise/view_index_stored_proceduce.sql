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
on products (p_code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index composite_index
on products (p_name, p_price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào

-- So sánh câu truy vấn trước và sau khi tạo index

-- Bước 4:
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
-- Tiến hành sửa đổi view
-- Tiến hành xoá view

-- Bước 5:
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
-- Tạo store procedure thêm một sản phẩm mới
-- Tạo store procedure sửa thông tin sản phẩm theo id
-- Tạo store procedure xoá sản phẩm theo id