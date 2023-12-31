package views.KhoanThuManagerFrame;

import controllers.KhoanThuManagerController.ThemKhoanThuController;
import controllers.KhoanThuManagerPanelController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Integer.parseInt;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ThemKhoanThuJFrame extends javax.swing.JFrame {

    private JFrame parentFrame;
    private ThemKhoanThuController controller;
    private KhoanThuManagerPanelController parentController;

    public ThemKhoanThuJFrame() {
    }

    public ThemKhoanThuJFrame(JFrame parentFrame, KhoanThuManagerPanelController parentController) {
        initComponents();
        this.parentFrame = parentFrame;
        this.parentFrame.setEnabled(false);
        this.parentController = parentController;
        this.controller = new ThemKhoanThuController(this.ccbLoaiKhoanThu, this.txtSoTien);
        InitAction();
        setTitle("Thêm khoản thu");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
        this.parentFrame.setEnabled(true);
        dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG = new javax.swing.JPanel();
        txtMaKhoanThu = new component.TextField();
        txtTenKhoanThu = new component.TextField();
        txtSoTien = new component.TextField();
        jLabel1 = new javax.swing.JLabel();
        btnThem = new component.MyButton();
        ccbLoaiKhoanThu = new component.Combobox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BG.setBackground(new java.awt.Color(255, 255, 255));

        txtMaKhoanThu.setBackground(new java.awt.Color(255, 255, 255));
        txtMaKhoanThu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtMaKhoanThu.setLabelText("Mã khoản thu");

        txtTenKhoanThu.setBackground(new java.awt.Color(255, 255, 255));
        txtTenKhoanThu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtTenKhoanThu.setLabelText("Tên khoản thu");

        txtSoTien.setBackground(new java.awt.Color(255, 255, 255));
        txtSoTien.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtSoTien.setLabelText("Số tiền");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Thêm Khoản Thu");

        btnThem.setForeground(new java.awt.Color(51, 51, 51));
        btnThem.setText("Thêm ngay");
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setRadius(5);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        ccbLoaiKhoanThu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Bắt buộc", "Tự nguyện", " " }));
        ccbLoaiKhoanThu.setLabeText("Loại khoản thu");

        javax.swing.GroupLayout BGLayout = new javax.swing.GroupLayout(BG);
        BG.setLayout(BGLayout);
        BGLayout.setHorizontalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ccbLoaiKhoanThu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(txtSoTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(txtTenKhoanThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaKhoanThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        BGLayout.setVerticalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BGLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(txtMaKhoanThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txtTenKhoanThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(ccbLoaiKhoanThu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txtSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (!this.controller.ValidateValue(this, txtMaKhoanThu.getText())) {
            return;
        }
        if (!this.controller.ValidateValue(this, txtSoTien.getText())) {
            return;
        }
        if (!this.controller.ValidateValue(this, txtTenKhoanThu.getText())) {
            return;
        }
        if (!this.controller.ValidateValue(this, ccbLoaiKhoanThu.getSelectedItem().toString())) {
            return;
        }
        if (!this.controller.ValidateIntValue(this, txtSoTien.getText())) {
            return;
        }
        try {
            if (!this.controller.CheckMaKhoanThu(txtMaKhoanThu.getText())) {
                JOptionPane.showMessageDialog(rootPane, "Mã khoản thu đã tổn tại!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            this.controller.ThemMoiKhoanThu(txtMaKhoanThu.getText(), txtTenKhoanThu.getText(),
                    ccbLoaiKhoanThu.getSelectedItem().toString(), parseInt(txtSoTien.getText()));
            JOptionPane.showMessageDialog(null, "Thêm thành công!!");
            close();
            parentController.Refresh();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG;
    private component.MyButton btnThem;
    private component.Combobox ccbLoaiKhoanThu;
    private javax.swing.JLabel jLabel1;
    private component.TextField txtMaKhoanThu;
    private component.TextField txtSoTien;
    private component.TextField txtTenKhoanThu;
    // End of variables declaration//GEN-END:variables

}
