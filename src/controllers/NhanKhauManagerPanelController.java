package controllers;

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
    private NhanKhauService nhanKhauService;
    private List<NhanKhauModel> listNhanKhau;

    public NhanKhauManagerPanelController(JFrame parentJFrame, JTable tableJpn) {
        this.tableJpn = tableJpn;
        this.parentJFrame = parentJFrame;
        this.nhanKhauService = new NhanKhauService();
        Refresh();
    }
    
    public void SetData() {
        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
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
