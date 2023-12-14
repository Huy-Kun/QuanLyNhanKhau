package controllers;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import services.HoKhauService;

public class HoKhauManagerPanelController {

    private JFrame parentJFrame;
    private JTable tableJpn;
    private final HoKhauService hoKhauService;

    public HoKhauManagerPanelController(JFrame parentJFrame, JTable tableJpn) {
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
    }
    
    public void Refresh()
    {
        setData();
    }
}
