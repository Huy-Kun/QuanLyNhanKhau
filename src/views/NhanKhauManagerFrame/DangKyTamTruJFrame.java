package views.NhanKhauManagerFrame;

import controllers.NhanKhauManagerController.DangKyTamTruController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DangKyTamTruJFrame extends javax.swing.JFrame {

    private JFrame parentFrame;
    private DangKyTamTruController controller;

    public DangKyTamTruJFrame() {
    }

    public DangKyTamTruJFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.parentFrame.setEnabled(false);
        this.controller = new DangKyTamTruController();
        initComponents();
        InitAction();
        setTitle("Đăng ký tạm trú");
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

        dateTuNgay = new com.raven.datechooser.DateChooser();
        dateDenNgay = new com.raven.datechooser.DateChooser();
        BG = new javax.swing.JPanel();
        txtTuNgay = new component.TextField();
        txtSoCCCD = new component.TextField();
        txtDiaChi = new component.TextField();
        txtLyDo = new component.TextField();
        txtDenNgay = new component.TextField();
        jLabel1 = new javax.swing.JLabel();
        btnDangKi = new component.MyButton();

        dateTuNgay.setTextRefernce(txtTuNgay);

        dateDenNgay.setTextRefernce(txtDenNgay);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BG.setBackground(new java.awt.Color(255, 255, 255));

        txtTuNgay.setBackground(new java.awt.Color(255, 255, 255));
        txtTuNgay.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtTuNgay.setLabelText("Từ ngày");

        txtSoCCCD.setBackground(new java.awt.Color(255, 255, 255));
        txtSoCCCD.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtSoCCCD.setLabelText("Số căn cước công dân");

        txtDiaChi.setBackground(new java.awt.Color(255, 255, 255));
        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDiaChi.setLabelText("Địa chỉ");

        txtLyDo.setBackground(new java.awt.Color(255, 255, 255));
        txtLyDo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtLyDo.setLabelText("Lý do");

        txtDenNgay.setBackground(new java.awt.Color(255, 255, 255));
        txtDenNgay.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDenNgay.setLabelText("Đến ngày");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Thêm tạm trú");

        btnDangKi.setForeground(new java.awt.Color(51, 51, 51));
        btnDangKi.setText("Đăng kí");
        btnDangKi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangKi.setRadius(5);
        btnDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BGLayout = new javax.swing.GroupLayout(BG);
        BG.setLayout(BGLayout);
        BGLayout.setHorizontalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BGLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18))
                        .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtLyDo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDenNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoCCCD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTuNgay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        BGLayout.setVerticalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BGLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(txtSoCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txtTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txtDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txtLyDo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
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

    private void btnDangKiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKiActionPerformed
        // TODO add your handling code here:
        if (!this.controller.ValidateValue(this, txtTuNgay.getText())) {
            return;
        }
        if (!this.controller.ValidateValue(this, txtLyDo.getText())) {
            return;
        }
        if (!this.controller.ValidateValue(this, txtSoCCCD.getText())) {
            return;
        }
        if (!this.controller.ValidateValue(this, txtDenNgay.getText())) {
            return;
        }
        if (!this.controller.ValidateValue(this, txtDiaChi.getText())) {
            return;
        }
        if (!this.controller.ValidateValueForCCCD(this, txtSoCCCD.getText())) {
            return;
        }
        try {
            if (!this.controller.CheckCCCD(txtSoCCCD.getText())) {
                JOptionPane.showConfirmDialog(null, "Không tìm thấy người có số CCCD: " + txtSoCCCD.getText() + ". Thêm mới?", "Confirm", JOptionPane.YES_NO_OPTION);
                return;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        try {
            this.controller.DangKi(txtSoCCCD.getText(), txtDiaChi.getText(),
                    txtTuNgay.getDate(), txtDenNgay.getDate(), txtLyDo.getText());
            JOptionPane.showMessageDialog(null, "Thêm thành công!!");
            close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDangKiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG;
    private component.MyButton btnDangKi;
    private com.raven.datechooser.DateChooser dateDenNgay;
    private com.raven.datechooser.DateChooser dateTuNgay;
    private javax.swing.JLabel jLabel1;
    private component.TextField txtDenNgay;
    private component.TextField txtDiaChi;
    private component.TextField txtLyDo;
    private component.TextField txtSoCCCD;
    private component.TextField txtTuNgay;
    // End of variables declaration//GEN-END:variables

}
