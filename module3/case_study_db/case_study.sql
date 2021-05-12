create database if not exists case_study_db;
use case_study_db;

create table vi_tri(
	id_vi_tri int not null auto_increment primary key,
    ten_vi_tri varchar(45) not null
);

create table trinh_do(
	id_trinh_do int not null auto_increment primary key,
    ten_trinh_do varchar(45) not null
);

create table bo_phan(
	id_bo_phan int not null auto_increment primary key,
    ten_bo_phan varchar(45) not null
);

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

create table loai_khach(
	id_loai_khach int not null auto_increment primary key,
    ten_loai_khach varchar(45)
);


create table khach_hang(
	id_khach_hang int not null auto_increment primary key,
    id_loai_khach int,
    foreign key (id_loai_khach) references loai_khach(id_loai_khach),
    ho_ten varchar(45) not null,
    ngay_sính date not null,
    so_cmnd varchar(45) not null unique,
    sdt varchar(10) not null,
    email varchar(45) not null unique,
    dia_chi varchar(45) not null
);

create table kieu_thue(
	id_kieu_thue int not null auto_increment primary key,
    ten_kieu_thue varchar(45) not null,
    gia int not null
);

create table loai_dich_vu(
	id_loai_dich_vu int not null auto_increment primary key,
    ten_loai_dich_vu varchar(45)
);

create table dich_vu(
	id_dich_vu int not null auto_increment primary key,
    ten_dich_vu varchar(45) not null,
    dien_tich int not null,
    so_tang int not null,
    so_nguoi_toi_da int not null,
    chi_phi_thue varchar(45),
    id_kieu_thue int,
    id_loai_dich_vu int,
    foreign key (id_kieu_thue) references kieu_thue(id_kieu_thue),
    foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu),
    trang_thai varchar(45)
);

create table dich_vu_di_kem(
	id_dich_vu_di_kem int not null auto_increment primary key,
    ten_dich_vu_di_kem varchar(45) not null,
    gia int not null,
    don_vi int not null,
    trang_thai_kha_dung varchar(45)
);

create table hop_dong(
	id_hop_dong int not null auto_increment primary key,
    id_nhan_vien int,
    id_khach_hang int,
    id_dich_vu int,
    foreign key (id_nhan_vien) references nhan_vien(id_nhan_vien),
    foreign key (id_khach_hang) references khach_hang(id_khach_hang),
    foreign key (id_dich_vu) references dich_vu(id_dich_vu),
    ngay_lam_hop_dong date not null,
    ngay_ket_thuc date not null,
    tien_dat_coc int not null,
    tong_tien int not null
);
create table hop_dong_chi_tiet(
	id_hop_dong_chi_tiet int not null auto_increment primary key,
    id_hop_dong int,
    id_dich_vu_di_kem int,
    so_luong int not null,
    foreign key (id_hop_dong) references hop_dong(id_hop_dong),
    foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);


