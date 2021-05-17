use classicmodels;

delimiter //
create procedure findAllCustommers()
begin
	select * from customers;
end //
delimiter ;

-- Cách gọi procedure
call findAllCustommers();

-- drop để xóa procedure
delimiter //
drop procedure if exists findAllCustommers //
create procedure findAllCustommers()
begin
	select * from customers where customerNumber = 175;
end //
    