package controllers.NopTienManagerController;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import models.CanCuocModel;
import models.ChuHoModel;
import models.HoKhauModel;
import services.MysqlConnection;

public class ThemNopTienController {

    private JComboBox ccbTenKhoanThu;
    private HoKhauModel hoKhauModel;
    private JTextField txtTenChuHo;
    private JTextField txtMaHoKhau;
    private JTextField txtSoTienNop;

    public ThemNopTienController(JComboBox ccbTenKhoanThu, HoKhauModel hoKhauModel, JTextField txtMaHoKhau,
            JTextField txtTenChuHo, JTextField txtSoTienNop) {
        this.ccbTenKhoanThu = ccbTenKhoanThu;
        this.hoKhauModel = hoKhauModel;
        this.txtMaHoKhau = txtMaHoKhau;
        this.txtTenChuHo = txtTenChuHo;
        this.txtSoTienNop = txtSoTienNop;
        this.ccbTenKhoanThu.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    JComboBox<String> source = (JComboBox<String>) e.getSource();
                    String selectedItem = (String) source.getSelectedItem();
                    if (GetMoneyOfKhoanThu(selectedItem) != 0 ) {
                        txtSoTienNop.setEnabled(false);
                        int soTienNop = GetMoneyOfKhoanThu(selectedItem)
                                * (GetSoThanhVienCuaHo(txtMaHoKhau.getText()) + 1);
                        txtSoTienNop.setText(String.valueOf(soTienNop));
                    } else {
                        txtSoTienNop.setText("");
                        txtSoTienNop.setEnabled(true);
                    }
                }
            }
        });
        SetData();
    }

    public void SetData() {
        if (this.ccbTenKhoanThu != null) {
            List<String> list = getListTenKhoanThu();
            this.ccbTenKhoanThu.removeAllItems();
            this.ccbTenKhoanThu.addItem("");
            list.forEach(tenKhoanThu -> {
                this.ccbTenKhoanThu.addItem(tenKhoanThu);
            });
        }
        if (hoKhauModel.getMaHoKhau() != null) {
            this.txtMaHoKhau.setText(this.hoKhauModel.getMaHoKhau());
            this.txtTenChuHo.setText(GetCanCuoc(GetChuHo(this.hoKhauModel.getMaHoKhau()).getSoCCCD()).getHoTen());
        }
    }

    public List<String> getListTenKhoanThu() {
        List<String> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM khoan_thu";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("tenKhoanThu"));
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public int GetMoneyOfKhoanThu(String tenKhoanThu) {
        int money = 0;
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM khoan_thu WHERE tenKhoanThu = '" + tenKhoanThu + "'";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                money = rs.getInt("soTien");
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return money;
    }

    public int GetSoThanhVienCuaHo(String maHoKhau) {
        int count = 0;
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM thanh_vien_cua_ho WHERE maHoKhau = '" + maHoKhau + "'";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public List<HoKhauModel> GetListHoKhau() {
        List<HoKhauModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM ho_khau ";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                HoKhauModel hoKhauModel = new HoKhauModel();
                hoKhauModel.setMaHoKhau(rs.getString("maHoKhau"));
                hoKhauModel.setDiaChi(rs.getString("diaChi"));
                hoKhauModel.setNgayTao(rs.getDate("ngayTao"));
                list.add(hoKhauModel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public boolean ThemMoiNopTien(String maHoKhau, String tenKhoanThu, int soTienNop, Date ngayNop) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO nop_tien (maHoKhau, tenKhoanThu, soTienNop, ngayNop)"
                + " values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, maHoKhau);
        preparedStatement.setString(2, tenKhoanThu);
        preparedStatement.setInt(3, soTienNop);
        preparedStatement.setDate(4, new java.sql.Date(ngayNop.getTime()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }

    public boolean ValidateValue(JFrame root, String temp) {
        if (temp.isEmpty()) {
            JOptionPane.showMessageDialog(root, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean ValidateIntValue(JFrame root, String temp) {
        try {
            long intValue = Long.parseLong(temp);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(root, "Không đúng định dạng số!", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public CanCuocModel GetCanCuoc(String soCCCD) {
        CanCuocModel canCuocModel = new CanCuocModel();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM can_cuoc WHERE can_cuoc.soCCCD = '" + soCCCD + "'";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                canCuocModel.setSoCCCD(rs.getString("soCCCD"));
                canCuocModel.setHoTen(rs.getString("hoTen"));
                canCuocModel.setNgaySinh(rs.getDate("ngaySinh"));
                canCuocModel.setGioiTinh(rs.getString("gioiTinh"));
                canCuocModel.setQuocTich(rs.getString("quocTich"));
                canCuocModel.setQueQuan(rs.getString("queQuan"));
                canCuocModel.setNoiThuongTru(rs.getString("noiThuongTru"));
                canCuocModel.setNgayCapCCCD(rs.getDate("ngayCapCCCD"));
                canCuocModel.setNoiCapCCCD(rs.getString("noiCapCCCD"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return canCuocModel;
    }

    public ChuHoModel GetChuHo(String maHoKhau) {
        ChuHoModel chuHoModel = new ChuHoModel();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM chu_ho WHERE chu_ho.maHoKhau = '" + maHoKhau + "'";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                chuHoModel.setSoCCCD(rs.getString("soCCCD"));
                chuHoModel.setMaHoKhau(rs.getString("maHoKhau"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return chuHoModel;
    }

}
