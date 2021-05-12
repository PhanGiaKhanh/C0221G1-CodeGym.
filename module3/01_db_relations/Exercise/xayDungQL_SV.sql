create database if not exists `student-management`;
use `student-management`;
create table Class (
	id int primary key,
    name varchar(255)
);

create table Teacher (
	id int primary key,
    name varchar(255),
    age int,
    country varchar(255)
);