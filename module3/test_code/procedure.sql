use test_person;
drop procedure if exists p_person;
delimiter //
create procedure p_person (
	in_p_id int ,
    p_name varchar(45),
    p_age date)
    
begin
	if in_p_id  not in (select p_id from person) then  
		insert into person values (in_p_id,p_name,p_age);
	else 
		SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'lỗi trùng id';
    end if;
end; //
delimiter ;

call p_person (5, "Nguễn Văn Hiếu1", "2000-11-25");
SELECT * FROM test_person.person;

