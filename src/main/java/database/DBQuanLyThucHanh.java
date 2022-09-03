/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.mycompany.quanlythuchanh.model.GiangVien;
import com.mycompany.quanlythuchanh.model.LopHocPhan;
import com.mycompany.quanlythuchanh.model.MonHoc;
import com.mycompany.quanlythuchanh.model.PhongMay;
import com.mycompany.quanlythuchanh.model.ThucHanh;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class DBQuanLyThucHanh {

    private static final String databaseHost = "sql6.freesqldatabase.com";
    private static final String databaseName = "sql6516524";
    private static final String username = "sql6516524";
    private static final String password = "cfC9FxDEIG";
    private static final String port = "3306";

    public static boolean insertThucHanh(int maPM, String maLopHP, String ngayTH, String buoiTH) {

//        String ;
        // sql execute: CALL insert_thuc_hanh("maPM", malophp, ngayth, buoith) -> thoiGianDangKi sẽ tự thêm trong lúc insert
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //here sonoo is database name, root is username and password
            try ( Connection con = DriverManager.getConnection(
                    String.format("jdbc:mysql://%s:%s/%s", databaseHost, port, databaseName), username, password)) {
                //here sonoo is database name, root is username and password
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("CALL insert_thuc_hanh(" + maPM + ",'" + maLopHP + "','" + ngayTH + "','" + buoiTH + "');");
                while (rs.next()) {
                    return rs.getBoolean(1);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public static ArrayList<LopHocPhan> getListMon(String maGV) {
        ArrayList<LopHocPhan> mon = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //here sonoo is database name, root is username and password
            try ( Connection con = DriverManager.getConnection(
                    String.format("jdbc:mysql://%s:%s/%s", databaseHost, port, databaseName), username, password)) {
                //here sonoo is database name, root is username and password
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("CALL get_list_mon('" + maGV + "');");
                while (rs.next()) {
                    mon.add(new LopHocPhan(rs.getString(1), new MonHoc(rs.getString(2))));
//                    System.out.println(rs.getString(1) + "  " + rs.getString(2));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return mon;
    }

    public static int getTuanNay() {
        // sql execute: CALL get_tuan_nay()
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //here sonoo is database name, root is username and password
            try ( Connection con = DriverManager.getConnection(
                    String.format("jdbc:mysql://%s:%s/%s", databaseHost, port, databaseName), username, password)) {
                //here sonoo is database name, root is username and password
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("CALL get_tuan_nay();");
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public static String getTenGV(String maGV) {
        // sql execute: CALL get_ten_gv(maGV)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //here sonoo is database name, root is username and password
            try ( Connection con = DriverManager.getConnection(
                    String.format("jdbc:mysql://%s:%s/%s", databaseHost, port, databaseName), username, password)) {
                //here sonoo is database name, root is username and password
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("CALL get_ten_gv('" + maGV + "');");
                while (rs.next()) {
                    return rs.getString(1);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return "Nguyễn Thị Lỗi";
    }

//    public static String getTenPhongMay(int maPM) {
//        // sql execute: CALL get_ten_phong_may(maPM) -> return: tenPM + vitripM
////        call get_ten_phong_may(1);
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //here sonoo is database name, root is username and password
//            try ( Connection con = DriverManager.getConnection(
//                    String.format("jdbc:mysql://%s:%s/%s", databaseHost, port, databaseName), username, password)) {
//                //here sonoo is database name, root is username and password
//                Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery("CALL get_ten_phong_may("+maPM+");");
//                while (rs.next()) {
//                    return rs.getString(1) + rs.getString(2);
//                }
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println(e);
//        }
//        
//        return "PM999 - Tòa A999 - Phòng 999";
//    }
    public static ArrayList<String> getBayNgayTrongTuan(int soTuanTiepTheo) {
        // sql execute: CALL get_bay_ngay_trong_tuan(soTuanTiepTheo)
        // hàm này có thể chuyển thành java 100% sẽ tốt hơn

        ArrayList<String> returns = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //here sonoo is database name, root is username and password
            try ( Connection con = DriverManager.getConnection(
                    String.format("jdbc:mysql://%s:%s/%s", databaseHost, port, databaseName), username, password)) {
                //here sonoo is database name, root is username and password
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("CALL get_bay_ngay_trong_tuan(" + soTuanTiepTheo + ");");
                while (rs.next()) {
                    returns.add(rs.getString(1));
                    returns.add(rs.getString(2));
                    returns.add(rs.getString(3));
                    returns.add(rs.getString(4));
                    returns.add(rs.getString(5));
                    returns.add(rs.getString(6));
                    returns.add(rs.getString(7));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return returns;
    }

    public static String getLyThuyet(String currentMaLop) {
        // sql execute: CALL get_ly_thuyet(malophp) -> return: lichDayLyThuyet, phongHocLyThuyet, tiethoc
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //here sonoo is database name, root is username and password
            try ( Connection con = DriverManager.getConnection(
                    String.format("jdbc:mysql://%s:%s/%s", databaseHost, port, databaseName), username, password)) {
                //here sonoo is database name, root is username and password
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("CALL get_ly_thuyet('" + currentMaLop + "');");
                while (rs.next()) {
                    return String.format("Lịch lý thuyết: %s, %s, tiết %s", rs.getString(1), rs.getString(2), rs.getString(3));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return String.format("Lịch lý thuyết: %s, %s, tiết %s", "T8", "Tòa 999", "1,2,3,4,5,6");
    }

    public static int getKhoa(String malophp) {
        // sql execute: CALL get_khoa(malophp) -> return: Khóa 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //here sonoo is database name, root is username and password
            try ( Connection con = DriverManager.getConnection(
                    String.format("jdbc:mysql://%s:%s/%s", databaseHost, port, databaseName), username, password)) {
                //here sonoo is database name, root is username and password
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("CALL get_khoa('" + malophp + "');");
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return 10;
    }

    public static ArrayList<ThucHanh> getDanhSachDaDangKi(String ngayBatDau, String ngayKetThuc, int maPhongMay) {
        // sql execute: CALL get_danh_sach_da_dang_ki(ngayBatDau, ngayKetThuc, maPhongMay) 
        // -> return: malophp, ngayThucHanh, buoiTH, thoiGianDangKi, giangvien(tenGiangVien, maGV), monhoc(tenMH)

        ArrayList<ThucHanh> daDangKi = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //here sonoo is database name, root is username and password
            try ( Connection con = DriverManager.getConnection(
                    String.format("jdbc:mysql://%s:%s/%s", databaseHost, port, databaseName), username, password)) {
                //here sonoo is database name, root is username and password
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("CALL get_danh_sach_da_dang_ki('" + ngayBatDau + "','" + ngayKetThuc + "'," + maPhongMay + ");");
                while (rs.next()) {
                    daDangKi.add(new ThucHanh(rs.getString(2), rs.getString(3), new LopHocPhan(rs.getString(1), new MonHoc(rs.getString(7)), new GiangVien(rs.getString(5), rs.getString(6))), rs.getString(4)));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

//        if ("1/9/2022".equalsIgnoreCase(ngayBatDau)) {
//            daDangKi.add(new ThucHanh("1/9/2022", "C", new LopHocPhan("2022IT6024002", new MonHoc("Lập trình hướng đối tượng"), new GiangVien("An Văn Minh", 3)), "1 phút trước"));
//            daDangKi.add(new ThucHanh("2/9/2022", "S", new LopHocPhan("2022IT6024002", new MonHoc("Mạng máy tính"), new GiangVien("Nguyễn Thị T", 1)), "29/08/2022"));
//            daDangKi.add(new ThucHanh("5/9/2022", "T", new LopHocPhan("2022IT6024002", new MonHoc("Lập trình web"), new GiangVien("Phạm Thế Anh", 5)), "30/08/2022"));
//        } else {
//            daDangKi.add(new ThucHanh("8/9/2022", "C", new LopHocPhan("2022IT6024002", new MonHoc("Lập trình căn bản"), new GiangVien("Nguyễn Thị T", 1)), "1 phút trước"));
//            daDangKi.add(new ThucHanh("10/9/2022", "T", new LopHocPhan("2022IT6024002", new MonHoc("Lập trình .net"), new GiangVien("Nguyễn Thế Vinh", 6)), "1 phút trước"));
//            daDangKi.add(new ThucHanh("11/9/2022", "S", new LopHocPhan("2022IT6024002", new MonHoc("Lập trình ASP.net"), new GiangVien("Nguyễn Ngọc Kí", 7)), "29/08/2022"));
//            daDangKi.add(new ThucHanh("13/9/2022", "T", new LopHocPhan("2022IT6024002", new MonHoc("Lập trình web bằng PHP"), new GiangVien("Trần Thị Huyền", 8)), "30/08/2022"));
//        }
        return daDangKi;
    }

    public static ArrayList<PhongMay> getPhongMayTheoTinhTrang(int isChuaDangKi, String ngay, String buoi) {
        // isChuaDangKi 1: chua dang ki
        // isChuaDangKi 0: da dang ki
        // sql execute: CALL get_phong_may_theo_tinh_trang(isChuaDangKi, ngay, buoi) -> return: maPM, tenPM, diaChiPM, soMC, soMT, tinhTrang, cacPhanMemTrenMay
        ArrayList<PhongMay> arrPhongMay = new ArrayList<>();

        arrPhongMay.add(new PhongMay(1, "PM01", "Tòa A1 - Phòng 701", 1, 40, "Sử dụng được", "Word, excel, powerpoint, VS code"));
        arrPhongMay.add(new PhongMay(2, "PM02", "Tòa A1 - Phòng 702", 1, 40, "Sử dụng được", "Word, excel, powerpoint, VS code"));
        arrPhongMay.add(new PhongMay(3, "PM03", "Tòa A1 - Phòng 703", 1, 40, "Sử dụng được", "Word, excel, powerpoint, VS code"));
        arrPhongMay.add(new PhongMay(4, "PM04", "Tòa A1 - Phòng 704", 1, 40, "Sử dụng được", "Word, excel, powerpoint, VS code"));
        arrPhongMay.add(new PhongMay(5, "PM05", "Tòa A1 - Phòng 705", 1, 40, "Sử dụng được", "Word, excel, powerpoint, VS code"));

        return arrPhongMay;
    }

    public static boolean deleteLichThucHanh(int maPM, String buoiTH, String ngayThucHanh) {
        // sql execute: CALL delete_lich_thuc_hanh(maPM, buoiTH, ngayThucHanh)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //here sonoo is database name, root is username and password
            try ( Connection con = DriverManager.getConnection(
                    String.format("jdbc:mysql://%s:%s/%s", databaseHost, port, databaseName), username, password)) {
                //here sonoo is database name, root is username and password
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("CALL delete_lich_thuc_hanh(" + maPM + ",'" + buoiTH + "','" + ngayThucHanh + "');");
                while (rs.next()) {
                    return rs.getBoolean(1);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
