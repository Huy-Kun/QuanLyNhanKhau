package controllers;

import component.EventCallBack;
import component.EventTextField;
import component.TextFieldAnimation;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.CanCuocModel;
import models.ChuHoModel;
import models.HoKhauModel;
import services.HoKhauService;

public class HoKhauManagerPanelController {

    private JFrame parentJFrame;
    private JTable tableJpn;
    private TextFieldAnimation textFieldAnimation1;
    private HoKhauService hoKhauService;
    private List<HoKhauModel> listHoKhauModel;

    public HoKhauManagerPanelController(JFrame parentJFrame, JTable tableJpn, TextFieldAnimation textFieldAnimation1) {
        this.parentJFrame = parentJFrame;
        this.tableJpn = tableJpn;
        this.textFieldAnimation1 = textFieldAnimation1;
        this.hoKhauService = new HoKhauService();
        this.textFieldAnimation1.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                try{
                    Thread.sleep(500);
                    listHoKhauModel = hoKhauService.GetListHoKhauByKey(textFieldAnimation1.getText());
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

    public void SetData() {
        DefaultTableModel model = (DefaultTableModel) tableJpn.getModel();
        model.setRowCount(0);
        this.listHoKhauModel.forEach(hoKhauModel -> {
            ChuHoModel chuHoModel = this.hoKhauService.GetChuHo(hoKhauModel.getMaHoKhau());
            CanCuocModel canCuocChuHo = this.hoKhauService.GetCanCuoc(chuHoModel.getSoCCCD());
            model.addRow(new Object[]{hoKhauModel.getMaHoKhau(), canCuocChuHo.getHoTen(), hoKhauModel.getDiaChi(), hoKhauModel.getNgayTao().toString()});
        });
    }

    public void Refresh() {
        this.listHoKhauModel = hoKhauService.GetListHoKhau();
        SetData();
    }
}
