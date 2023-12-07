/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.KhoanThuManagerFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Bean.KhoanTienBean;
import models.KhoanThuModel;
import controllers.KhoanThuManagerPanelController;
import controllers.KhoanThuManagerController.ThemKhoanThuController;

public class ThemKhoanThu extends javax.swing.JFrame {

    private JFrame parentFrame;
    private KhoanThuManagerPanelController parentController;
    private KhoanTienBean khoanTienBean;
    private ThemKhoanThuController controller;

    public ThemKhoanThu(JFrame parentFrame, KhoanThuManagerPanelController parentController) {
        this.parentController = parentController;
        this.parentFrame = parentFrame;
        this.parentFrame.setEnabled(false);
        this.khoanTienBean = new KhoanTienBean();
        this.controller = new ThemKhoanThuController();
        initComponents();
        setTitle("Thêm mới khoản tiền");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
            }

        });
    }

    private void close() {
        this.parentFrame.setEnabled(true);
        dispose();
    }

    private boolean validateValueInForm() {
        // check null
        if (maKhoanTienTxb.getText().trim().isEmpty()
                || tenKhoanTienTxb.getText().trim().isEmpty()
                || soTienTxb.getText().trim().isEmpty()
                || !isNumeric(soTienTxb.getText().trim())) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        soTienTxb = new javax.swing.JTextField();
        loaiKhoanTienCbb = new javax.swing.JComboBox<>();
        maKhoanTienJlb = new javax.swing.JLabel();
        loaiKhoanTienJlb = new javax.swing.JLabel();
        tenKhoanTienJlb = new javax.swing.JLabel();
        soTienJlb = new javax.swing.JLabel();
        maKhoanTienTxb = new javax.swing.JTextField();
        tenKhoanTienTxb = new javax.swing.JTextField();
        cancelBtn = new javax.swing.JButton();
        storeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        soTienTxb.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        soTienTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soTienTxbActionPerformed(evt);
            }
        });

        loaiKhoanTienCbb.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        loaiKhoanTienCbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bắt Buộc", "Tự Nguyện" }));
        loaiKhoanTienCbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loaiKhoanTienCbbActionPerformed(evt);
            }
        });

        maKhoanTienJlb.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        maKhoanTienJlb.setText("Mã Khoản Tiền:");

        loaiKhoanTienJlb.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        loaiKhoanTienJlb.setText("Loại Khoản Tiền:");

        tenKhoanTienJlb.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tenKhoanTienJlb.setText("Tên Khoản Tiền:");

        soTienJlb.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        soTienJlb.setText("Số Tiền:");

        maKhoanTienTxb.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        maKhoanTienTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maKhoanTienTxbActionPerformed(evt);
            }
        });

        tenKhoanTienTxb.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tenKhoanTienTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenKhoanTienTxbActionPerformed(evt);
            }
        });

        cancelBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cancelBtn.setText("Hủy");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        storeBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        storeBtn.setText("Thêm");
        storeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(maKhoanTienJlb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tenKhoanTienJlb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loaiKhoanTienJlb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(soTienJlb, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(maKhoanTienTxb)
                                .addComponent(tenKhoanTienTxb)
                                .addComponent(soTienTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(loaiKhoanTienCbb, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(storeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maKhoanTienJlb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(maKhoanTienTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tenKhoanTienJlb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenKhoanTienTxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loaiKhoanTienJlb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loaiKhoanTienCbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soTienJlb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soTienTxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(storeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void storeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storeBtnActionPerformed
        // TODO add your handling code here:
        if (validateValueInForm()) {
            // tao moi 1 doi tuong nhan khau
            KhoanThuModel temp = this.khoanTienBean.getKhoanTienModel();
            temp.setTenKhoanThu(tenKhoanTienTxb.getText());
            temp.setLoaiKhoanThu(loaiKhoanTienCbb.getSelectedItem().toString());
            temp.setSoTien(Integer.parseInt(soTienTxb.getText()));
            try {
                if (this.controller.ThemMoiKhoanTien(this.khoanTienBean)) {
                    JOptionPane.showMessageDialog(null, "Thêm thành công!!");
                    close();
                    parentController.Refresh();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_storeBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void maKhoanTienTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maKhoanTienTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maKhoanTienTxbActionPerformed

    private void tenKhoanTienTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenKhoanTienTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenKhoanTienTxbActionPerformed

    private void loaiKhoanTienCbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loaiKhoanTienCbbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loaiKhoanTienCbbActionPerformed

    private void soTienTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soTienTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soTienTxbActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ThemKhoanThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ThemKhoanThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ThemKhoanThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ThemKhoanThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ThemKhoanThu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> loaiKhoanTienCbb;
    private javax.swing.JLabel loaiKhoanTienJlb;
    private javax.swing.JLabel maKhoanTienJlb;
    private javax.swing.JTextField maKhoanTienTxb;
    private javax.swing.JLabel soTienJlb;
    private javax.swing.JTextField soTienTxb;
    private javax.swing.JButton storeBtn;
    private javax.swing.JLabel tenKhoanTienJlb;
    private javax.swing.JTextField tenKhoanTienTxb;
    // End of variables declaration//GEN-END:variables
}