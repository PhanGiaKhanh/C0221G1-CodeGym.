create database if not exists case_study_db;
use case_study_db;

create table vi_tri(
	id_vi_tri int not null auto_increment primary key,
    ten_vi_tri varchar(45) not null
);

insert into vi_tri(ten_vi_tri) values
("Lễ tân"),
("Phục vụ"),
("Chuyên viên"),
("Giám sát"),
("Quản lý"),
("Giám đốc");

create table trinh_do(
	id_trinh_do int not null auto_increment primary key,
    ten_trinh_do varchar(45) not null
);

insert into trinh_do(ten_trinh_do) values
("Trung cấp"),
("Cao đẳng"),
("Đại học"),
("Sau đại học");

create table bo_phan(
	id_bo_phan int not null auto_increment primary key,
    ten_bo_phan varchar(45) not null
);

insert into bo_phan(ten_bo_phan)values
("Sale marketing"),
("Hành chính"),
("Phục vụ"),
("Quản lý");

create table nhan_vien(
	id_nhan_vien int not null auto_increment primary key,
    ho_ten varchar(50) not null,
    id_vi_tri int,
    id_trinh_do int,
    id_bo_phan int,
    foreign key (id_vi_tri) references vi_tri(id_vi_tri),
    foreign key (id_trinh_do) references trinh_do(id_trinh_do),
    foreign key (id_bo_phan) references bo_phan(id_bo_phan),
    ngay_sinh  date not null,
    so_cmnd varchar(45) not null,
    luong varchar(45) not null,
    sdt varchar(10) not null,
    email varchar(45) not null,
    dia_chi varchar(45) not null,
    unique(so_cmnd, email, sdt)
);
insert into nhan_vien(ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmnd, luong, sdt, email, dia_chi) values
("Nguyễn Văn A", 1, 1, 2, "2000-01-01", "2012312312", "5000000", "0905123123", "vanA@gmail.com", "Đà Nẵng"),
("Nguyễn Văn Anh", 4, 2, 2, "2001-12-11", "2112312312", "8000000", "0905123234", "anh@gmail.com", "Đà Nẵng"),
("Nguyễn Văn Hiếu", 1, 1,2, "1999-11-11", "2212312312", "5000000", "0905123345", "hieu@gmail.com", "Huế"),
("Nguyễn Văn Hoàng",5, 4 , 1, "1998-08-24", "2312312312", "15000000", "0905567563", "hoang@gmail.com", "HCM"),
("Nguyễn Thị Hiếu", 3, 4, 2, "1988-08-23", "2412312312", "12000000", "0905343563", "thihieu@gmail.com", "Đà Nẵng"),
("Nguyễn Văn Toản", 4, 3, 2, "1998-04-17", "2512312312", "7000000", "0905555563", "toan@gmail.com", "Hà Nội"),
("Nguyễn Thị Loan", 2, 1, 3,"1996-08-07", "2612312312", "5000000", "0905080563", "loan@gmail.com", "Đà Nẵng"),
("Nguyễn Kim Anh", 6, 4, 4,"1993-05-28", "2712312312", "18000000", "0905570563", "anh@gmail.com", "HCM");
create table loai_khach(
	id_loai_khach int not null auto_increment primary key,
    ten_loai_khach varchar(45)
);

insert into loai_khach(ten_loai_khach) values
("Diamond"),
("Platinium"),
("Gold"),
("Silver"),
("Member");

create table khach_hang(
	id_khach_hang int not null auto_increment primary key,
    id_loai_khach int,
    foreign key (id_loai_khach) references loai_khach(id_loai_khach),
    ho_ten varchar(45) not null,
    ngay_sinh date not null,
    so_cmnd varchar(45) not null unique,
    sdt varchar(10) not null,
    email varchar(45) not null unique,
    dia_chi varchar(45) not null
);

insert into khach_hang(id_loai_khach, ho_ten, ngay_sinh, so_cmnd, sdt, email, dia_chi) values 
(1, "Nguyễn Huyền Trang", "2000-01-01", "1231231231", "0905111111", "trang@gmail.com", "Hà Nội"),
(1, "Nguyễn Huyền Trang", "1998-01-01", "2231231231", "0905111112", "trang1@gmail.com", "Vinh"),
(2, "Thái Hoàng Long", "2002-01-01", "1231231232", "0905222222", "long@gmail.com", "Đà Nẵng"),
(3, "Hoàng Cường", "1999-01-01", "1231231233", "0905333333", "cuong@gmail.com", "HCM"),
(4, "Tấn Công", "1899-01-01", "1231231234", "0905444444", "cong@gmail.com", "Huế"),
(5, "Hà Thái Thú", "2006-12-11", "1231231235", "090555555", "thu@gmail.com", "Quảng Trị"),
(1, "Ngụy Hàn Tuấn", "2004-11-14", "1231231236", "0905666666", "tuan@gmail.com", "Đà Nẵng"),
(2, "Hùng Vương", "1989-05-01", "1231231237", "0905777777", "vuong@gmail.com", "Huế"),
(3, "Công Hùng", "1980-04-28", "1231231238", "0905888888", "hung@gmail.com", "Quảng Trị"),
(1, "Đào Văn Bá", "2008-12-22", "1231231239", "0905999999", "ba@gmail.com", "Đà Nẵng"),
(2, "Thái Hoàng An", "2001-01-01", "1231231230", "090555554", "an@gmail.com", "Hà Nội"),
(2, "Thái Hoàng An", "1992-01-01", "2341231230", "090355554", "an1@gmail.com", "Đà Nẵng"),
(1, "An Bình", "1994-01-01", "3341231230", "090455554", "anbinh@gmail.com", "Quảng Ngãi"),
(1, "Bỉ Bỉ Đông", "1990-01-01", "4341231230", "090255554", "bibidong@gmail.com", "Vinh");

