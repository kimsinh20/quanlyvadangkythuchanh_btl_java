package com.mycompany.quanlythuchanh.model;


import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sinh
 */
public class PhanMemMay implements Serializable{
    private String loaiMay;
    private String phanMem;

    public PhanMemMay() {
    }

    public PhanMemMay(String loaiMay, String phanMem) {
        this.loaiMay = loaiMay;
        this.phanMem = phanMem;
    }

    public String getLoaiMay() {
        return loaiMay;
    }

    public void setLoaiMay(String loaiMay) {
        this.loaiMay = loaiMay;
    }

    public String getPhanMem() {
        return phanMem;
    }

    public void setPhanMem(String phanMem) {
        this.phanMem = phanMem;
    }

    @Override
    public String toString() {
        return "PhanMemMay{" + "loaiMay=" + loaiMay + ", phanMem=" + phanMem + '}';
    }
    
}
