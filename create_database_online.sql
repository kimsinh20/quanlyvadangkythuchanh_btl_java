-- drop database quanlythuchanh;
-- create database quanlythuchanh;
use sql6516524;

CREATE TABLE PhongMay (
    maPhongMay INT AUTO_INCREMENT PRIMARY KEY,
    tenPhongMay VARCHAR(20)CHARACTER SET UTF8MB4,
    diaChiPhongMay VARCHAR(25)CHARACTER SET UTF8MB4,
    soMayChieu INT,
    soMayTinh INT,
    tinhTrang VARCHAR(20)CHARACTER SET UTF8MB4,
    danhSachPhanMem TEXT
);

CREATE TABLE TaiKhoan (
    tenDangNhap VARCHAR(20)CHARACTER SET UTF8MB4,
    matKhau VARCHAR(20)CHARACTER SET UTF8MB4,
    quyen VARCHAR(20)CHARACTER SET UTF8MB4,
    PRIMARY KEY (tenDangNhap)
);

CREATE TABLE GiangVien (
    maGiangVien VARCHAR(20)CHARACTER SET UTF8MB4 PRIMARY KEY,
    tenGiangVien VARCHAR(40)CHARACTER SET UTF8MB4,
    soDienThoai VARCHAR(12)CHARACTER SET UTF8MB4,
    hocVi VARCHAR(40)CHARACTER SET UTF8MB4,
    khoa VARCHAR(40)CHARACTER SET UTF8MB4,
    FOREIGN KEY (maGiangVien)
        REFERENCES TaiKhoan (tenDangNhap)
);

CREATE TABLE LopHocPhan (
    maLopHocPhan VARCHAR(20)CHARACTER SET UTF8MB4 PRIMARY KEY,
    maGiangVien VARCHAR(20)CHARACTER SET UTF8MB4,
    tenMonHoc VARCHAR(60)CHARACTER SET UTF8MB4,
    soluongsv INT,
    lichHocLyThuyet VARCHAR(2),
    phongHocLyThuyet VARCHAR(35)CHARACTER SET UTF8MB4,
    tietHocLyThuyet VARCHAR(40)CHARACTER SET UTF8MB4,
    khoaHoc INT,
    FOREIGN KEY (maGiangVien)
        REFERENCES GiangVien (maGiangVien)
);

drop table ThucHanh;
CREATE TABLE ThucHanh (
    maPhongMay INT,
    maLopHocPhan VARCHAR(20)CHARACTER SET UTF8MB4,
    ngayThucHanh DATE,
    buoiThucHanh CHAR(1),
    thoiGianDangKi DATETIME,
    PRIMARY KEY (maPhongMay , ngayThucHanh , buoiThucHanh),
    FOREIGN KEY (maPhongMay)
        REFERENCES PhongMay (maPhongMay),
    FOREIGN KEY (maLopHocPhan)
        REFERENCES LopHocPhan (maLopHocPhan)
);

CREATE TABLE HocKy (
    ngayBatDauHocKi DATE PRIMARY KEY
);

CREATE TABLE ToaNha (
    toa VARCHAR(4) PRIMARY KEY
);

CREATE TABLE Phong (
    tenPhong INT PRIMARY KEY
);

