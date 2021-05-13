create database if not exists quan_ly_sv;
use quan_ly_sv;

create table class(
	id_class int not null auto_increment primary key,
    name_class varchar(45) not null,
    start_date date,
    status_class bool
    );
insert into class (name_class, start_date, status_class) values
("A1", '2008-12-20',1),
("A2", '2008-12-20',1),
("B3", current_date(),0);

create table student(
	id_stu int not null auto_increment primary key,
    name_stu varchar(45) not null,
    address varchar(45) not null,
    phone int,
    status_stu bool,
    id_class int,
    foreign key (id_class) references class(id_class)
);

insert into student(name_stu, address, phone, status_stu, id_class) values
("Hung", "Ha Noi", 0912113113,1,1),
("Hoa", "Hai Phong", null,1,1),
("Manh", "HCM", 0123123123,0,2);


create table `subject`(
	id_sub int not null auto_increment primary key,
    name_sub varchar(45) not null,
    credit int not null,
    status_sub bool
);

insert into `subject`(name_sub, credit, status_sub) values
("CF", 5, 1),
("C", 6, 1),
("HDJ", 5, 1),
("RDBMS", 10, 1);

create table mark(
	id_mark int not null auto_increment primary key,
    id_sub int,
    id_stu int,
    foreign key (id_sub) references `subject`(id_sub),
    foreign key (id_stu) references student(id_stu),
    mark int,
    examtimes int
);
insert into mark(id_sub, id_stu, mark, examtimes) values
(1 ,1, 8, 1),
(1 ,2, 10, 2),
(2 ,1, 12, 1);

select * from mark;
select * from `subject`;
select * from student;
select * from class;