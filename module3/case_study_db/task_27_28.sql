use case_study_db;

-- 27.	Tạo user function thực hiện yêu cầu sau:
-- a.	Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ.
delimiter //
create function func_1 ()
returns int 
deterministic 
begin
	return (select count(id_dich_vu)
		from hop_dong
        where id_dich_vu in (select dv.id_dich_vu 			
			from hop_dong hd
			join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
			join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
			join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
			group by dv.id_dich_vu
			having sum(dv.chi_phi_thue + hdct.so_luong*dvdk.gia)  > 2000000)
	);        
end; //
delimiter ;

drop function func_1;

select func_1();
-- b.	Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng 
-- đến lúc kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng 
-- thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). 
-- Mã của Khách hàng được truyền vào như là 1 tham số của function này.
delimiter //
create function func_2()
returns int
deterministic 
begin 
	return (select max(datediff(ngay_ket_thuc,ngay_lam_hop_dong) )
	from hop_dong
    group by id_khach_hang);
end; //
delimiter ;    

select func_2();

-- 28.	Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” 
-- từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong 
-- bảng DichVu) và xóa những HopDong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng 
-- HopDong) và những bản liên quan khác.
