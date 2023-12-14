package controllers;

import javax.swing.JTable;
import javax.swing.JFrame;
import services.KhoanThuService;

public class KhoanThuManagerPanelController {

    private JFrame parentJFrame;
    private JTable tableJpn;
    private KhoanThuService khoanThuService;

    public KhoanThuManagerPanelController(JFrame parentJFrame, JTable tableJpn) {
        this.parentJFrame = parentJFrame;
        this.tableJpn = tableJpn;
        this.khoanThuService = new KhoanThuService();
        Refresh();
    }

    public void SetData() {
//        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
//        this.listKhoanTienBean.forEach(khoanTienBean -> {
//            model.addRow(new Object[]{khoanTienBean.getKhoanTienModel().getID(),
//            khoanTienBean.getKhoanTienModel().getTenKhoanThu(),
//            khoanTienBean.getKhoanTienModel().getSoTien(),
//            khoanTienBean.getKhoanTienModel().getLoaiKhoanThu(),
//            khoanTienBean.getSoHoDaNop(),
//            khoanTienBean.getTongSoTien()});
//        });
        
    }

    public void Refresh() {
        SetData();
    }
}
