package controllers;

import component.EventCallBack;
import component.EventTextField;
import component.TextFieldAnimation;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import models.KhoanThuModel;
import services.KhoanThuService;

public class KhoanThuManagerPanelController {

    private JFrame parentJFrame;
    private JTable tableJpn;
    private TextFieldAnimation textFieldAnimation1;
    private KhoanThuService khoanThuService;
    private List<KhoanThuModel> listKhoanThu;

    public KhoanThuManagerPanelController(JFrame parentJFrame, JTable tableJpn, TextFieldAnimation textFieldAnimation1) {
        this.parentJFrame = parentJFrame;
        this.tableJpn = tableJpn;
        this.textFieldAnimation1 = textFieldAnimation1;
        this.khoanThuService = new KhoanThuService();
        this.textFieldAnimation1.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                try{
                    Thread.sleep(500);
                    listKhoanThu = khoanThuService.GetListKhoanThuByKey(textFieldAnimation1.getText());
                    SetData();
                    call.done();
                }catch (Exception e)
                {
                    System.err.println(e);
                }
            }

            @Override
            public void onCancel() {
            }
            
        });
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
