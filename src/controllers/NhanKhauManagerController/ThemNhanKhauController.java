package controllers.NhanKhauManagerController;

import Bean.NhanKhauBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.ChungMinhThuModel;
import models.NhanKhauModel;
import services.MysqlConnection;

public class ThemNhanKhauController {
    public void ThemMoiNhanKhau(String soCCCD, String hoTen, Date ngaySinh, String gioiTinh, String quocTich,
            String queQuan, String noiThuongTru, Date ngayCapCCCD, String noiCapCCCD,
            String biDanh, String danToc, String tonGiao, String ngheNghiep, String noiLamViec, Date ngayChuyenDen) 
            throws SQLException, ClassNotFoundException{
        
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
        
        query = query = "INSERT INTO nhan_khau (cccdNhanKhau, hoTen, ngaySinh, gioiTinh, quocTich, queQuan, noiThuongTru, ngayCapCCCD, noiCapCCCD)" 
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
}