insert into PhongMay values (1,"PM01","Tòa A1 - phòng 701",1,40,"Sử dụng được","Visual Studio Code, Word 2019, Excel 2019, Power Point 2019, Dream Weaver"),
(2,"PM02","Tòa A1 - phòng 702",1,40,"Sử dụng được","Visual Studio Code, Word 2019, Excel 2019, Power Point 2019, Dream Weaver"),
(3,"PM03","Tòa A1 - phòng 703",1,40,"Sử dụng được","Visual Studio Code, Word 2019, Excel 2019, Power Point 2019, Dream Weaver"),
(4,"PM04","Tòa A1 - phòng 704",1,40,"Sử dụng được","Visual Studio Code, Word 2019, Excel 2019, Power Point 2019, Dream Weaver"),
(5,"PM05","Tòa A1 - phòng 705",1,40,"Sử dụng được","Visual Studio Code, Word 2019, Excel 2019, Power Point 2019, Dream Weaver"),
(6,"PM06","Tòa A1 - phòng 706",1,40,"Sử dụng được","Visual Studio Code, Word 2019, Excel 2019, Power Point 2019, Dream Weaver"),
(7,"PM07","Tòa A1 - phòng 707",1,40,"Sử dụng được","Visual Studio Code, Word 2019, Excel 2019, Power Point 2019, Dream Weaver"),
(8,"PM08","Tòa A1 - phòng 708",1,40,"Sử dụng được","Visual Studio Code, Word 2019, Excel 2019, Power Point 2019, Dream Weaver"),
(9,"PM09","Tòa A1 - phòng 709",1,40,"Sử dụng được","Visual Studio Code, Word 2019, Excel 2019, Power Point 2019, Dream Weaver"),
(10,"PM10","Tòa A1 - phòng 710",1,40,"Sử dụng được","Visual Studio Code, Word 2019, Excel 2019, Power Point 2019, Dream Weaver");

insert into TaiKhoan values ("admin",123456,"admin"),
("20226001",123456,"user"),
("20226002",123456,"user"),
("20226003",123456,"user"),
("20226004",123456,"user"),
("20226005",123456,"user");

insert into GiangVien values ("20226001","Nguyễn Phú Đồng","0914302430","Thạc sĩ","Công nghệ thông tin"),
("20226002","Huỳnh Văn Nhứt","0914113578","tiến sĩ","Công nghệ thông tin"),
("20226003","Nguyễn Thị Minh Hằng","01914909000","Thạc sĩ","Công nghệ thông tin"),
("20226004","Trần Thị Thanh Hảo","0914560298","Thạc sĩ","Công nghệ thông tin"),
("20226005","Lương Thị Phương","0395656357","Thạc sĩ","Công nghệ thông tin");

insert into LopHocPhan values ("20221IT6075001","20226001","Khai thác dữ liệu và ứng dụng",70,"S2","Tòa A8 - phòng 401","1,2,3",15),
("20221IT6075002","20226002","Phát triển ứng dụng di động đơn nền tảng",70,"C2","Tòa A8 - phòng 402","7,8,9",16),
("20221IT6075003","20226003","Nhập môn công nghệ phần mềm",70,"S3","Tòa A8 - phòng 403","3,4,5",14),
("20221IT6075004","20226004","Mạng máy tính",70,"C4","Tòa A8 - phòng 404","7,8,9",15),
("20221IT6075005","20226005","Kiểm thử phần mềm",70,"C6","Tòa A8 - phòng 405","9,10,11",14);

insert into ThucHanh values (1,"20221IT6075001","2022-09-02","S","2022-09-01 09:00:00"),
(2,"20221IT6075002","2022-09-03","S","2022-09-01 09:00:00"),
(3,"20221IT6075003","2022-09-03","S","2022-09-01 09:00:00"),
(4,"20221IT6075004","2022-09-03","S","2022-09-01 09:00:00"),
(5,"20221IT6075005","2022-09-03","S","2022-09-01 09:00:00");

insert into ToaNha values ("A1"),
("A2"),
("A3"),
("A4"),
("A5"),
("A6"),
("A7"),
("A8"),
("A9"),
("A10"),
("A11"),
("A12"),
("A13"),
("A14");

delete from HocKy where ngayBatDauHocKi < curdate();
insert into HocKy values ("2022-04-28"),("2022-07-28");

