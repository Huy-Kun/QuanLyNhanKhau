package models;

import java.util.Date;

public class HoKhauModel {
    private String maHoKhau;
    private String cccdChuHo;
    private String diaChi;
    private Date ngayLap;

    /**
     * @return the maHoKhau
     */
    public String getMaHoKhau() {
        return maHoKhau;
    }

    /**
     * @param maHoKhau the maHoKhau to set
     */
    public void setMaHoKhau(String maHoKhau) {
        this.maHoKhau = maHoKhau;
    }

    /**
     * @return the cccdChuHo
     */
    public String getCccdChuHo() {
        return cccdChuHo;
    }

    /**
     * @param cccdChuHo the cccdChuHo to set
     */
    public void setCccdChuHo(String cccdChuHo) {
        this.cccdChuHo = cccdChuHo;
    }

    /**
     * @return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    /**
     * @return the ngayLap
     */
    public Date getNgayLap() {
        return ngayLap;
    }

    /**
     * @param ngayLap the ngayLap to set
     */
    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }
    
    
}
