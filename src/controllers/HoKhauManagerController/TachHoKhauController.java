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
import models.HoKhauModel;
import models.NhanKhauModel;
import models.ThanhVienCuaHoModel;
import services.MysqlConnection;

public class TachHoKhauController {

    private JFrame parentJframe;
    private JTable jTable1;
    private JTextField txtChuHoMoi;
    private JTextField txtMaHoKhauCanTach;
    private JButton btnChonChuHoMoi;
    private JButton btnThemThanhVien;
    private HoKhauModel hoKhau;
    private NhanKhauModel chuHoMoi;
    private List <NhanKhauModel> listThanhVien;

    public TachHoKhauController(JFrame parentJframe, JTable jTable1, JTextField txtChuHoMoi, JTextField txtMaHoKhauCanTach,
            JButton btnChonChuHoMoi, JButton btnThemThanhVien, HoKhauModel hoKhau, NhanKhauModel chuHoMoi, List <NhanKhauModel> listThanhVien) {
        this.parentJframe = parentJframe;
        this.jTable1 = jTable1;
        this.txtChuHoMoi = txtChuHoMoi;
        this.txtMaHoKhauCanTach = txtMaHoKhauCanTach;
        this.btnChonChuHoMoi = btnChonChuHoMoi;
        this.btnThemThanhVien = btnThemThanhVien;
        this.hoKhau = hoKhau;
        this.chuHoMoi = chuHoMoi;
        this.listThanhVien = listThanhVien;
        this.btnChonChuHoMoi.setEnabled(false);
        this.btnThemThanhVien.setEnabled(false);
        SetData();
    }
    
    public void SetData()
    {
        if(this.hoKhau != null)
        {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            if(!this.hoKhau.getMaHoKhau().equalsIgnoreCase(this.txtMaHoKhauCanTach.getText()))
            {
                this.txtMaHoKhauCanTach.setText("");
                model.setRowCount(0);
            }
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

    public boolean ValidateValue(JFrame root, String temp) {
        if (temp.isEmpty()) {
            JOptionPane.showMessageDialog(root, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
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

    public List<HoKhauModel> GetListHoKhau() {
        List<HoKhauModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM ho_khau ";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                HoKhauModel hoKhauModel = new HoKhauModel();
                hoKhauModel.setMaHoKhau(rs.getString("maHoKhau"));
                hoKhauModel.setDiaChi(rs.getString("diaChi"));
                hoKhauModel.setNgayTao(rs.getDate("ngayTao"));
                list.add(hoKhauModel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public List<ThanhVienCuaHoModel> GetListThanhVienCuaHo()
    {
        List<ThanhVienCuaHoModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM thanh_vien_cua_ho WHERE maHoKhau = '" + this.hoKhau.getMaHoKhau() + "'";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThanhVienCuaHoModel thanhVienCuaHoModel = new ThanhVienCuaHoModel();
                thanhVienCuaHoModel.setSoCCCD(rs.getString("soCCCD"));
                thanhVienCuaHoModel.setMaHoKhau(rs.getString("maHoKhau"));
                thanhVienCuaHoModel.setQuanHeVoiChuHo(rs.getString("quanHeVoiChuHo"));
                list.add(thanhVienCuaHoModel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public List<ThanhVienCuaHoModel> GetListThanhVienTach()
    {
        List<ThanhVienCuaHoModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM thanh_vien_cua_ho WHERE maHoKhau = '" + this.hoKhau.getMaHoKhau()
                    + "' AND soCCCD != '" + this.chuHoMoi.getCccdNhanKhau() + "'";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThanhVienCuaHoModel thanhVienCuaHoModel = new ThanhVienCuaHoModel();
                thanhVienCuaHoModel.setSoCCCD(rs.getString("soCCCD"));
                thanhVienCuaHoModel.setMaHoKhau(rs.getString("maHoKhau"));
                thanhVienCuaHoModel.setQuanHeVoiChuHo(rs.getString("quanHeVoiChuHo"));
                list.add(thanhVienCuaHoModel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
}
