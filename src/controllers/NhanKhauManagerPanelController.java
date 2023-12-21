package controllers;

import component.EventCallBack;
import component.EventTextField;
import component.TextFieldAnimation;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.CanCuocModel;
import models.NhanKhauModel;
import services.NhanKhauService;

public class NhanKhauManagerPanelController {
    
    private JFrame parentJFrame;
    private JTable tableJpn;
    private TextFieldAnimation textFieldAnimation1;
    private NhanKhauService nhanKhauService;
    private List<NhanKhauModel> listNhanKhau;

    public NhanKhauManagerPanelController(JFrame parentJFrame, JTable tableJpn, TextFieldAnimation textFieldAnimation1) {
        this.tableJpn = tableJpn;
        this.parentJFrame = parentJFrame;
        this.textFieldAnimation1 = textFieldAnimation1;
        this.nhanKhauService = new NhanKhauService();
        this.textFieldAnimation1.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                try{
                    Thread.sleep(500);
                    listNhanKhau = nhanKhauService.GetListNhanKhauByKey(textFieldAnimation1.getText());
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
        this.listNhanKhau.forEach(nhanKhauModel -> {
            CanCuocModel canCuocModel = nhanKhauService.GetCanCuoc(nhanKhauModel.getCccdNhanKhau());
            model.addRow(new Object[]{nhanKhauModel.getCccdNhanKhau(), canCuocModel.getHoTen(),
                canCuocModel.getNgaySinh(), canCuocModel.getGioiTinh(), canCuocModel.getNoiThuongTru(),
            nhanKhauModel.getNgayChuyenDen()});
        });
    }
    
    public void Refresh() {
        listNhanKhau = nhanKhauService.GetListNhanKhau();
        SetData();
    }
}
