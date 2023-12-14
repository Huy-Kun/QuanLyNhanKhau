package controllers.NopTienManagerController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import models.NopTienModel;
import services.MysqlConnection;

public class ThemNopTienController {
    public boolean ThemMoiNopTien(NopTienModel nopTienModel) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO nop_tien (maHoKhau, tenKhoanThu, soTienNop, ngayNop)"
                + " values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, nopTienModel.getMaHoKhau());
        preparedStatement.setString(2, nopTienModel.getTenKhoanThu());
        preparedStatement.setInt(3, nopTienModel.getSoTienNop());
        java.sql.Date ngayNop = new java.sql.Date(nopTienModel.getNgayNop().getTime());
        preparedStatement.setDate(4, ngayNop);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }
}
