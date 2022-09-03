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
public class GiangVien implements Serializable {

    private String maGiangVien;
    private String tenGiangVien;
    private String soDienThoai;
    private String giangVienKhoa;
    private String hocVi;
    

    public GiangVien() {
    }

    public GiangVien(String maGiangVien, String tenGiangVien, String soDT, String diaChi, String email, String giangVienKhoa,String hocVi) {
        this.maGiangVien = maGiangVien;
        this.tenGiangVien = tenGiangVien;
        this.soDienThoai = soDT;
        this.hocVi = hocVi;
        this.giangVienKhoa = giangVienKhoa;
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public GiangVien(String tenGiangVien, String maGiangVien) {
        this.tenGiangVien = tenGiangVien;
        this.maGiangVien = maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public String getSoDT() {
        return soDienThoai;
    }

    public void setSoDT(String soDT) {
        this.soDienThoai = soDT;
    }
    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getKhoa() {
        return giangVienKhoa;
    }

    public void setKhoa(String khoa) {
        this.giangVienKhoa = khoa;
    }

    @Override
    public String toString() {
        return "GiangVien{" + "maGiangVien=" + maGiangVien + ", tenGiangVien=" + tenGiangVien + ", soDienThoai=" + soDienThoai + ", giangVienKhoa=" + giangVienKhoa + ", hocVi=" + hocVi + '}';
    }

   
}
