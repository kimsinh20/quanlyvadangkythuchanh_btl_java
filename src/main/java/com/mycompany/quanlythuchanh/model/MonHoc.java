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
public class MonHoc implements Serializable{
    private String maMH;
    private String tenMH;
    private int soTinChi;
    private String hinhThucThi;

    public MonHoc() {
    }

    public MonHoc(String maMH, String tenMH, int soTinChi, String hinhThucThi) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.soTinChi = soTinChi;
        this.hinhThucThi = hinhThucThi;
    }
    
    public MonHoc(String tenMH) {
        this.tenMH = tenMH;
    }
    

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public String getHinhThucThi() {
        return hinhThucThi;
    }

    public void setHinhThucThi(String hinhThucThi) {
        this.hinhThucThi = hinhThucThi;
    }

    @Override
    public String toString() {
        return "MonHoc{" + "maMH=" + maMH + ", tenMH=" + tenMH + ", soTinChi=" + soTinChi + ", hinhThucThi=" + hinhThucThi + '}';
    }
    
    
}
