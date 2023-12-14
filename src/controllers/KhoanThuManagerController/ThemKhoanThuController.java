package controllers.KhoanThuManagerController;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import services.MysqlConnection;
import models.KhoanThuModel;

public class ThemKhoanThuController {

    public boolean ThemMoiKhoanTien(KhoanThuModel khoanThuModel) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO khoan_thu (maKhoanThu, tenKhoanThu, loaiKhoanThu, soTien)"
                + " values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, khoanThuModel.getMaKhoanThu());
        preparedStatement.setString(2, khoanThuModel.getTenKhoanThu());
        preparedStatement.setString(3, khoanThuModel.getLoaiKhoanThu());
        preparedStatement.setInt(4, khoanThuModel.getSoTien());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }

}
