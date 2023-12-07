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

public class KhoanThuService {
    
    public List<KhoanTienBean> getListKhoanThu() {
        List<KhoanTienBean> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM khoan_thu";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                KhoanTienBean khoanTienBean = new KhoanTienBean();
                KhoanThuModel khoanTienModel = khoanTienBean.getKhoanTienModel();
                khoanTienModel.setID(rs.getInt("ID"));
                khoanTienModel.setTenKhoanThu(rs.getString("tenKhoanThu"));
                khoanTienModel.setSoTien(rs.getInt("soTien"));
                khoanTienModel.setLoaiKhoanThu(rs.getString("loaiKhoanThu"));
                String extraQuery = "SELECT COUNT(*) as count,SUM(soTienThu) as sum "
                        + "FROM nop_tien "
                        + "WHERE tenKhoanThu='"
                        + rs.getString("tenKhoanThu")
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

}
