package controllers.KhoanThuManagerController;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import services.MysqlConnection;
import Bean.KhoanTienBean;
import models.KhoanThuModel;

public class ThemKhoanThuController {

    public boolean ThemMoiKhoanTien(KhoanTienBean khoanTienBean) throws SQLException, ClassNotFoundException {
        KhoanThuModel khoanTien = khoanTienBean.getKhoanTienModel();
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO khoan_thu (tenKhoanThu, soTien, loaiKhoanThu)"
                + " values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, khoanTien.getTenKhoanThu());
        preparedStatement.setInt(2, khoanTien.getSoTien());
        preparedStatement.setString(3, khoanTien.getLoaiKhoanThu());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }

}
