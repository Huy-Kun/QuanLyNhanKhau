package controllers.NopTienManagerController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import models.CanCuocModel;
import models.ChuHoModel;
import models.HoKhauModel;
import services.MysqlConnection;

public final class ChonHoKhauNopTienController {

    private final JTable tableJpn;
    private List<HoKhauModel> listHoKhauModel;

    public ChonHoKhauNopTienController(JTable tableJpn, List<HoKhauModel> listHoKhauModel) {
        this.tableJpn = tableJpn;
        this.listHoKhauModel = listHoKhauModel;
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

    public void SetData() {
        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
        this.listHoKhauModel.forEach(hoKhauModel -> {
            ChuHoModel chuHoModel = this.GetChuHo(hoKhauModel.getMaHoKhau());
            CanCuocModel canCuocChuHo = this.GetCanCuoc(chuHoModel.getSoCCCD());
            model.addRow(new Object[]{false, hoKhauModel.getMaHoKhau(), canCuocChuHo.getHoTen(), hoKhauModel.getDiaChi(), hoKhauModel.getNgayTao().toString()});
        });
    }

    public HoKhauModel GetPickedHoKhauModel() {
        HoKhauModel hoKhauModel = new HoKhauModel();
        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
        for (int row = 0; row < model.getRowCount(); row++) {
            Object obj = true;
            if (model.getValueAt(row, 0) == obj) {
                hoKhauModel = listHoKhauModel.get(row);
            }
        }
        return hoKhauModel;
    }

    public ChuHoModel GetChuHo(String maHoKhau) {
        ChuHoModel chuHoModel = new ChuHoModel();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM chu_ho WHERE chu_ho.maHoKhau = '" + maHoKhau + "'";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                chuHoModel.setSoCCCD(rs.getString("soCCCD"));
                chuHoModel.setMaHoKhau(rs.getString("maHoKhau"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return chuHoModel;
    }

    public CanCuocModel GetCanCuoc(String soCCCD) {
        CanCuocModel canCuocModel = new CanCuocModel();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM can_cuoc WHERE can_cuoc.soCCCD = '" + soCCCD + "'";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                canCuocModel.setSoCCCD(rs.getString("soCCCD"));
                canCuocModel.setHoTen(rs.getString("hoTen"));
                canCuocModel.setNgaySinh(rs.getDate("ngaySinh"));
                canCuocModel.setGioiTinh(rs.getString("gioiTinh"));
                canCuocModel.setQuocTich(rs.getString("quocTich"));
                canCuocModel.setQueQuan(rs.getString("queQuan"));
                canCuocModel.setNoiThuongTru(rs.getString("noiThuongTru"));
                canCuocModel.setNgayCapCCCD(rs.getDate("ngayCapCCCD"));
                canCuocModel.setNoiCapCCCD(rs.getString("noiCapCCCD"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return canCuocModel;
    }
}
