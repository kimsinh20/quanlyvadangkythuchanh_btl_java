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
public class PhongMay implements Serializable
{
    private int maPhongMay;
    private String tenPhongMay;
    private String diaChiPhongMay;
    private int soThietBi;
    private String trangThai;

    public PhongMay() {
    }

    public PhongMay(int maPhongMay, String tenPhongMay, String diaChiPhongMay, int soThietBi, String trangThai) {
        this.maPhongMay = maPhongMay;
        this.tenPhongMay = tenPhongMay;
        this.diaChiPhongMay = diaChiPhongMay;
        this.soThietBi = soThietBi;
        this.trangThai = trangThai;
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

    public int getSoThietBi() {
        return soThietBi;
    }

    public void setSoThietBi(int soThietBi) {
        this.soThietBi = soThietBi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "PhongMay{" + "maPhongMay=" + maPhongMay + ", tenPhongMay=" + tenPhongMay + ", diaChiPhongMay=" + diaChiPhongMay + ", soThietBi=" + soThietBi + ", trangThai=" + trangThai + '}';
    }
}
