package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.HoKhauModel;
import models.KhoanThuModel;

public class KhoanThuService {

    public List<KhoanThuModel> GetListKhoanThu() {
        List<KhoanThuModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM khoan_thu ";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                KhoanThuModel khoanThuModel = new KhoanThuModel();
                khoanThuModel.setMaKhoanThu(rs.getString("maKhoanThu"));
                khoanThuModel.setTenKhoanThu(rs.getString("tenKhoanThu"));
                khoanThuModel.setLoaiKhoanThu(rs.getString("loaiKhoanThu"));
                khoanThuModel.setSoTien(rs.getInt("soTien"));
                list.add(khoanThuModel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public int GetTongNopTien(KhoanThuModel khoanThuModel)
    {
        int count = 0;
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT count(*) as count FROM nop_tien WHERE nop_tien.tenKhoanThu = " + khoanThuModel.getTenKhoanThu();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
    
    public int GetTongTienNop(KhoanThuModel khoanThuModel)
    {
        int sum = 0;
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT SUM(soTienNop) as sum FROM nop_tien WHERE nop_tien.tenKhoanThu = " + khoanThuModel.getTenKhoanThu();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sum = rs.getInt("sum");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sum;
    }
}
