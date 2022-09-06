/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.qlth.views.admin;

import com.qlth.model.GiangVien;
import com.qlth.model.PhongMay;
import database.DBQuanLyThucHanh;
import java.awt.event.KeyEvent;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sinh
 */
public class viewManagerTeacher extends javax.swing.JFrame {

    /**
     * Creates new form viewManagerTeacher
     */
    public viewManagerTeacher() {
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtmagv = new javax.swing.JTextField();
        txttengv = new javax.swing.JTextField();
        khoa = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        sdt = new javax.swing.JTextField();
        hocvi = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("quản lý giảng viên");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setText("mã giảng viên");

        jLabel3.setText("tên giảng viên");

        jLabel4.setText("khoa");

        jLabel5.setText("học vị");

        khoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Công nghệ thông tin", "Cơ khí", "Ô tô", "Điện tử", "Ngoại ngữ", "Du lịch" }));

        jLabel6.setText("SĐT");

        hocvi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiến sĩ", "Thạc sĩ", "Giáo sư" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hocvi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(khoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmagv, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(txttengv)
                    .addComponent(sdt))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmagv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttengv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hocvi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(khoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(16, 16, 16))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("quản lý giảng viên");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlth/icons/add2.png"))); // NOI18N
        jButton1.setText("thêm");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themgiangvien(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlth/icons/edit.png"))); // NOI18N
        jButton2.setText("sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlth/icons/delete.png"))); // NOI18N
        jButton3.setText("xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("tìm kiếm ");

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel7))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(30, 30, 30)
                        .addComponent(jButton3))
                    .addComponent(search))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlth/icons/return.png"))); // NOI18N
        jButton4.setText("thoát");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "stt", "mã giảng viên", "tên giảng viên", "SĐT", "học vị", "Giảng vien khoa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xemthongtingv(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButton4)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(393, 393, 393))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        AdminScreenMain admin = new AdminScreenMain();
        admin.setLocationRelativeTo(admin);

        admin.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (int i = 0; i < DBQuanLyThucHanh.getDanhSachGiangVien().size(); i++) {
                GiangVien gv = DBQuanLyThucHanh.getDanhSachGiangVien().get(i);
                model.addRow(new Object[]{i + 1, gv.getMaGiangVien(), gv.getTenGiangVien(), gv.getSoDT(), gv.getHocVi(), gv.getKhoa()});
            }
            //get list combobox
        } catch (Exception ex) {
            Logger.getLogger(viewManagerRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void xemthongtingv(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xemthongtingv
        // TODO add your handling code here:
        try {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            Vector<Object> teacherVector = (Vector<Object>) tableModel.getDataVector().elementAt(table.getSelectedRow());
            GiangVien gv = new GiangVien(teacherVector.get(1).toString(), teacherVector.get(2).toString(), teacherVector.get(3).toString(), teacherVector.get(4).toString(), teacherVector.get(5).toString());
            txtmagv.setText(gv.getMaGiangVien());
            txttengv.setText(gv.getTenGiangVien());
            sdt.setText(gv.getSoDT());
            DefaultComboBoxModel comboBoxModelHocVi = (DefaultComboBoxModel) hocvi.getModel();
            for (int i = 0; i < comboBoxModelHocVi.getSize(); i++) {
                String itemComboBoxSelected = (String) comboBoxModelHocVi.getElementAt(i);
                if (itemComboBoxSelected.equals(gv.getHocVi())) {
                    comboBoxModelHocVi.setSelectedItem(itemComboBoxSelected);
                }
            }
            DefaultComboBoxModel comboBoxModelKhoa = (DefaultComboBoxModel) khoa.getModel();
            for (int i = 0; i < comboBoxModelKhoa.getSize(); i++) {
                String itemComboBoxSelected = (String) comboBoxModelKhoa.getElementAt(i);
                if (itemComboBoxSelected.equals(gv.getKhoa())) {
                    comboBoxModelKhoa.setSelectedItem(itemComboBoxSelected);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(viewManagerRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_xemthongtingv

    private void themgiangvien(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themgiangvien
        // TODO add your handling code here:
        try {
        String maGiangVien = (String) txtmagv.getText();
        String tenGiangVien=(String) txttengv.getText();
        String soDienThoai=(String) sdt.getText();
        String hocVi=String.valueOf(hocvi.getSelectedItem());
        String giangVienKhoa=String.valueOf(khoa.getSelectedItem());
        if (maGiangVien.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "vui lòng nhập đủ thông tin");
            }
            if (DBQuanLyThucHanh.insertGiangVien(maGiangVien, tenGiangVien, soDienThoai, hocVi, giangVienKhoa)) {
                JOptionPane.showMessageDialog(rootPane, "thêm thành công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "chưa thêm thành công");
            }
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for (int i = 0; i < DBQuanLyThucHanh.getDanhSachGiangVien().size(); i++) {
                GiangVien gv = DBQuanLyThucHanh.getDanhSachGiangVien().get(i);
                model.addRow(new Object[]{i + 1, gv.getMaGiangVien(), gv.getTenGiangVien(), gv.getSoDT(), gv.getHocVi(), gv.getKhoa()});
            }
        }catch (Exception ex) {
            Logger.getLogger(viewManagerRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_themgiangvien

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            DBQuanLyThucHanh.deleteGiangVien(txtmagv.getText());
             JOptionPane.showMessageDialog(rootPane, "xóa thành công");
              DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for (int i = 0; i < DBQuanLyThucHanh.getDanhSachGiangVien().size(); i++) {
                GiangVien gv = DBQuanLyThucHanh.getDanhSachGiangVien().get(i);
                model.addRow(new Object[]{i + 1, gv.getMaGiangVien(), gv.getTenGiangVien(), gv.getSoDT(), gv.getHocVi(), gv.getKhoa()});
            }
        } catch (Exception ex) {
           Logger.getLogger(viewManagerRoom.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
        String maGiangVien = (String) txtmagv.getText();
        String tenGiangVien=(String) txttengv.getText();
        String soDienThoai=(String) sdt.getText();
        String hocVi=String.valueOf(hocvi.getSelectedItem());
        String giangVienKhoa=String.valueOf(khoa.getSelectedItem());
        if (maGiangVien.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "vui lòng nhập đủ thông tin");
            }
            DBQuanLyThucHanh.updateGiangVien(maGiangVien, tenGiangVien, soDienThoai, hocVi, giangVienKhoa);
                JOptionPane.showMessageDialog(rootPane, "sửa thành công");
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for (int i = 0; i < DBQuanLyThucHanh.getDanhSachGiangVien().size(); i++) {
                GiangVien gv = DBQuanLyThucHanh.getDanhSachGiangVien().get(i);
                model.addRow(new Object[]{i + 1, gv.getMaGiangVien(), gv.getTenGiangVien(), gv.getSoDT(), gv.getHocVi(), gv.getKhoa()});
            }
        }catch (Exception ex) {
            Logger.getLogger(viewManagerRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String keySearch = search.getText().trim();
            if (keySearch.compareTo("") == 0) {
                JOptionPane.showMessageDialog(rootPane, "vui lòng nhập từ khóa muốn tìm kiếm");
            }
            try {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                for (int i = 0; i < DBQuanLyThucHanh.searchGiangVien(keySearch).size(); i++) {
                    GiangVien gv = DBQuanLyThucHanh.searchGiangVien(keySearch).get(i);
                    model.addRow(new Object[]{i + 1, gv.getMaGiangVien(),gv.getTenGiangVien(),gv.getSoDT(),gv.getHocVi(),gv.getKhoa()});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_searchKeyPressed

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
            java.util.logging.Logger.getLogger(viewManagerTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewManagerTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewManagerTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewManagerTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                viewManagerTeacher viewgv = new viewManagerTeacher();
                viewgv.setLocationRelativeTo(viewgv);
                viewgv.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> hocvi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> khoa;
    private javax.swing.JTextField sdt;
    private javax.swing.JTextField search;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtmagv;
    private javax.swing.JTextField txttengv;
    // End of variables declaration//GEN-END:variables
}
