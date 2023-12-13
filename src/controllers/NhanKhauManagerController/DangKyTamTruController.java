package controllers.NhanKhauManagerController;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import services.MysqlConnection;

public class DangKyTamTruController {

    public void DangKi(String cccdNhanKhau, String diaChi, Date tuNgay, Date denNgay, String lyDo)
            throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO tam_tru(cccdNhanKhau, diaChi, tuNgay, denNgay, lyDo)"
                + " value (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, cccdNhanKhau);
        preparedStatement.setString(2, diaChi);
        preparedStatement.setDate(3, new java.sql.Date(tuNgay.getTime()));
        preparedStatement.setDate(4, new java.sql.Date(denNgay.getTime()));
        preparedStatement.setString(5, lyDo);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public boolean CheckCCCD(String cccd) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT * FROM nhan_khau LEFT JOIN can_cuoc ON nhan_khau.cccdNhanKhau = can_cuoc.soCCCD WHERE soCCCD = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, cccd);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            if (!rs.getString("cccdNhanKhau").trim().isEmpty()) {
                preparedStatement.close();
                connection.close();
                return true;
            }
        }
        preparedStatement.close();
        connection.close();
        return false;
    }
    
    public boolean ValidateValue(JFrame root, String temp) {
        if (temp.isEmpty()) {
            JOptionPane.showMessageDialog(root, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    public boolean ValidateValueForCCCD(JFrame root, String cccd) {
        try {
            long soCCCD = Long.parseLong(cccd);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(root, "Số CCCD không thể chứa các ký tự", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (cccd.length() != 12) {
            JOptionPane.showMessageDialog(root, "Vui lòng nhập đúng định dạng căn cước công dân", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}
