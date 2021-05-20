use internship;

insert into faculty values 
(1, "Khoa Toán", 1231231231),
(2, "Khoa Hóa", 231231232),
(3, "Khoa Sinh", 331231233),
(4, "Khoa Văn", 431231234),
(5, "Khoa Sử", 531231235),
(6, "Khoa Lý", 631231236)
;

insert into student values
	(1, "Nguễn Văn Hiếu", "2000-11-25", "Hải Châu", 1),
	(2, "Thái Hoàng Long", "1990-06-25", "Liên Chiểu", 2),
	(3, "Đông Phương", "1980-07-01", "Liên Chiểu", 2),
	(4, "Lan Ý Nguyên", "1997-09-09", "Cẩm Lệ", 1),
	(5, "Phương Đông", "1996-10-14", "Hải Châu", 3),
	(6, "Hùng Vương", "1993-12-27", "Hải Châu", 4),
	(7, "Chương Hiền Anh", "2002-02-02", "Liên Chiểu", 1),
	(8, "Thái Anh Văn", "2004-05-12", "Hải Châu", 4),
	(9, "Trần Văn Cường", "1995-11-18", "Cẩm lệ", 3),
	(10, "Bỉ Đông", "1995-11-18", "Cẩm lệ", 2),
    (11, "Nguễn Văn Hiếu", "2000-11-25", "Hải Châu", 1)
;

insert into instructor values 
	(1, "Lê Văn Luyện", 10, 1),
	(2, "Minh Đạo", 8000000, 2),
	(3, "Ngô Thừa Ân", 7000000, 3),
	(4, "Ngọc Trinh", 9000000, 4),
	(5, "Đông Nhi", 6000000, null),
	(6, "Ưng Hoàng Phuc", 12000000, null),
	(7, "Ninh Dương Lan Ngọc", 5000000, null)
;

insert into project values
(1, "Dự án 1", 100, "Hải Châu"),
(2, "Dự án 2", 200, "Liên Chiểu"),
(3, "Dự án 3", 150, "Cẩm lệ"),
(4, "Dự án 4", 220, "Liên Chiểu"),
(5, "Dự án 5", 180, "Hải Châu")
;

insert into project values
(6, "Dự án 6", 220, "Liên Chiểu"),
(7, "Dự án 7", 180, "Hải Châu")
;

insert into instructor_student values
(1, 1, 5, 1),
(1, 2, 2, 2),
(3, 3, 3, 3),
(4, 4, 4, 4),
(1, 2, 2, 1),
(1, 1, 1, 1)
;