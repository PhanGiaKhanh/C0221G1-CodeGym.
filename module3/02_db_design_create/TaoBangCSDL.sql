create database QuanLyDiemThi;
use QuanLyDiemThi;

create table person(
	id_person int not null auto_increment primary key,
	name_person varchar(45),
    sdt int
);
drop table person;
alter table person
add age int not null
after name_person;

alter table person
drop age;

update  person 
set age = 2
where sdt = 3;
select * from person
limit 5;
insert into person (name_person, sdt) values
("khanh", 12),
("khanh", 11),
("khanh", 1),
("khanh", 1),
("khanh", 1);
create table HocSinh (
	MaHS varchar(20) primary key,
    TenHS varchar(50),
    NgaySinh datetime,
    Lop varchar(20),
    GT varchar(20)
);

create table MonHoc (
	MaMH varchar(20) primary key,
    TenMH varchar(50)
);

create table BangDiem (
	MaHS varchar(20),
    MaMH varchar(20),
    DiemThi int,
    NgayKT datetime,
    primary key (MaHS, MaMH),
    foreign key (MaHS) references HocSinh(MaHS),
    foreign key (MaMH) references MonHoc(MaMH)
);

create table GiaoVien (
	MaGV varchar(20) primary key,
    TenGV varchar(50),
    SDT varchar(20)
);

alter table MonHoc add MaGV varchar(20);
alter table MonHoc add constraint FK_MaGV foreign key (MaGV) references GiaoVien(MaGV);

select * from QuanLyDiemThi.bangdiem;
