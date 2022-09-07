/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.qlth.views.admin;

import com.qlth.model.ThucHanh;
import database.DBQuanLyThucHanh;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Sinh
 */
public class viewBaoCaoTheoKy extends javax.swing.JFrame {

    /**
     * Creates new form viewStatistical
     */
    public viewBaoCaoTheoKy() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonXuatBaoCao = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        comboKy = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboNam = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("BÁO CÁO THEO KỲ");

        buttonXuatBaoCao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlth/icons/save.png"))); // NOI18N
        buttonXuatBaoCao.setText("Xuất báo cáo ");
        buttonXuatBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXuatBaoCaoActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlth/icons/return.png"))); // NOI18N
        jButton2.setText("thoát");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        comboKy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        comboKy.setSelectedIndex(1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Kỳ học:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Năm:");

        comboNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2023", "2024", "2025", "2026" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 271, Short.MAX_VALUE)
                .addComponent(buttonXuatBaoCao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(285, 285, 285))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonXuatBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(224, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        AdminScreenMain admin = new AdminScreenMain();
        admin.setLocationRelativeTo(admin);

        admin.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buttonXuatBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXuatBaoCaoActionPerformed
        new Thread(() -> {
            int nam = Integer.parseInt(comboNam.getSelectedItem().toString());
            int ky = Integer.parseInt(comboKy.getSelectedItem().toString());

            String ngay = DBQuanLyThucHanh.getNgayBatDauHocKy(nam, ky);

            xuatBaoCaoTheoKy(ngay, "D:/BaoCao_Nam" + nam + "_Ky" + ky + "_ThoiGianXuat_" + LocalDate.now() + ".xlsx");
        }).start();

    }//GEN-LAST:event_buttonXuatBaoCaoActionPerformed

    private void xuatBaoCaoTheoKy(String ngay, String path) {
        ArrayList<Integer> listMaPhongMay = DBQuanLyThucHanh.getListMaPhongMay();
        int rowid;
        int cellid;
        XSSFRow row;
        XSSFWorkbook workbook = new XSSFWorkbook();

        for (int tuan = 1; tuan <= soTuanMotKy; tuan++) {
            XSSFSheet spreadsheet = workbook.createSheet("Tuần " + tuan);
            buttonXuatBaoCao.setText(String.format("%3.2f",((float)tuan / soTuanMotKy)*100) + "%");
            rowid = 0;
            String ngayBatDau_ketThuc = DBQuanLyThucHanh.getThoiGianBatDauDenKetThucTuan(ngay, tuan);

            String[] splitNgay = ngayBatDau_ketThuc.split("\\|");
            String ngayBatDau = splitNgay[0];
            String ngayKetThuc = splitNgay[6];

            for (Integer integer : listMaPhongMay) {
                ArrayList<ThucHanh> danhSachDaDangKi = DBQuanLyThucHanh.getDanhSachDaDangKi(ngayBatDau, ngayKetThuc, integer);
                if (danhSachDaDangKi == null) {
                    continue;
                }

                // row 1
                row = spreadsheet.createRow(rowid++);
                cellid = 0;

                String tenPhongMay = DBQuanLyThucHanh.getTenPhongMay(integer);

                Cell cell = row.createCell(cellid++);
                cell.setCellValue(tenPhongMay);

                cell = row.createCell(cellid++);
                cell.setCellValue("Ngày");
                for (String string : splitNgay) {
                    cell = row.createCell(cellid++);
                    cell.setCellValue(string);
                }

                // row 2
                row = spreadsheet.createRow(rowid++);
                cellid = 0;
                cell = row.createCell(cellid++);
                cell.setCellValue("");
                cell = row.createCell(cellid++);
                cell.setCellValue("Ca");
                cell = row.createCell(cellid++);
                cell.setCellValue("Thứ 2");
                cell = row.createCell(cellid++);
                cell.setCellValue("Thứ 3");
                cell = row.createCell(cellid++);
                cell.setCellValue("Thứ 4");
                cell = row.createCell(cellid++);
                cell.setCellValue("Thứ 5");
                cell = row.createCell(cellid++);
                cell.setCellValue("Thứ 6");
                cell = row.createCell(cellid++);
                cell.setCellValue("Thứ 7");
                cell = row.createCell(cellid++);
                cell.setCellValue("Thứ 8 - CN");

                // row 3
                row = spreadsheet.createRow(rowid++);
                cellid = 0;
                cell = row.createCell(cellid++);
                cell.setCellValue("");
                cell = row.createCell(cellid++);
                cell.setCellValue("S");

                while (cellid < 9) {
                    ThucHanh lichInCurrentCell = isInDanhSachDaDangKi(danhSachDaDangKi, cellid - 2, "S", splitNgay);
                    cell = row.createCell(cellid++);
                    if (lichInCurrentCell != null) {
                        cell.setCellValue(String.format("%s\n%s\n%s", lichInCurrentCell.getLopHocPhan().getMaLopHocPhan(), lichInCurrentCell.getLopHocPhan().getGiangVien().getTenGiangVien(), lichInCurrentCell.getLopHocPhan().getTenMonHoc()));
                    } else {
                        cell.setCellValue("#N/A");
                    }
                }

                // row 4
                row = spreadsheet.createRow(rowid++);
                cellid = 0;

                cell = row.createCell(cellid++);
                cell.setCellValue("");
                cell = row.createCell(cellid++);
                cell.setCellValue("C");

                while (cellid < 9) {
                    ThucHanh lichInCurrentCell = isInDanhSachDaDangKi(danhSachDaDangKi, cellid - 2, "C", splitNgay);
                    cell = row.createCell(cellid++);
                    if (lichInCurrentCell != null) {
                        cell.setCellValue(String.format("%s\n%s\n%s", lichInCurrentCell.getLopHocPhan().getMaLopHocPhan(), lichInCurrentCell.getLopHocPhan().getGiangVien().getTenGiangVien(), lichInCurrentCell.getLopHocPhan().getTenMonHoc()));
                    } else {
                        cell.setCellValue("#N/A");
                    }
                }

                // row 5
                row = spreadsheet.createRow(rowid++);
                cellid = 0;
                cell = row.createCell(cellid++);
                cell.setCellValue("");
                cell = row.createCell(cellid++);
                cell.setCellValue("T");

                while (cellid < 9) {
                    ThucHanh lichInCurrentCell = isInDanhSachDaDangKi(danhSachDaDangKi, cellid - 2, "T", splitNgay);
                    cell = row.createCell(cellid++);
                    if (lichInCurrentCell != null) {
                        cell.setCellValue(String.format("%s\n%s\n%s", lichInCurrentCell.getLopHocPhan().getMaLopHocPhan(), lichInCurrentCell.getLopHocPhan().getGiangVien().getTenGiangVien(), lichInCurrentCell.getLopHocPhan().getTenMonHoc()));
                    } else {
                        cell.setCellValue("#N/A");
                    }
                }
            }
        }

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(
                    new File(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(viewBaoCaoTheoTuan.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            workbook.write(out);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(viewBaoCaoTheoTuan.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(rootPane, """
                                                \u0110\u00e3 xu\u1ea5t b\u00e1o c\u00e1o.
                                                """ + path);
        buttonXuatBaoCao.setText("Xuất báo cáo ");
    }

    private ThucHanh isInDanhSachDaDangKi(ArrayList<ThucHanh> danhSachDaDangKi, int col, String buoiTH, String[] splitNgay) {
        String ngayTH = splitNgay[col];

        for (ThucHanh thucHanh : danhSachDaDangKi) {
//            System.out.println(thucHanh.getNgayThucHanh() + "-" + ngayTH);
            if (thucHanh.getNgayThucHanh().equalsIgnoreCase(ngayTH) && thucHanh.getTietTH().equalsIgnoreCase(buoiTH)) {
//                System.out.println("yes");
                return thucHanh;
            }
        }
        return null;
    }

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
            java.util.logging.Logger.getLogger(viewBaoCaoTheoKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewBaoCaoTheoKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewBaoCaoTheoKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewBaoCaoTheoKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewBaoCaoTheoKy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonXuatBaoCao;
    private javax.swing.JComboBox<String> comboKy;
    private javax.swing.JComboBox<String> comboNam;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    private int soTuanMotKy = 15;
}
