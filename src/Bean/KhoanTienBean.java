package Bean;

import models.KhoanTienModel;

public class KhoanTienBean {
    private KhoanTienModel khoanTienModel;
    private int soHoDaNop;
    private int tongSoTien;

    /**
     * @return the khoanTienModel
     */
    public KhoanTienModel getKhoanTienModel() {
        return khoanTienModel;
    }

    /**
     * @param khoanTienModel the khoanTienModel to set
     */
    public void setKhoanTienModel(KhoanTienModel khoanTienModel) {
        this.khoanTienModel = khoanTienModel;
    }

    /**
     * @return the soHoDaNop
     */
    public int getSoHoDaNop() {
        return soHoDaNop;
    }

    /**
     * @param soHoDaNop the soHoDaNop to set
     */
    public void setSoHoDaNop(int soHoDaNop) {
        this.soHoDaNop = soHoDaNop;
    }

    /**
     * @return the tongSoTien
     */
    public int getTongSoTien() {
        return tongSoTien;
    }

    /**
     * @param tongSoTien the tongSoTien to set
     */
    public void setTongSoTien(int tongSoTien) {
        this.tongSoTien = tongSoTien;
    }
}
