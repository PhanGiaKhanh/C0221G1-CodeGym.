create database if not exists `student-management`;
use `student-management`;
create table class (
	id int not null auto_increment primary key,
    `name` varchar(50)
);
insert into class (id, `name`) values
('1','Nguyễn Văn A '),
('2','Nguyễn Văn C '),
('3','Nguyễn Văn B ');

update `student-management`.class
set `name` = "Nuyễn Thị C"
where id = 3;

delete from `student-management`.class
where id = 2;

insert into  `student-management`.class (id, `name`) values
("2" ,"Nguyễn Văn B");

select * from `student-management`.class;

