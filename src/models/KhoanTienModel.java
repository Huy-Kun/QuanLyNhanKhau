/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

public class KhoanTienModel {
    private int ID;
    private String tenKhoanTien;
    private int soTien;
    private String loaiKhoanTien;

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
    public String getTenKhoanTien() {
        return tenKhoanTien;
    }

    /**
     * @param tenKhoanThu the tenKhoanThu to set
     */
    public void setTenKhoanTien(String tenKhoanTien) {
        this.tenKhoanTien = tenKhoanTien;
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
     * @return the loaiKhoanTien
     */
    public String getLoaiKhoanTien() {
        return loaiKhoanTien;
    }

    /**
     * @param loaiKhoanTien the loaiKhoanTien to set
     */
    public void setLoaiKhoanTien(String loaiKhoanTien) {
        this.loaiKhoanTien = loaiKhoanTien;
    }
    
}
