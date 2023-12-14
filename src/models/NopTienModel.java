package models;
import java.util.Date;

public class NopTienModel {
    private String maHoKhau;
    private String tenKhoanThu;
    private int soTienNop;
    private Date ngayNop;

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
     * @return the soTienNop
     */
    public int getSoTienNop() {
        return soTienNop;
    }

    /**
     * @param soTienNop the soTienNop to set
     */
    public void setSoTienNop(int soTienNop) {
        this.soTienNop = soTienNop;
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
