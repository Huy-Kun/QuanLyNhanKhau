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

    public ArrayList<String> PeopleByAge() {
        ArrayList<String> list = new ArrayList<>();
        int[] age = {0, 5, 10, 14, 17, 60, 100};
        try {
            try (Connection connection = MysqlConnection.getMysqlConnection()) {
                for (int i = 1; i < 7; i++) {
                    String query = "SELECT SELECT count(*) FROM nhan_khau nk WHERE (YEAR(NOW()) - YEAR(nk.namSinh)) BETWEEN " + age[i] + " AND " + (age[i-1] + 1);
                    PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
                    ResultSet rs = preparedStatement.executeQuery();
                    while (rs.next()) {
                        list.add(rs.getString("count"));
                    }
                    preparedStatement.close();
                }
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<String> Gender()
    {
        ArrayList<String> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT nk.gioiTinh, Count(*) as sum FROM nhan_khau nk GROUP BY nk.gioiTinh";
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
}
