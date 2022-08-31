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
public class PhongMay implements Serializable {

    private int maPhongMay;
    private String tenPhongMay;
    private String diaChiPhongMay;
    private int soMayChieu;
    private int soMayTinh;
    private String tinhTrang;
    private String cacPhanMem;

    public PhongMay() {
    }

    public PhongMay(int maPhongMay, String tenPhongMay, String diaChiPhongMay, int soMayChieu, int soMayTinh, String tinhTrang, String cacPhanMem) {
        this.maPhongMay = maPhongMay;
        this.tenPhongMay = tenPhongMay;
        this.diaChiPhongMay = diaChiPhongMay;
        this.soMayChieu = soMayChieu;
        this.soMayTinh = soMayTinh;
        this.tinhTrang = tinhTrang;
        this.cacPhanMem = cacPhanMem;
    }

    public String getCacPhanMem() {
        return cacPhanMem;
    }

    public void setCacPhanMem(String cacPhanMem) {
        this.cacPhanMem = cacPhanMem;
    }

    public int getMaPhongMay() {
        return maPhongMay;
    }

    public void setMaPhongMay(int maPhongMay) {
        this.maPhongMay = maPhongMay;
    }

    public String getTenPhongMay() {
        return tenPhongMay;
    }

    public void setTenPhongMay(String tenPhongMay) {
        this.tenPhongMay = tenPhongMay;
    }

    public String getDiaChiPhongMay() {
        return diaChiPhongMay;
    }

    public void setDiaChiPhongMay(String diaChiPhongMay) {
        this.diaChiPhongMay = diaChiPhongMay;
    }

    public int getSoMayChieu() {
        return soMayChieu;
    }

    public void setSoMayChieu(int soMayChieu) {
        this.soMayChieu = soMayChieu;
    }

    public int getSoMayTinh() {
        return soMayTinh;
    }

    public void setSoMayTinh(int soMayTinh) {
        this.soMayTinh = soMayTinh;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "PhongMay{" + "maPhongMay=" + maPhongMay + ", tenPhongMay=" + tenPhongMay + ", diaChiPhongMay=" + diaChiPhongMay + ", soMayChieu=" + soMayChieu + ", soMayTinh=" + soMayTinh + ", tinhTrang=" + tinhTrang + '}';
    }

}