insert into Phong values (101),
(102),
(103),
(104),
(105),
(106),
(107),
(108),
(109),
(201),
(202),
(203),
(204),
(205),
(206),
(207),
(208),
(209),
(301),
(302),
(303),
(304),
(305),
(306),
(307),
(308),
(309),
(401),
(402),
(403),
(404),
(405),
(406),
(407),
(408),
(409),
(501),
(502),
(503),
(504),
(505),
(506),
(507),
(508),
(509),
(601),
(602),
(603),
(604),
(605),
(606),
(607),
(608),
(609),
(701),
(702),
(703),
(704),
(705),
(706),
(707),
(708),
(709),
(801),
(802),
(803),
(804),
(805),
(806),
(807),
(808),
(809),
(901),
(902),
(903),
(904),
(905),
(906),
(907),
(908),
(909);

select * from PhongMay;

select * from ThucHanh;

select * from LopHocPhan;

select * from GiangVien;

select * from TaiKhoan;

select * from HocKy;

select * from ToaNha;

select tenphong from Phong;



-- input: username, password
-- out: 0, 1, 2
drop PROCEDURE login;

DELIMITER //
CREATE PROCEDURE login(username VARCHAR(20)CHARACTER SET UTF8MB4, MK VARCHAR(20))
BEGIN
	if(exists(select * FROM TaiKhoan where tenDangNhap = username and matKhau = MK))
    then
		SELECT 
			CASE
				WHEN quyen = "admin" THEN 2
				WHEN quyen = "user" THEN 1
			END as "quyenTruyCap"
		FROM TaiKhoan
		where tenDangNhap = username and matKhau = MK;
	ELSE
		SELECT 0 as "quyenTruyCap";
    end if;
END //
DELIMITER ;

call login("20226001", 123456);
call login("admin", 123456);
call login("20226999", 123456);




DELIMITER //
CREATE PROCEDURE get_list_mon(maGiangVien VARCHAR(20)CHARACTER SET UTF8MB4)
BEGIN
	select maLopHocPhan, tenMonHoc
    from LopHocPhan
    where LopHocPhan.maGiangVien = maGiangVien;
END //
DELIMITER ;

CALL get_list_mon('20226001');
CALL get_list_mon("20226001");

DELIMITER //
CREATE PROCEDURE get_ten_gv(maGiangVien VARCHAR(20)CHARACTER SET UTF8MB4)
BEGIN
	select tenGiangVien from GiangVien where GiangVien.maGiangVien = maGiangVien;
END //
DELIMITER ;

call get_ten_gv('20226001');

DELIMITER //
CREATE PROCEDURE get_ten_phong_may(maPhongMay INT)
BEGIN
	select tenphongmay, diachiphongmay
    from PhongMay where PhongMay.maphongmay = maphongmay;
END //
DELIMITER ;

call get_ten_phong_may(1);

DELIMITER //
CREATE PROCEDURE get_ly_thuyet(maLopHocPhan VARCHAR(20)CHARACTER SET UTF8MB4)
BEGIN
    select lichHocLyThuyet, phongHocLyThuyet, tietHocLyThuyet
    from LopHocPhan
    where LopHocPhan.maLopHocPhan = maLopHocPhan;
END //
DELIMITER ;

call get_ly_thuyet("20221IT6075001");

DELIMITER //
CREATE PROCEDURE get_khoa(maLopHocPhan VARCHAR(20)CHARACTER SET UTF8MB4)
BEGIN
    select khoaHoc from LopHocPhan where LopHocPhan.maLopHocPhan = maLopHocPhan;
END //
DELIMITER ;

call get_khoa("20221IT6075001");

