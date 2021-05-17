use case_study_db;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
select nv.ho_ten, year(hd.ngay_lam_hop_dong)
from nhan_vien nv, hop_dong hd
where nv.id_nhan_vien = hd.id_nhan_vien;

delete from nhan_vien
where id_nhan_vien not in (
	select id_nhan_vien
    from hop_dong
    where year(ngay_lam_hop_dong) in ( 2017, 2018, 2019 )
);

-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond,
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 
-- là lớn hơn 10.000.000 VNĐ
select kh.id_khach_hang, kh.ho_ten , sum(dv.chi_phi_thue + hdct.so_luong*dvdk.gia ) as tong_tien,year(hd.ngay_lam_hop_dong) as year_hd
from khach_hang kh
join loai_khach lk on lk.id_loai_khach = kh.id_loai_khach
join hop_dong hd on hd.id_khach_hang = kh.id_khach_hang
left join dich_vu dv on dv.id_dich_vu = hd.id_dich_vu
join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id_hop_dong
join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_hop_dong_chi_tiet
where (
	year(hd.ngay_lam_hop_dong) =2019
)
group by hd.id_hop_dong
having tong_tien > 10000000;

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).
delete
from khach_hang
where id_khach_hang in (
	select id_khach_hang
    from hop_dong
    where year(ngay_lam_hop_dong) < 2016
);



