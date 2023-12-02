package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.KhoanTienModel;
import models.ThuTienModel;
import Bean.KhoanTienBean;

public class KhoanThuService {

    public List<String> getListTenKhoanTien() {
        List<String> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM khoan_tien";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("tenKhoanTien"));
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<KhoanTienBean> getListKhoanTien() {
        List<KhoanTienBean> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM khoan_tien";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                KhoanTienBean khoanTienBean = new KhoanTienBean();
                KhoanTienModel khoanTienModel = khoanTienBean.getKhoanTienModel();
                khoanTienModel.setID(rs.getInt("ID"));
                khoanTienModel.setTenKhoanTien(rs.getString("tenKhoanTien"));
                khoanTienModel.setSoTien(rs.getInt("soTien"));
                khoanTienModel.setLoaiKhoanTien(rs.getString("loaiKhoanTien"));
                String extraQuery = "SELECT COUNT(*) as count,SUM(soTienThu) as sum "
                        + "FROM thu_tien "
                        + "WHERE tenKhoanThu='"
                        + rs.getString("tenKhoanTien")
                        + "'";
                PreparedStatement extraPreparedStatement = (PreparedStatement) connection.prepareStatement(extraQuery);
                ResultSet extraRs = extraPreparedStatement.executeQuery();
                while (extraRs.next()) {
                    khoanTienBean.setSoHoDaNop(extraRs.getInt("count"));
                    khoanTienBean.setTongSoTien(extraRs.getInt("sum"));
                    list.add(khoanTienBean);
                }
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<ThuTienModel> getListThuTien() {
        List<ThuTienModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM thu_tien ";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThuTienModel thuTienModel = new ThuTienModel();
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