drop procedure get_danh_sach_da_dang_ki;
DELIMITER //
CREATE PROCEDURE get_danh_sach_da_dang_ki(ngayBatDau date, ngayKetThuc date, maPhongMay INT)
BEGIN
	SET @@session.time_zone = "+07:00";
	select LopHocPhan.maLopHocPhan, ngayThucHanh, buoiThucHanh, 
		case
        when time_to_sec(timediff(now(), thoiGianDangKi )) / 3600 <= 24 then 
			CONCAT (FLOOR(time_to_sec(timediff(now(), thoiGianDangKi )) / 3600), " giờ ",round(time_to_sec(timediff(now(), thoiGianDangKi )) / 60)%60 , " phút trước")
		else thoiGianDangKi
        end as 	"thoiGianDangKi"
		, tenGiangVien, GiangVien.maGiangVien, tenMonHoc
	from (LopHocPhan inner join ThucHanh 
    on LopHocPhan.maLopHocPhan = ThucHanh.maLopHocPhan)
    inner join GiangVien on GiangVien.maGiangVien = LopHocPhan.maGiangVien
    where (ngayThucHanh between ngayBatDau and ngayKetThuc)
    and ThucHanh.maPhongMay = maPhongMay;
END //
DELIMITER ;

SET @@session.time_zone = "+07:00";
select CONCAT (round(time_to_sec(timediff(now(), '2022-09-04 08:10:00' )) / 60) , " phút");

call get_danh_sach_da_dang_ki ;

select CURDATE() - "2022-09-03";

select CURDATE() between "2022-09-03" and "2022-09-04";

call get_danh_sach_da_dang_ki("2022-09-00","2022-09-04",2);

drop PROCEDURE get_tuan_nay;

DELIMITER //
CREATE PROCEDURE get_tuan_nay()
BEGIN
    select max(ngayBatDauHocKi) into @NBDHK from HocKy;
	SELECT DATEDIFF(curdate(), @NBDHK) / 7 into @soTuan;
    select  CEILING(@soTuan) as "soTuan";
END //
DELIMITER ;

call get_tuan_nay();

SELECT DATEDIFF("2017-06-25", "2017-06-15");

select 6/7, round(6/7, 0);
select 8/7, round(8/7, 0);

drop PROCEDURE get_bay_ngay_trong_tuan;

DELIMITER //
CREATE PROCEDURE get_bay_ngay_trong_tuan(soTuanTiepTheo int)
BEGIN
	select WEEKDAY(curdate()) into @thu;
    -- tro ve dau tuan và dịch đến tuần cần lấy
    select curdate() - interval @thu day + interval soTuanTiepTheo week 
    into @ngayBatDau;
    
	select @ngayBatDau as Mo,
    @ngayBatDau + interval 1 day as Tu, 
    @ngayBatDau + interval 2 day as We, 
    @ngayBatDau + interval 3 day as Th, 
    @ngayBatDau + interval 4 day as Fr, 
    @ngayBatDau + interval 5 day as Sa, 
    @ngayBatDau + interval 6 day as Su;
END //
DELIMITER ;

call get_bay_ngay_trong_tuan(0);
call get_bay_ngay_trong_tuan(1);
call get_bay_ngay_trong_tuan(2);



drop PROCEDURE insert_thuc_hanh;

SELECT @@session.time_zone;
SET @@session.time_zone = "+07:00";
    
DELIMITER //
CREATE PROCEDURE insert_thuc_hanh(maPhongMay int, maLopHocPhan VARCHAR(20)CHARACTER SET UTF8MB4, ngayThucHanh DATE, buoiThucHanh VARCHAR(2))
BEGIN
	 --  // sql execute: CALL insert_thuc_hanh("maPM", malophp, ngayth, buoith) -> thoiGianDangKi sẽ tự thêm trong lúc insert
	SET @@session.time_zone = "+07:00";
	select now() into @thoiGianDangKi;
    select @thoiGianDangKi;
    if (exists(select * from PhongMay where PhongMay.maPhongMay = maPhongMay) and exists(select * from LopHocPhan where LopHocPhan.maLopHocPhan =  maLopHocPhan))
    then 
		insert into ThucHanh values (maPhongMay, maLopHocPhan, ngayThucHanh , buoiThucHanh, @thoiGianDangKi);
		select true;
    end if;
    select false;
