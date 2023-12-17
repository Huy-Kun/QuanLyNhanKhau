package controllers.HoKhauManagerController;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.CanCuocModel;
import models.ChuHoModel;
import models.HoKhauModel;
import services.HoKhauService;

public final class ChonHoKhauController {

    private final JFrame parentFrame;
    private final JTable tableJpn;
    private final HoKhauService hoKhauService;
    private List<HoKhauModel> listHoKhauModel;

    public ChonHoKhauController(JFrame parentFrame, JTable tableJpn) {
        this.parentFrame = parentFrame;
        this.tableJpn = tableJpn;
        this.hoKhauService = new HoKhauService();
        Refresh();
    }

    public void SetData() {
        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
        this.listHoKhauModel.forEach(hoKhauModel -> {
            ChuHoModel chuHoModel = this.hoKhauService.GetChuHo(hoKhauModel.getMaHoKhau());
            CanCuocModel canCuocChuHo = this.hoKhauService.GetCanCuoc(chuHoModel.getSoCCCD());
            model.addRow(new Object[]{false, hoKhauModel.getMaHoKhau(), canCuocChuHo.getHoTen(), hoKhauModel.getDiaChi(), hoKhauModel.getNgayTao().toString()});
        });
    }

    public void Refresh() {
        this.listHoKhauModel = hoKhauService.GetListHoKhau();
        SetData();
    }
}
