drop database if exists manage_employee;
create database manage_employee;

-- mã nhân viên, tên nhân viên, ngày sinh.
create table employee (
	id int auto_increment primary key,
    e_code varchar(45),
    e_name varchar(45),
    birthday date
);

INSERT INTO `manage_employee`.`employee` (`id`, `e_code`, `e_name`, `birthday`) VALUES ('1', '01', 'Thanh Tùng', '2000-12-12');
INSERT INTO `manage_employee`.`employee` (`id`, `e_code`, `e_name`, `birthday`) VALUES ('2', '02', 'Dương Quá', '2000-01-01');