END //
DELIMITER ;

CALL insert_thuc_hanh(2,'20221IT6075001','2022-08-30','S');

drop PROCEDURE delete_lich_thuc_hanh;

DELIMITER //
CREATE PROCEDURE delete_lich_thuc_hanh(maPhongMay INT, buoiThucHanh VARCHAR(2), ngayThucHanh DATE)
BEGIN
	code_block:
    begin
		if(exists(select * from ThucHanh 
			where ThucHanh.maPhongMay = maPhongMay
				and ThucHanh.buoiThucHanh = buoiThucHanh
				and ThucHanh.ngayThucHanh = ngayThucHanh))
		then
			SET @@session.time_zone = "+07:00";
			select thoiGianDangKi into @thoiGianDangKi from ThucHanh 
			where ThucHanh.maPhongMay = maPhongMay
				and ThucHanh.buoiThucHanh = buoiThucHanh
				and ThucHanh.ngayThucHanh = ngayThucHanh;
			if(time_to_sec(timediff(now(), @thoiGianDangKi )) / 60 >= 5)
			then
				select false;
				leave code_block;
			end if;
			delete from ThucHanh 
			where ThucHanh.maPhongMay = maPhongMay
				and ThucHanh.buoiThucHanh = buoiThucHanh
				and ThucHanh.ngayThucHanh = ngayThucHanh;
			select true;
		else
			select false;
		end if;
	end;
END //
DELIMITER ;

CALL delete_lich_thuc_hanh(1,'T','2022-09-04');

DELIMITER //
CREATE PROCEDURE delete_lich_thuc_hanh_by_admin(maPhongMay INT, buoiThucHanh VARCHAR(2), ngayThucHanh DATE)
BEGIN
	code_block:
    begin
		if(exists(select * from ThucHanh 
			where ThucHanh.maPhongMay = maPhongMay
				and ThucHanh.buoiThucHanh = buoiThucHanh
				and ThucHanh.ngayThucHanh = ngayThucHanh))
		then
			delete from ThucHanh 
			where ThucHanh.maPhongMay = maPhongMay
				and ThucHanh.buoiThucHanh = buoiThucHanh
				and ThucHanh.ngayThucHanh = ngayThucHanh;
			select true;
		else
			select false;
		end if;
	end;
END //
DELIMITER ;


select time_to_sec(timediff(now(), thoiGianDangKi )) / 60 >= 5 ,thoiGianDangKi
from ThucHanh;

SET @@session.time_zone = "+07:00";
select timediff(now(), '2022-09-04 18:07:07' );
select time_to_sec(timediff(now(), '2022-09-04 18:07:07' )) / 60 <= 5;

-- // isChuaDangKi 1: chua dang ki
--         // isChuaDangKi 0: da dang ki
--         // sql execute: CALL get_phong_may_theo_tinh_trang(isChuaDangKi, ngay, buoi) -> return: maPM, tenPM, diaChiPM, soMC, soMT, tinhTrang, cacPhanMemTrenMay

DELIMITER //
CREATE PROCEDURE get_phong_may_theo_tinh_trang(isChuaDangKi int, ngay date, buoi varchar(3))
BEGIN
	if(isChuaDangKi = 0)
    then
		select PhongMay.*
        from PhongMay
		where maPhongMay in
        (select maPhongMay from ThucHanh
        where ngayThucHanh = ngay and INSTR(buoi , buoiThucHanh) > 0
        group by maPhongMay
        having count(buoiThucHanh) = length(buoi));
        
    elseif(isChuaDangKi = 1)
	then
        select PhongMay.*
        from PhongMay
		where maPhongMay not in
        (select maPhongMay from ThucHanh
        where ngayThucHanh = ngay and INSTR(buoi , buoiThucHanh) > 0
        group by maPhongMay
        having count(buoiThucHanh) = length(buoi));
	else
    select PhongMay.* 
        from PhongMay;
		end if;	
