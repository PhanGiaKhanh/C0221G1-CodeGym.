use test_person;

use test_person;
-- Hiển thị tên chứa chữ H, độ dài tên <=15
select *
from person
where p_name like "% H%" 
or p_name like "H%"
having length(p_name) <=15;
-- Hiển thị danh sách id 3 - 10 độ dài tên <=15
select *
from person
where p_id between 3 and 10
having length(p_name) <=15;
-- Sử dụng in và between
select *
from person
where p_id in (1,2,5,6)
having  year(now()) - year(p_age) between 22 and 33;