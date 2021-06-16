Drop database if exists cms;
create database cms;
use cms;

create table customers(
	id int primary key,
    c_name varchar(45),
    email varchar(45),
    address varchar(45)
);