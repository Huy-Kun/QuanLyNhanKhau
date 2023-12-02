package controllers.KhoanThuManagerController;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import services.MysqlConnection;
import Bean.KhoanTienBean;
import models.KhoanTienModel;

public class ThemKhoanTienController {

    public boolean ThemMoiKhoanTien(KhoanTienBean khoanTienBean) throws SQLException, ClassNotFoundException {
        KhoanTienModel khoanTien = khoanTienBean.getKhoanTienModel();
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO khoan_tien (tenKhoanTien, soTien, loaiKhoanTien)"
                + " values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, khoanTien.getTenKhoanTien());
        preparedStatement.setInt(2, khoanTien.getSoTien());
        preparedStatement.setString(3, khoanTien.getLoaiKhoanTien());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }

}
