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
    private String soDT;
    private String diaChi;
    private String email;
    private String hocVi;
    private String khoa;

    public GiangVien() {
    }

    public GiangVien(String maGiangVien, String tenGiangVien, String soDT, String diaChi, String email, String hocVi, String khoa) {
        this.maGiangVien = maGiangVien;
        this.tenGiangVien = tenGiangVien;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.email = email;
        this.hocVi = hocVi;
        this.khoa = khoa;
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
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    @Override
    public String toString() {
        return "GiangVien{" + "maGiangVien=" + maGiangVien + ", tenGiangVien=" + tenGiangVien + ", soDT=" + soDT + ", diaChi=" + diaChi + ", email=" + email + ", hocVi=" + hocVi + ", khoa=" + khoa + '}';
    }
}
