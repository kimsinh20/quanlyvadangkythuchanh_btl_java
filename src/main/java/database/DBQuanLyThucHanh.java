package database;

import com.qlth.model.GiangVien;
import com.qlth.model.LopHocPhan;
import com.qlth.model.PhongMay;
import com.qlth.model.TaiKhoan;
import com.qlth.model.ThucHanh;
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
//    private static final String databaseHost = "localhost";
//    private static final String databaseName = "quanlythuchanh";
//    private static final String username = "root";
//    private static final String password = "123456";
//    private static final String port = "3306";

    private static Connection conn = null;

    public static final String DATABASE_USER = "user";
    public static final String DATABASE_PASSWORD = "password";
    public static final String MYSQL_AUTO_RECONNECT = "autoReconnect";
    public static final String MYSQL_MAX_RECONNECTS = "maxReconnects";

    public static boolean initConnection() {
        try {
            conn = DBQuanLyThucHanh.getConnection();
            System.out.println("connect successful.");
            return true;
        } catch (Exception ex) {
            System.out.println("initConnection");
            Logger.getLogger(DBQuanLyThucHanh.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static Connection getConnection() {
        try {
            System.out.println("connecting database...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = String.format("jdbc:mysql://%s:%s/%s", databaseHost, port, databaseName);
            java.util.Properties connProperties = new java.util.Properties();
            connProperties.put(DATABASE_USER, username);
            connProperties.put(DATABASE_PASSWORD, password);
            connProperties.put(MYSQL_AUTO_RECONNECT, "true");
            connProperties.put(MYSQL_MAX_RECONNECTS, "99999");
            return DriverManager.getConnection(dbURL, connProperties);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBQuanLyThucHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void checkConnection(){
        try {
            if (conn == null || conn.isClosed()) {
                DBQuanLyThucHanh.initConnection();
            }
        } catch (SQLException ex) {
            DBQuanLyThucHanh.initConnection();
            System.out.println("checkConnection: ");
            Logger.getLogger(DBQuanLyThucHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean insertThucHanh(int maPM, String maLopHP, String ngayTH, String buoiTH) {
        // sql execute: CALL insert_thuc_hanh("maPM", malophp, ngayth, buoith) -> thoiGianDangKi sẽ tự thêm trong lúc insert
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
//            System.out.println("CALL insert_thuc_hanh(" + maPM + ",'" + maLopHP + "','" + ngayTH + "','" + buoiTH + "');");
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
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
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
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
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
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
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
        DBQuanLyThucHanh.checkConnection();
        ArrayList<String> returns = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
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
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
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
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
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
        if (ngayBatDau.isEmpty()) {
            return null;
        }
        // sql execute: CALL get_danh_sach_da_dang_ki(ngayBatDau, ngayKetThuc, maPhongMay) 
        // -> return: malophp, ngayThucHanh, buoiTH, thoiGianDangKi, giangvien(tenGiangVien, maGV), monhoc(tenMH)
        DBQuanLyThucHanh.checkConnection();
        ArrayList<ThucHanh> daDangKi = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
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
        if (ngay.isEmpty()) {
            return null;
        }
        // isChuaDangKi 1: chua dang ki
        // isChuaDangKi 0: da dang ki
        // buoi: SCT ST S T C CT
        // sql execute: CALL get_phong_may_theo_tinh_trang(isChuaDangKi, ngay, buoi) -> return: maPM, tenPM, diaChiPM, soMC, soMT, tinhTrang, cacPhanMemTrenMay
        DBQuanLyThucHanh.checkConnection();
        ArrayList<PhongMay> arrPhongMay = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("CALL get_phong_may_theo_tinh_trang(" + isChuaDangKi + ",'" + ngay + "','" + buoi + "');");
            while (rs.next()) {
                arrPhongMay.add(new PhongMay(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("getPhongMayTheoTinhTrang");
            System.out.println(e);
        }

        return arrPhongMay;
    }

    public static boolean deleteLichThucHanh(int maPM, String buoiTH, String ngayThucHanh) {
        // sql execute: CALL delete_lich_thuc_hanh(maPM, buoiTH, ngayThucHanh)
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
            System.out.println("CALL delete_lich_thuc_hanh(" + maPM + ",'" + buoiTH + "','" + ngayThucHanh + "');");
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
      public static boolean deleteLichThucHanhByAdmin(int maPM, String buoiTH, String ngayThucHanh) {
        // sql execute: CALL delete_lich_thuc_hanh_by_admin(maPM, buoiTH, ngayThucHanh)
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
//            System.out.println("CALL delete_lich_thuc_hanh_by_admin(" + maPM + ",'" + buoiTH + "','" + ngayThucHanh + "');");
            ResultSet rs = stmt.executeQuery("CALL delete_lich_thuc_hanh_by_admin(" + maPM + ",'" + buoiTH + "','" + ngayThucHanh + "');");
            while (rs.next()) {
                return rs.getBoolean(1);
            }
        } catch (SQLException e) {
            System.out.println("deleteLichThucHanhByAdmin");
            System.out.println(e);
        }
        return false;
    }
    public static int getLogin(String tenDangNhap, String matKhau) {
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("CALL login('" + tenDangNhap + "','" + matKhau + "');");
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("login faile");
            System.out.println(e);
        }
        return -1;
    }

    public static ArrayList<Integer> getDanhSachPhong() {
        ArrayList<Integer> phong = new ArrayList<>();
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("CALL get_danh_sach_phong();");
            while (rs.next()) {
                phong.add(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("getDanhSachPhong: " + e);
        }

        return phong;
    }
    public static ArrayList<String> getDanhSachToaNha() {
        ArrayList<String> toa = new ArrayList<>();
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("CALL get_danh_sach_toa();");
            while (rs.next()) {
                toa.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("getDanhSachToaNha: " + e);
        }

        return toa;
    }
    public static ArrayList<String> getDanhSachMonHoc() {
        ArrayList<String> mon = new ArrayList<>();
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("CALL get_danh_sach_mon_hoc();");
            while (rs.next()) {
                mon.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("getDanhSachMonHoc: " + e);
        }

        return mon;
    }
    public static ArrayList<GiangVien> getDanhSachGiangVien() {
        ArrayList<GiangVien> gv = new ArrayList<>();
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("CALL get_danh_sach_giang_vien();");
            while (rs.next()) {
                gv.add(new GiangVien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
        } catch (SQLException e) {
            System.out.println("getDanhSachGiangVien: " + e);
        }

        return gv;
    }
    public static ArrayList<PhongMay> getDanhSachPhongMay() {
        ArrayList<PhongMay> listpm = new ArrayList<>();
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("CALL get_list_phong_may();");
            while (rs.next()) {
                listpm.add(new PhongMay(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("getDanhSachphongmay: " + e);
        }

        return listpm;
    }
    public static boolean insertPhongMay(String tenPM, String diaChiPM, int soMayChieu,int soMayTinh,String tinhTrang,String dsPhanMem) {
        
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
//      call them_phong_may("PM12","Tòa A1 - phòng 701",1,40,"Sử dụng được","Visual Studio Code, Word 2019, Excel 2019, Power Point 2019, Dream Weaver");
           
            ResultSet rs = stmt.executeQuery("CALL insert_phong_may('" + tenPM + "','" + diaChiPM + "'," + soMayChieu + "," + soMayTinh+",'"+tinhTrang+"','"+dsPhanMem + "');");
            while (rs.next()) {
                return rs.getBoolean(1);
            }
        } catch (SQLException e) {
            System.out.println("insertPhongMay loi: " + e);
        }

        return false;
    }
    public static void deletePhongMay(int maPhongMay) {
        
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();     
            ResultSet rs = stmt.executeQuery("CALL delete_phong_may("+maPhongMay+");");
        } catch (SQLException e) {
            System.out.println("delete PhongMay loi: " + e);
        }

    }
     public static void updatePhongMay(int maPhongMay,String tenPM, String diaChiPM, int soMayChieu,int soMayTinh,String tinhTrang,String dsPhanMem) {
        
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();     
            ResultSet rs = stmt.executeQuery("CALL update_phong_may(" +maPhongMay+ ",'" + tenPM + "','" + diaChiPM + "'," + soMayChieu + "," + soMayTinh+",'"+tinhTrang+"','"+dsPhanMem + "');");
        } catch (SQLException e) {
            System.out.println("update Phong May loi: " + e);
        }

    }
    public static ArrayList<PhongMay> searchPhongMay(String search) {
         ArrayList<PhongMay> listpm = new ArrayList<>();
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();     
            ResultSet rs = stmt.executeQuery("CALL search_phong_may_theo_ten('" +search+ "');");
             while (rs.next()) {
                listpm.add(new PhongMay(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("search Phong May loi: " + e);
        }
        return listpm;
    }
    public static boolean insertGiangVien(String maGiangVien,String tenGiangVien,String soDienThoai,String hocVi,String khoa) {
        
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("CALL insert_giang_vien('" + maGiangVien + "','" + tenGiangVien + "','" + soDienThoai + "','"+hocVi+"','"+khoa + "');");
            while (rs.next()) {
                return rs.getBoolean(1);
            }
        } catch (SQLException e) {
            System.out.println("insert giang vien loi: " + e);
        }

        return false;
    }
      public static void deleteGiangVien(String maGiangVien) {
        
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();     
            ResultSet rs = stmt.executeQuery("CALL delete_giang_vien('"+maGiangVien+"');");
        } catch (SQLException e) {
            System.out.println("delete giang vien loi: " + e);
        }
    }
      public static void updateGiangVien(String maGiangVien,String tenGiangVien,String soDienThoai,String hocVi,String khoa) {
        
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();     
            ResultSet rs = stmt.executeQuery("CALL update_giang_vien('" + maGiangVien + "','" + tenGiangVien + "','" + soDienThoai + "','"+hocVi+"','"+khoa + "');");
        } catch (SQLException e) {
            System.out.println("update giang vien loi: " + e);
        }
    }
      public static ArrayList<GiangVien> searchGiangVien(String search) {
         ArrayList<GiangVien> listgv = new ArrayList<>();
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();     
            ResultSet rs = stmt.executeQuery("CALL search_giang_vien('" +search+ "');");
             while (rs.next()) {
                listgv.add(new GiangVien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
        } catch (SQLException e) {
            System.out.println("search Phong May loi: " + e);
        }
        return listgv;
    }
  
    public static boolean insertLopHocPhan(String maLopHocPhan, String maGV, String tenMH, int soLuongSV, String lichHocLT, String phongHocLT, String tietHLT, int khoa) {
        // sql execute: CALL insert_lop_hoc_phan(maLopHocPhan, maGiangVien, tenMonHoc , soluongsv, lichHocLyThuyet, phongHocLyThuyet, tietHocLyThuyet, khoaHoc
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("CALL insert_lop_hoc_phan('" + maLopHocPhan + "', '" + maGV + "', '" + tenMH + "' , " + soLuongSV + ", '" + lichHocLT + "', '" + phongHocLT + "', '" + tietHLT + "', " + khoa + ");");
            while (rs.next()) {
                return rs.getBoolean(1);
            }
        } catch (SQLException e) {
            System.out.println("insertLopHocPhan: " + e);
        }
        return false;
    }

    public static void updateLopHocPhan(String maLopHocPhan, String maGV, String tenMH, int soLuongSV, String lichHocLT, String phongHocLT, String tietHLT, int khoa) {
//        update_lop_hoc_phan
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("CALL update_lop_hoc_phan('" + maLopHocPhan + "', '" + maGV + "', '" + tenMH + "' , " + soLuongSV + ", '" + lichHocLT + "', '" + phongHocLT + "', '" + tietHLT + "', " + khoa + ");");
        } catch (SQLException e) {
            System.out.println("updateLopHocPhan: " + e);
        }
    }

    public static void deleteLopHocPhan(String maLopHocPhan) {
//       delete_lop_hoc_phan
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("CALL delete_lop_hoc_phan('" + maLopHocPhan + "');");
        } catch (SQLException e) {
            System.out.println("deleteLopHocPhan: " + e);
        }
    }

    public static ArrayList<LopHocPhan> searchLopHocPhan(String searchTerm) {
        ArrayList<LopHocPhan> arrLopHocPhan = new ArrayList<>();
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("CALL search_lop_hoc_phan('" + searchTerm + "');");
            while (rs.next()) {
                String[] split = rs.getString(2).split(" - ");
                arrLopHocPhan.add(new LopHocPhan(rs.getString(1), new GiangVien(split[1], split[0]), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException e) {
            System.out.println("searchLopHocPhan: " + e);
        }
        return arrLopHocPhan;
    }
     public static ArrayList<LopHocPhan> getDanhSachLopHocPhan() {
        ArrayList<LopHocPhan> listlhp = new ArrayList<>();
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("CALL get_danh_sach_lop_hoc_phan();");
            while (rs.next()) {
                listlhp.add(new LopHocPhan(rs.getString(1),new GiangVien(rs.getString(2)),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
        } catch (SQLException e) {
            System.out.println("getDanhSachphongmay: " + e);
        }

        return listlhp;
    }
      public static ArrayList<TaiKhoan> searchTaiKhoan(String search) {
         ArrayList<TaiKhoan> listtk = new ArrayList<>();
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();     
            ResultSet rs = stmt.executeQuery("CALL search_tai_khoan('" +search+ "');");
             while (rs.next()) {
                listtk.add(new TaiKhoan(rs.getString(1),rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println("search  loi: " + e);
        }
        return listtk;
    }
       public static void resetMatKhau(String tenTaiKhoan) {
        DBQuanLyThucHanh.checkConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("CALL reset_mat_khau('" + tenTaiKhoan+"');");
        } catch (SQLException e) {
            System.out.println("reset mk: " + e);
        }
    }
    public static void main(String[] args) {
   //test db
        System.out.println(searchTaiKhoan(""));
    }
}