package controllers.KhoanThuManagerController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import models.ThuTienModel;
import services.MysqlConnection;

public class ThemThuTienController {
    public boolean ThemMoiThuTien(ThuTienModel thuTienModel) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO thu_tien (maHoKhau, tenKhoanThu, soTienThu, ngayNop)"
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
