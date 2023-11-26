/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Admin
 */
public class KhoanThuModel {

    private int ID;
    private String tenKhoanThu;
    private int soTien;
    private int loaiKhoanThu;

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) { 
       this.ID = ID;
    }

    /**
     * @return the tenKhoanThu
     */
    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    /**
     * @param tenKhoanThu the tenKhoanThu to set
     */
    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }

    /**
     * @return the soTien
     */
    public int getSoTien() {
        return soTien;
    }

    /**
     * @param soTien the soTien to set
     */
    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    /**
     * @return the loaiKhoanThu
     */
    public int getLoaiKhoanThu() {
        return loaiKhoanThu;
    }

    /**
     * @param loaiKhoanThu the loaiKhoanThu to set
     */
    public void setLoaiKhoanThu(int loaiKhoanThu) {
        this.loaiKhoanThu = loaiKhoanThu;
    }
}
