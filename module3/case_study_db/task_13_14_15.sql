use case_study_db;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
create view so_lan_su_dung_dvdk as
	select dvdk.ten_dich_vu_di_kem,sum(hdct.so_luong) as so_lan_su_dung
    from dich_vu_di_kem dvdk, hop_dong_chi_tiet hdct, hop_dong hd
    where (
		dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
        and hdct.id_hop_dong = hd.id_hop_dong
    )
    group by dvdk.ten_dich_vu_di_kem;
    
select ten_dich_vu_di_kem, max(so_lan_su_dung)
from so_lan_su_dung_dvdk;

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung
select hd.id_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, hdct.so_luong -- , count(dvdk.id_dich_vu_di_kem) as "lan_xuat_hien"
from hop_dong hd 
join dich_vu dv on dv.id_dich_vu = hd.id_dich_vu
join loai_dich_vu ldv on ldv.id_loai_dich_vu = dv.id_loai_dich_vu
join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id_hop_dong
join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
group by dvdk.id_dich_vu_di_kem
having count(dvdk.id_dich_vu_di_kem) = 1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, 
-- SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.
select nv.id_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.sdt, nv.dia_chi  , hd.id_hop_dong, year(hd.ngay_lam_hop_dong) as "nam", count(nv.id_nhan_vien) as "so_hd"
from nhan_vien nv
join hop_dong hd on hd.id_nhan_vien = nv.id_nhan_vien
join trinh_do td on td.id_trinh_do = nv.id_trinh_do
join bo_phan bp on bp.id_bo_phan = nv.id_bo_phan
where (
	year(hd.ngay_lam_hop_dong) in (2018,2019)
)
group by nv.id_nhan_vien
having count(nv.id_nhan_vien) <= 3;
