use quan_ly_sv;
select * from class;
select * from mark;
select * from student;
select * from `subject`;

--  Sử dụng hàm count để hiển thị số lượng sinh viên ở từng nơi
select address, count(id_stu) as "so_luong_hoc_vien"
from student
group by address;

-- Tính điểm trung bình các môn học của mỗi học viên bằng cách sử dụng hàm AVG
select s.id_stu, s.name_stu, avg(mark)
from student s join mark m on s.id_stu = m.id_stu
group by s.id_stu, s.name_stu;

-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
select s.id_stu, s.name_stu, avg(mark)
from student s join mark m on s.id_stu = m.id_stu
group by s.id_stu, s.name_stu
having avg(mark)>9;

-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
select s.id_stu, s.name_stu, avg(mark)
from student s join mark m on s.id_stu = m.id_stu
group by s.id_stu, s.name_stu
having avg(mark)>= all (select avg(mark) from mark group by mark.id_stu);

