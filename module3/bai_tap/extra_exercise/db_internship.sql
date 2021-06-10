create database if not exists internship;
use internship;

create table faculty (
	f_id int not null primary key,
    f_name varchar(30),
    phone int(10)
);

create table instructor (
	i_id int not null primary key,
    i_name varchar(45),
    salary float,
    f_id int,
    foreign key (f_id) references faculty(f_id) 
);

create table student (
	s_id int not null primary key,
    s_name varchar(40),
    date_of_birth date,
    place_of_birth varchar(30),
    f_id int,
    foreign key (f_id) references faculty(f_id) 
);

create table project (
	p_id int not null primary key,
    p_name varchar(30),
    expense int,
    place_of_intern varchar(30)
);

create table instructor_student (
	s_id int,
    i_id int,
    p_id int,
    grade float,
    foreign key (s_id) references student(s_id),
    foreign key (i_id) references instructor(i_id),
    foreign key (p_id) references project(p_id)
);