END //
DELIMITER ;



SELECT LENGTH("SQL Tutorial") AS LengthOfString;

select INSTR('ill' , 'i');

-- (maPhongMay, maLopHocPhan, @ngayThucHanh, buoiThucHanh, thoiGianDangKi)
-- SET ngayThucHanh = STR_TO_DATE(@ngayThucHanh, '%m/%d/%Y'),
--  = STR_TO_DATE(@expired_date, '%m/%d/%Y ')
-- %H:%i:%s

DELIMITER //
CREATE PROCEDURE get_danh_sach_phong()
BEGIN
	select tenPhong from Phong;
END //
DELIMITER ;

call get_danh_sach_phong()


DELIMITER //
CREATE PROCEDURE get_danh_sach_toa ()
BEGIN
	select toa from ToaNha;
END //
DELIMITER ;

call get_danh_sach_toa();


DELIMITER //
CREATE PROCEDURE get_danh_sach_mon_hoc()
BEGIN
	select tenMonHoc from LopHocPhan;
END //
DELIMITER ;

call get_danh_sach_mon_hoc();


DELIMITER //
CREATE PROCEDURE get_danh_sach_giang_vien_ten_va_ma ()
BEGIN
	select tenGiangVien, maGiangVien from GiangVien;
END //
DELIMITER ;

DELIMITER //
create  PROCEDURE get_danh_sach_giang_vien()
begin
	select * from GiangVien;
end//
DELIMITER ;


call get_danh_sach_giang_vien ();

select * from LopHocPhan;
delete from LopHocPhan where maLopHocPhan = '';
DELIMITER //
CREATE PROCEDURE insert_lop_hoc_phan(
	maLopHocPhan VARCHAR(20)CHARACTER SET UTF8MB4 ,
    maGiangVien VARCHAR(20)CHARACTER SET UTF8MB4,
    tenMonHoc VARCHAR(60)CHARACTER SET UTF8MB4,
    soluongsv INT,
    lichHocLyThuyet VARCHAR(2),
    phongHocLyThuyet VARCHAR(35)CHARACTER SET UTF8MB4,
    tietHocLyThuyet VARCHAR(40)CHARACTER SET UTF8MB4,
    khoaHoc INT)
BEGIN
	
    if (exists(select * from GiangVien where GiangVien.maGiangVien = maGiangVien) and not exists(select * from LopHocPhan where LopHocPhan.maLopHocPhan =  maLopHocPhan))
    then 
		insert into LopHocPhan values (maLopHocPhan, maGiangVien, tenMonHoc , soluongsv, lichHocLyThuyet, phongHocLyThuyet, tietHocLyThuyet, khoaHoc);
		select true;
    end if;
    select false;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE get_list_phong_may()
BEGIN
	SELECT * FROM PhongMay;
END //
DELIMITER ;
call get_list_phong_may();



drop PROCEDURE insert_phong_may;
DELIMITER //
CREATE PROCEDURE insert_phong_may (
    tenPhongMay VARCHAR(20)CHARACTER SET UTF8MB4,
    diaChiPhongMay VARCHAR(25)CHARACTER SET UTF8MB4,
    soMayChieu INT,
    soMayTinh INT,
    tinhTrang VARCHAR(20)CHARACTER SET UTF8MB4,
    danhSachPhanMem TEXT)
BEGIN
	if (not exists(select * from PhongMay where PhongMay.diaChiPhongMay = diaChiPhongMay))
    then
		insert into PhongMay (tenPhongMay, diaChiPhongMay, soMayChieu , soMayTinh, tinhTrang, danhSachPhanMem) values (tenPhongMay, diaChiPhongMay, soMayChieu , soMayTinh, tinhTrang, danhSachPhanMem);
		select true;
    end if;
	select false;
END //
DELIMITER ;

