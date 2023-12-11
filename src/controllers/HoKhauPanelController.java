package controllers;

import Bean.HoKhauBean;
import models.HoKhauModel;
import models.NhanKhauModel;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import services.HoKhauService;

public class HoKhauPanelController {

    private JFrame parentJFrame;
    private JTable tableJpn;
    private final HoKhauService hoKhauService;
    private List<HoKhauBean> list;

    public HoKhauPanelController(JFrame parentJFrame, JTable tableJpn) {
        this.parentJFrame = parentJFrame;
        this.tableJpn = tableJpn;
        this.hoKhauService = new HoKhauService();
        Refresh();
        //initAction();
    }

//    public void initAction() {
//        this.searchJtf.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                String key = searchJtf.getText().trim();
//                if (key.isEmpty()) {
//                    list = hoKhauService.getListHoKhau();
//                } else {
//                    list = hoKhauService.search(key);
//                }
//                setData();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                String key = searchJtf.getText().trim();
//                if (key.isEmpty()) {
//                    list = hoKhauService.getListHoKhau();
//                } else {
//                    list = hoKhauService.search(key);
//                }
//                setData();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                String key = searchJtf.getText().trim();
//                if (key.isEmpty()) {
//                    list = hoKhauService.getListHoKhau();
//                } else {
//                    list = hoKhauService.search(key);
//                }
//                setData();
//            }
//        });
//    }

    public void setData() {
        DefaultTableModel model = (DefaultTableModel)tableJpn.getModel();
        this.list.forEach(hoKhauBean -> {
            model.addRow(new Object[]{hoKhauBean.getHoKhauModel().getID(),
            hoKhauBean.getHoKhauModel().getMaHoKhau(),
            hoKhauBean.getChuHo().getHoTen(),
            hoKhauBean.getHoKhauModel().getDiaChi(),
            hoKhauBean.getHoKhauModel().getNgayLap()});
        });
    }
    
    public void Refresh()
    {
        this.list = hoKhauService.getListHoKhau();
        setData();
    }
}
