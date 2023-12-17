package controllers.HoKhauManagerController;

import java.util.List;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import models.CanCuocModel;
import models.NhanKhauModel;
import services.NhanKhauService;

public class ChonNhanKhauChuHoController {

    private List<NhanKhauModel> list;
    private JTable tableJpn;
    private NhanKhauService nhanKhauService;

    public ChonNhanKhauChuHoController(JTable tableJpn, List<NhanKhauModel> list) {
        this.list = list;
        this.tableJpn = tableJpn;
        this.nhanKhauService = new NhanKhauService();
        SetData();
        InitListener();
    }
    
    void InitListener() {
        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
        model.addTableModelListener(new TableModelListener() {
            private boolean programmaticChange = false;

            @Override
            public void tableChanged(TableModelEvent e) {
                if (!programmaticChange) {
                    programmaticChange = true;
                    int rowww = e.getFirstRow();
                    for (int row = 0; row < tableJpn.getRowCount(); row++) {
                        if (row != rowww) {
                            tableJpn.setValueAt(false, row, 0);
                        }
                    }
                    programmaticChange = false;
                }
            }
        });
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
    
    public NhanKhauModel GetPickedNhanKhauModel() {
        NhanKhauModel nhanKhauModel = new NhanKhauModel();
        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
        for (int row = 0; row < model.getRowCount(); row++) {
            Object obj = true;
            if (model.getValueAt(row, 0) == obj) {
                nhanKhauModel = list.get(row);
            }
        }
        return nhanKhauModel;
    }
}
