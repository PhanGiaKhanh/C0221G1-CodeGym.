use internship;

-- 1.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của tất cả các giảng viên
select i_id as ma_so, i_name as ho_ten, f.f_name as ten_hoa
from instructor i
left join faculty f on f.f_id = i.f_id;

-- 2.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của các giảng viên của khoa
--  ‘Khoa Toán va Khoa Lý’
select i_id as ma_so, i_name as ho_ten, f.f_name as ten_hoa
from instructor i
left join faculty f on f.f_id = i.f_id
where f_name in ("Khoa Toán", "Khoa Lý");

-- 3.	Cho biết số sinh viên của khoa ‘Khoa Toán’
select f.f_name, count(s_id) as so_sv
from student s
join faculty f on f.f_id = s.f_id
where f.f_name = "Khoa Toán"
group by s.f_id;

-- 4.	Đưa ra danh sách gồm mã số, họ tên và tuổi của các sinh viên khoa ‘TOAN’
select s.s_id, s.s_name as ho_ten, s.date_of_birth as tuoi, f.f_name as ten_khoa
from student s
join faculty f on f.f_id = s.f_id
where f.f_name = "Khoa Toán";

-- 5.	Cho biết số giảng viên của khoa ‘Khoa Toán’
select  f.f_name as ten_hoa, count(i.i_name) as so_giang_vien
from instructor i
left join faculty f on f.f_id = i.f_id
where f_name = "Khoa Toán"
group by f.f_id;

-- 6.	Cho biết thông tin về sinh viên không tham gia thực tập
select *
from student 
where s_id not in (
	select s_id
	from instructor_student
);

-- 7.	Đưa ra mã khoa, tên khoa và số giảng viên của mỗi khoa
select f.f_id as ma_khoa, f.f_name as ten_khoa, count(i.i_id) as so_giang_vien
from faculty f
join instructor i on i.f_id = f.f_id
group by f.f_id;

-- 8.	Cho biết số điện thoại của khoa mà sinh viên có tên ‘Nguễn Văn Hiếu’ đang theo học
select s.s_name, f.phone
from student s
join faculty f on f.f_id = s.f_id
where s.s_name = "Nguễn Văn Hiếu";
