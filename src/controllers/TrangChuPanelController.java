package controllers;

import component.Card;
import component.Model_Card;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import services.TrangChuService;

public class TrangChuPanelController {
    private TrangChuService trangChuService;
    private Card nhanKhau;
    private Card hoKhau;
    private Card tamVang;
    private Card tamTru;
    
    public TrangChuPanelController(Card nhanKhau, Card hoKhau, Card tamTru, Card tamVang) {
        this.nhanKhau = nhanKhau;
        this.hoKhau = hoKhau;
        this.tamTru = tamTru;
        this.tamVang = tamVang;
        this.trangChuService = new TrangChuService();
        setData();
    }
    
    public void setData() {
        this.nhanKhau.setData(new Model_Card(new ImageIcon(getClass().getResource("/Icons/tongnhankhau.png")),
        "Tổng nhân khẩu",
        String.valueOf(trangChuService.TongNhanKhau()),
        "Các nhân khẩu được quản lý"));
        this.hoKhau.setData(new Model_Card(new ImageIcon(getClass().getResource("/Icons/tonghokhau.png")),
        "Tổng hộ khẩu",
        String.valueOf(trangChuService.TongHoKhau()),
        "Các hộ khẩu được quản lý"));
        this.tamTru.setData(new Model_Card(new ImageIcon(getClass().getResource("/Icons/tongtamtru.png")),
        "Tổng tạm trú",
        String.valueOf(trangChuService.TongTamTru()),
        "Các tạm trú được quản lý"));
        this.tamVang.setData(new Model_Card(new ImageIcon(getClass().getResource("/Icons/tongtamvang.png")),
        "Tổng tạm vắng",
        String.valueOf(trangChuService.TongTamVang()),
        "Các tạm vắng được quản lý"));
    }
}
