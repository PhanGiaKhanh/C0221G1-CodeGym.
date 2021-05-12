create schema `student-management`;
use `student-management`;
create table student(
	id int primary key,
    name varchar(255),
    age int,
    country varchar(255)
);
