package Bean;

import models.KhoanTienModel;

public class KhoanTienBean {
    private KhoanTienModel khoanTienModel;
    private int soHoDaNop;
    private int tongSoTien;
    
    public KhoanTienBean()
    {
        this.khoanTienModel = new KhoanTienModel();
        this.soHoDaNop = 0;
        this.tongSoTien = 0;
    }
    
    public KhoanTienBean(KhoanTienModel khoanTienModel, int soHoDaNop, int tongSoTien)
    {
        this.khoanTienModel = khoanTienModel;
        this.soHoDaNop = soHoDaNop;
        this.tongSoTien = tongSoTien;
    }

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
