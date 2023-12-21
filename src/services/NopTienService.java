package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.NopTienModel;

public class NopTienService {

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

    public List<NopTienModel> getListNopTien() {
        List<NopTienModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM nop_tien ";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                NopTienModel nopTienModel = new NopTienModel();
                nopTienModel.setMaHoKhau(rs.getString("maHoKhau"));
                nopTienModel.setTenKhoanThu(rs.getString("tenKhoanThu"));
                nopTienModel.setSoTienNop(rs.getInt("soTienNop"));
                nopTienModel.setNgayNop(rs.getDate("ngayNop"));
                list.add(nopTienModel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public List<NopTienModel> getListNopTienByKey(String key) {
        List<NopTienModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM nop_tien WHERE maHoKhau LIKE '%" + key + "%'";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                NopTienModel nopTienModel = new NopTienModel();
                nopTienModel.setMaHoKhau(rs.getString("maHoKhau"));
                nopTienModel.setTenKhoanThu(rs.getString("tenKhoanThu"));
                nopTienModel.setSoTienNop(rs.getInt("soTienNop"));
                nopTienModel.setNgayNop(rs.getDate("ngayNop"));
                list.add(nopTienModel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
