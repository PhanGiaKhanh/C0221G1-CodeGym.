Drop database if exists cms;
create database cms;
use cms;

create table customers(
	id int primary key,
    c_name varchar(45),
    email varchar(45),
    address varchar(45)
);

create table `comment`(
	id int auto_increment primary key,
    `start` varchar(45),
    `name` varchar(45),
    feedback varchar(200)
);

DELIMITER //
CREATE PROCEDURE Insert_Customer(IN first_name VARCHAR(255), IN last_name VARCHAR(255))
BEGIN
    INSERT INTO customers(firstName,lastName) VALUES (first_name,last_name);
END//
DELIMITER ;