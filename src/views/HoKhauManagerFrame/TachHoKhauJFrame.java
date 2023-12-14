package views.HoKhauManagerFrame;

import component.ScrollBar;
import controllers.HoKhauManagerController.TachHoKhauController;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TachHoKhauJFrame extends javax.swing.JFrame {

    private JFrame parentFrame;
    private TachHoKhauController controller;

    public TachHoKhauJFrame() {
    }

    public TachHoKhauJFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.parentFrame.setEnabled(false);
        this.controller = new TachHoKhauController(parentFrame);
        initComponents();
        InitAction();
        setTitle("Tách hộ khẩu");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jScrollPane2.setVerticalScrollBar(new ScrollBar());
        jScrollPane2.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        jScrollPane2.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        jScrollPane2.setViewportBorder(null);
        jScrollPane2.setBorder(BorderFactory.createEmptyBorder());
    }

    void InitAction() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }

        });
    }

    void close() {
        if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure to close?", "Warning!!", JOptionPane.YES_NO_OPTION)) {
            this.parentFrame.setEnabled(true);
            dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtMaHoKhauCanTach = new component.TextField();
        txtDiaChiMoi = new component.TextField();
        panelBorder2 = new com.raven.swing.PanelBorder();
        panelBorder1 = new com.raven.swing.PanelBorder();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new component.Table();
        jLabel1 = new javax.swing.JLabel();
        btnThemThanhVien = new component.MyButton();
        btnChonChuHoMoi = new component.MyButton();
        txtChuHoMoi = new component.TextField();
        jLabel2 = new javax.swing.JLabel();
        btnChonHoKhauCanTach = new component.MyButton();
        txtMaHoKhauMoi = new component.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtMaHoKhauCanTach.setBackground(new java.awt.Color(255, 255, 255));
        txtMaHoKhauCanTach.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtMaHoKhauCanTach.setLabelText("Mã hộ khẩu cần tách");

        txtDiaChiMoi.setBackground(new java.awt.Color(255, 255, 255));
        txtDiaChiMoi.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDiaChiMoi.setLabelText("Địa chỉ mới");

        panelBorder2.setBackground(new java.awt.Color(204, 204, 204));
        panelBorder2.setPreferredSize(new java.awt.Dimension(820, 413));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setPreferredSize(new java.awt.Dimension(800, 401));

        jScrollPane2.setBorder(null);

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Số CCCD", "Họ tên", "Quan hệ với chủ hộ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Thành viên tách cùng");

        btnThemThanhVien.setForeground(new java.awt.Color(28, 95, 192));
        btnThemThanhVien.setText("Thêm thành viên");
        btnThemThanhVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemThanhVien.setRadius(25);
        btnThemThanhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThanhVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnThemThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnChonChuHoMoi.setText("Chọn ...");
        btnChonChuHoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonChuHoMoiActionPerformed(evt);
            }
        });

        txtChuHoMoi.setBackground(new java.awt.Color(255, 255, 255));
        txtChuHoMoi.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtChuHoMoi.setLabelText("Chủ hộ mới");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tách hộ khẩu");

        btnChonHoKhauCanTach.setText("Chọn ...");
        btnChonHoKhauCanTach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonHoKhauCanTachActionPerformed(evt);
            }
        });

        txtMaHoKhauMoi.setBackground(new java.awt.Color(255, 255, 255));
        txtMaHoKhauMoi.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtMaHoKhauMoi.setLabelText("Mã hộ khẩu mới");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMaHoKhauCanTach, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnChonHoKhauCanTach, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtChuHoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnChonChuHoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addComponent(txtMaHoKhauMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                    .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(txtDiaChiMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMaHoKhauCanTach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonHoKhauCanTach, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtChuHoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnChonChuHoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaHoKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(txtDiaChiMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
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

    private void btnChonChuHoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonChuHoMoiActionPerformed
        // TODO add your handling code here:
        ChonNhanKhauJFrame chonNhanKhauJFrame = new ChonNhanKhauJFrame();
        chonNhanKhauJFrame.setLocationRelativeTo(null);
        chonNhanKhauJFrame.setResizable(false);
        chonNhanKhauJFrame.setVisible(true);
    }//GEN-LAST:event_btnChonChuHoMoiActionPerformed

    private void btnThemThanhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThanhVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemThanhVienActionPerformed

    private void btnChonHoKhauCanTachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonHoKhauCanTachActionPerformed
        // TODO add your handling code here:
        ChonHoKhauJFrame chonHoKhauJFrame = new ChonHoKhauJFrame();
        chonHoKhauJFrame.setLocationRelativeTo(null);
        chonHoKhauJFrame.setResizable(false);
        chonHoKhauJFrame.setVisible(true);
    }//GEN-LAST:event_btnChonHoKhauCanTachActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnChonChuHoMoi;
    private component.MyButton btnChonHoKhauCanTach;
    private component.MyButton btnThemThanhVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private component.Table jTable1;
    private com.raven.swing.PanelBorder panelBorder1;
    private com.raven.swing.PanelBorder panelBorder2;
    private component.TextField txtChuHoMoi;
    private component.TextField txtDiaChiMoi;
    private component.TextField txtMaHoKhauCanTach;
    private component.TextField txtMaHoKhauMoi;
    // End of variables declaration//GEN-END:variables
}
