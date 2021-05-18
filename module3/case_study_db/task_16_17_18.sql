use case_study_db;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
delete from nhan_vien
where id_nhan_vien not in (
	select id_nhan_vien
    from hop_dong
    where year(ngay_lam_hop_dong) in ( 2017, 2018, 2019 )
);

-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond,
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 
-- là lớn hơn 10.000.000 VNĐ
create view tong_tien_theo_thang_dv_dvdk as
-- tổng tiền theo tháng dv
select kh.ho_ten, lk.ten_loai_khach, month(ngay_lam_hop_dong) as months, hd.ngay_lam_hop_dong, sum(dv.chi_phi_thue) as tong_tien 
from hop_dong hd 
join dich_vu dv on dv.id_dich_vu = hd.id_dich_vu
join khach_hang kh on kh.id_khach_hang = hd.id_khach_hang
join loai_khach lk on lk.id_loai_khach = kh.id_loai_khach
group by kh.id_khach_hang
union all
-- tổng tiền theo tháng dvdk
select kh.ho_ten, lk.ten_loai_khach, month(ngay_lam_hop_dong) as months, hd.ngay_lam_hop_dong, sum(dvdk.gia*hdct.so_luong) as tong_tien
from hop_dong hd
join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id_hop_dong
join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
join khach_hang kh on kh.id_khach_hang = hd.id_khach_hang
join loai_khach lk on lk.id_loai_khach = kh.id_loai_khach
group by kh.id_khach_hang;

select ho_ten, ten_loai_khach, sum(tong_tien) as tong
from tong_tien_theo_thang_dv_dvdk
where (
	year(ngay_lam_hop_dong) = 2019
)
group by months
having tong > 10000000;


-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).
delete from khach_hang
where id_khach_hang in (
	select id_khach_hang
    from hop_dong
    where year(ngay_lam_hop_dong) < 2016
);
-- sử dụng lệnh dưới cho các khóa ngoại >> xóa luôn các ràng buộc 
--     on delete cascade
