use test_person;

create view person_view as
select *
from person;

insert into person values
	(14, "Đoàn Dự", "2000-11-25");

update person_view
set p_name = "Nguyễn Huệ"
where p_id = 13;

update person
set p_name = "Quôc Hưng"
where p_id = 12;

delete from person_view 
where p_id = 14;

drop view person_view;