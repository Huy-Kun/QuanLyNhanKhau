package controllers;

import Bean.NhanKhauBean;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import models.NhanKhauModel;
import services.NhanKhauService;
import utility.ClassTableModel;

public class NhanKhauManagerPanelController {
    
    private JFrame parentJFrame;
    private JTable tableJpn;
    private NhanKhauService nhanKhauService;
    private List<NhanKhauBean> listNhanKhauBeans;

    public NhanKhauManagerPanelController(JFrame parentJFrame, JTable tableJpn) {
        this.tableJpn = tableJpn;
        this.parentJFrame = parentJFrame;
        this.nhanKhauService = new NhanKhauService();
        Refresh();
        //initAction();
    }

//    public void initAction(){
//        this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                String key = jtfSearch.getText();
//                listNhanKhauBeans = nhanKhauService.search(key.trim());
//                setDataTable();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                String key = jtfSearch.getText();
//                listNhanKhauBeans = nhanKhauService.search(key.trim());
//                setDataTable();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                String key = jtfSearch.getText();
//                listNhanKhauBeans = nhanKhauService.search(key.trim());
//                setDataTable();
//            }
//        });
//    }
    
    public void setDataTable() {
        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
        this.listNhanKhauBeans.forEach(nhanKhau -> {
            NhanKhauModel nhanKhauModel = nhanKhau.getNhanKhauModel();
            model.addRow(new Object[]{nhanKhauModel.getID(), nhanKhauModel.getHoTen(), nhanKhauModel.getNamSinh(), nhanKhauModel.getGioiTinh(), nhanKhauModel.getDiaChiHienNay()});
        });
      
    }
    
    public void Refresh() {
        this.listNhanKhauBeans = this.nhanKhauService.getListNhanKhau();
        setDataTable();
    }
}
