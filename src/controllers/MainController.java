package controllers;

import Bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import views.HoKhauPanel;
import views.TrangChuPanel;
import views.NhanKhauPanel;
import views.KhoanThuPanel;
import views.NopTienPanel;

public class MainController {
    private JFrame jfrMain;
    private JPanel root;
    private String kindSelected;
    private List<DanhMucBean> listDanhMuc;

    public MainController(JPanel root, JFrame jfrMain) {
        this.jfrMain = jfrMain;
        this.root = root;
    }
    
    public void setView(JPanel jpnItem, String kind) {
        this.kindSelected = kind;
        setDefaultColor();
        jpnItem.setBackground(new Color(85,65,118));
        JPanel view = new  JPanel();
        switch(kind) {
                case "TrangChu":
                    view = new TrangChuPanel();
                    break;
                case "NhanKhau":
                    view = new NhanKhauPanel(this.jfrMain);
                    break;
                case "HoKhau":
                    view = new HoKhauPanel(this.jfrMain);
                    break;
                case "KhoanThu":
                    view = new KhoanThuPanel(this.jfrMain);
                    break;
                case "NopTien":
                    view = new NopTienPanel(this.jfrMain);
                    break;
                //any more
                default:
                    break;
            }
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(view);
        root.validate();
        root.repaint();
    } 
    
    //set animation for menu panel
    public void setEvent(List<DanhMucBean> listDanhMuc) {
        this.listDanhMuc = listDanhMuc;
        this.listDanhMuc.forEach((item) -> {
            item.getJpn().addMouseListener(new LabelEvent(this.jfrMain, item.getKind(), item.getJpn()));
        });
    }
    
    public void setDefaultColor() {
        this.listDanhMuc.forEach((item) -> {
                item.getJpn().setBackground(new Color(54, 33, 99));
        });
    }
    
    class LabelEvent implements MouseListener {
        
        private JPanel view;
        private JFrame jfrMain;
        private String kind;
        private JPanel jpnItem;

        public LabelEvent(String kind, JPanel jpnItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
        }

        public LabelEvent(JFrame jfrMain, String kind, JPanel jpnItem) {
            this.jfrMain = jfrMain;
            this.kind = kind;
            this.jpnItem = jpnItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind) {
                case "TrangChu":
                    view = new TrangChuPanel();
                    break;
                case "NhanKhau":
                    view = new NhanKhauPanel(this.jfrMain);
                    break;
                 case "HoKhau":
                    view = new HoKhauPanel(this.jfrMain);
                    break;
                case "KhoanThu":
                    view = new KhoanThuPanel(this.jfrMain);
                    break;
                case "NopTien":
                    view = new NopTienPanel(this.jfrMain);
                    break;
                default:
                    break;
            }
            
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(view);
            root.validate();
            root.repaint();
            setDefaultColor();
            jpnItem.setBackground(new Color(85,65,118));
        }        

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(85,65,118));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(85,65,118));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kind.equalsIgnoreCase(kindSelected)) {
                jpnItem.setBackground(new Color(54, 33, 99));
            }
        }
        
    }
}
