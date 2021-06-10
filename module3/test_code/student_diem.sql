drop database if exists school;
create database school;
use school;
create table students(
	id int auto_increment primary key,
    s_name varchar(45),
    gender varchar(45),
    birthday date,
    email varchar(45),
    address varchar(45),
    `point` double
);
INSERT INTO `school`.`students` (`id`, `s_name`, gender, birthday, `email`, `address`, `point`) VALUES ('1', 'Nam', 'Nam', '2000-12-12', 'nam@gmail.com', 'Hà Nội', '5');
INSERT INTO `school`.`students` (`id`, `s_name`, gender, birthday, `email`, `address`, `point`) VALUES ('2', 'Hau', 'Nam', '2001-01-11', 'hau@gmail.com', 'Đà Nẵng', '4');
INSERT INTO `school`.`students` (`id`, `s_name`, gender, birthday, `email`, `address`, `point`) VALUES ('3', 'Tin', 'Nam', '2002-03-21', 'tin@gmail.com', 'Vinh', '3');
INSERT INTO `school`.`students` (`id`, `s_name`, gender, birthday, `email`, `address`, `point`) VALUES ('4', 'Toan', 'Nam', '2000-04-09', 'toan@gmail.com', 'Huế', '6');
INSERT INTO `school`.`students` (`id`, `s_name`, gender, birthday, `email`, `address`, `point`) VALUES ('5', 'Ha', 'Nam', '2004-10-10', 'ha@gmail.com', 'Đà Nẵng', '10');
INSERT INTO `school`.`students` (`id`, `s_name`, gender, birthday, `email`, `address`, `point`) VALUES ('6', 'Lê văn Hải', 'Nam', '2003-09-12', 'Hai@gmail.com', 'HCM', '10');
INSERT INTO `school`.`students` (`id`, `s_name`, gender, birthday, `email`, `address`, `point`) VALUES ('7', 'Nguyễn Hải Phong', 'Nam', '2005-12-12', 'Phong@gmail.com', 'HCM', '10');
INSERT INTO `school`.`students` (`id`, `s_name`, gender, birthday, `email`, `address`, `point`) VALUES ('8', 'Tấn Hải', 'Nam', '2002-12-12', 'TanHai@gmail.com', 'Hà Nội', '10');
INSERT INTO `school`.`students` (`id`, `s_name`, gender, birthday, `email`, `address`, `point`) VALUES ('9', 'Hải Cẩu', 'Nam', '2001-12-12', 'Cau@gmail.com', 'Hà Nội', '10');
update students 
set s_name = "Phương Nam", gender = "Nữ", brithday = '2000-12-11', email = "nam1@gmai.com", address = "Đà Nẵng", `point` = "7"
where id = 1;
-- delete from students
-- where id = 10;
select * from students;
-- select * from students where (id or `point`) like 6;
-- select s_name
-- from students
-- where (s_name like "Lê%")
-- 	or (s_name like "%Hải");


-- select s_name, ((toan+ly+hoa)/3) as dtb
-- from students
-- where dtb > 5;