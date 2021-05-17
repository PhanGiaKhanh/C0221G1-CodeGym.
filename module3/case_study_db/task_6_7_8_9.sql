use case_study_db;

-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của 
-- tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt 
-- từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, hd.ngay_lam_hop_dong, ldv.ten_loai_dich_vu
from dich_vu dv
join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
join hop_dong hd on hd.id_dich_vu = dv.id_dich_vu
where dv.id_dich_vu not in (select hd.id_dich_vu 
	from hop_dong hd
    where (month(ngay_lam_hop_dong) in (1,2,3) and year(ngay_lam_hop_dong) = 2019 ));

-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
-- nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
select dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.dien_tich, dv.chi_phi_thue, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu, hd.ngay_lam_hop_dong
from dich_vu dv
join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
join hop_dong hd on hd.id_dich_vu = dv.id_dich_vu
where (year(ngay_lam_hop_dong) = 2018
and dv.id_dich_vu not in (
	select id_dich_vu 
	from hop_dong
	where year(ngay_lam_hop_dong) = 2019)
);

 
--  8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
-- cách 1
select kh.ho_ten
from khach_hang kh
group by ho_ten;
-- cách 2
select distinct kh.ho_ten
from khach_hang kh;
-- cách 3
select distinctrow kh.ho_ten
from khach_hang kh;
-- cách 4
select kh.ho_ten
from khach_hang kh
union  -- kết hợp 2 bảng, xóa kq trung lặp
select kh.ho_ten
from khach_hang kh;
-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019
--  thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
 create view doanh_thu_dv_dvdk as
 -- doanh thu bên dịch vụ
 select kh.ho_ten, year(hd.ngay_lam_hop_dong) as years, month(hd.ngay_lam_hop_dong) as months,(dv.chi_phi_thue)
 from khach_hang kh
 join hop_dong hd on hd.id_khach_hang = kh.id_khach_hang
 join dich_vu dv on dv.id_dich_vu = hd.id_dich_vu
 group by months
 union all
 -- doanh thu bên dịch vụ đi kèm
 select kh.ho_ten, year(hd.ngay_lam_hop_dong) as years, month(hd.ngay_lam_hop_dong) as months ,sum(dvdk.gia*hdct.so_luong) as "doanh_thu_dvdk"
 from khach_hang kh
 join hop_dong hd on hd.id_khach_hang = kh.id_khach_hang
 join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id_hop_dong
 join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
 group by months;
 
 select ho_ten, years, months, sum(chi_phi_thue) as tong_doanh_thu
 from  doanh_thu_dv_dvdk
 group by months
 order by months;