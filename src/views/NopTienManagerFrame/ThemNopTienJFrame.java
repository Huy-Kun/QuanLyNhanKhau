package views.NopTienManagerFrame;

import controllers.NopTienManagerController.ThemNopTienController;
import controllers.NopTienManagerPanelController;
import views.NopTienManagerFrame.ChonHoKhauNopTienJFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Integer.parseInt;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.HoKhauModel;

public class ThemNopTienJFrame extends javax.swing.JFrame {

    private JFrame parentFrame;
    private ThemNopTienController controller;
    private NopTienManagerPanelController parentController;
    private HoKhauModel hoKhauModel;

    public ThemNopTienJFrame() {
    }

    public ThemNopTienJFrame(JFrame parentFrame, NopTienManagerPanelController parentController) {
        initComponents();
        this.parentFrame = parentFrame;
        this.parentFrame.setEnabled(false);
        this.parentController = parentController;
        this.hoKhauModel = new HoKhauModel();
        this.controller = new ThemNopTienController(this.ccbTenKhoanThu, this.hoKhauModel,
                this.txtMaHoKhau, this.txtTenChuHo, this.txtSoTienNop);
        InitAction();
        setTitle("Thêm nộp tiền");
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG = new javax.swing.JPanel();
        txtMaHoKhau = new component.TextField();
        txtTenChuHo = new component.TextField();
        txtSoTienNop = new component.TextField();
        jLabel1 = new javax.swing.JLabel();
        btnThem = new component.MyButton();
        ccbTenKhoanThu = new component.Combobox();
        btnChonHoKhau = new component.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BG.setBackground(new java.awt.Color(255, 255, 255));

        txtMaHoKhau.setEditable(false);
        txtMaHoKhau.setBackground(new java.awt.Color(255, 255, 255));
        txtMaHoKhau.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtMaHoKhau.setLabelText("Mã hộ khẩu");

        txtTenChuHo.setEditable(false);
        txtTenChuHo.setBackground(new java.awt.Color(255, 255, 255));
        txtTenChuHo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtTenChuHo.setLabelText("Tên chủ hộ");

        txtSoTienNop.setBackground(new java.awt.Color(255, 255, 255));
        txtSoTienNop.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtSoTienNop.setLabelText("Số tiền nộp");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Thêm nộp tiền");

        btnThem.setForeground(new java.awt.Color(51, 51, 51));
        btnThem.setText("Thêm ngay");
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setRadius(5);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        ccbTenKhoanThu.setLabeText("Chọn khoản thu");

        btnChonHoKhau.setText("Chọn ...");
        btnChonHoKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonHoKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BGLayout = new javax.swing.GroupLayout(BG);
        BG.setLayout(BGLayout);
        BGLayout.setHorizontalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGLayout.createSequentialGroup()
                .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BGLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel1))
                    .addGroup(BGLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ccbTenKhoanThu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(txtSoTienNop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTenChuHo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BGLayout.createSequentialGroup()
                                    .addComponent(txtMaHoKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnChonHoKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        BGLayout.setVerticalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BGLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaHoKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChonHoKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(txtTenChuHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(ccbTenKhoanThu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txtSoTienNop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (!this.controller.ValidateValue(this, txtMaHoKhau.getText())) {
            return;
        }
        if (!this.controller.ValidateValue(this, txtSoTienNop.getText())) {
            return;
        }
        if (!this.controller.ValidateValue(this, ccbTenKhoanThu.getSelectedItem().toString())) {
            return;
        }
        if (!this.controller.ValidateIntValue(this, txtSoTienNop.getText())) {
            return;
        }
        try {
            this.controller.ThemMoiNopTien(txtMaHoKhau.getText(), ccbTenKhoanThu.getSelectedItem().toString(),
                    parseInt(txtSoTienNop.getText()), new Date(System.currentTimeMillis()));
            JOptionPane.showMessageDialog(null, "Thêm thành công!!");
            close();
            parentController.Refresh();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnChonHoKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonHoKhauActionPerformed
        // TODO add your handling code here:
//        if (this.controller.GetListHoKhau().size() == 0) {
//            JOptionPane.showMessageDialog(null, "Không tồn tại hộ khẩu nào!", "Warning", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
        ChonHoKhauNopTienJFrame chonHoKhauNopTienJFrame = new ChonHoKhauNopTienJFrame(this.parentFrame, this.controller, this.hoKhauModel);
        chonHoKhauNopTienJFrame.setLocationRelativeTo(null);
        chonHoKhauNopTienJFrame.setResizable(false);
        chonHoKhauNopTienJFrame.setVisible(true);
    }//GEN-LAST:event_btnChonHoKhauActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG;
    private component.MyButton btnChonHoKhau;
    private component.MyButton btnThem;
    private component.Combobox ccbTenKhoanThu;
    private javax.swing.JLabel jLabel1;
    private component.TextField txtMaHoKhau;
    private component.TextField txtSoTienNop;
    private component.TextField txtTenChuHo;
    // End of variables declaration//GEN-END:variables

}
