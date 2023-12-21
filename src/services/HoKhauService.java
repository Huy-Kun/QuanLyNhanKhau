package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.CanCuocModel;
import models.ChuHoModel;
import models.HoKhauModel;

public class HoKhauService {

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
    public List<HoKhauModel> GetListHoKhauByKey(String key) {
        List<HoKhauModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM ho_khau WHERE maHoKhau LIKE '%" + key + "%'";
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

}
