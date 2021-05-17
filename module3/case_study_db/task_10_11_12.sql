use case_study_db;

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
--  Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
--  (được tính dựa trên việc count các IDHopDongChiTiet).
select hd.id_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, count(hdct.id_hop_dong) "so_luong"
from hop_dong hd, hop_dong_chi_tiet hdct
where hd.id_hop_dong = hdct.id_hop_dong
group by id_hop_dong
order by count(id_hop_dong) desc;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có 
-- TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select kh.ho_ten, dvdk.ten_dich_vu_di_kem, dvdk.gia, dvdk.don_vi, hdct.so_luong, kh.dia_chi, lk.ten_loai_khach
from dich_vu_di_kem dvdk, hop_dong_chi_tiet hdct,  hop_dong hd, khach_hang kh, loai_khach lk
where (dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
and hdct.id_hop_dong = hd.id_hop_dong
and hd.id_khach_hang = kh.id_khach_hang
and kh.id_loai_khach = lk.id_loai_khach
and kh.dia_chi in ("Vinh", "Quảng Ngãi")
and lk.ten_loai_khach = "Diamond");

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem
-- (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 
-- 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019
select hd.id_hop_dong, nv.ho_ten, kh.ho_ten, kh.sdt, dv.ten_dich_vu, sum(hdct.so_luong) as "so_luong", hd.tien_dat_coc, hd.ngay_lam_hop_dong
from khach_hang kh
join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
join nhan_vien nv on hd.id_nhan_vien = nv.id_nhan_vien
join dich_vu dv on dv.id_dich_vu = hd.id_dich_vu
join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id_hop_dong
join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
where ((year(hd.ngay_lam_hop_dong) = 2019 and month(hd.ngay_lam_hop_dong)>=10)
and hd.id_dich_vu not in (select hd.id_dich_vu
	from hop_dong hd
    where (year(hd.ngay_lam_hop_dong)= 2019 AND month(hd.ngay_lam_hop_dong)<= 6)
))
group by id_hop_dong;