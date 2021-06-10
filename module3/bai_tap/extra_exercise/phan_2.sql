use internship;

-- 1.	Cho biết mã số và tên của các đề tài do giảng viên ‘Lê Văn Luyện’ hướng dẫn
select p.p_id as ma_so, p.p_name as ten, i.i_name as ten_giang_vien 
from instructor i
join instructor_student ist on ist.i_id = i.i_id
join project p on p.p_id = ist.p_id
where i.i_name = "Lê Văn Luyện";

-- 2.	Cho biết tên đề tài không có sinh viên nào thực tập
select * 
from project 
where p_id not in (
	select p_id
	from instructor_student 
);

-- 3.	Cho biết mã số, họ tên, tên khoa của các giảng viên hướng dẫn từ 2 
-- sinh viên trở lên.
select i.i_id as ma_so, i.i_name as ho_ten, f.f_name as ten_khoa
from instructor i
join faculty f on i.f_id = f.f_id
join instructor_student ist on ist.i_id = i.i_id
group by i.i_id
having count(ist.s_id) >= 2;

-- 4.	Cho biết mã số, tên đề tài của đề tài có kinh phí cao nhất
select p_id, p_name
from project p
where expense >= all ( select max(expense) from project);

-- 5.	Cho biết mã số và tên các đề tài có nhiều hơn 2 sinh viên tham gia thực tập
select p.p_id as ma_so, p.p_name as ten_de_tai
from project p
join instructor_student ist on ist.p_id = p.p_id
join student s on ist.s_id = s.s_id
group by ist.p_id
having count(ist.s_id) >= 2;

-- 6.	Đưa ra mã số, họ tên và điểm của các sinh viên khoa ‘Toán và Lý’
select s.s_id as ma_so, s.s_name as ho_ten, ist.grade as diem
from student s
join instructor_student ist on ist.s_id = s.s_id
join faculty f on f.f_id = s.f_id
where f.f_name in ("Khoa Toán", "Khoa Lý");

-- 7.	Đưa ra tên khoa, số lượng sinh viên của mỗi khoa
select f.f_name as ten_khoa, count(s.s_id) as so_sinh_vien
from  faculty f
join student s on s.f_id = f.f_id
join instructor_student ist on ist.s_id = s.s_id
group by f.f_id;

-- 8.	Cho biết thông tin về các sinh viên thực tập tại quê nhà
select s.s_id, s.s_name , s.place_of_birth, s.date_of_birth
from student s 
join instructor_student ist on ist.s_id = s.s_id
join project p on p.p_id = ist.p_id = p.p_id
where s.place_of_birth = p.place_of_intern;


-- 9.	Hãy cho biết thông tin về những sinh viên chưa có điểm thực tập
select *
from student 
where s_id not in (select s_id from instructor_student);


-- 10.	 Đưa ra danh sách gồm mã số, họ tên các sinh viên có điểm thực tập bằng 0
select s.s_id as ma_so, s.s_name as ho_ten
from student s
join instructor_student ist on ist.s_id = s.s_id
where ist.grade = 0;

