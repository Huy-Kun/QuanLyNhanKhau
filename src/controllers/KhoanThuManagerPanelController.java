package controllers;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import views.KhoanThuManagerFrame.KhoanTienPanel;
import views.KhoanThuManagerFrame.ThuTienPanel;

public class KhoanThuManagerPanelController {
    private JFrame parentFrame;
    private JPanel mainJpn;
    
    public KhoanThuManagerPanelController(JFrame parentFrame, JPanel mainJpn)
    {
        this.parentFrame = parentFrame;
        this.mainJpn = mainJpn;
    }
    
    public void SetView(String kind)
    {
        JPanel view = new  JPanel();
        switch(kind)
        {
            case "KhoanTien":
                view = new KhoanTienPanel(parentFrame);
                break;
            case "ThuTien":
                view = new ThuTienPanel(parentFrame);
                break;
            default:
                break;
        }
        mainJpn.removeAll();
        mainJpn.setLayout(new BorderLayout());
        mainJpn.add(view);
        mainJpn.validate();
        mainJpn.repaint();
    }
    
    public void refreshData()
    {
        
    }
}
