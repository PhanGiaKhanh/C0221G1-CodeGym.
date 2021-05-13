create database if not exists lesson3;
use lesson3;

create table product(
	id_product int not null auto_increment primary key,
    name_product varchar(50) not null,
    price int not null
);

insert into product (name_product, price) values
("nokia",8),
("samsung",9),
("iphone",9),
("oppo",8),
("meizu",7),
("vsmart",8);

select *
from product
order by price, name_product;

select count(id_product) as id, price
from product
group by price
order by id desc;

select * from product;
	