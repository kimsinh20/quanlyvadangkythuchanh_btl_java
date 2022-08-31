/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.mycompany.quanlythuchanh.model.GiangVien;
import com.mycompany.quanlythuchanh.model.LopHocPhan;
import com.mycompany.quanlythuchanh.model.MonHoc;
import com.mycompany.quanlythuchanh.model.ThucHanh;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class DBQuanLyThucHanh {

    public static boolean insertThucHanh(int maPM, String maLopHP, String ngayTH, String buoiTH) {
//        String ;
        // sql execute: CALL insert_thuc_hanh("maPM", malophp, ngayth, buoith) -> thoiGianDangKi sẽ tự thêm trong lúc insert
        return true;
    }

    public static ArrayList<LopHocPhan> getListMon(String maGV) {

        // sql execute: CALL get_list_mon("maGV") -> trả về các môn gv dạy và mã lớp hp
        // DATA GIẢ:
        ArrayList<LopHocPhan> mon = new ArrayList<>();
        mon.add(new LopHocPhan("2022IT6022001", new MonHoc("Lập trình Java")));
        mon.add(new LopHocPhan("2022IT6052001", new MonHoc("Lập trình web")));
        mon.add(new LopHocPhan("2022IT6024001", new MonHoc("Lập trình căn bản")));

        return mon;
    }

    public static int getTuanNay(String maLop) {
        // sql execute: CALL get_tuan_nay("maLop")

        return 46;
    }

    public static String getTenGV(String maGV) {
        // sql execute: CALL get_ten_gv("maGV")

        return "Nguyễn Thị T";
    }

    public static String getTenPhongMay(int maPM) {
        // sql execute: CALL get_ten_phong_may(maPM)

        return "PM04 - Tòa A1 - Phòng 701";
    }

    public static ArrayList<String> getBayNgayTrongTuan(int tuan) {
        // sql execute: CALL get_bay_ngay_trong_tuan(tuan)

        ArrayList<String> returns = new ArrayList<>();

        if (tuan % 2 == 0) {
            returns.add("1/9/2022");
            returns.add("2/9/2022");
            returns.add("3/9/2022");
            returns.add("4/9/2022");
            returns.add("5/9/2022");
            returns.add("6/9/2022");
            returns.add("7/9/2022");
        } else {
            returns.add("8/9/2022");
            returns.add("9/9/2022");
            returns.add("10/9/2022");
            returns.add("11/9/2022");
            returns.add("12/9/2022");
            returns.add("13/9/2022");
            returns.add("14/9/2022");
        }

        return returns;
    }

    public static String getLyThuyet(String currentMaLop) {
        // sql execute: CALL get_ly_thuyet(malophp) -> return: lichDayLyThuyet, phongHocLyThuyet, tiethoc

        return "Lịch lý thuyết: C4, Tòa A4 - phòng 402, tiết 3, 4, 5";
    }

    public static int getKhoa(String maGV) {
        // sql execute: CALL get_khoa(malophp)

        return 15;
    }

    public static ArrayList<ThucHanh> getDanhSachDaDangKi(String ngayBatDau, String ngayKetThuc, int maPhongMay) {
        // sql execute: CALL get_danh_sach_da_dang_ki(ngayBatDau, ngayKetThuc, maPhongMay) -> return: malophp, ngayThucHanh, buoiTH, thoiGianDangKi, giangvien(tenGiangVien), monhoc(tenMH)

        ArrayList<ThucHanh> daDangKi = new ArrayList<>();
        if ("1/9/2022".equalsIgnoreCase(ngayBatDau)) {
            daDangKi.add(new ThucHanh("1/9/2022", "C", new LopHocPhan("2022IT6024002", new MonHoc("Lập trình hướng đối tượng"), new GiangVien("An Văn Minh")), "1 phút trước"));
            daDangKi.add(new ThucHanh("2/9/2022", "S", new LopHocPhan("2022IT6024002", new MonHoc("Mạng máy tính"), new GiangVien("Lê Thị Huyền")), "29/08/2022"));
            daDangKi.add(new ThucHanh("5/9/2022", "T", new LopHocPhan("2022IT6024002", new MonHoc("Lập trình web"), new GiangVien("Phạm Thế Anh")), "30/08/2022"));
        } else {
            daDangKi.add(new ThucHanh("8/9/2022", "C", new LopHocPhan("2022IT6024002", new MonHoc("Lập trình căn bản"), new GiangVien("Phan Xuân An")), "1 phút trước"));
            daDangKi.add(new ThucHanh("10/9/2022", "T", new LopHocPhan("2022IT6024002", new MonHoc("Lập trình .net"), new GiangVien("Nguyễn Thế Vinh")), "1 phút trước"));
            daDangKi.add(new ThucHanh("11/9/2022", "S", new LopHocPhan("2022IT6024002", new MonHoc("Lập trình ASP.net"), new GiangVien("Nguyễn Ngọc Kí")), "29/08/2022"));
            daDangKi.add(new ThucHanh("13/9/2022", "T", new LopHocPhan("2022IT6024002", new MonHoc("Lập trình web bằng PHP"), new GiangVien("Trần Thị Huyền")), "30/08/2022"));
        }

        return daDangKi;
    }
}
