package controllers.NopTienManagerController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import models.HoKhauModel;
import services.MysqlConnection;

public class ThemNopTienController {

    private JComboBox ccbTenKhoanThu;
    private HoKhauModel hoKhauModel;
    private JTextField txtTenChuHo;

    public ThemNopTienController(JComboBox ccbTenKhoanThu, HoKhauModel hoKhauModel, JTextField txtTenChuHo) {
        this.ccbTenKhoanThu = ccbTenKhoanThu;
        this.hoKhauModel = hoKhauModel;
        this.txtTenChuHo = txtTenChuHo;
        SetData();
    }

    public void SetData() {
        if (this.ccbTenKhoanThu != null) {
            List<String> list = getListTenKhoanThu();
            this.ccbTenKhoanThu.addItem("");
            list.forEach(tenKhoanThu -> {
                this.ccbTenKhoanThu.addItem(tenKhoanThu);
            });
        }
        if (hoKhauModel.getMaHoKhau() != null) {
            this.txtTenChuHo.setText(hoKhauModel.getMaHoKhau());
        }
    }
    
    public List<String> getListTenKhoanThu() {
        List<String> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM khoan_thu";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("tenKhoanThu"));
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
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

    public boolean ThemMoiNopTien(String maHoKhau, String tenKhoanThu, int soTienNop, Date ngayNop) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO nop_tien (maHoKhau, tenKhoanThu, soTienNop, ngayNop)"
                + " values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, maHoKhau);
        preparedStatement.setString(2, tenKhoanThu);
        preparedStatement.setInt(3, soTienNop);
        preparedStatement.setDate(4, new java.sql.Date(ngayNop.getTime()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }

    public boolean ValidateValue(JFrame root, String temp) {
        if (temp.isEmpty()) {
            JOptionPane.showMessageDialog(root, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean ValidateIntValue(JFrame root, String temp) {
        try {
            long intValue = Long.parseLong(temp);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(root, "Không đúng định dạng số!", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}