call insert_phong_may("PM01","Tòa A1 - phòng 701",1,40,"Sử dụng được","Visual Studio Code, Word 2019, Excel 2019, Power Point 2019, Dream Weaver");

DELIMITER //
CREATE PROCEDURE update_phong_may (
	maPhongMay INT,
    tenPhongMay VARCHAR(20)CHARACTER SET UTF8MB4,
    diaChiPhongMay VARCHAR(25)CHARACTER SET UTF8MB4,
    soMayChieu INT,
    soMayTinh INT,
    tinhTrang VARCHAR(20)CHARACTER SET UTF8MB4,
    danhSachPhanMem TEXT)
BEGIN
	update PhongMay
    set PhongMay.tenPhongMay = tenPhongMay,
    PhongMay.diaChiPhongMay = diaChiPhongMay,
    PhongMay.soMayChieu = soMayChieu,
    PhongMay.soMayTinh = soMayTinh,
    PhongMay.tinhTrang = tinhTrang,
    PhongMay.danhSachPhanMem = danhSachPhanMem
    where PhongMay.maPhongMay = maPhongMay;
END //
DELIMITER ;


drop PROCEDURE delete_phong_may;

DELIMITER //
CREATE PROCEDURE delete_phong_may (maPhongMay INT)
BEGIN
	delete
    from ThucHanh
    where ThucHanh.maPhongMay = maPhongMay;
	delete
    from PhongMay
    where PhongMay.maPhongMay = maPhongMay;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_phong_may_theo_ten (tenPhongMay VARCHAR(20)CHARACTER SET UTF8MB4)
BEGIN
	select * from PhongMay
    where PhongMay.tenPhongMay like concat ("%",tenPhongMay,"%");
END //
DELIMITER ;

call search_phong_may_theo_ten('');





drop PROCEDURE  insert_giang_vien;

DELIMITER //
CREATE PROCEDURE  insert_giang_vien(
	maGiangVien VARCHAR(20)CHARACTER SET UTF8MB4,
    tenGiangVien VARCHAR(40)CHARACTER SET UTF8MB4,
    soDienThoai VARCHAR(12)CHARACTER SET UTF8MB4,
    hocVi VARCHAR(40)CHARACTER SET UTF8MB4,
    khoa VARCHAR(40)CHARACTER SET UTF8MB4)
BEGIN
	if(not exists(select * from GiangVien where GiangVien.maGiangVien = maGiangVien))
    then
		insert into TaiKhoan values (maGiangVien, "123456","user");
		insert into GiangVien values (maGiangVien,tenGiangVien,soDienThoai,hocVi, khoa);
        select true;
	else
		select false;
    end if;
END //
DELIMITER ;

call insert_giang_vien("20226009","Nguyễn Văn Giảng","0914302430","Thạc sĩ","Công nghệ thông tin");


DELIMITER //
CREATE PROCEDURE search_giang_vien(tenGiangVien VARCHAR(40)CHARACTER SET UTF8MB4)
BEGIN
	select * from GiangVien where GiangVien.tenGiangVien like concat("%", tenGiangVien, "%");
END //
DELIMITER ;

call search_giang_vien('phú');

DELIMITER //
CREATE PROCEDURE update_giang_vien(
	maGiangVien VARCHAR(20)CHARACTER SET UTF8MB4,
    tenGiangVien VARCHAR(40)CHARACTER SET UTF8MB4,
    soDienThoai VARCHAR(12)CHARACTER SET UTF8MB4,
    hocVi VARCHAR(40)CHARACTER SET UTF8MB4,
    khoa VARCHAR(40)CHARACTER SET UTF8MB4)
BEGIN
	update GiangVien 
    set GiangVien.tenGiangVien = tenGiangVien,
    GiangVien.soDienThoai = soDienThoai,
    GiangVien.hocVi = hocVi,
    GiangVien.khoa = khoa
    where GiangVien.maGiangVien = maGiangVien;
END //
DELIMITER ;



