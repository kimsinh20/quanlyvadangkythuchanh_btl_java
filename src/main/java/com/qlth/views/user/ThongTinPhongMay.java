/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.qlth.views.user;

import com.qlth.model.PhongMay;
import com.qlth.share.ShareData;
import database.DBQuanLyThucHanh;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ADMIN
 */
public class ThongTinPhongMay extends javax.swing.JFrame {

    /**
     * Creates new form ThongTinPhongMay
     *
     * @param maGV
     */
    public ThongTinPhongMay(String maGV) {
        this.maGV = maGV;
        initComponents();
        isUsingProcess = true;
        tableDanhSachPhong.getColumnModel().getColumn(0).setPreferredWidth(174);
        tableDanhSachPhong.getColumnModel().getColumn(1).setPreferredWidth(85);
        tableDanhSachPhong.getColumnModel().getColumn(2).setPreferredWidth(75);
        tableDanhSachPhong.getColumnModel().getColumn(3).setPreferredWidth(127);
        tableDanhSachPhong.getColumnModel().getColumn(4).setPreferredWidth(790);
        tableDanhSachPhong.getColumnModel().getColumn(5).setPreferredWidth(70);
        tinhTrang.setSelectedIndex(2);

        Calendar c = Calendar.getInstance();

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (int i = 0; i <= DangKiPhongMay.soTuanDangDuocKiTruoc * 7; i++) {
            model.addElement(convertDateToString(c.getTime()));
            c.add(Calendar.DATE, 1);
        }
        ngay.setModel(model);
        ngay.setSelectedIndex(0);
        TableColumn tColumn = tableDanhSachPhong.getColumnModel().getColumn(5);
        tColumn.setCellRenderer(new ColumnColorRenderer(Color.blue));
        
        autoRefresh();
    }

