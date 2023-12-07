package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.KhoanThuModel;
import models.NopTienModel;
import Bean.KhoanTienBean;

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
                NopTienModel thuTienModel = new NopTienModel();
                thuTienModel.setID(rs.getInt("ID"));
                thuTienModel.setMaHoKhau(rs.getInt("maHoKhau"));
                thuTienModel.setTenKhoanThu(rs.getString("tenKhoanThu"));
                thuTienModel.setSoTienThu(rs.getInt("soTienThu"));
                thuTienModel.setNgayNop(rs.getDate("ngayNop"));
                list.add(thuTienModel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
