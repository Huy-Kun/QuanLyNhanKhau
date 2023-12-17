package controllers.HoKhauManagerController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.NhanKhauModel;
import services.MysqlConnection;

public class ThemHoKhauController {
    
    private JTable tableJpn;
    private JButton btnChonChuHo;
    private JButton btnThemThanhVien;
    private JTextField txtChuHo;
    private List <NhanKhauModel> list;
    private String soCCCDChuHo;
    
    public ThemHoKhauController(JTable tableJpn, JButton btnChonChuHo, JButton btnThemThanhVien, JTextField txtChuHo){
        this.tableJpn = tableJpn;
        this.btnChonChuHo = btnChonChuHo;
        this.btnThemThanhVien = btnThemThanhVien;
        this.txtChuHo = txtChuHo;
        this.list = new ArrayList<>();
    }
    
    public List <NhanKhauModel> GetList()
    {
        return this.list;
    }
    
    public void SetTxtChuHo(String chuHo)
    {
        txtChuHo.setText(chuHo);
        btnThemThanhVien.setEnabled(true);
        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
        model.setRowCount(0);
    }
    
    public String GetSoCCCDChuHo()
    {
        return soCCCDChuHo;
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
    
    public boolean CheckMaHoKhau(String maHoKhau) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT * FROM ho_khau WHERE ho_khau.maHoKhau = " + maHoKhau;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            if (!rs.getString("maHoKhau").trim().isEmpty()) {
                preparedStatement.close();
                connection.close();
                return true;
            }
        }
        preparedStatement.close();
        connection.close();
        return false;
    }
    
    public List<NhanKhauModel> GetListNhanKhauByChuHo(String soCCCD ) {
        List<NhanKhauModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM nhan_khau ";
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
