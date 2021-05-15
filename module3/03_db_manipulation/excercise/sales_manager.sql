create database if not exists sales_management;
use sales_management;

create table customer(
	c_id int primary key,
    c_name varchar(25),
    c_age tinyint
);

insert into customer values
(1,"Minh Quan", 10),
(2,"Ngoc Oanh", 20),
(3,"Hong Ha", 50);

create table `order`(
	o_id int primary key,
    c_id int,
    o_date date,
    o_total_price int,
    foreign key (c_id) references customer(c_id)
);

insert into `order` values
(1, 1, '2006-03-21',null),
(2, 2, '2006-03-23',null),
(3, 1, '2006-03-16',null);

create table product (
	p_id int primary key,
    p_name varchar(25),
    p_price int
);

insert into product values
(1, "May Giat", 3),
(2, "Tu Lanh", 5),
(3, "Dieu Hoa", 7),
(4, "Quat", 1),
(5, "Bep Dien", 2);

create table order_detail(
	o_id int,
    p_id int,
    od_qty int,
    foreign key (o_id) references `order`(o_id),
    foreign key (p_id) references product(p_id)
);

insert into order_detail values
(1, 1, 3),
(1, 3, 7),
(1, 4, 2),
(2, 1, 1),
(3, 1, 8),
(2, 5, 4),
(2, 3, 3);

select * from customer;
select * from `order`;
select * from product;
select * from order_detail;

-- Hiển thị các thông tin  gồm oID, oDate, oPrice bảng Order
select o.o_id, o.o_date, p.p_price, count(o_date) as "so_luong"
from `order` o, order_detail od, product p
where o.o_id = od.o_id
and p.p_id = od.o_id
group by o.o_id, o.o_date, p.p_price;

-- select o.o_id, o.o_date, p.p_price, count(o_date) as "số lượng"
-- from `order` o 
-- join order_detail od on o.o_id = od.o_id
-- join product p on p.p_id = od.o_id
-- group by o.o_id, o.o_date, p.p_price;
 
 -- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select o.c_id, c.c_name, p.p_name, count(p_name) as "so_luong"
from customer c, `order` o, product p, order_detail od
where c.c_id = o.c_id 
and o.o_id = od.o_id 
and od.p_id = p.p_id
group by  o.c_id, c.c_name, p.p_name;


-- select o.c_id, c.c_name, p.p_name, count(p_name) as "số lượng"
-- from customer c
-- inner join `order` o on c.c_id = o.c_id
-- inner join order_detail od on o.o_id = od.o_id
-- inner join product p on p.p_id = od.p_id
-- group by o.c_id, c.c_name, p.p_name;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
-- select c.c_name
-- from customer c
-- where not exists 
-- (select o.c_id from `order` o where  o.c_id = c.c_id );

select c.c_name
from customer c left join  `order` o 
on o.c_id = c.c_id
where o.c_id is null;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn
select o.o_id, o.o_date, sum(p.p_price* od_qty) as "price"
from  `order` o, product p, order_detail od
where o.o_id = od.o_id 
and od.p_id = p.p_id
group by  o.o_id, o.o_date;