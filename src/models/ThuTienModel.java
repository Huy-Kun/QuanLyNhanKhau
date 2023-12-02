/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.Date;

public class ThuTienModel {
    private int ID;
    private int maHoKhau;
    private String tenKhoanThu;
    private int soTienThu;
    private Date ngayNop;

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
     * @return the maHoKhau
     */
    public int getMaHoKhau() {
        return maHoKhau;
    }

    /**
     * @param maHoKhau the maHoKhau to set
     */
    public void setMaHoKhau(int maHoKhau) {
        this.maHoKhau = maHoKhau;
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
     * @return the soTienThu
     */
    public int getSoTienThu() {
        return soTienThu;
    }

    /**
     * @param soTienThu the soTienThu to set
     */
    public void setSoTienThu(int soTienThu) {
        this.soTienThu = soTienThu;
    }

    /**
     * @return the ngayNop
     */
    public Date getNgayNop() {
        return ngayNop;
    }

    /**
     * @param ngayNop the ngayNop to set
     */
    public void setNgayNop(Date ngayNop) {
        this.ngayNop = ngayNop;
    }
}
