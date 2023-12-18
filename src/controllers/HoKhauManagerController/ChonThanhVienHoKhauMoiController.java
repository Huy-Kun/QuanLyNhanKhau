package controllers.HoKhauManagerController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import models.CanCuocModel;
import models.NhanKhauModel;
import models.ThanhVienCuaHoModel;
import services.MysqlConnection;
import services.NhanKhauService;

public class ChonThanhVienHoKhauMoiController {

    private List<ThanhVienCuaHoModel> listThanhVienCuaHo;
    private JTable tableJpn;
    private NhanKhauService nhanKhauService;

    public ChonThanhVienHoKhauMoiController(JTable tableJpn, List<ThanhVienCuaHoModel> listThanhVienCuaHo) {
        this.listThanhVienCuaHo = listThanhVienCuaHo;
        this.tableJpn = tableJpn;
        this.nhanKhauService = new NhanKhauService();
        SetData();
    }

    void SetData() {
        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
        this.listThanhVienCuaHo.forEach(thanhVienCuaHoModel -> {
            CanCuocModel canCuocModel = nhanKhauService.GetCanCuoc(thanhVienCuaHoModel.getSoCCCD());
            model.addRow(new Object[]{false, canCuocModel.getNoiCapCCCD(), canCuocModel.getHoTen(),
                canCuocModel.getNgaySinh(), canCuocModel.getGioiTinh(), thanhVienCuaHoModel.getQuanHeVoiChuHo()
            });
        });
    }

    public List<NhanKhauModel> GetPickedNhanKhauModel() {
        List <NhanKhauModel> list = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
        for (int row = 0; row < model.getRowCount(); row++) {
            Object obj = true;
            if (model.getValueAt(row, 0) == obj) {
                list.add(GetNhanKhau(listThanhVienCuaHo.get(row).getSoCCCD()));
            }
        }
        return list;
    }

    public NhanKhauModel GetNhanKhau(String soCCCD) {
        NhanKhauModel nhanKhauModel = new NhanKhauModel();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM nhan_khau WHERE cccdNhanKhau = '" + soCCCD + "'";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                nhanKhauModel.setBiDanh(rs.getString("biDanh"));
                nhanKhauModel.setCccdNhanKhau(rs.getString("cccdNhanKhau"));
                nhanKhauModel.setDanToc(rs.getString("danToc"));
                nhanKhauModel.setNgayChuyenDen(rs.getDate("ngayChuyenDen"));
                nhanKhauModel.setNgheNghiep(rs.getString("ngheNghiep"));
                nhanKhauModel.setNoiLamViec(rs.getString("noiLamViec"));
                nhanKhauModel.setTonGiao(rs.getString("tonGiao"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return nhanKhauModel;
    }
}
