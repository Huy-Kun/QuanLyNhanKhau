package controllers.KhoanThuManagerController;

import javax.swing.JPanel;
import javax.swing.JFrame;
import services.KhoanThuService;

public class KhoanTienPanelController {
    private JFrame parentJFrame;
    private JPanel tableJpn;
    private KhoanThuService khoanThuService;
    private final String COLUNMS[] = {"ID", "Tên khoản tiền", "Số tiền", "Loại", "Số hộ đã nộp", "Tổng số tiền"};
    
    public KhoanTienPanelController(JFrame parentJFrame, JPanel tableJpn)
    {
        this.parentJFrame = parentJFrame;
        this.tableJpn = tableJpn;
        khoanThuService = new KhoanThuService();
        SetData();
    }
    
    public void SetData()
    {
        
    }
}
