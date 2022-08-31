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
public class LopHocPhan implements Serializable{
    private String maLopHocPhan;
    private String caHoc;
    private String phongHocLyThuyet;
    private String lichHocLyThuyet;
    private int soSV;
    private MonHoc monHoc;
    private GiangVien giangVien;

    public LopHocPhan() {
    }

    public LopHocPhan(String maLopHocPhan, String caHoc, String phongHocLyThuyet, String lichHocLyThuyet, int soSV, MonHoc monHoc, GiangVien giangVien) {
        this.maLopHocPhan = maLopHocPhan;
        this.caHoc = caHoc;
        this.phongHocLyThuyet = phongHocLyThuyet;
        this.lichHocLyThuyet = lichHocLyThuyet;
        this.soSV = soSV;
        this.monHoc = monHoc;
        this.giangVien = giangVien;
    }
    public LopHocPhan(String maLopHocPhan, MonHoc monHoc) {
        this.maLopHocPhan = maLopHocPhan;
        this.monHoc = monHoc;
    }
    public LopHocPhan(String maLopHocPhan) {
        this.maLopHocPhan = maLopHocPhan;
    }
    public LopHocPhan(String maLopHocPhan, MonHoc monHoc, GiangVien giangVien) {
        this.maLopHocPhan = maLopHocPhan;
        this.monHoc = monHoc;
        this.giangVien = giangVien;
    }
    
    public String getMaLopHocPhan() {
        return maLopHocPhan;
    }

    public void setMaLopHocPhan(String maLopHocPhan) {
        this.maLopHocPhan = maLopHocPhan;
    }

    public String getCaHoc() {
        return caHoc;
    }

    public void setCaHoc(String caHoc) {
        this.caHoc = caHoc;
    }

    public String getPhongHocLyThuyet() {
        return phongHocLyThuyet;
    }

    public void setPhongHocLyThuyet(String phongHocLyThuyet) {
        this.phongHocLyThuyet = phongHocLyThuyet;
    }

    public String getLichHocLyThuyet() {
        return lichHocLyThuyet;
    }

    public void setLichHocLyThuyet(String lichHocLyThuyet) {
        this.lichHocLyThuyet = lichHocLyThuyet;
    }

    public int getSoSV() {
        return soSV;
    }

    public void setSoSV(int soSV) {
        this.soSV = soSV;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    @Override
    public String toString() {
        return "LopHocPhan{" + "maLopHocPhan=" + maLopHocPhan + ", caHoc=" + caHoc + ", phongHocLyThuyet=" + phongHocLyThuyet + ", lichHocLyThuyet=" + lichHocLyThuyet + ", soSV=" + soSV + ", monHoc=" + monHoc + ", giangVien=" + giangVien + '}';
    }
    
}
