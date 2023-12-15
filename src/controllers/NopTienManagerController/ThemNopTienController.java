package controllers.NopTienManagerController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.NopTienModel;
import services.MysqlConnection;

public class ThemNopTienController {
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
