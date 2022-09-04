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
public class PhongMay implements Serializable {

    private int maPhongMay;
    private String tenPhongMay;
    private String diaChiPhongMay;
    private int soMayChieu;
    private int soMayTinh;
    private String tinhTrangPhong;
    private String danhSachPhanMem;

    public PhongMay() {
    }

    public PhongMay(int maPhongMay, String tenPhongMay, String diaChiPhongMay, int soMayChieu, int soMayTinh, String tinhTrangPhong, String danhSachPhanMem) {
        this.maPhongMay = maPhongMay;
        this.tenPhongMay = tenPhongMay;
        this.diaChiPhongMay = diaChiPhongMay;
        this.soMayChieu = soMayChieu;
        this.soMayTinh = soMayTinh;
        this.tinhTrangPhong = tinhTrangPhong;
        this.danhSachPhanMem = danhSachPhanMem;
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

    public String getTinhTrangPhong() {
        return tinhTrangPhong;
    }

    public void setTinhTrangPhong(String tinhTrangPhong) {
        this.tinhTrangPhong = tinhTrangPhong;
    }

    public String getDanhSachPhanMem() {
        return danhSachPhanMem;
    }

    public void setDanhSachPhanMem(String danhSachPhanMem) {
        this.danhSachPhanMem = danhSachPhanMem;
    }

    @Override
    public String toString() {
        return "PhongMay{" + "maPhongMay=" + maPhongMay + ", tenPhongMay=" + tenPhongMay + ", diaChiPhongMay=" + diaChiPhongMay + ", soMayChieu=" + soMayChieu + ", soMayTinh=" + soMayTinh + ", tinhTrangPhong=" + tinhTrangPhong + ", danhSachPhanMem=" + danhSachPhanMem + '}';
    }

   

}
