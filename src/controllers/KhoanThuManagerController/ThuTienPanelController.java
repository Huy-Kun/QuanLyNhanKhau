package controllers.KhoanThuManagerController;

import javax.swing.JFrame;
import javax.swing.JPanel;
import services.KhoanThuService;

public class ThuTienPanelController {
    private JPanel jpnView;
    private JFrame parentJFrame;
    private KhoanThuService khoanThuService;
    private final String[] COLUMNS = {"ID", "Mã hộ khẩu", "Tên khoản thu", "Số tiền thu", "Ngày nộp"};
    
    public ThuTienPanelController()
    {
        
    }
    
    public ThuTienPanelController(JPanel jpnView, JFrame parentJFrame)
    {
        this.jpnView = jpnView;
        this.parentJFrame = parentJFrame;
        this.khoanThuService = new KhoanThuService();
    }
    
    public void SetData()
    {
        
    }
    public void Refresh()
    {
        
    }
}
