/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlth.model;

import java.io.Serializable;

/**
 *
 * @author Sinh
 */
public class LopHocPhan implements Serializable{
    private String maLopHocPhan;
    private GiangVien giangVien;
    private String tenMonHoc;
    private int soLuongSv;
    private String lichHocLyThuyet;
    private String phongHocLyThuyet;
    private String tietHocLyThuyet;
    private int khoa;
   
    

    public LopHocPhan() {
    }

    public LopHocPhan(String maLopHocPhan, GiangVien giangVien, String tenMonHoc, int soLuongSv, String lichHocLyThuyet, String phongHocLyThuyet, String tietHocLyThuyet, int khoa) {
        this.maLopHocPhan = maLopHocPhan;
        this.giangVien = giangVien;
        this.tenMonHoc = tenMonHoc;
        this.soLuongSv = soLuongSv;
        this.lichHocLyThuyet = lichHocLyThuyet;
        this.phongHocLyThuyet = phongHocLyThuyet;
        this.tietHocLyThuyet = tietHocLyThuyet;
        this.khoa = khoa;
    }
    public LopHocPhan(String maLopHocPhan, String tenMonHoc) {
        this.maLopHocPhan = maLopHocPhan;
        this.tenMonHoc = tenMonHoc;
    }

    public LopHocPhan(String maLopHocPhan) {
        this.maLopHocPhan = maLopHocPhan;
    }

    public LopHocPhan(String maLopHocPhan, GiangVien giangVien, String tenMonHoc) {
        this.maLopHocPhan = maLopHocPhan;
        this.giangVien = giangVien;
        this.tenMonHoc = tenMonHoc;
    }

    public String getMaLopHocPhan() {
        return maLopHocPhan;
    }

    public void setMaLopHocPhan(String maLopHocPhan) {
        this.maLopHocPhan = maLopHocPhan;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public int getSoLuongSv() {
        return soLuongSv;
    }

    public void setSoLuongSv(int soLuongSv) {
        this.soLuongSv = soLuongSv;
    }

    public String getLichHocLyThuyet() {
        return lichHocLyThuyet;
    }

    public void setLichHocLyThuyet(String lichHocLyThuyet) {
        this.lichHocLyThuyet = lichHocLyThuyet;
    }

    public String getPhongHocLyThuyet() {
        return phongHocLyThuyet;
    }

    public void setPhongHocLyThuyet(String phongHocLyThuyet) {
        this.phongHocLyThuyet = phongHocLyThuyet;
    }

    public String getTietHocLyThuyet() {
        return tietHocLyThuyet;
    }

    public void setTietHocLyThuyet(String tietHocLyThuyet) {
        this.tietHocLyThuyet = tietHocLyThuyet;
    }

    public int getKhoa() {
        return khoa;
    }

    public void setKhoa(int khoa) {
        this.khoa = khoa;
    }
    
      
}
