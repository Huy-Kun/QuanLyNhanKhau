package controllers;

import java.util.List;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import models.KhoanThuModel;
import services.KhoanThuService;

public class KhoanThuManagerPanelController {

    private JFrame parentJFrame;
    private JTable tableJpn;
    private KhoanThuService khoanThuService;
    private List<KhoanThuModel> listKhoanThu;

    public KhoanThuManagerPanelController(JFrame parentJFrame, JTable tableJpn) {
        this.parentJFrame = parentJFrame;
        this.tableJpn = tableJpn;
        this.khoanThuService = new KhoanThuService();
        Refresh();
    }

    public void SetData() {
        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
        model.setRowCount(0);
        this.listKhoanThu.forEach(khoanThuModel -> {
            int count = this.khoanThuService.GetTongNopTien(khoanThuModel);
            int sum = this.khoanThuService.GetTongTienNop(khoanThuModel);
            model.addRow(new Object[]{khoanThuModel.getMaKhoanThu(), khoanThuModel.getTenKhoanThu(), khoanThuModel.getLoaiKhoanThu(),
                khoanThuModel.getSoTien(), count, sum});
        });
    }

    public void Refresh() {
        this.listKhoanThu = khoanThuService.GetListKhoanThu();
        SetData();
    }
}
