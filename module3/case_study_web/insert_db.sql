use database_furama;

insert into customer_type(customer_type_name) values
("Diamond"),
("Platinium"),
("Gold"),
("Silver"),
("Member");
	
insert into customer(customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address) values 
(1, "Hoàng Huyền Trang", "2000-01-01", "Nữ", "1231231231", "0905111111", "trang@gmail.com", "Hà Nội"),
(1, "Nguyễn Huyền Trang", "1998-01-01", "Nữ", "2231231231", "0905111112", "trang1@gmail.com", "Vinh"),
(2, "Thái Hoàng Long", "2002-01-01", "Nam", "1231231232", "0905222222", "long@gmail.com", "Đà Nẵng"),
(3, "Hoàng Cường", "1999-01-01", "Nam", "1231231233", "0905333333", "cuong@gmail.com", "HCM"),
(4, "Tấn Công", "1899-01-01", "Nam", "1231231234", "0905444444", "cong@gmail.com", "Huế"),
(5, "Hà Thái Thú", "2006-12-11", "Nam", "1231231235", "090555555", "thu@gmail.com", "Quảng Trị"),
(1, "Ngụy Hàn Tuấn", "2004-11-14", "Nam", "1231231236", "0905666666", "tuan@gmail.com", "Đà Nẵng"),
(2, "Hùng Vương", "1989-05-01", "Nam", "1231231237", "0905777777", "vuong@gmail.com", "Huế"),
(3, "Công Hùng", "1980-04-28", "Nam", "1231231238", "0905888888", "hung@gmail.com", "Quảng Trị"),
(1, "Đào Văn Bá", "2008-12-22", "Nam", "1231231239", "0905999999", "ba@gmail.com", "Đà Nẵng"),
(2, "Thái Hoàng An", "2001-01-01", "Nam", "1231231230", "090555554", "an@gmail.com", "Hà Nội"),
(2, "Thái Hoàng An", "1992-01-01", "Nam", "2341231230", "090355554", "an1@gmail.com", "Đà Nẵng"),
(1, "An Bình", "1994-01-01", "Nữ", "3341231230", "090455554", "anbinh@gmail.com", "Quảng Ngãi"),
(1, "Bỉ Bỉ Đông", "1990-01-01", "Nữ", "4341231230", "090255554", "bibidong@gmail.com", "Vinh");
insert into customer(customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address) values 
(1, "Hoàng Việt Trang", "2000-01-01", "Nữ", "1231231231", "0905111111", "trang@gmail.com", "Hà Nội");
insert into service_type (service_type_name) values
("Villa"),
("House"),
("Room");

insert into position (position_name) values
("Lễ tân"),
("Phục vụ"),
("Chuyên viên"),
("Giám sát"),
("Quản lý"),
("Giám đốc");

insert into education_degree (education_degree_name) values
("Trung cấp"),
("Cao đẳng"),
("Đại học"),
("Sau đại học");

insert into division (division_name) values
("Sale marketing"),
("Hành chính"),
("Phục vụ"),
("Quản lý");


insert into rent_type (rent_type_name, rent_type_cost) values
("Năm", 100000000),
("Tháng", 10000000),
("Ngày", 2000000),
("Giờ", 500000);

insert into service_type (service_type_name) values
("Villa"),
("House"),
("Room");


-- insert into employee (employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address) values