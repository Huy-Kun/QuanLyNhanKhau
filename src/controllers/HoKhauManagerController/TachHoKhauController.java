package controllers.HoKhauManagerController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import services.MysqlConnection;

public class TachHoKhauController {

    private JFrame parentJframe;
    private JTable jTable1;
    private JTextField txtChuHoMoi;
    private JTextField txtMaHoKhauCanTach;
    private JButton btnChonChuHoMoi;
    private JButton btnChonHoKhauCanTach;
    private JButton btnThemThanhVien;
    private String soCCCDChuHoMoi;

    public TachHoKhauController(JFrame parentJframe, JTable jTable1, JTextField txtChuHoMoi, JTextField txtMaHoKhauCanTach,
            JButton btnChonChuHoMoi, JButton btnChonHoKhauCanTach, JButton btnThemThanhVien) {
        this.parentJframe = parentJframe;
        this.jTable1 = jTable1;
        this.txtChuHoMoi = txtChuHoMoi;
        this.txtMaHoKhauCanTach = txtMaHoKhauCanTach;
        this.btnChonChuHoMoi = btnChonChuHoMoi;
        this.btnChonHoKhauCanTach = btnChonHoKhauCanTach;
        this.btnThemThanhVien = btnThemThanhVien;
        this.btnChonChuHoMoi.setEnabled(false);
        this.btnThemThanhVien.setEnabled(false);
    }

    public void SetTxtMaHoKhauCanTach(String maChuHoCanTach) {
        txtMaHoKhauCanTach.setText(maChuHoCanTach);
        txtChuHoMoi.setText("");
        btnChonChuHoMoi.setEnabled(true);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        btnThemThanhVien.setEnabled(false);
    }

    public void SetTxtChuHoMoi(String chuHoMoi) {
        txtChuHoMoi.setText(chuHoMoi);
        btnThemThanhVien.setEnabled(true);
    }

    public void AddObjectToTable(Object[] thanhVienModel) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(thanhVienModel);
    }
    
    public void ThemMoiHoKhau(String maHoKhau, String diaChi, Date ngayTao)
            throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO ho_khau(maHoKhau, diaChi, ngayTao)"
                + " value (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, maHoKhau);
        preparedStatement.setString(2, diaChi);
        preparedStatement.setDate(3, new java.sql.Date(ngayTao.getTime()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }
    
     public void ThemMoiChuHo(String soCCCD, String maHoKhau)
            throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO chu_ho(soCCCD, maHoKhau)"
                + " value (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, soCCCD);
        preparedStatement.setString(2, maHoKhau);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }
    
    public boolean ValidateValue(JFrame root, String temp) {
        if (temp.isEmpty()) {
            JOptionPane.showMessageDialog(root, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    public boolean CheckMaHoKhau(String maHoKhau) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT * FROM ho_khau WHERE ho_khau.maHoKhau = " + maHoKhau;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            if (!rs.getString("maHoKhau").trim().isEmpty()) {
                preparedStatement.close();
                connection.close();
                return true;
            }
        }
        preparedStatement.close();
        connection.close();
        return false;
    }
}