    public static String convertDateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableDanhSachPhong = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tinhTrang = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        ngay = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        buoiSang = new javax.swing.JCheckBox();
        buoiToi = new javax.swing.JCheckBox();
        buoiChieu = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tableDanhSachPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ph??ng m??y", "S??? m??y chi???u", "S??? m??y t??nh", "T??nh tr???ng ho???t ?????ng", "C??c ph???n m???m tr??n m??y", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDanhSachPhong.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableDanhSachPhong.setCellSelectionEnabled(true);
        tableDanhSachPhong.setRowHeight(40);
        tableDanhSachPhong.setShowGrid(false);
        tableDanhSachPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDanhSachPhongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDanhSachPhong);

        jLabel1.setText("Lo???i ph??ng: ");

        tinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "???? ????ng k??", "Ch??a ????ng k??", "T???t c???" }));
        tinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinhTrangActionPerformed(evt);
            }
        });

        jLabel2.setText("Ng??y: ");

        ngay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "", "" }));
        ngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngayActionPerformed(evt);
            }
        });

        jLabel3.setText("Bu???i:");

        buoiSang.setSelected(true);
        buoiSang.setText("S??ng");
        buoiSang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buoiSangActionPerformed(evt);
            }
        });

        buoiToi.setSelected(true);
        buoiToi.setText("T???i");
        buoiToi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buoiToiActionPerformed(evt);
            }
        });

        buoiChieu.setSelected(true);
        buoiChieu.setText("Chi???u");
        buoiChieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buoiChieuActionPerformed(evt);
            }
        });

        jMenu1.setText("trang ch???");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1327, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buoiSang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buoiChieu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buoiToi))
                    .addComponent(ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(buoiSang)
                    .addComponent(buoiChieu)
                    .addComponent(buoiToi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tinhTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinhTrangActionPerformed
        // TODO add your handling code here:
        updateTable();
    }//GEN-LAST:event_tinhTrangActionPerformed

    private void ngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngayActionPerformed
        // TODO add your handling code here:
        updateTable();
    }//GEN-LAST:event_ngayActionPerformed

    private void buoiSangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buoiSangActionPerformed
        // TODO add your handling code here:
        updateTable();
    }//GEN-LAST:event_buoiSangActionPerformed

    private void buoiChieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buoiChieuActionPerformed
        // TODO add your handling code here:
        updateTable();
    }//GEN-LAST:event_buoiChieuActionPerformed

    private void buoiToiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buoiToiActionPerformed
        // TODO add your handling code here:
        updateTable();
    }//GEN-LAST:event_buoiToiActionPerformed

    private void tableDanhSachPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDanhSachPhongMouseClicked
        // TODO add your handling code here:m
        if (tinhTrang.getSelectedIndex() >= 1) {
            int row = tableDanhSachPhong.rowAtPoint(evt.getPoint());
            int col = tableDanhSachPhong.columnAtPoint(evt.getPoint());
            if (row >= 0 && row < soPhongMayTrong && col == 5 && arrPhongMay != null) {
                int maPM = arrPhongMay.get(row).getMaPhongMay();
                String tenPM = arrPhongMay.get(row).getTenPhongMay();
                String diaChiPM = arrPhongMay.get(row).getDiaChiPhongMay();
                Point locationOnScreen = this.getLocationOnScreen();
                Thread thread = new Thread(() -> {
                    DangKiPhongMay dk = new DangKiPhongMay(ShareData.nguoiDangNhap.getTenDangNhap(), maPM, tenPM, diaChiPM, locationOnScreen);
                    dk.setVisible(true);
                });
                thread.start();
                this.dispose();
                isUsingProcess = false;
                try {
                    thread.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThongTinPhongMay.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    thread.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThongTinPhongMay.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                evt.consume();
            }
        }


    }//GEN-LAST:event_tableDanhSachPhongMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        this.dispose();
        UserScreenMain ttpm = new UserScreenMain();
        ttpm.setLocationRelativeTo(ttpm);
        ttpm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

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
            java.util.logging.Logger.getLogger(ThongTinPhongMay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinPhongMay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinPhongMay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinPhongMay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            ThongTinPhongMay ttpm = new ThongTinPhongMay(ShareData.nguoiDangNhap.getTenDangNhap());
            ttpm.setVisible(true);

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();

            //Calculate the frame location  
            int x = (screenSize.width - ttpm.getWidth()) / 2;
            int y = (screenSize.height - ttpm.getHeight()) / 2;

            ttpm.setLocation(x, y);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox buoiChieu;
    private javax.swing.JCheckBox buoiSang;
    private javax.swing.JCheckBox buoiToi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> ngay;
    private javax.swing.JTable tableDanhSachPhong;
    private javax.swing.JComboBox<String> tinhTrang;
    // End of variables declaration//GEN-END:variables
    private String maGV;
    private int soPhongMayTrong = 0;
    private boolean isUsingProcess = true;
    private ArrayList<PhongMay> arrPhongMay;

    private void autoRefresh() {
        Thread thAutoRefresh = new Thread(() -> {
            while (isUsingProcess) {
                try {
                    updateTable();
                } catch (Exception e) {
                }
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DangKiPhongMay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        thAutoRefresh.start();
    }

    private synchronized void updateTable() {
        System.out.println("update");
        // X??a h???t b???ng 
        DefaultTableModel model = (DefaultTableModel) tableDanhSachPhong.getModel();

//        for (int i = model.getRowCount() - 1; i >= 0; i--) {
//            model.removeRow(i);
//        }
        // t???o l???i b???ng 
        String buoi = "";
        if (buoiSang.isSelected()) {
            buoi += "S";
        }
        if (buoiChieu.isSelected()) {
            buoi += "C";
        }
        if (buoiToi.isSelected()) {
            buoi += "T";
        }
        int selectedTinhTrang = tinhTrang.getSelectedIndex();
        arrPhongMay = null;
        if (selectedTinhTrang == 0) {
            // lay cac phong da dang ki
            arrPhongMay = DBQuanLyThucHanh.getPhongMayTheoTinhTrang(0, ngay.getSelectedItem().toString(), buoi);
            soPhongMayTrong = 0;

        } else if (selectedTinhTrang > 0) {
            arrPhongMay = DBQuanLyThucHanh.getPhongMayTheoTinhTrang(1, ngay.getSelectedItem().toString(), buoi);
            if (arrPhongMay != null) {
                soPhongMayTrong = arrPhongMay.size();
            } else {
                arrPhongMay = new ArrayList<>();
            }

            if (selectedTinhTrang == 2) {
                ArrayList arrPhongChuaDK = DBQuanLyThucHanh.getPhongMayTheoTinhTrang(0, ngay.getSelectedItem().toString(), buoi);
                if (arrPhongChuaDK != null) {
                    arrPhongMay.addAll(arrPhongChuaDK);
                }
            }

        } else {
            System.out.println("SOS!!!");
        }

        if (arrPhongMay == null) {
            return;
        }

        model.setRowCount(arrPhongMay.size());

        for (int i = 0; i < arrPhongMay.size(); i++) {
            model.setValueAt(arrPhongMay.get(i).getTenPhongMay() + " - " + arrPhongMay.get(i).getDiaChiPhongMay(), i, 0);
            model.setValueAt(arrPhongMay.get(i).getSoMayChieu(), i, 1);
            model.setValueAt(arrPhongMay.get(i).getSoMayTinh(), i, 2);
            model.setValueAt(arrPhongMay.get(i).getTinhTrangPhong(), i, 3);
            model.setValueAt(arrPhongMay.get(i).getDanhSachPhanMem(), i, 4);
            if (i < soPhongMayTrong) {
                model.setValueAt("????ng k??", i, 5);
            } else {
                model.setValueAt("", i, 5);
            }
        }
    }
    // Customize the code to set the background and foreground color for each column of a JTable

    class ColumnColorRenderer extends DefaultTableCellRenderer {

        Color foregroundColor;

        public ColumnColorRenderer(Color foregroundColor) {
            super();
            this.foregroundColor = foregroundColor;
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            cell.setForeground(foregroundColor);
            return cell;
        }
    }
}
