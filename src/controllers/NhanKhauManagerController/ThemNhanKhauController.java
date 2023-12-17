package controllers.NhanKhauManagerController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import java.util.Date;
import javax.swing.JOptionPane;
import services.MysqlConnection;

public class ThemNhanKhauController {

    public void ThemMoiNhanKhau(String soCCCD, String hoTen, Date ngaySinh, String gioiTinh, String quocTich,
            String queQuan, String noiThuongTru, Date ngayCapCCCD, String noiCapCCCD,
            String biDanh, String danToc, String tonGiao, String ngheNghiep, String noiLamViec, Date ngayChuyenDen)
            throws SQLException, ClassNotFoundException {

        Connection connection = MysqlConnection.getMysqlConnection();

        String query = "INSERT INTO nhan_khau (cccdNhanKhau, biDanh, danToc, tonGiao, ngheNghiep, noiLamViec, ngayChuyenDen)"
                + " values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, soCCCD);
        preparedStatement.setString(2, biDanh);
        preparedStatement.setString(3, danToc);
        preparedStatement.setString(4, tonGiao);
        preparedStatement.setString(5, ngheNghiep);
        preparedStatement.setString(6, noiLamViec);
        preparedStatement.setDate(7, new java.sql.Date(ngayChuyenDen.getTime()));
        preparedStatement.executeUpdate();
        preparedStatement.close();

        query = "INSERT INTO can_cuoc (soCCCD   , hoTen, ngaySinh, gioiTinh, quocTich, queQuan, noiThuongTru, ngayCapCCCD, noiCapCCCD)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, soCCCD);
        preparedStatement.setString(2, hoTen);
        preparedStatement.setDate(3, new java.sql.Date(ngaySinh.getTime()));
        preparedStatement.setString(4, gioiTinh);
        preparedStatement.setString(5, quocTich);
        preparedStatement.setString(6, queQuan);
        preparedStatement.setString(7, noiThuongTru);
        preparedStatement.setDate(8, new java.sql.Date(ngayCapCCCD.getTime()));
        preparedStatement.setString(9, noiCapCCCD);
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

    public boolean CheckCCCD(String cccd) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT * FROM nhan_khau LEFT JOIN can_cuoc ON nhan_khau.cccdNhanKhau = can_cuoc.soCCCD WHERE soCCCD = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, cccd);
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
