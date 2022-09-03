/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlythuchanh.model;

import java.io.Serializable;

/**
 *
 * @author Sinh
 */
public class ThucHanh implements Serializable {
//    malophp, ngayThucHanh, buoiTH, thoiGianDangKi
    private PhongMay phongMay;
    private LopHocPhan lopHocPhan;
    private String ngayThucHanh;
    private String buoiThucHanh;
    
    private String thoiGianDangKi;
    

    public ThucHanh() {
    }

    public ThucHanh(String ngayThucHanh, String tietTH, LopHocPhan lopHocPhan, String thoiGianDangKi, PhongMay phongMay) {
        this.ngayThucHanh = ngayThucHanh;
        this.buoiThucHanh = tietTH;
        this.lopHocPhan = lopHocPhan;
        this.thoiGianDangKi = thoiGianDangKi;
        this.phongMay = phongMay;
    }

    public ThucHanh(String ngayThucHanh, String tietTH, LopHocPhan lopHocPhan, String thoiGianDangKi) {
        this.ngayThucHanh = ngayThucHanh;
        this.buoiThucHanh = tietTH;
        this.lopHocPhan = lopHocPhan;
        this.thoiGianDangKi = thoiGianDangKi;
    }

    public String getNgayThucHanh() {
        return ngayThucHanh;
    }

    public void setNgayThucHanh(String ngayThucHanh) {
        this.ngayThucHanh = ngayThucHanh;
    }

    public String getTietTH() {
        return buoiThucHanh;
    }

    public void setTietTH(String tietTH) {
        this.buoiThucHanh = tietTH;
    }

    public LopHocPhan getLopHocPhan() {
        return lopHocPhan;
    }

    public void setLopHocPhan(LopHocPhan lopHocPhan) {
        this.lopHocPhan = lopHocPhan;
    }

    public String getThoiGianDangKi() {
        return thoiGianDangKi;
    }

    public void setThoiGianDangKi(String thoiGianDangKi) {
        this.thoiGianDangKi = thoiGianDangKi;
    }

    public PhongMay getPhongMay() {
        return phongMay;
    }

    public void setPhongMay(PhongMay phongMay) {
        this.phongMay = phongMay;
    }

   
}
