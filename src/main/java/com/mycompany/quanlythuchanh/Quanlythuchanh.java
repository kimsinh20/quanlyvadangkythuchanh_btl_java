/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlythuchanh;

import java.awt.Dimension;
import java.awt.Toolkit;
import views.user.ThongTinPhongMay;

/**
 *
 * @author ADMIN
 */
public class Quanlythuchanh {

    public Quanlythuchanh() {
    }

    public static void main(String[] args) {
        ThongTinPhongMay windowThongTinPhongMay = new ThongTinPhongMay("20226001");
        windowThongTinPhongMay.setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        //Calculate the frame location  
        int x = (screenSize.width - windowThongTinPhongMay.getWidth()) / 2;
        int y = (screenSize.height - windowThongTinPhongMay.getHeight()) / 2;

        windowThongTinPhongMay.setLocation(x, y);
    }
}
