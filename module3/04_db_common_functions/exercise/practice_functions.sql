use quan_ly_sv;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * 
from `subject`
where credit = (select max(credit) from `subject`);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select *
from `subject`
where id_sub in (
	select id_sub
	from mark
    where mark = (select max(mark) from mark)
);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên,
--  xếp hạng theo thứ tự điểm giảm dần
select s.name_stu, s.address, s.phone, avg(m.mark) as "avg", count(m.id_sub) as "count_subject"
from student s
left join mark m on m.id_stu = s.id_stu
group by s.name_stu


