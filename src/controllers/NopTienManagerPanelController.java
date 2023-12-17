package controllers;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.NopTienModel;
import services.NopTienService;

public class NopTienManagerPanelController {
    private JTable tableJpn;
    private JFrame parentJFrame;
    private NopTienService nopTienService;
    private List<NopTienModel> listThuTienModel;
    
    public NopTienManagerPanelController()
    {
        
    }
    
    public NopTienManagerPanelController(JFrame parentJFrame,JTable tableJpn)
    {
        this.tableJpn = tableJpn;
        this.parentJFrame = parentJFrame;
        this.nopTienService = new NopTienService();
        Refresh();
    }
    
    public List<String> getListTenKhoanTien()
    {
        return nopTienService.getListTenKhoanThu();
    }
    
    public void SetData()
    {
        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
        model.setRowCount(0);
        this.listThuTienModel.forEach(thuTienModel -> {
            model.addRow(new Object[]{thuTienModel.getMaHoKhau(), thuTienModel.getTenKhoanThu(), thuTienModel.getSoTienNop(), thuTienModel.getNgayNop()});
        });
    }
    public void Refresh()
    {
        listThuTienModel = nopTienService.getListNopTien();
        SetData();
    }
}
