package controllers.HoKhauManagerController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.ThanhVienCuaHoModel;
import services.HoKhauService;
import views.HoKhauManagerFrame.TachHoKhauJFrame;
import views.infoViews.InfoJframe;

public class TachHoKhauController {
    private JTextField searchJtf;
    private JPanel tableTopJpn;
    private JPanel tableBotJpn;
    private JPanel tableRightJpn;
    private JTextField chuHoHienTaiJtf;
    private JTextField maKhuVucJtf;
    private JTextField diaChiJtf;
    private JTextField maHoKhauMoiJtf;
    private JTextField chuHoMoiJtf;
    private JButton addBtn;
    private JButton removeBtn;
    private JButton cancelBtn;
    private JButton acceptBtn;
    private final HoKhauService hoKhauService = new HoKhauService();
    private JFrame tachHoKhauJFrame;
    
    public TachHoKhauController(JFrame tachHoKhauJFrame) {
        this.tachHoKhauJFrame = tachHoKhauJFrame;
    }
    
    public void init() {
        
        searchJtf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = searchJtf.getText().trim();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = searchJtf.getText().trim();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = searchJtf.getText().trim();
            }
        });
        
        addBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                try {
//                    boolean isInHoMoi = false;
//                    for(ThanhVienCuaHoModel item : hoKhauMoi.getListThanhVienCuaHo()) {
//                        if (item.getIdNhanKhau() == thanhVienSeclected.getNhanKhau().getNhanKhauModel().getID()) {
//                            isInHoMoi = true;
//                        }
//                    }
//                    if (isInHoMoi || hoKhauMoi.getChuHo().getID() == thanhVienSeclected.getNhanKhau().getNhanKhauModel().getID()) {
//                        JOptionPane.showMessageDialog(null, "Nhân khẩu đã nằm trong hộ mới.");
//                    } else {
//                        String quanHeVoiChuHo = "";
//                        while (quanHeVoiChuHo.trim().isEmpty()) {                        
//                            quanHeVoiChuHo = JOptionPane.showInputDialog(null, "Nhập quan hệ với chủ hộ: ", thanhVienSeclected.getNhanKhau().getNhanKhauModel().getHoTen(), 0);
//                        }
//                        if (quanHeVoiChuHo.equalsIgnoreCase("Chủ hộ")) {
//                            chuHoMoiJtf.setText(thanhVienSeclected.getNhanKhau().getNhanKhauModel().getHoTen());
//                            hoKhauMoi.setChuHo(thanhVienSeclected.getNhanKhau().getNhanKhauModel());
//                        } else {
//                            hoKhauMoi.getListNhanKhauModels().add(thanhVienSeclected.getNhanKhau().getNhanKhauModel());
//                            ThanhVienCuaHoModel thanhVienCuaHoModel = new ThanhVienCuaHoModel();
//                            thanhVienCuaHoModel.setIdNhanKhau(thanhVienSeclected.getNhanKhau().getNhanKhauModel().getID());
//                            thanhVienCuaHoModel.setQuanHeVoiChuHo(quanHeVoiChuHo);
//                            hoKhauMoi.getListThanhVienCuaHo().add(thanhVienCuaHoModel);
//                            setDataHoMoi();
//                        }
//                    }
//                } catch (Exception exception) {
//                }
            }
        });
        
        removeBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                try {
//                    for (int i = 0; i < hoKhauMoi.getListNhanKhauModels().size(); i++) {
//                        if (hoKhauMoi.getListNhanKhauModels().get(i).getID() == thanhVienHoMoiSeclected.getNhanKhau().getNhanKhauModel().getID()) {
//                            hoKhauMoi.getListNhanKhauModels().remove(i);
//                            hoKhauMoi.getListThanhVienCuaHo().remove(i);
//                            thanhVienHoMoiSeclected = null;
//                            setDataHoMoi();
//                        }
//                    }
//                } catch (Exception exception) {
//                }
            }
            
        });
        
        acceptBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                if (maKhuVucJtf.getText().trim().isEmpty() 
//                        || diaChiJtf.getText().trim().isEmpty() 
//                        || maHoKhauMoiJtf.getText().trim().isEmpty() 
//                        || chuHoMoiJtf.getText().trim().isEmpty()) {
//                    JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các trường bắt buộc!");
//                } else {
//                    hoKhauMoi.getHoKhauModel().setDiaChi(diaChiJtf.getText().trim());
//                    hoKhauMoi.getHoKhauModel().setMaHoKhau( maHoKhauMoiJtf.getText().trim());
//                    hoKhauMoi.getHoKhauModel().setMaKhuVuc(maKhuVucJtf.getText().trim());
//                    hoKhauService.tachHoKhau(hoKhauMoi);
//                    TachHoKhau tachHoKhau = (TachHoKhau)tachHoKhauJFrame;
//                    tachHoKhau.getParentJFrame().setEnabled(true);
//                    tachHoKhau.dispose();
//                }
            }
            
        });
    }
    
    
}
