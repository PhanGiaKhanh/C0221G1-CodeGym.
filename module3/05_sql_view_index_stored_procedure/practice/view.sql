use classicmodels;

-- Tạo view có tên customer_views
create view customer_views as
select customerNumber, customerName, phone
from customers;

-- Lấy data từ bảng ảo customer_views
select * from customer_views;

-- Cập nhật cho view
create or replace view customer_views as
select customerNumber, customerName, contactFirstName, contactLastName, phone
from customers
where city = "Nantes";

-- Xóa view
drop view customer_views;