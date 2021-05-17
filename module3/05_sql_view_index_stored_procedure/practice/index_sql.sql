use classicmodels;

 -- tìm thông tin của khách hàng có tên là Land Of Toys Inc.
select * 
from customers 
where customerName = "Land of Toys Inc.";

-- sử dụng lệnh EXPLAIN
explain select *
from customers 
where customerName = "Land of Toys Inc.";

-- thêm chỉ mục cho bảng customers
alter table customers 
add index idx_customerName(customerName);

--  Add index theo cặp như bạn add index cho cặp contactFirstName và contactLastName
alter table customers
add index idx_full_name(contactFirstName, contactLastName);

explain select * 
from customers
where contactFirstName = 'Jean' or contactFirstName = 'King';

-- xoá chỉ mục trong bảng
alter table customers drop index idx_full_name;