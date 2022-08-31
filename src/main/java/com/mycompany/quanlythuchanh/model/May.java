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
public class May implements Serializable{
    private int maMay;
    private PhongMay phongMay;
    private PhanMemMay phanMemMay;

    public May() {
    }
    
    public May(int maMay, PhongMay phongMay, PhanMemMay phanMemMay) {
        this.maMay = maMay;
        this.phongMay = phongMay;
        this.phanMemMay = phanMemMay;
    }

    public int getMaMay() {
        return maMay;
    }

    public void setMaMay(int maMay) {
        this.maMay = maMay;
    }

    public PhongMay getPhongMay() {
        return phongMay;
    }

    public void setPhongMay(PhongMay phongMay) {
        this.phongMay = phongMay;
    }

    public PhanMemMay getPhanMemMay() {
        return phanMemMay;
    }

    public void setPhanMemMay(PhanMemMay phanMemMay) {
        this.phanMemMay = phanMemMay;
    }

    @Override
    public String toString() {
        return "May{" + "maMay=" + maMay + ", phongMay=" + phongMay + ", phanMemMay=" + phanMemMay + '}';
    }
}
