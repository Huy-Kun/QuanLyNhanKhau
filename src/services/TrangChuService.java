package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    public ArrayList<String> TotalperMonth() {
        ArrayList<String> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT MONTH(tuNgay), Count(*) as sum FROM tam_tru GROUP BY MONTH(tuNgay)";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("sum"));
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
        }
        return list;
    }

    public int PeopleByAge(int from, int to) {
        ArrayList<String> list = new ArrayList<>();
        try {
            try (Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "SELECT count(*) as sum FROM can_cuoc WHERE (YEAR(NOW()) - YEAR(ngaySinh)) BETWEEN " 
                        + String.valueOf(from) + " AND " + String.valueOf(to);
                PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    return rs.getInt("sum");
                }
                preparedStatement.close();
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int MaleGender() {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT Count(*) as sum FROM can_cuoc WHERE gioiTinh = 'Nam'";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return rs.getInt("sum");
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
        }
        return 0;
    }

    public int FemaleGender() {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT Count(*) as sum FROM can_cuoc WHERE gioiTinh = 'Nữ'";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return rs.getInt("sum");
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
        }
        return 0;
    }
}
