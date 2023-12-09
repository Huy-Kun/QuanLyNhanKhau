package controllers;

import javax.swing.JPanel;
import javax.swing.JFrame;
import services.KhoanThuService;
import Bean.KhoanTienBean;
import java.util.ArrayList;
import java.util.List;
import utility.ClassTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.util.EventObject;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class KhoanThuManagerPanelController {

    private JFrame parentJFrame;
    private JPanel tableJpn;
    private KhoanThuService khoanThuService;
    private ClassTableModel classTableModel;
    private final String COLUNMS[] = {"ID", "Tên khoản tiền", "Số tiền", "Loại", "Số hộ đã nộp", "Tổng số tiền"};
    private List<KhoanTienBean> listKhoanTienBean;

    public KhoanThuManagerPanelController(JFrame parentJFrame, JPanel tableJpn) {
        this.parentJFrame = parentJFrame;
        this.tableJpn = tableJpn;
        this.khoanThuService = new KhoanThuService();
        this.classTableModel = new ClassTableModel();
        Refresh();
    }

    public void SetData() {
        List<KhoanTienBean> listItem = new ArrayList<>();
        this.listKhoanTienBean.forEach(khoanTienBean -> {
            listItem.add(khoanTienBean);
        });
        DefaultTableModel model = classTableModel.setTableKhoanTien(listItem, COLUNMS);
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
        scroll.setPreferredSize(new Dimension(1350, 400));
        tableJpn.removeAll();   
        tableJpn.setLayout(new BorderLayout());
        tableJpn.add(scroll);
        tableJpn.validate();
        tableJpn.repaint();
    }

    public void Refresh() {
        listKhoanTienBean = khoanThuService.getListKhoanThu();
        SetData();
    }
}
