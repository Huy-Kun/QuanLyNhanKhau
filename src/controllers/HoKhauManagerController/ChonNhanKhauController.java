package controllers.HoKhauManagerController;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.CanCuocModel;
import models.NhanKhauModel;
import services.NhanKhauService;

public class ChonNhanKhauController {

    private List<NhanKhauModel> list;
    private JTable tableJpn;
    private NhanKhauService nhanKhauService;

    public ChonNhanKhauController(List<NhanKhauModel> list, JTable tableJpn) {
        this.list = list;
        this.tableJpn = tableJpn;
        this.nhanKhauService = new NhanKhauService();
        SetData();
    }

    void SetData() {
        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
        this.list.forEach(nhanKhauModel -> {
            CanCuocModel canCuocModel = nhanKhauService.GetCanCuoc(nhanKhauModel.getCccdNhanKhau());
            model.addRow(new Object[]{false, nhanKhauModel.getCccdNhanKhau(), canCuocModel.getHoTen(),
                canCuocModel.getNgaySinh(), canCuocModel.getGioiTinh(), canCuocModel.getNoiThuongTru(),
                nhanKhauModel.getNgayChuyenDen()});
        });
    }
}
