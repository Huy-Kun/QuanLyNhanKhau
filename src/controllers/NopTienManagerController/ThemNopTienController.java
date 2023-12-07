package controllers.NopTienManagerController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import models.NopTienModel;
import services.MysqlConnection;

public class ThemNopTienController {
    public boolean ThemMoiNopTien(NopTienModel thuTienModel) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO nop_tien (maHoKhau, tenKhoanThu, soTienThu, ngayNop)"
                + " values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, thuTienModel.getMaHoKhau());
        preparedStatement.setString(2, thuTienModel.getTenKhoanThu());
        preparedStatement.setInt(3, thuTienModel.getSoTienThu());
        java.sql.Date ngayNop = new java.sql.Date(thuTienModel.getNgayNop().getTime());
        preparedStatement.setDate(4, ngayNop);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }
}
