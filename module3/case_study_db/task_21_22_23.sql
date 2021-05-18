use case_study_db;

-- 21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả 
-- các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho 1 hoặc nhiều 
-- Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”
create view v_nhan_vien as
	select * 
    from nhan_vien
    where dia_chi = "Hải Châu" 
		and id_nhan_vien in (
			select id_nhan_vien
			from hop_dong 
            where ngay_lam_hop_dong = "2019-12-12"
		);

-- 22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành 
-- “Liên Chiểu” đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.
select * from v_nhan_vien;
update v_nhan_vien
set dia_chi = "Liên Chiểu";

-- 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó
--  với Id Khách hàng được truyền vào như là 1 tham số của Sp_1
delimiter //
create procedure sp_1 (sp_id int)
begin
	delete from khach_hang
    where id_khach_hang = sp_id;
end; //
delimiter ;


