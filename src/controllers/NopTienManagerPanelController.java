package controllers;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.NopTienModel;
import services.NopTienService;
import utility.ClassTableModel;

public class NopTienManagerPanelController {
    private JTable tableJpn;
    private JFrame parentJFrame;
    private NopTienService nopTienService;
    private ClassTableModel classTableModel;
    private List<NopTienModel> listThuTienModel;
    private final String[] COLUMNS = {"ID", "Mã hộ khẩu", "Tên khoản thu", "Số tiền thu", "Ngày nộp"};
    
    public NopTienManagerPanelController()
    {
        
    }
    
    public NopTienManagerPanelController(JFrame parentJFrame,JTable tableJpn)
    {
        this.tableJpn = tableJpn;
        this.parentJFrame = parentJFrame;
        this.nopTienService = new NopTienService();
        this.classTableModel = new ClassTableModel();
        Refresh();
    }
    
    public List<String> getListTenKhoanTien()
    {
        return nopTienService.getListTenKhoanThu();
    }
    
    public void SetData()
    {
        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
        this.listThuTienModel.forEach(thuTienModel -> {
            model.addRow(new Object[]{thuTienModel.getID(), thuTienModel.getMaHoKhau(), thuTienModel.getTenKhoanThu(), thuTienModel.getSoTienThu(), thuTienModel.getNgayNop()});
        });
    }
    public void Refresh()
    {
        listThuTienModel = nopTienService.getListNopTien();
        SetData();
    }
}