drop PROCEDURE delete_giang_vien;

DELIMITER //
CREATE PROCEDURE delete_giang_vien(maGiangVien VARCHAR(20)CHARACTER SET UTF8MB4)
BEGIN
	delete
		from GiangVien
		where GiangVien.maGiangVien = maGiangVien;
    delete 
		from TaiKhoan
        where TaiKhoan.tenDangNhap = maGiangVien;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE update_lop_hoc_phan (
	maLopHocPhan VARCHAR(20)CHARACTER SET UTF8MB4,
    maGiangVien VARCHAR(20)CHARACTER SET UTF8MB4,
    tenMonHoc VARCHAR(60)CHARACTER SET UTF8MB4,
    soluongsv INT,
    lichHocLyThuyet VARCHAR(2),
    phongHocLyThuyet VARCHAR(35)CHARACTER SET UTF8MB4,
    tietHocLyThuyet VARCHAR(40)CHARACTER SET UTF8MB4,
    khoaHoc INT)
BEGIN
	update LopHocPhan
    set LopHocPhan.maGiangVien = maGiangVien,
    LopHocPhan.tenMonHoc = tenMonHoc,
    LopHocPhan.soluongsv = soluongsv,
    LopHocPhan.lichHocLyThuyet = lichHocLyThuyet,
    LopHocPhan.phongHocLyThuyet = phongHocLyThuyet,
    LopHocPhan.tietHocLyThuyet = tietHocLyThuyet,
    LopHocPhan.khoaHoc = khoaHoc
    where LopHocPhan.maLopHocPhan = maLopHocPhan;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE delete_lop_hoc_phan(maLopHocPhan VARCHAR(20)CHARACTER SET UTF8MB4)
BEGIN
	delete
		from ThucHanh
		where ThucHanh.maLopHocPhan = maLopHocPhan;
    delete 
		from LopHocPhan
        where LopHocPhan.maLopHocPhan = maLopHocPhan;
END //
DELIMITER ;

drop PROCEDURE search_lop_hoc_phan;

DELIMITER //
CREATE PROCEDURE search_lop_hoc_phan (searchTerm VARCHAR(60)CHARACTER SET UTF8MB4)
BEGIN
	select maLopHocPhan,concat( GiangVien.maGiangVien, " - ", tenGiangVien),tenMonHoc,soluongsv,lichHocLyThuyet,phongHocLyThuyet,tietHocLyThuyet,khoaHoc 
    from LopHocPhan inner join GiangVien
    on GiangVien.maGiangVien = LopHocPhan.maGiangVien
    where LopHocPhan.maLopHocPhan like concat("%",searchTerm,"%") or 
    LopHocPhan.maGiangVien like concat("%",searchTerm,"%") or 
    LopHocPhan.tenMonHoc like concat("%",searchTerm,"%") or 
    LopHocPhan.soluongsv like concat("%",searchTerm,"%") or 
    LopHocPhan.lichHocLyThuyet like concat("%",searchTerm,"%") or 
    LopHocPhan.phongHocLyThuyet like concat("%",searchTerm,"%") or 
    LopHocPhan.tietHocLyThuyet like concat("%",searchTerm,"%") or 
    LopHocPhan.khoaHoc like concat("%",searchTerm,"%");
END //
DELIMITER ;

call search_lop_hoc_phan('khai');

DELIMITER //
CREATE PROCEDURE get_danh_sach_hoc_ky (nam_hoc int)
BEGIN
	SELECT 
		ngayBatDauHocKi, @rownum:=@rownum + 1 AS rank
	FROM
		HocKy,
		(SELECT @rownum:=0) r
	where nam_hoc = year(ngayBatDauHocKi)
	ORDER BY ngayBatDauHocKi;
END //
DELIMITER ;



DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE search_ ()
BEGIN
	
END //
DELIMITER ;




show variables like "max_connections";
set global max_connections = 300;


