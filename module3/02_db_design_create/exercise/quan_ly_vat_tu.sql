create database if not exists quan_ly_vat_tu;
use quan_ly_vat_tu;

create table nha_cung_cap(
	ma_ncc varchar(20) not null primary key,
    ten_ncc varchar(45) not null,
    dia_chi varchar(45) not null,
    phone varchar(10)
);

create table don_dat_hang(
	so_dh int not null primary key,
    ngay_dh date not null,
    ma_ncc varchar(20),
    foreign key (ma_ncc) references nha_cung_cap(ma_ncc)
);

create table phieu_nhap(
	so_pn int not null primary key,
    ngay_nhap date,
    don_gia_nhap int not null
);


create table vat_tu(
	ma_vt int not null primary key,
    ten_vt varchar(45) not null,
    so_luong int not null
);

create table chi_tiet_phieu_nhap(	
	ma_vt int,
    so_pn int,
    primary key(ma_vt,so_pn),
    foreign key (ma_vt) references vat_tu(ma_vt),
    foreign key (so_pn) references phieu_nhap(so_pn),
	dg_nhap int,
    sl_nhap int
);

create table phieu_xuat(
	so_px int not null primary key,
    ngay_xuat date not null,
    don_gia int not null
);

create table chi_tiet_phieu_xuat(
	ma_vt int,
    so_px int,
    primary key(ma_vt,so_px),
    foreign key (ma_vt) references vat_tu(ma_vt),
    foreign key (so_px) references phieu_xuat(so_px),
	dg_xuat int,
    sl_xuat int
);

create table chi_tiet_don_dat_hang(
	ma_vt int,
    so_dh int,
    primary key(ma_vt, so_dh),
    foreign key (ma_vt) references vat_tu(ma_vt),
    foreign key (so_dh) references don_dat_hang(so_dh)
);
