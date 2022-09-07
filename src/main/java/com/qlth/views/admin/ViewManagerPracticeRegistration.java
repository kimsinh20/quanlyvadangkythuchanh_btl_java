/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.qlth.views.admin;

import com.qlth.views.user.*;
import com.qlth.model.PhongMay;
import com.qlth.model.ThucHanh;
import database.DBQuanLyThucHanh;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public final class ViewManagerPracticeRegistration extends javax.swing.JFrame {

    /**
     * Creates new form DangKiPhongMay
     *
     */
    public ViewManagerPracticeRegistration() {
        initClass();
    }

    private void initClass() {
        isUsingProcess = true;
        initComponents();

        thoiKhoaBieu[0][0] = S2Content;
        thoiKhoaBieu[0][1] = S3Content;
        thoiKhoaBieu[0][2] = S4Content;
        thoiKhoaBieu[0][3] = S5Content;
        thoiKhoaBieu[0][4] = S6Content;
        thoiKhoaBieu[0][5] = S7Content;
        thoiKhoaBieu[0][6] = S8Content;

        thoiKhoaBieu[1][0] = C2Content;
        thoiKhoaBieu[1][1] = C3Content;
        thoiKhoaBieu[1][2] = C4Content;
        thoiKhoaBieu[1][3] = C5Content;
        thoiKhoaBieu[1][4] = C6Content;
        thoiKhoaBieu[1][5] = C7Content;
        thoiKhoaBieu[1][6] = C8Content;

        thoiKhoaBieu[2][0] = T2Content;
        thoiKhoaBieu[2][1] = T3Content;
        thoiKhoaBieu[2][2] = T4Content;
        thoiKhoaBieu[2][3] = T5Content;
        thoiKhoaBieu[2][4] = T6Content;
        thoiKhoaBieu[2][5] = T7Content;
        thoiKhoaBieu[2][6] = T8Content;

        ngayThang[0] = thu2Ngay;
        ngayThang[1] = thu3Ngay;
        ngayThang[2] = thu4Ngay;
        ngayThang[3] = thu5Ngay;
        ngayThang[4] = thu6Ngay;
        ngayThang[5] = thu7Ngay;
        ngayThang[6] = thu8Ngay;
//        Thread thread1 = new Thread(() -> {
        initData();
//        });
//        thread1.start();
//        try {
//            thread1.join();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(DangKiPhongMay.class.getName()).log(Level.SEVERE, null, ex);
//        }
        autoRefresh();
    }

    private void autoRefresh() {
        Thread thAutoRefresh = new Thread(() -> {
            while (isUsingProcess) {
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ViewManagerPracticeRegistration.class.getName()).log(Level.SEVERE, null, ex);
                }
                refreshData();
            }
        });
        thAutoRefresh.start();
    }

    private void initData() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        arrPM = DBQuanLyThucHanh.getDanhSachPhongMay();
        for (int i = 0; i < arrPM.size(); i++) {
            model.addElement(arrPM.get(i).getTenPhongMay() + " - " + arrPM.get(i).getDiaChiPhongMay());
        }
        comboPhongMay.setModel(model);
        comboPhongMay.setSelectedIndex(0);
        //init Tuan
        tuanNay = DBQuanLyThucHanh.getTuanNay();
        System.out.println("tuan nay: " + tuanNay);
        currentTuan = tuanNay;
        model = new DefaultComboBoxModel();
        for (Integer i = tuanNay; i <= tuanNay + soTuanDangDuocKiTruoc; i++) {
            model.addElement(i);
        }
        comboTuan.setModel(model);
        comboTuan.setSelectedIndex(0);

        // init ngay thang
        ArrayList<String> bayNgayTrongTuan = DBQuanLyThucHanh.getBayNgayTrongTuan(0);
        for (int i = 0; i < 7; i++) {
            ngayThang[i].setText(bayNgayTrongTuan.get(i));
        }
    }

    private synchronized void refreshData() {
        System.out.println("refreshing");
        DateTimeFormatter f = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        LocalDate today = LocalDate.now();
        int maPM = arrPM.get(comboPhongMay.getSelectedIndex()).getMaPhongMay();
        ArrayList<ThucHanh> danhSachDaDangKi = DBQuanLyThucHanh.getDanhSachDaDangKi(ngayThang[0].getText(), ngayThang[6].getText(), maPM);
        if (danhSachDaDangKi == null) {
            return;
        }
        ThucHanh lichInCurrentCell;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                lichInCurrentCell = isInDanhSachDaDangKi(danhSachDaDangKi, i, j);

//                System.out.println(today.toString() + "->" + dateInCell.toString() + ": " + dateInCell.isAfter(today));
                // khác null nếu đã đăng kí 
                if (lichInCurrentCell != null) {
                    // Do giáo viên này đăng kí 
//                    System.out.println("current: " + maGV);
//                    System.out.println("access to: " + lichInCurrentCell.getLopHocPhan().getGiangVien().getMaGiangVien());
                    thoiKhoaBieu[i][j].setComponentPopupMenu(menuHuy);
                    thoiKhoaBieu[i][j].setToolTipText("Nhấn phải chuột");

                    setDaDangKi(thoiKhoaBieu[i][j], lichInCurrentCell.getLopHocPhan().getMaLopHocPhan(), lichInCurrentCell.getLopHocPhan().getGiangVien().getTenGiangVien(), lichInCurrentCell.getLopHocPhan().getTenMonHoc(), lichInCurrentCell.getTietTH() + (j + 1), lichInCurrentCell.getThoiGianDangKi());

                } else {
                    // chua dang ki
                    setChuaDangKi(thoiKhoaBieu[i][j]);
                }

                if (Integer.parseInt(comboTuan.getSelectedItem().toString()) == tuanNay) {
                    LocalDate dateInCell = LocalDate.parse(ngayThang[j].getText(), f);

                    if (dateInCell.isBefore(today) || (dateInCell.isEqual(today) && getBuoiTrongNgay() > i)) {
                        thoiKhoaBieu[i][j].setComponentPopupMenu(null);
                        thoiKhoaBieu[i][j].setEnabled(false);
                        thoiKhoaBieu[i][j].setToolTipText(null);
                    }

                } else {
                    thoiKhoaBieu[i][j].setEnabled(true);
                }
            }
        }
    }

    private void setLoadingData() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                setLoading(thoiKhoaBieu[i][j]);
            }
        }
    }

    private ThucHanh isInDanhSachDaDangKi(ArrayList<ThucHanh> danhSachDaDangKi, int i, int j) {
        String ngayTH = ngayThang[j].getText();
        String buoiTH = "";
        switch (i) {
            case 0 ->
                buoiTH = "S";
            case 1 ->
                buoiTH = "C";
            case 2 ->
                buoiTH = "T";
        }
        for (ThucHanh thucHanh : danhSachDaDangKi) {
//            System.out.println(thucHanh.getNgayThucHanh() + "-" + ngayTH);
            if (thucHanh.getNgayThucHanh().equalsIgnoreCase(ngayTH) && thucHanh.getTietTH().equalsIgnoreCase(buoiTH)) {
                return thucHanh;
            }
        }
        return null;
    }

    public void setDaDangKi(javax.swing.JEditorPane content, String maLopHP, String tenGV, String tenHP, String lichLT, String thoiGianDangKi) {
        content.setText(String.format("\n%s\n%s\n%s\nLT:%s\n\nThời gian đăng kí: \n%s", maLopHP, tenGV, tenHP, lichLT, thoiGianDangKi));
        content.setForeground(Color.black);
        content.setFocusable(false);
    }

    public void setChuaDangKi(javax.swing.JEditorPane content) {
        content.setText("");
        content.setForeground(Color.blue);
        content.setFocusable(true);
    }

    public void setLoading(javax.swing.JEditorPane content) {
        content.setText("\n\n\n\n                Loading...");
        content.setForeground(Color.green);
        content.setFocusable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuHuy = new javax.swing.JPopupMenu();
        buttonHuy = new javax.swing.JMenuItem();
        lichDangKi = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        S2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        S2Content = new javax.swing.JEditorPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        S4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        S4Content = new javax.swing.JEditorPane();
        S3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        S3Content = new javax.swing.JEditorPane();
        S5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        S5Content = new javax.swing.JEditorPane();
        S6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        S6Content = new javax.swing.JEditorPane();
        S8 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        S8Content = new javax.swing.JEditorPane();
        S7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        S7Content = new javax.swing.JEditorPane();
        C2 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        C2Content = new javax.swing.JEditorPane();
        C3 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        C3Content = new javax.swing.JEditorPane();
        C4 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        C4Content = new javax.swing.JEditorPane();
        C5 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        C5Content = new javax.swing.JEditorPane();
        C6 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        C6Content = new javax.swing.JEditorPane();
        C7 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        C7Content = new javax.swing.JEditorPane();
        C8 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        C8Content = new javax.swing.JEditorPane();
        T2 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        T2Content = new javax.swing.JEditorPane();
        T3 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        T3Content = new javax.swing.JEditorPane();
        T4 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        T4Content = new javax.swing.JEditorPane();
        T5 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        T5Content = new javax.swing.JEditorPane();
        T6 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        T6Content = new javax.swing.JEditorPane();
        T7 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        T7Content = new javax.swing.JEditorPane();
        T8 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        T8Content = new javax.swing.JEditorPane();
        jLabel11 = new javax.swing.JLabel();
        comboTuan = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        thu2Ngay = new javax.swing.JLabel();
        thu3Ngay = new javax.swing.JLabel();
        thu4Ngay = new javax.swing.JLabel();
        thu5Ngay = new javax.swing.JLabel();
        thu6Ngay = new javax.swing.JLabel();
        thu7Ngay = new javax.swing.JLabel();
        thu8Ngay = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        comboPhongMay = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        menuHuy.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                menuHuyPopupMenuWillBecomeVisible(evt);
            }
        });

        buttonHuy.setText("Hủy đăng kí");
        buttonHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHuyActionPerformed(evt);
            }
        });
        menuHuy.add(buttonHuy);

        menuHuy.getAccessibleContext().setAccessibleParent(C3Content);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        lichDangKi.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Thứ 2");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Thứ 3");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Thứ 5");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Thứ 4");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Thứ 6");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Thứ 7");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Chủ nhật");

        S2.setBackground(new java.awt.Color(255, 255, 255));

        S2Content.setEditable(false);
        S2Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                S2ContentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(S2Content);

        javax.swing.GroupLayout S2Layout = new javax.swing.GroupLayout(S2);
        S2.setLayout(S2Layout);
        S2Layout.setHorizontalGroup(
            S2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        S2Layout.setVerticalGroup(
            S2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tối:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Sáng:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Chiều:");

        S4.setBackground(new java.awt.Color(255, 255, 255));

        S4Content.setEditable(false);
        S4Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                S4ContentMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(S4Content);

        javax.swing.GroupLayout S4Layout = new javax.swing.GroupLayout(S4);
        S4.setLayout(S4Layout);
        S4Layout.setHorizontalGroup(
            S4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        S4Layout.setVerticalGroup(
            S4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        S3.setBackground(new java.awt.Color(255, 255, 255));

        S3Content.setEditable(false);
        S3Content.setToolTipText("");
        S3Content.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        S3Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                S3ContentMouseClicked(evt);
            }
        });
        S3Content.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                S3ContentComponentShown(evt);
            }
        });
        jScrollPane2.setViewportView(S3Content);

        javax.swing.GroupLayout S3Layout = new javax.swing.GroupLayout(S3);
        S3.setLayout(S3Layout);
        S3Layout.setHorizontalGroup(
            S3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
        );
        S3Layout.setVerticalGroup(
            S3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        S5.setBackground(new java.awt.Color(255, 255, 255));

        S5Content.setEditable(false);
        S5Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                S5ContentMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(S5Content);

        javax.swing.GroupLayout S5Layout = new javax.swing.GroupLayout(S5);
        S5.setLayout(S5Layout);
        S5Layout.setHorizontalGroup(
            S5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        S5Layout.setVerticalGroup(
            S5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        S6.setBackground(new java.awt.Color(255, 255, 255));

        S6Content.setEditable(false);
        S6Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                S6ContentMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(S6Content);

        javax.swing.GroupLayout S6Layout = new javax.swing.GroupLayout(S6);
        S6.setLayout(S6Layout);
        S6Layout.setHorizontalGroup(
            S6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );
        S6Layout.setVerticalGroup(
            S6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );

        S8.setBackground(new java.awt.Color(255, 255, 255));

        S8Content.setEditable(false);
        S8Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                S8ContentMouseClicked(evt);
            }
        });
        jScrollPane22.setViewportView(S8Content);

        javax.swing.GroupLayout S8Layout = new javax.swing.GroupLayout(S8);
        S8.setLayout(S8Layout);
        S8Layout.setHorizontalGroup(
            S8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        S8Layout.setVerticalGroup(
            S8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane22)
        );

        S7.setBackground(new java.awt.Color(255, 255, 255));

        S7Content.setEditable(false);
        S7Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                S7ContentMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(S7Content);

        javax.swing.GroupLayout S7Layout = new javax.swing.GroupLayout(S7);
        S7.setLayout(S7Layout);
        S7Layout.setHorizontalGroup(
            S7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        S7Layout.setVerticalGroup(
            S7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        C2.setBackground(new java.awt.Color(255, 255, 255));

        C2Content.setEditable(false);
        C2Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C2ContentMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(C2Content);

        javax.swing.GroupLayout C2Layout = new javax.swing.GroupLayout(C2);
        C2.setLayout(C2Layout);
        C2Layout.setHorizontalGroup(
            C2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        C2Layout.setVerticalGroup(
            C2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14)
        );

        C3.setBackground(new java.awt.Color(255, 255, 255));

        C3Content.setEditable(false);
        C3Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C3ContentMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(C3Content);

        javax.swing.GroupLayout C3Layout = new javax.swing.GroupLayout(C3);
        C3.setLayout(C3Layout);
        C3Layout.setHorizontalGroup(
            C3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
        );
        C3Layout.setVerticalGroup(
            C3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13)
        );

        C4.setBackground(new java.awt.Color(255, 255, 255));

        C4Content.setEditable(false);
        C4Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C4ContentMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(C4Content);

        javax.swing.GroupLayout C4Layout = new javax.swing.GroupLayout(C4);
        C4.setLayout(C4Layout);
        C4Layout.setHorizontalGroup(
            C4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        C4Layout.setVerticalGroup(
            C4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12)
        );

        C5.setBackground(new java.awt.Color(255, 255, 255));

        C5Content.setEditable(false);
        C5Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C5ContentMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(C5Content);

        javax.swing.GroupLayout C5Layout = new javax.swing.GroupLayout(C5);
        C5.setLayout(C5Layout);
        C5Layout.setHorizontalGroup(
            C5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        C5Layout.setVerticalGroup(
            C5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11)
        );

        C6.setBackground(new java.awt.Color(255, 255, 255));

        C6Content.setEditable(false);
        C6Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C6ContentMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(C6Content);

        javax.swing.GroupLayout C6Layout = new javax.swing.GroupLayout(C6);
        C6.setLayout(C6Layout);
        C6Layout.setHorizontalGroup(
            C6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );
        C6Layout.setVerticalGroup(
            C6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10)
        );

        C7.setBackground(new java.awt.Color(255, 255, 255));

        C7Content.setEditable(false);
        C7Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C7ContentMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(C7Content);

        javax.swing.GroupLayout C7Layout = new javax.swing.GroupLayout(C7);
        C7.setLayout(C7Layout);
        C7Layout.setHorizontalGroup(
            C7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        C7Layout.setVerticalGroup(
            C7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9)
        );

        C8.setBackground(new java.awt.Color(255, 255, 255));

        C8Content.setEditable(false);
        C8Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C8ContentMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(C8Content);

        javax.swing.GroupLayout C8Layout = new javax.swing.GroupLayout(C8);
        C8.setLayout(C8Layout);
        C8Layout.setHorizontalGroup(
            C8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        C8Layout.setVerticalGroup(
            C8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        );

        T2.setBackground(new java.awt.Color(255, 255, 255));

        T2Content.setEditable(false);
        T2Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T2ContentMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(T2Content);

        javax.swing.GroupLayout T2Layout = new javax.swing.GroupLayout(T2);
        T2.setLayout(T2Layout);
        T2Layout.setHorizontalGroup(
            T2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        T2Layout.setVerticalGroup(
            T2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15)
        );

        T3.setBackground(new java.awt.Color(255, 255, 255));

        T3Content.setEditable(false);
        T3Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T3ContentMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(T3Content);

        javax.swing.GroupLayout T3Layout = new javax.swing.GroupLayout(T3);
        T3.setLayout(T3Layout);
        T3Layout.setHorizontalGroup(
            T3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
        );
        T3Layout.setVerticalGroup(
            T3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16)
        );

        T4.setBackground(new java.awt.Color(255, 255, 255));

        T4Content.setEditable(false);
        T4Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T4ContentMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(T4Content);

        javax.swing.GroupLayout T4Layout = new javax.swing.GroupLayout(T4);
        T4.setLayout(T4Layout);
        T4Layout.setHorizontalGroup(
            T4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        T4Layout.setVerticalGroup(
            T4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        T5.setBackground(new java.awt.Color(255, 255, 255));

        T5Content.setEditable(false);
        T5Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T5ContentMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(T5Content);

        javax.swing.GroupLayout T5Layout = new javax.swing.GroupLayout(T5);
        T5.setLayout(T5Layout);
        T5Layout.setHorizontalGroup(
            T5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        T5Layout.setVerticalGroup(
            T5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18)
        );

        T6.setBackground(new java.awt.Color(255, 255, 255));

        T6Content.setEditable(false);
        T6Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T6ContentMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(T6Content);

        javax.swing.GroupLayout T6Layout = new javax.swing.GroupLayout(T6);
        T6.setLayout(T6Layout);
        T6Layout.setHorizontalGroup(
            T6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );
        T6Layout.setVerticalGroup(
            T6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane19, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        T7.setBackground(new java.awt.Color(255, 255, 255));

        T7Content.setEditable(false);
        T7Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T7ContentMouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(T7Content);

        javax.swing.GroupLayout T7Layout = new javax.swing.GroupLayout(T7);
        T7.setLayout(T7Layout);
        T7Layout.setHorizontalGroup(
            T7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        T7Layout.setVerticalGroup(
            T7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane20)
        );

        T8.setBackground(new java.awt.Color(255, 255, 255));

        T8Content.setEditable(false);
        T8Content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T8ContentMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(T8Content);

        javax.swing.GroupLayout T8Layout = new javax.swing.GroupLayout(T8);
        T8.setLayout(T8Layout);
        T8Layout.setHorizontalGroup(
            T8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane21)
        );
        T8Layout.setVerticalGroup(
            T8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout lichDangKiLayout = new javax.swing.GroupLayout(lichDangKi);
        lichDangKi.setLayout(lichDangKiLayout);
        lichDangKiLayout.setHorizontalGroup(
            lichDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lichDangKiLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel1)
                .addGap(128, 128, 128)
                .addComponent(jLabel2)
                .addGap(132, 132, 132)
                .addComponent(jLabel4)
                .addGap(134, 134, 134)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(143, 143, 143)
                .addComponent(jLabel6)
                .addGap(105, 105, 105)
                .addComponent(jLabel7)
                .addGap(75, 75, 75))
            .addGroup(lichDangKiLayout.createSequentialGroup()
                .addGroup(lichDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lichDangKiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(S2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(S3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(S4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(S5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(S6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(S7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(S8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(lichDangKiLayout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(lichDangKiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lichDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addGap(14, 14, 14)
                .addGroup(lichDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lichDangKiLayout.createSequentialGroup()
                        .addComponent(T2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(T3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(T4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(T5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(T6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(T7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(T8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(lichDangKiLayout.createSequentialGroup()
                        .addComponent(C2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(C3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(C4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(C5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(C6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(C7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(C8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        lichDangKiLayout.setVerticalGroup(
            lichDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lichDangKiLayout.createSequentialGroup()
                .addGroup(lichDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lichDangKiLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lichDangKiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(lichDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGroup(lichDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lichDangKiLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel9))
                    .addGroup(lichDangKiLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(lichDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(S2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(S3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(S4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(S5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(S6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(S7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(S8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(lichDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lichDangKiLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel10))
                    .addGroup(lichDangKiLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(lichDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(C2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(C3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(C4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(C5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(C6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(C7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(C8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(lichDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lichDangKiLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(lichDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(T2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(T3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(T4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(T5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(T6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(T7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(T8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(lichDangKiLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel8)))
                .addGap(24, 24, 24)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Tuần:");

        comboTuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "46", "47", "48", "49", "50", "51", "52" }));
        comboTuan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboTuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTuanActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        thu2Ngay.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jPanel2.add(thu2Ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        thu3Ngay.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jPanel2.add(thu3Ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        thu4Ngay.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jPanel2.add(thu4Ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        thu5Ngay.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jPanel2.add(thu5Ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, -1));

        thu6Ngay.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jPanel2.add(thu6Ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

        thu7Ngay.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jPanel2.add(thu7Ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, -1, -1));

        thu8Ngay.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jPanel2.add(thu8Ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Ngày:");

        comboPhongMay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PM04 - Tòa A1 - Phòng 701" }));
        comboPhongMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPhongMayActionPerformed(evt);
            }
        });

        jMenu1.setText("trang chủ");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboPhongMay, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(24, 24, 24)
                        .addComponent(comboTuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lichDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(comboPhongMay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboTuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel20)))
                .addGap(3, 3, 3)
                .addComponent(lichDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void T8ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T8ContentMouseClicked

    }//GEN-LAST:event_T8ContentMouseClicked

    private void comboTuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTuanActionPerformed
        // TODO add your handling code here:
        new Thread(() -> {
            System.out.println("ahi: " + currentTuan);
            if (currentTuan == 0) {
                setLoadingData();
                return;
            }
            int selectedTuan = Integer.parseInt(comboTuan.getSelectedItem().toString());
            if (currentTuan != selectedTuan) {
                ArrayList<String> bayNgayTrongTuan = DBQuanLyThucHanh.getBayNgayTrongTuan(comboTuan.getSelectedIndex());

                for (int i = 0; i < 7; i++) {
                    ngayThang[i].setText(bayNgayTrongTuan.get(i));
                }

                currentTuan = selectedTuan;
                refreshData();
            }
        }).start();
    }//GEN-LAST:event_comboTuanActionPerformed

    private void S2ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S2ContentMouseClicked

    }//GEN-LAST:event_S2ContentMouseClicked

    private void S3ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S3ContentMouseClicked

    }//GEN-LAST:event_S3ContentMouseClicked

    private void S4ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S4ContentMouseClicked

    }//GEN-LAST:event_S4ContentMouseClicked

    private void S5ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S5ContentMouseClicked

    }//GEN-LAST:event_S5ContentMouseClicked

    private void S6ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S6ContentMouseClicked

    }//GEN-LAST:event_S6ContentMouseClicked

    private void S7ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S7ContentMouseClicked

    }//GEN-LAST:event_S7ContentMouseClicked

    private void S8ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S8ContentMouseClicked

    }//GEN-LAST:event_S8ContentMouseClicked

    private void C2ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C2ContentMouseClicked

    }//GEN-LAST:event_C2ContentMouseClicked

    private void C3ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C3ContentMouseClicked

    }//GEN-LAST:event_C3ContentMouseClicked

    private void C4ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C4ContentMouseClicked

    }//GEN-LAST:event_C4ContentMouseClicked

    private void C5ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C5ContentMouseClicked

    }//GEN-LAST:event_C5ContentMouseClicked

    private void C6ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C6ContentMouseClicked

    }//GEN-LAST:event_C6ContentMouseClicked

    private void C7ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C7ContentMouseClicked

    }//GEN-LAST:event_C7ContentMouseClicked

    private void C8ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C8ContentMouseClicked

    }//GEN-LAST:event_C8ContentMouseClicked

    private void T2ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T2ContentMouseClicked

    }//GEN-LAST:event_T2ContentMouseClicked

    private void T3ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T3ContentMouseClicked

    }//GEN-LAST:event_T3ContentMouseClicked

    private void T4ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T4ContentMouseClicked

    }//GEN-LAST:event_T4ContentMouseClicked

    private void T5ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T5ContentMouseClicked

    }//GEN-LAST:event_T5ContentMouseClicked

    private void T6ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T6ContentMouseClicked

    }//GEN-LAST:event_T6ContentMouseClicked

    private void T7ContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T7ContentMouseClicked

    }//GEN-LAST:event_T7ContentMouseClicked

    private void S3ContentComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_S3ContentComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_S3ContentComponentShown

    private void menuHuyPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_menuHuyPopupMenuWillBecomeVisible
        // TODO add your handling code here:
//        System.out.println("kich hoat huy");

    }//GEN-LAST:event_menuHuyPopupMenuWillBecomeVisible

    private void buttonHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHuyActionPerformed
        // TODO add your handling code here:
        Component invoker = menuHuy.getInvoker();
        javax.swing.JEditorPane canHuy = (javax.swing.JEditorPane) invoker;
        String buoiTH = "";
        String ngayCanHuy = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (thoiKhoaBieu[i][j].getText().equalsIgnoreCase(canHuy.getText())) {
                    switch (i) {
                        case 0 ->
                            buoiTH = "S";
                        case 1 ->
                            buoiTH = "C";
                        case 2 ->
                            buoiTH = "T";
                    }
                    ngayCanHuy = ngayThang[j].getText();

                    i = 99;
                    break;
                }
            }
        }

        System.out.println("Buoi can huy: " + buoiTH);
        System.out.println("Ngay can huy: " + ngayCanHuy);
        int maPM = arrPM.get(comboPhongMay.getSelectedIndex()).getMaPhongMay();
        boolean isDeletedLichThucHanh = DBQuanLyThucHanh.deleteLichThucHanhByAdmin(maPM, buoiTH, ngayCanHuy);
        if (isDeletedLichThucHanh) {
            JOptionPane.showMessageDialog(this, "Hủy thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Hủy không thành công!!!");
        }

        refreshData();
    }//GEN-LAST:event_buttonHuyActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        this.dispose();
        AdminScreenMain ttpm = new AdminScreenMain();
        ttpm.setLocationRelativeTo(ttpm);
        ttpm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void comboPhongMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPhongMayActionPerformed
        // TODO add your handling code here:
        new Thread(() -> {
            if (comboPhongMay.getSelectedIndex() == -1) {
                comboPhongMay.setSelectedIndex(0);
            }

            refreshData();
        }).start();
    }//GEN-LAST:event_comboPhongMayActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewManagerPracticeRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewManagerPracticeRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewManagerPracticeRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewManagerPracticeRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            ViewManagerPracticeRegistration dkPM = new ViewManagerPracticeRegistration();
            dkPM.setVisible(true);

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();

            //Calculate the frame location  
            int x = (screenSize.width - dkPM.getWidth()) / 2;
            int y = (screenSize.height - dkPM.getHeight()) / 2;

            dkPM.setLocation(x, y);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel C2;
    private javax.swing.JEditorPane C2Content;
    private javax.swing.JPanel C3;
    private javax.swing.JEditorPane C3Content;
    private javax.swing.JPanel C4;
    private javax.swing.JEditorPane C4Content;
    private javax.swing.JPanel C5;
    private javax.swing.JEditorPane C5Content;
    private javax.swing.JPanel C6;
    private javax.swing.JEditorPane C6Content;
    private javax.swing.JPanel C7;
    private javax.swing.JEditorPane C7Content;
    private javax.swing.JPanel C8;
    private javax.swing.JEditorPane C8Content;
    private javax.swing.JPanel S2;
    private javax.swing.JEditorPane S2Content;
    private javax.swing.JPanel S3;
    private javax.swing.JEditorPane S3Content;
    private javax.swing.JPanel S4;
    private javax.swing.JEditorPane S4Content;
    private javax.swing.JPanel S5;
    private javax.swing.JEditorPane S5Content;
    private javax.swing.JPanel S6;
    private javax.swing.JEditorPane S6Content;
    private javax.swing.JPanel S7;
    private javax.swing.JEditorPane S7Content;
    private javax.swing.JPanel S8;
    private javax.swing.JEditorPane S8Content;
    private javax.swing.JPanel T2;
    private javax.swing.JEditorPane T2Content;
    private javax.swing.JPanel T3;
    private javax.swing.JEditorPane T3Content;
    private javax.swing.JPanel T4;
    private javax.swing.JEditorPane T4Content;
    private javax.swing.JPanel T5;
    private javax.swing.JEditorPane T5Content;
    private javax.swing.JPanel T6;
    private javax.swing.JEditorPane T6Content;
    private javax.swing.JPanel T7;
    private javax.swing.JEditorPane T7Content;
    private javax.swing.JPanel T8;
    private javax.swing.JEditorPane T8Content;
    private javax.swing.JMenuItem buttonHuy;
    private javax.swing.JComboBox<String> comboPhongMay;
    private javax.swing.JComboBox<String> comboTuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel lichDangKi;
    private javax.swing.JPopupMenu menuHuy;
    private javax.swing.JLabel thu2Ngay;
    private javax.swing.JLabel thu3Ngay;
    private javax.swing.JLabel thu4Ngay;
    private javax.swing.JLabel thu5Ngay;
    private javax.swing.JLabel thu6Ngay;
    private javax.swing.JLabel thu7Ngay;
    private javax.swing.JLabel thu8Ngay;
    // End of variables declaration//GEN-END:variables
    public static final int soTuanDangDuocKiTruoc = 4;
    private int currentTuan;
    private int tuanNay;
    private boolean isUsingProcess;
    private ArrayList<PhongMay> arrPM;
    private ArrayList<String> arrMaLopHP = new ArrayList<>();
    private final javax.swing.JEditorPane[][] thoiKhoaBieu = new javax.swing.JEditorPane[3][7];
    private final javax.swing.JLabel[] ngayThang = new javax.swing.JLabel[7];

    private int getBuoiTrongNgay() {
        Date dt = new Date();
        int hours = dt.getHours();
        int mins = dt.getMinutes();
        if (hours < 7 && mins <= 59) {
            return 0;
        } else if (hours <= 12 && mins <= 30) {
            return 1;
        } else if (hours <= 17 && mins <= 30) {
            return 2;
        } else {
            return 3;
        }
    }
}
