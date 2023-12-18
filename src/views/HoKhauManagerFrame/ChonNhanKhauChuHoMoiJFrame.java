package views.HoKhauManagerFrame;

import component.ScrollBar;
import controllers.HoKhauManagerController.ChonNhanKhauChuHoMoiController;
import controllers.HoKhauManagerController.TachHoKhauController;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import models.NhanKhauModel;

public class ChonNhanKhauChuHoMoiJFrame extends javax.swing.JFrame {

    private JFrame parentJframe;
    private ChonNhanKhauChuHoMoiController controller;
    private TachHoKhauController parentController;
    private NhanKhauModel chuHoMoi;
    
    public ChonNhanKhauChuHoMoiJFrame(JFrame parentJframe, TachHoKhauController parentController, NhanKhauModel chuHoMoi) {
        initComponents();
        this.parentJframe = parentJframe;
        this.parentJframe.setEnabled(false);
        this.chuHoMoi = chuHoMoi;
        this.parentController = parentController;
        this.controller = new ChonNhanKhauChuHoMoiController(jTable3, parentController.GetListThanhVienCuaHo());
        InitAction();
        setTitle("Chọn nhân khẩu");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jScrollPane4.setVerticalScrollBar(new ScrollBar());
        jScrollPane4.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPane4.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        jScrollPane4.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        jScrollPane4.setViewportBorder(null);
        jScrollPane4.setBorder(BorderFactory.createEmptyBorder());
    }
    
    public void InitAction() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
            }

        });
    }

    void close() {
        this.parentJframe.setEnabled(true);
        dispose();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelBorder3 = new com.raven.swing.PanelBorder();
        panelBorder4 = new com.raven.swing.PanelBorder();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new component.Table();
        jLabel1 = new javax.swing.JLabel();
        textFieldAnimation1 = new component.TextFieldAnimation();
        btnTiepTuc = new component.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelBorder3.setPreferredSize(new java.awt.Dimension(820, 413));

        panelBorder4.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder4.setPreferredSize(new java.awt.Dimension(800, 401));

        jScrollPane4.setBorder(null);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Số CCCD", "Họ tên", "Ngày sinh", "Giới tính", "Quan hệ với chủ hộ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        javax.swing.GroupLayout panelBorder4Layout = new javax.swing.GroupLayout(panelBorder4);
        panelBorder4.setLayout(panelBorder4Layout);
        panelBorder4Layout.setHorizontalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );
        panelBorder4Layout.setVerticalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder4Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Danh sách thành viên");

        textFieldAnimation1.setBackground(new java.awt.Color(255, 255, 255));
        textFieldAnimation1.setAnimationColor(new java.awt.Color(178, 178, 178));
        textFieldAnimation1.setPreferredSize(new java.awt.Dimension(61, 40));

        btnTiepTuc.setForeground(new java.awt.Color(51, 51, 51));
        btnTiepTuc.setText("Tiếp tục");
        btnTiepTuc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTiepTuc.setRadius(5);
        btnTiepTuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiepTucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder4, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textFieldAnimation1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTiepTuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textFieldAnimation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnTiepTuc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnTiepTucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiepTucActionPerformed
        // TODO add your handling code here:
        NhanKhauModel _nhanKhauModel = controller.GetPickedNhanKhauModel();
        this.chuHoMoi.setBiDanh(_nhanKhauModel.getBiDanh());
        this.chuHoMoi.setCccdNhanKhau(_nhanKhauModel.getCccdNhanKhau());
        this.chuHoMoi.setDanToc(_nhanKhauModel.getDanToc());
        this.chuHoMoi.setNgayChuyenDen(_nhanKhauModel.getNgayChuyenDen());
        this.chuHoMoi.setNgheNghiep(_nhanKhauModel.getNgheNghiep());
        this.chuHoMoi.setNoiLamViec(_nhanKhauModel.getNoiLamViec());
        this.chuHoMoi.setTonGiao(_nhanKhauModel.getTonGiao());
        this.parentController.SetData();
        close();

    }//GEN-LAST:event_btnTiepTucActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MyButton btnTiepTuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private component.Table jTable3;
    private com.raven.swing.PanelBorder panelBorder3;
    private com.raven.swing.PanelBorder panelBorder4;
    private component.TextFieldAnimation textFieldAnimation1;
    // End of variables declaration//GEN-END:variables
}
