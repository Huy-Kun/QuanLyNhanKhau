package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TrangChuService {

    public int TongNhanKhau() {
        int sum = 0;
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT COUNT(*) AS tong FROM nhan_khau";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sum = rs.getInt("tong");
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
        }
        return sum;
    }

    public int TongHoKhau() {
        int sum = 0;
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT COUNT(*) AS tong FROM ho_khau";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sum = rs.getInt("tong");
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
        }
        return sum;
    }

    public int TongTamTru() {
        int sum = 0;
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT COUNT(*) AS tong FROM tam_tru WHERE denNgay < NOW()";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sum = rs.getInt("tong");
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
        }
        return sum;
    }

    public int TongTamVang() {
        int sum = 0;
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT COUNT(*) AS tong FROM tam_vang WHERE denNgay < NOW()";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sum = rs.getInt("tong");
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
        }
        return sum;
    }
}
