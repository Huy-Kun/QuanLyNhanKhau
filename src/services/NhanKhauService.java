package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.NhanKhauModel;
import models.CanCuocModel;

public class NhanKhauService {

    public List<NhanKhauModel> GetListNhanKhau() {
        List<NhanKhauModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM nhan_khau ";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                NhanKhauModel nhanKhauModel = new NhanKhauModel();
                nhanKhauModel.setCccdNhanKhau(rs.getString("cccdNhanKhau"));
                nhanKhauModel.setBiDanh(rs.getString("biDanh"));
                nhanKhauModel.setDanToc(rs.getString("danToc"));
                nhanKhauModel.setTonGiao(rs.getString("tonGiao"));
                nhanKhauModel.setNgheNghiep(rs.getString("ngheNghiep"));
                nhanKhauModel.setNoiLamViec(rs.getString("noiLamViec"));
                nhanKhauModel.setNgayChuyenDen(rs.getDate("ngayChuyenDen"));
                list.add(nhanKhauModel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public List<NhanKhauModel> GetListNhanKhauByKey(String key) {
        List<NhanKhauModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM nhan_khau WHERE cccdNhanKhau LIKE '%" + key +"%'";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                NhanKhauModel nhanKhauModel = new NhanKhauModel();
                nhanKhauModel.setCccdNhanKhau(rs.getString("cccdNhanKhau"));
                nhanKhauModel.setBiDanh(rs.getString("biDanh"));
                nhanKhauModel.setDanToc(rs.getString("danToc"));
                nhanKhauModel.setTonGiao(rs.getString("tonGiao"));
                nhanKhauModel.setNgheNghiep(rs.getString("ngheNghiep"));
                nhanKhauModel.setNoiLamViec(rs.getString("noiLamViec"));
                nhanKhauModel.setNgayChuyenDen(rs.getDate("ngayChuyenDen"));
                list.add(nhanKhauModel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public CanCuocModel GetCanCuoc(String soCCCD) {
        CanCuocModel canCuocModel = new CanCuocModel();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM can_cuoc WHERE can_cuoc.soCCCD = " + soCCCD;
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