create table kieu_thue(
	id_kieu_thue int not null auto_increment primary key,
    ten_kieu_thue varchar(45) not null,
    gia int not null
);
insert into kieu_thue(ten_kieu_thue, gia) values
("năm", 1000),
("tháng", 100),
("ngày", 10),
("giờ", 2);

create table loai_dich_vu(
	id_loai_dich_vu int not null auto_increment primary key,
    ten_loai_dich_vu varchar(45)
);

insert into loai_dich_vu(ten_loai_dich_vu) values
("Villa"),
("House"),
("Room");

create table dich_vu(
	id_dich_vu int not null auto_increment primary key,
    ten_dich_vu varchar(45) not null,
    dien_tich int not null,
    so_tang int not null,
    so_nguoi_toi_da int not null,
    chi_phi_thue int default 0,
    id_kieu_thue int,
    id_loai_dich_vu int,
    foreign key (id_kieu_thue) references kieu_thue(id_kieu_thue),
    foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu),
    trang_thai varchar(45)
);

insert into dich_vu(ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue, id_kieu_thue, id_loai_dich_vu, trang_thai) values 
("Villa1", 300, 2, 10, 5000000, 3, 1, "hoạt động"),
("House1", 100, 2, 5, 3000000, 3, 2, "hoạt động"),
("Room1", 80, 2, 3, 1000000, 2, 3, "hoạt động"),
("House2", 100, 2, 6, 3000000, 3, 2, "hoạt động"),
("Villa2", 500, 2, 8, 7000000, 1, 1, "hoạt động"),
("Villa3", 600, 3, 10, 8000000, 2, 1, "hoạt động"),
("House3", 100, 3, 8, 3000000, 2, 1, "hoạt động"),
("Room2", 100, 3, 6, 1500000, 2, 1, "hoạt động"),
("Room3", 100, 3, 6, 1500000, 2, 1, "hoạt động");

create table dich_vu_di_kem(
	id_dich_vu_di_kem int not null auto_increment primary key,
    ten_dich_vu_di_kem varchar(45) not null,
    gia int default 0,
    don_vi int default 0,
    trang_thai_kha_dung varchar(45)
);

insert into dich_vu_di_kem(ten_dich_vu_di_kem, gia, don_vi, trang_thai_kha_dung) values
("massage",100, 1, "mở"),
("karaoke",120, 1, "mở"),
("thức ăn",50, 1, "mở"),
("nước uống",10, 1, "mở"),
("thuê xe",100, 1, "mở");

create table hop_dong(
	id_hop_dong int not null auto_increment primary key,
    id_nhan_vien int,
    id_khach_hang int,
    id_dich_vu int,
    foreign key (id_nhan_vien) references nhan_vien(id_nhan_vien),
    foreign key (id_khach_hang) references khach_hang(id_khach_hang),
    foreign key (id_dich_vu) references dich_vu(id_dich_vu),
    ngay_lam_hop_dong date,
    ngay_ket_thuc date,
    tien_dat_coc int default 0 ,
    tong_tien int default 0 
);

insert into hop_dong(id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc)values
(1, 1, 1, "2019-01-22", "2020-03-10"),
(2, 2, 1, "2019-03-22", "2021-05-10"),
(3, 3, 2, "2018-02-22", "2020-10-18"),
(4, 1, 3, "2018-01-22", "2019-02-11"),
(5, 2, 2, "2019-04-22", "2021-10-01"),
(6, 2, 5, "2018-06-22", "2020-07-15"),
(7, 1, 4, "2019-09-22", "2020-10-19"),
(7, 2, 4, "2019-09-22", "2020-10-19"),
(7, 3, 8, "2018-09-22", "2020-10-19"),
(7, 3, 3, "2019-06-04", "2020-10-19"),
(7, 13, 5, "2018-09-22", "2020-10-19"),
(7, 14, 4, "2018-09-22", "2020-10-19"),
(8, 6, 2, "2020-01-01", "2021-04-16")
;

create table hop_dong_chi_tiet(
	id_hop_dong_chi_tiet int not null auto_increment primary key,
    id_hop_dong int,
    id_dich_vu_di_kem int,
    so_luong int default 0,
    foreign key (id_hop_dong) references hop_dong(id_hop_dong),
    foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);
	
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values
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
(3, 5, 1)
;

-- select * from vi_tri;
-- select * from trinh_do;
-- select * from bo_phan;
-- select * from dich_vu;
-- select * from dich_vu_di_kem;
-- select * from hop_dong;
-- select * from hop_dong_chi_tiet;
-- select * from khach_hang;
-- select * from kieu_thue;
-- select * from loai_dich_vu;
-- select * from loai_khach;
-- select * from nhan_vien;
