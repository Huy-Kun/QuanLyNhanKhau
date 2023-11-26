/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class NopPhiModel {

    private int ID;
    private int idHoKhau;
    private String tenChuHo;
    private String tenKhoanThu;
    private Date ngayNop;
    private int soTien;

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
     * @return the idHoKhau
     */
    public int getIdHoKhau() {
        return idHoKhau;
    }

    /**
     * @param idHoKhau the idHoKhau to set
     */
    public void setIdHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
    }

    /**
     * @return the tenChuHo
     */
    public String getTenChuHo() {
        return tenChuHo;
    }

    /**
     * @param tenChuHo the tenChuHo to set
     */
    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
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

    
    
}
