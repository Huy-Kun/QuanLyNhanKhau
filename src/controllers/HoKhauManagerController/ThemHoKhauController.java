package controllers.HoKhauManagerController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.CanCuocModel;
import models.NhanKhauModel;
import services.MysqlConnection;

public class ThemHoKhauController {

    private JTable tableJpn;
    private JButton btnThemThanhVien;
    private JTextField txtChuHo;
    private NhanKhauModel chuHo;
    private List<NhanKhauModel> listThanhVien;

    public ThemHoKhauController(JTable tableJpn, JButton btnThemThanhVien, JTextField txtChuHo,
            NhanKhauModel chuHo, List<NhanKhauModel> listThanhVien) {
        this.tableJpn = tableJpn;
        this.btnThemThanhVien = btnThemThanhVien;
        this.txtChuHo = txtChuHo;
        this.chuHo = chuHo;
        this.listThanhVien = listThanhVien;
        SetData();
    }

    public void SetData() {
        if (chuHo.getCccdNhanKhau() != null) {
            DefaultTableModel model = (DefaultTableModel) this.tableJpn.getModel();
            model.setRowCount(0);
            if (!txtChuHo.getText().equalsIgnoreCase(GetCanCuoc(chuHo.getCccdNhanKhau()).getHoTen())) {
                btnThemThanhVien.setEnabled(true);
                this.listThanhVien.clear();
            }
            this.listThanhVien.forEach(nhanKhauModel -> {
                model.addRow(new Object[]{nhanKhauModel.getCccdNhanKhau(),
                    GetCanCuoc(nhanKhauModel.getCccdNhanKhau()).getHoTen(), ""});
            });
            txtChuHo.setText(GetCanCuoc(chuHo.getCccdNhanKhau()).getHoTen());
        }
    }

    public void ThemMoiHoKhau(String maHoKhau, String diaChi, Date ngayTao)
            throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO ho_khau(maHoKhau, diaChi, ngayTao)"
                + " value (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, maHoKhau);
        preparedStatement.setString(2, diaChi);
        preparedStatement.setDate(3, new java.sql.Date(ngayTao.getTime()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public void ThemMoiChuHo(String soCCCD, String maHoKhau)
            throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO chu_ho(soCCCD, maHoKhau)"
                + " value (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, soCCCD);
        preparedStatement.setString(2, maHoKhau);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public void ThemMoiThanhVien(String soCCCD, String maHoKhau, String quanHeVoiChuHo)
            throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO thanh_vien_cua_ho(soCCCD, maHoKhau, quanHeVoiChuHo)"
                + " value (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, soCCCD);
        preparedStatement.setString(2, maHoKhau);
        preparedStatement.setString(3, quanHeVoiChuHo);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public boolean ValidateValue(JFrame root, String temp) {
        if (temp.isEmpty()) {
            JOptionPane.showMessageDialog(root, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
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

    public boolean CheckMaHoKhau(String maHoKhau) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT * FROM ho_khau WHERE ho_khau.maHoKhau = '" + maHoKhau + "'";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next() == false) {
            preparedStatement.close();
            connection.close();
            return true;
        }
        preparedStatement.close();
        connection.close();
        return false;
    }

    public List<NhanKhauModel> GetListNhanKhauByChuHo() {
        List<NhanKhauModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM nhan_khau WHERE cccdNhanKhau != '" + chuHo.getCccdNhanKhau()
                    + "' AND cccdNhanKhau NOT IN (SELECT soCCCD FROM thanh_vien_cua_ho) "
                    + "AND cccdNhanKhau NOT IN (SELECT soCCCD FROM chu_ho)";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                NhanKhauModel nhanKhauModel = new NhanKhauModel();
                nhanKhauModel.setCccdNhanKhau(rs.getString("cccdNhanKhau"));
                nhanKhauModel.setBiDanh(rs.getString("biDanh"));
                nhanKhauModel.setDanToc(rs.getString("danToc"));
                nhanKhauModel.setTonGiao(rs.getString("tonGiao"));
                nhanKhauModel.setNgheNghiep(rs.getString("ngheNghiep"));
                nhanKhauModel.setNoiLamViec(rs.getString("noiLamViec"));
                nhanKhauModel.setNgayChuyenDen(rs.getDate("ngayChuyenDen"));
                list.add(nhanKhauModel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.listThanhVien.forEach(thanhVien -> {
            Iterator<NhanKhauModel> iterator = list.iterator();
            while (iterator.hasNext()) {
                NhanKhauModel nhanKhauModel = iterator.next();
                if (nhanKhauModel.getCccdNhanKhau().equalsIgnoreCase(thanhVien.getCccdNhanKhau())) {
                    iterator.remove();
                    System.out.println("floag");
                }
            }
        });
        return list;
    }

    public List<NhanKhauModel> GetListNhanKhauNoHome() {
        List<NhanKhauModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM nhan_khau WHERE cccdNhanKhau NOT IN (SELECT soCCCD FROM thanh_vien_cua_ho) "
                    + "AND cccdNhanKhau NOT IN (SELECT soCCCD FROM chu_ho)";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                NhanKhauModel nhanKhauModel = new NhanKhauModel();
                nhanKhauModel.setCccdNhanKhau(rs.getString("cccdNhanKhau"));
                nhanKhauModel.setBiDanh(rs.getString("biDanh"));
                nhanKhauModel.setDanToc(rs.getString("danToc"));
                nhanKhauModel.setTonGiao(rs.getString("tonGiao"));
                nhanKhauModel.setNgheNghiep(rs.getString("ngheNghiep"));
                nhanKhauModel.setNoiLamViec(rs.getString("noiLamViec"));
                nhanKhauModel.setNgayChuyenDen(rs.getDate("ngayChuyenDen"));
                list.add(nhanKhauModel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
