create database if not exists test_person;
use test_person;

create table person(
	p_id int primary key,
    p_name varchar(45),
    p_age date
);

insert into person values
	(1, "Nguễn Văn Hiếu", "2000-11-25"),
	(2, "Thái Hoàng Long", "1990-06-25"),
	(3, "Đông Phương", "1980-07-01"),
	(4, "Lan Ý Nguyên", "1997-09-09"),
	(5, "Phương Đông", "1996-10-14"),
	(6, "Hùng Vương", "1993-12-27"),
	(7, "Chương Hiền Anh", "2002-02-02"),
	(8, "Thái Anh Văn", "2004-05-12"),
	(9, "Trần Văn Cường", "1995-11-18")
;
insert into person value
	-- (10, "Hưng Yên", "2000-11-25"),
-- 	(11, "Huệ", "1990-06-25");
    (12, "Hưng1", "2000-11-25"),
	(13, "Huệ2", "1990-06-25");


create table class (
	c_id int auto_increment primary key,
    c_name varchar(40)
);

insert into class (c_name) values
("Toán"),
("Lý"),
("Hóa"),
("Anh Văn"),
("Sinh Học");