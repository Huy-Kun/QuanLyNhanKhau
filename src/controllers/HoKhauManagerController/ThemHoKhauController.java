package controllers.HoKhauManagerController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import services.MysqlConnection;


public class ThemHoKhauController {
    public void ThemMoiHoKhau(String maHoKhau, String diaChi, Date ngaoTao)
            throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO ho_khau(maHoKhau, diaChi, ngaoTao)"
                + " value (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, maHoKhau);
        preparedStatement.setString(2, diaChi);
        preparedStatement.setDate(3, new java.sql.Date(ngaoTao.getTime()));
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
        String query = "INSERT INTO ho_khau(soCCCD, maHoKhau, quanHeVoiChuHo)"
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
    
}
