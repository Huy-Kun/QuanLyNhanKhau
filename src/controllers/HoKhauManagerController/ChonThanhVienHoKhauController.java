package controllers.HoKhauManagerController;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import models.CanCuocModel;
import models.NhanKhauModel;
import services.NhanKhauService;

public class ChonThanhVienHoKhauController {

    private List<NhanKhauModel> list;
    private JTable tableJpn;
    private NhanKhauService nhanKhauService;

    public ChonThanhVienHoKhauController(JTable tableJpn, List<NhanKhauModel> list) {
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
    
    public List<NhanKhauModel> GetPickedListNhanKhauModel() {
        List <NhanKhauModel> listThanhVien = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
        for (int row = 0; row < model.getRowCount(); row++) {
            Object obj = true;
            if (model.getValueAt(row, 0) == obj) {
                listThanhVien.add(list.get(row));
            }
        }
        return listThanhVien;
    }
}
