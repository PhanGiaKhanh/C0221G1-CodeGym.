use demo;

DELIMITER $$
create procedure get_by_all()
begin
	select * from users;
end$$
DELIMITER ;

call  get_by_all();

DELIMITER $$
create procedure edit_user(
in in_id int,
in in_name varchar(45),
in in_email varchar(45),
in in_country varchar(45)
)
begin
	update users
    set `name`= in_name, email = in_email, country = in_country
    where id = in_id;
end $$
DELIMITER ;

call edit_user(2, "Khanh", "khanh@gmail", "vn");

DELIMITER $$
create procedure delete_user(in in_id int)
begin
	delete from users
    where id = in_id;
end$$
DELIMITER ;


call delete_user(2);