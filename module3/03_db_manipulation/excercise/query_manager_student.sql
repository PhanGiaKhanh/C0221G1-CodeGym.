use quan_ly_sv;
select * from student;

-- tìm tất cả tên bắt đầu bằng chữ H
select * from student
where name_stu like "H%";

-- lấy data có tháng là 12
select * from class
where month(start_date)=12;

-- lấy tất cả data trong subject có 3 < credit < 5
select * from `subject`
where credit between 3 and 5;

-- thay đổi id_class hưng 1 - 2
update student
set id_class = 2
where id_stu =1;

-- sắp xếp theo thứ tự tăng dần mark 
select s.name_stu, sub.name_sub, m.mark
from student s 
join mark m on s.id_stu= m.id_stu 
join `subject` sub on sub.id_sub = m.id_sub 
order by m.mark;