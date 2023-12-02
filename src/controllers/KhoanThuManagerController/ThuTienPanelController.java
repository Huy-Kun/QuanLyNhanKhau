package controllers.KhoanThuManagerController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.ThuTienModel;
import services.KhoanThuService;
import utility.ClassTableModel;

public class ThuTienPanelController {
    private JPanel tableJpn;
    private JFrame parentJFrame;
    private KhoanThuService khoanThuService;
    private ClassTableModel classTableModel;
    private List<ThuTienModel> listThuTienModel;
    private final String[] COLUMNS = {"ID", "Mã hộ khẩu", "Tên khoản thu", "Số tiền thu", "Ngày nộp"};
    
    public ThuTienPanelController()
    {
        
    }
    
    public ThuTienPanelController(JFrame parentJFrame,JPanel tableJpn)
    {
        this.tableJpn = tableJpn;
        this.parentJFrame = parentJFrame;
        this.khoanThuService = new KhoanThuService();
        this.classTableModel = new ClassTableModel();
        Refresh();
    }
    
    public List<String> getListTenKhoanTien()
    {
        return khoanThuService.getListTenKhoanTien();
    }
    
    public void SetData()
    {
        List<ThuTienModel> listItem = new ArrayList<>();
        this.listThuTienModel.forEach(thuTienModel -> {
            listItem.add(thuTienModel);
        });
        DefaultTableModel model = classTableModel.setTableThuTien(listItem, COLUMNS);
        JTable table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }

        };

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
//        table.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                //                JOptionPane.showConfirmDialog(null, table.getSelectedRow());
//                if (e.getClickCount() > 1) {
//                    KhoanTienBean temp = listKhoanTienBean.get(table.getSelectedRow());
//                    KhoanTienBean info = nhanKhauService.getNhanKhau(temp.getChungMinhThuModel().getSoCMT());
//                    InfoJframe infoJframe = new InfoJframe(info.toString(), parentJFrame);
//                    infoJframe.setLocationRelativeTo(null);
//                    infoJframe.setVisible(true);
//                }
//            }
//
//        });
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 335));
        tableJpn.removeAll();
        tableJpn.setLayout(new BorderLayout());
        tableJpn.add(scroll);
        tableJpn.validate();
        tableJpn.repaint();
    }
    public void Refresh()
    {
        listThuTienModel = khoanThuService.getListThuTien();
        SetData();
    }
}
