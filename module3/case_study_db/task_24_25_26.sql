use case_study_db;

-- 24.	Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với 
-- yêu cầu Sp_2 phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung,
--  với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham 
--  chiếu đến các bảng liên quan.

delimiter //
create procedure sp_2 (	
	inp_id_hop_dong int,
    inp_id_nhan_vien int,
    inp_id_khach_hang int,
    inp_id_dich_vu int,
    inp_ngay_lam_hop_dong date,
    inp_ngay_ket_thuc date,
    inp_tien_dat_coc int,
    out result varchar(45))

begin
	if (inp_id_hop_dong not in ( select id_hop_dong from hop_dong)) then
		insert into hop_dong (
			id_hop_dong,
			id_nhan_vien,
			id_khach_hang,
			id_dich_vu,
			ngay_lam_hop_dong,
			ngay_ket_thuc,
			tien_dat_coc	
		) values (
			inp_id_hop_dong,
			inp_id_nhan_vien,
			inp_id_khach_hang,
			inp_id_dich_vu,
			inp_ngay_lam_hop_dong,
			inp_ngay_ket_thuc,
			inp_tien_dat_coc	
		);
        set result = "Nhập thành công dữ liệu";
    else
		set result = "id_hop_dong đã tồn tại";
	end if;
end; //
delimiter ;

-- 25.	Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển 
-- thị tổng số lượng bản ghi còn lại có trong bảng HopDong ra giao diện 
-- console của database
delimiter //
create trigger tr_1
after delete
on hop_dong for each row
begin
	set @result = (select count(*) from hop_dong);
end; //
delimiter ;
-- drop trigger tr_1;
select * from hop_dong;

delete from hop_dong
where id_hop_dong = 18;

select @result as so_luong;
-- 26.	Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần 
-- kiểm tra xem thời gian cập nhật có phù hợp hay không, với quy tắc sau: 
-- Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày.
delimiter //
create trigger tr_2
after update
on hop_dong for each row
begin
	if (datediff(new.ngay_ket_thuc,old.ngay_lam_hop_dong) <2) then
		set @kq="phù hợp";
	else 
		set @kq="không phù hợp";
	end if;
end; //
delimiter ;
drop trigger tr_2;
select @kq
 
