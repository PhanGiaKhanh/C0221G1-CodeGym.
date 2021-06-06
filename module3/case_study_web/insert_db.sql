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
insert into `user` (username, `password`) values
("Admin", "12345678"),
("User", "user12345678"),
("ALong", "12345678"),
("AAnh", "12345678"),
("AHieu", "12345678"),
("AHoang", "12345678"),
("ThiHieu", "12345678"),
("Toan", "12345678"),
("ThiLoan", "12345678"),
("KimAnh", "12345678"),
("KieuNga", "12345678"),
("NgoaMai", "12345678"),
("AThu", "12345678");

-- ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmnd, luong, sdt, email, dia_chi
insert into employee (employee_name, position_id, education_degree_id, division_id, employee_birthday, employee_id_card, employee_salary,
employee_phone, employee_email, employee_address, username) values 
("Nông Văn A", 1, 1, 2, "2000-01-01", "2012312312", "5000000", "0905123123", "vanA@gmail.com", "Đà Nẵng", "ALong"),
("Hoàng Văn Anh", 4, 2, 2, "2001-12-11", "2112312312", "8000000", "0905123234", "anh@gmail.com", "Đà Nẵng", "AAnh"),
("Lê Văn Hiếu", 1, 1,2, "1999-11-11", "2212312312", "5000000", "0905123345", "hieu@gmail.com", "Huế", "AHieu"),
("Thái Văn Hoàng",5, 4 , 1, "1998-08-24", "2312312312", "15000000", "0905567563", "hoang@gmail.com", "HCM", "AHoang"),
("Phan Thị Hiếu", 3, 4, 2, "1988-08-23", "2412312312", "12000000", "0905343563", "thihieu@gmail.com", "Đà Nẵng", "ThiHieu"),
("Nguyễn Văn Toản", 4, 3, 2, "1998-04-17", "2512312312", "7000000", "0905555563", "toan@gmail.com", "Hà Nội", "Toan"),
("Trần Thị Loan", 2, 1, 3,"1996-08-07", "2612312312", "5000000", "0905080563", "loan@gmail.com", "Đà Nẵng", "ThiLoan"),
("Nguyễn Kim Anh", 6, 4, 4,"1993-05-28", "2712312312", "18000000", "0905570563", "anh@gmail.com", "HCM", "KimAnh"),
("Anh Thư", 6, 4, 4,"1994-05-28", "1712312312", "7000000", "0915570563", "anhthu@gmail.com", "Vinh", "AThu"),
("Kiều Nga", 6, 4, 4,"1995-05-28", "2313312312", "6000000", "0925570563", "kieunga@gmail.com", "Quãng Ngãi", "KieuNga"),
("Ngọc Mai", 6, 4, 4,"1997-05-28", "2912312312", "4000000", "0935570563", "ngocmai@gmail.com", "Lào", "NgoaMai");
-- update employee 
-- set employee_name="A",employee_birthday="2000-01-01", employee_id_card = "2012312312", employee_salary= "6000000",
-- employee_phone = "0905123123", employee_email ="vanA@gmail.com", employee_address = "Huế", position_id ="1",
-- education_degree_id ="2", division_id ="1"
-- where employee_id = 1;
-- delete from employee where employee_id =15;
-- select * from employee;

insert into rent_type (rent_type_name, rent_type_cost) values
("Năm", 100000000),
("Tháng", 10000000),
("Ngày", 2000000),
("Giờ", 500000);

-- ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue, id_kieu_thue, id_loai_dich_vu, trang_thai
insert into service (service_name, service_area, number_of_floor, service_max_people, service_cost, 
rent_type_id, service_type_id, standard_room, description_other_convenience
-- , pool_area, number_of_floor
) values

("Villa1", 300, 2, 10, 5000000, 3, 1, "1 sao", "hoạt động"),
("House1", 100, 2, 5, 3000000, 3, 2, "1 sao", "hoạt động"),
("Room1", 80, 2, 3, 1000000, 2, 3, "1 sao", "hoạt động"),
("House2", 100, 2, 6, 3000000, 3, 2, "1 sao", "hoạt động"),
("Villa2", 500, 2, 8, 7000000, 1, 1, "1 sao", "hoạt động"),
("Villa3", 600, 3, 10, 8000000, 2, 1, "1 sao", "hoạt động"),	
("House3", 100, 3, 8, 3000000, 2, 1, "1 sao", "hoạt động"),
("Room2", 100, 3, 6, 1500000, 2, 1, "1 sao", "hoạt động"),
("Room3", 100, 3, 6, 1500000, 2, 1, "1 sao", "hoạt động");
-- select * from customer_use_service;contract_detaileducation_degreecustomer_typecustomer_type
-- id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc
insert into contract (employee_id, customer_id, service_id, contract_start_date, contract_end_date, contract_deposit) values
(1, 1, 1, "2021-01-22", "2021-03-10", 0),
(2, 2, 1, "2021-06-22", "2021-10-10", 0),
(3, 3, 2, "2021-02-22", "2021-12-18", 0),
(3, 3, 2, "2019-04-22", "2021-09-18", 0),
(4, 1, 3, "2020-11-22", "2021-07-11", 0),
(5, 2, 2, "2019-04-22", "2021-10-01", 0),
(6, 2, 5, "2018-06-22", "2020-07-15", 0),
(7, 1, 4, "2019-12-22", "2020-10-19", 0),
(1, 2, 4, "2019-10-22", "2020-10-19", 0),
(1, 3, 8, "2019-02-22", "2020-10-19", 0),
(7, 3, 3, "2019-06-04", "2020-10-19", 0),
(7, 13, 5, "2021-01-22", "2021-10-19", 0),
(7, 14, 4, "2018-09-22", "2020-10-19", 0),
(8, 6, 2, "2020-01-01", "2021-04-16", 0),
(8, 6, 2, "2017-01-01", "2021-04-16", 0),
(8, 6, 2, "2015-01-01", "2021-04-16", 0),
(8, 12, 2, "2016-01-01", "2021-04-16", 0),
(8, 6, 2, "2019-01-01", "2021-04-16", 0)
;
insert into contract (contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id) values
("2021-01-01", "2021-04-16", 2000000, 10000000, 2, 2, 3 );
select*from contract;
-- update contract
-- set contract_start_date = "2021-01-22", contract_end_date ="2021-04-10", contract_deposit = 1000000, contract_total_money = 1, employee_id = "2", customer_id = "1", service_id = "1"
-- where contract_id = 1;-- 
insert into attach_service (attach_service_name, attach_service_cost, attach_service_unit, attach_service_status) 
values ("massage",100, 1000, "mở"),
("karaoke",120, 1000, "mở"),
("thức ăn",50, 1000, "mở"),
("nước uống",10, 1000, "mở"),
("thuê xe",100, 1000, "mở");

-- delete from contract
-- where contract_id = 1;
-- (id_hop_dong, id_dich_vu_di_kem, so_luong)
insert into contract_detail (contract_id, attach_service_id, quantity) values
(1, 1, 2),
(1, 2, 4),
(11, 3, 1),
(11, 1, 5),
(2, 4, 4),
(2, 1, 4),
(6, 2, 5),
(6, 1, 5),
(12, 4, 4),	
(12, 2, 4),	
(5, 3, 6),
(4, 3, 2),
(4, 4, 2),
(7, 3, 4),
(8, 3, 5),
(9, 3, 6),
(3, 5, 1)
;