package controllers.KhoanThuManagerController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import services.MysqlConnection;

public class ThemKhoanThuController {

    public boolean ThemMoiKhoanThu(String maKhoanThu, String tenKhoanThu, String loaiKhoanThu, int soTien) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO khoan_thu (maKhoanThu, tenKhoanThu, loaiKhoanThu, soTien)"
                + " values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, maKhoanThu);
        preparedStatement.setString(2, tenKhoanThu);
        preparedStatement.setString(3, loaiKhoanThu);
        preparedStatement.setInt(4, soTien);
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

    public boolean CheckMaKhoanThu(String maKhoanThu) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT * FROM khoan_thu WHERE khoan_thu.maKhoanThu = '" + maKhoanThu + "'";
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
}
