/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.mycompany.quanlythuchanh.model.GiangVien;
import com.mycompany.quanlythuchanh.model.LopHocPhan;
import com.mycompany.quanlythuchanh.model.PhongMay;
import com.mycompany.quanlythuchanh.model.ThucHanh;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private static Connection conn;
    private static Statement stmt;

    public static final String DATABASE_USER = "user";
    public static final String DATABASE_PASSWORD = "password";
    public static final String MYSQL_AUTO_RECONNECT = "autoReconnect";
    public static final String MYSQL_MAX_RECONNECTS = "maxReconnects";

    public static boolean initConnection() {
        try {
            conn = DBQuanLyThucHanh.getConnection();
            stmt = conn.createStatement();
            return true;
        } catch (Exception ex) {
            System.out.println("initConnection");
            Logger.getLogger(DBQuanLyThucHanh.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String dbURL = String.format("jdbc:mysql://%s:%s/%s", databaseHost, port, databaseName);
        java.util.Properties connProperties = new java.util.Properties();
        connProperties.put(DATABASE_USER, username);
        connProperties.put(DATABASE_PASSWORD, password);
        connProperties.put(MYSQL_AUTO_RECONNECT, "true");
        connProperties.put(MYSQL_MAX_RECONNECTS, "99999");
        return DriverManager.getConnection(dbURL, connProperties);
    }

    public static boolean insertThucHanh(int maPM, String maLopHP, String ngayTH, String buoiTH) {
        // sql execute: CALL insert_thuc_hanh("maPM", malophp, ngayth, buoith) -> thoiGianDangKi sẽ tự thêm trong lúc insert
        try {
            if (stmt == null || stmt.isClosed()) {
                DBQuanLyThucHanh.initConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBQuanLyThucHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println("CALL insert_thuc_hanh(" + maPM + ",'" + maLopHP + "','" + ngayTH + "','" + buoiTH + "');");
            stmt.execute("SET @@session.time_zone = \"+07:00\";");
            ResultSet rs = stmt.executeQuery("CALL insert_thuc_hanh(" + maPM + ",'" + maLopHP + "','" + ngayTH + "','" + buoiTH + "');");
            while (rs.next()) {
                return rs.getBoolean(1);
            }
        } catch (SQLException e) {
            System.out.println("insertThucHanh: " + e);
        }

        return false;
    }

    public static ArrayList<LopHocPhan> getListMon(String maGV) {
        ArrayList<LopHocPhan> mon = new ArrayList<>();
        try {
            if (stmt == null || stmt.isClosed()) {
                DBQuanLyThucHanh.initConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBQuanLyThucHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs = stmt.executeQuery("CALL get_list_mon('" + maGV + "');");
            while (rs.next()) {
                mon.add(new LopHocPhan(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println("getListMon: " + e);
        }

        return mon;
    }

    public static int getTuanNay() {
        // sql execute: CALL get_tuan_nay()
        try {
            if (stmt == null || stmt.isClosed()) {
                DBQuanLyThucHanh.initConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBQuanLyThucHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs = stmt.executeQuery("CALL get_tuan_nay();");
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("getTuanNay: " + e);
        }
        return 0;
    }

    public static String getTenGV(String maGV) {
        // sql execute: CALL get_ten_gv(maGV)
        try {
            if (stmt == null || stmt.isClosed()) {
                DBQuanLyThucHanh.initConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBQuanLyThucHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs = stmt.executeQuery("CALL get_ten_gv('" + maGV + "');");
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("getTenGV");
            System.out.println(e);
        }
        return "Nguyễn Thị Lỗi";
    }

    public static ArrayList<String> getBayNgayTrongTuan(int soTuanTiepTheo) {
        // sql execute: CALL get_bay_ngay_trong_tuan(soTuanTiepTheo)
        // hàm này có thể chuyển thành java 100% sẽ tốt hơn
        try {
            if (stmt == null || stmt.isClosed()) {
                DBQuanLyThucHanh.initConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBQuanLyThucHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> returns = new ArrayList<>();

        try {
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
        } catch (SQLException e) {
            System.out.println("getBayNgayTrongTuan");
            System.out.println(e);
        }

        return returns;
    }

    public static String getLyThuyet(String currentMaLop) {
        // sql execute: CALL get_ly_thuyet(malophp) -> return: lichDayLyThuyet, phongHocLyThuyet, tiethoc
        try {
            if (stmt == null || stmt.isClosed()) {
                DBQuanLyThucHanh.initConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBQuanLyThucHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs = stmt.executeQuery("CALL get_ly_thuyet('" + currentMaLop + "');");
            while (rs.next()) {
                return String.format("Lịch lý thuyết: %s, %s, tiết %s", rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("getLyThuyet");
            System.out.println(e);
        }
        return String.format("Lịch lý thuyết: %s, %s, tiết %s", "T8", "Tòa 999", "1,2,3,4,5,6");
    }

    public static int getKhoa(String malophp) {
        // sql execute: CALL get_khoa(malophp) -> return: Khóa 
        try {
            if (stmt == null || stmt.isClosed()) {
                DBQuanLyThucHanh.initConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBQuanLyThucHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs = stmt.executeQuery("CALL get_khoa('" + malophp + "');");
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("getKhoa");
            System.out.println(e);
        }
        return 10;
    }

    public static ArrayList<ThucHanh> getDanhSachDaDangKi(String ngayBatDau, String ngayKetThuc, int maPhongMay) {
        // sql execute: CALL get_danh_sach_da_dang_ki(ngayBatDau, ngayKetThuc, maPhongMay) 
        // -> return: malophp, ngayThucHanh, buoiTH, thoiGianDangKi, giangvien(tenGiangVien, maGV), monhoc(tenMH)
        try {
            if (stmt == null || stmt.isClosed()) {
                DBQuanLyThucHanh.initConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBQuanLyThucHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<ThucHanh> daDangKi = new ArrayList<>();

        try {
            ResultSet rs = stmt.executeQuery("CALL get_danh_sach_da_dang_ki('" + ngayBatDau + "','" + ngayKetThuc + "'," + maPhongMay + ");");
            while (rs.next()) {
                daDangKi.add(new ThucHanh(rs.getString(2), rs.getString(3), new LopHocPhan(rs.getString(1), new GiangVien(rs.getString(5), rs.getString(6)), rs.getString(7)), rs.getString(4)));
            }
        } catch (SQLException e) {
            System.out.println("getDanhSachDaDangKi");
            System.out.println(e);
        }

        return daDangKi;
    }

    public static ArrayList<PhongMay> getPhongMayTheoTinhTrang(int isChuaDangKi, String ngay, String buoi) {
        // isChuaDangKi 1: chua dang ki
        // isChuaDangKi 0: da dang ki
        // buoi: SCT ST S T C CT
        // sql execute: CALL get_phong_may_theo_tinh_trang(isChuaDangKi, ngay, buoi) -> return: maPM, tenPM, diaChiPM, soMC, soMT, tinhTrang, cacPhanMemTrenMay
        try {
            if (stmt == null || stmt.isClosed()) {
                DBQuanLyThucHanh.initConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBQuanLyThucHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<PhongMay> arrPhongMay = new ArrayList<>();

        try {
            ResultSet rs = stmt.executeQuery("CALL get_phong_may_theo_tinh_trang(" + isChuaDangKi + ",'" + ngay + "','" + buoi + "');");
            while (rs.next()) {
                arrPhongMay.add(new PhongMay(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("getDanhSachDaDangKi");
            System.out.println(e);
        }

//        arrPhongMay.add(new PhongMay(1, "PM01", "Tòa A1 - Phòng 701", 1, 40, "Sử dụng được", "Word, excel, powerpoint, VS code"));
//        arrPhongMay.add(new PhongMay(2, "PM02", "Tòa A1 - Phòng 702", 1, 40, "Sử dụng được", "Word, excel, powerpoint, VS code"));
//        arrPhongMay.add(new PhongMay(3, "PM03", "Tòa A1 - Phòng 703", 1, 40, "Sử dụng được", "Word, excel, powerpoint, VS code"));
//        arrPhongMay.add(new PhongMay(4, "PM04", "Tòa A1 - Phòng 704", 1, 40, "Sử dụng được", "Word, excel, powerpoint, VS code"));
//        arrPhongMay.add(new PhongMay(5, "PM05", "Tòa A1 - Phòng 705", 1, 40, "Sử dụng được", "Word, excel, powerpoint, VS code"));
        return arrPhongMay;
    }

    public static boolean deleteLichThucHanh(int maPM, String buoiTH, String ngayThucHanh) {
        // sql execute: CALL delete_lich_thuc_hanh(maPM, buoiTH, ngayThucHanh)
        try {
            if (stmt == null || stmt.isClosed()) {
                DBQuanLyThucHanh.initConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBQuanLyThucHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs = stmt.executeQuery("CALL delete_lich_thuc_hanh(" + maPM + ",'" + buoiTH + "','" + ngayThucHanh + "');");
            while (rs.next()) {
                return rs.getBoolean(1);
            }
        } catch (SQLException e) {
            System.out.println("deleteLichThucHanh");
            System.out.println(e);
        }
        return false;
    }
}
