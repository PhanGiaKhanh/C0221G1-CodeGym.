use quan_ly_sv;

select * from student;

select * 
from student
where status_stu = true;

select * 
from `subject`
where credit <10;

select S.id_stu, S.name_stu, C.name_class
from student S join class C on S.id_class = C.id_class;

select S.id_stu, S.name_stu, C.name_class
from student S join class C on S.id_class = c.id_class
where name_class = "A1";

select S.id_stu, S.name_stu, Sub.name_sub, M.mark
from student S 
join mark M on S.id_stu = M.id_stu 
join `subject` Sub on M.id_sub = Sub.id_sub;

select S.id_stu, S.name_stu, Sub.name_sub, M.mark
from student S 
join mark M on S.id_stu = M.id_stu 
join `subject` Sub on M.id_sub = Sub.id_sub
where Sub.name_sub = "CF";