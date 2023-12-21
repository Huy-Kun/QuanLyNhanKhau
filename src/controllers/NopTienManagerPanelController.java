package controllers;

import component.EventCallBack;
import component.EventTextField;
import component.TextFieldAnimation;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.NopTienModel;
import services.NopTienService;

public class NopTienManagerPanelController {
    private JTable tableJpn;
    private JFrame parentJFrame;
    private TextFieldAnimation textFieldAnimation1;
    private NopTienService nopTienService;
    private List<NopTienModel> listThuTienModel;
    
    public NopTienManagerPanelController()
    {
        
    }
    
    public NopTienManagerPanelController(JFrame parentJFrame, JTable tableJpn, TextFieldAnimation textFieldAnimation1)
    {
        this.tableJpn = tableJpn;
        this.parentJFrame = parentJFrame;
        this.textFieldAnimation1 = textFieldAnimation1;
        this.nopTienService = new NopTienService();
        this.textFieldAnimation1.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                try{
                    Thread.sleep(500);
                    listThuTienModel = nopTienService.getListNopTienByKey(textFieldAnimation1.getText());
                    SetData();
                    call.done();
                }catch (Exception e)
                {
                    System.err.println(e);
                }
            }

            @Override
            public void onCancel() {
            }
            
        });
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
