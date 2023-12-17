package controllers;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.CanCuocModel;
import models.ChuHoModel;
import models.HoKhauModel;
import services.HoKhauService;

public class HoKhauManagerPanelController {

    private JFrame parentJFrame;
    private JTable tableJpn;
    private HoKhauService hoKhauService;
    private List<HoKhauModel> listHoKhauModel;

    public HoKhauManagerPanelController(JFrame parentJFrame, JTable tableJpn) {
        this.parentJFrame = parentJFrame;
        this.tableJpn = tableJpn;
        this.hoKhauService = new HoKhauService();
        Refresh();
    }

    public void SetData() {
        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
        model.setRowCount(0);
        this.listHoKhauModel.forEach(hoKhauModel -> {
            ChuHoModel chuHoModel = this.hoKhauService.GetChuHo(hoKhauModel.getMaHoKhau());
            CanCuocModel canCuocChuHo = this.hoKhauService.GetCanCuoc(chuHoModel.getSoCCCD());
            model.addRow(new Object[]{hoKhauModel.getMaHoKhau(), canCuocChuHo.getHoTen(), hoKhauModel.getDiaChi(), hoKhauModel.getNgayTao().toString()});
        });
    }

    public void Refresh() {
        this.listHoKhauModel = hoKhauService.GetListHoKhau();
        SetData();
    }
}
