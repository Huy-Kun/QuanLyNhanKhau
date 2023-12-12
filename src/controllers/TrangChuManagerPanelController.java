package controllers;

import component.Card;
import component.Model_Card;
import javax.swing.ImageIcon;
import services.TrangChuService;
import component.Chart;
import component.ModelChart;
import component.ChartPie;
import component.ModelChartPie;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class TrangChuManagerPanelController {
    private TrangChuService trangChuService;
    private Card nhanKhau;
    private Card hoKhau;
    private Card tamVang;
    private Card tamTru;
    private Chart chart;
    private ChartPie chartPie;
    
    public TrangChuManagerPanelController(Card nhanKhau, Card hoKhau, Card tamTru, Card tamVang, Chart chart, ChartPie chartPie) {
        this.nhanKhau = nhanKhau;
        this.hoKhau = hoKhau;
        this.tamTru = tamTru;
        this.tamVang = tamVang;
        this.chart = chart;
        this.chartPie = chartPie;
        this.trangChuService = new TrangChuService();
        setData();
    }
    
    public void setData() {
        SetCard();
        SetChart();
        SetChartPie();
        SetChartLine();
    }
    
    void SetCard()
    {
        this.nhanKhau.setData(new Model_Card(new ImageIcon(getClass().getResource("/Icons/tongnhankhau.png")),
        "Tổng nhân khẩu",
        String.valueOf(trangChuService.TongNhanKhau()),
        "Các nhân khẩu được quản lý"));
        this.hoKhau.setData(new Model_Card(new ImageIcon(getClass().getResource("/Icons/tonghokhau.png")),
        "Tổng hộ khẩu",
        String.valueOf(trangChuService.TongHoKhau()),
        "Các hộ khẩu được quản lý"));
        this.tamTru.setData(new Model_Card(new ImageIcon(getClass().getResource("/Icons/tongtamtru.png")),
        "Tổng tạm trú",
        String.valueOf(trangChuService.TongTamTru()),
        "Các tạm trú được quản lý"));
        this.tamVang.setData(new Model_Card(new ImageIcon(getClass().getResource("/Icons/tongtamvang.png")),
        "Tổng tạm vắng",
        String.valueOf(trangChuService.TongTamVang()),
        "Các tạm vắng được quản lý"));
    }
    
    void SetChart()
    {
        chart.addLegend("Tạm trú", new Color(227, 25, 25));
        chart.addLegend("Tạm vắng", new Color(59, 42, 240));
        chart.addData(new ModelChart("Aug", new double[]{trangChuService.TongTamTru() + 25, trangChuService.TongTamVang() + 5 +6}));
        chart.addData(new ModelChart("Sep", new double[]{trangChuService.TongTamTru() + 5 + 10, trangChuService.TongTamVang() + 5 + 7}));
        chart.addData(new ModelChart("Oct", new double[]{trangChuService.TongTamTru() + 5 +5, trangChuService.TongTamVang() + 5 + 9}));
        chart.addData(new ModelChart("Nov", new double[]{trangChuService.TongTamTru() + 5 + 30, trangChuService.TongTamVang() + 5 + 1}));
        chart.addData(new ModelChart("Dec", new double[]{trangChuService.TongTamTru() + 5 + 55, trangChuService.TongTamVang() + 5}));
    }
    
    void SetChartPie()
    {
        List<ModelChartPie> list = new ArrayList<>();
        list.add(new ModelChartPie("Mẫu giáo", 150, new Color(215, 39, 250)));
        list.add(new ModelChartPie("Cấp 1", 80, new Color(44, 88, 236)));
        list.add(new ModelChartPie("Cấp 2", 100, new Color(21, 202, 87)));
        list.add(new ModelChartPie("Cấp 3", 125, new Color(127, 63, 255)));
        list.add(new ModelChartPie("Lao động", 80, new Color(238, 167, 35)));
        list.add(new ModelChartPie("Nghỉ hưu", 200, new Color(245, 79, 99)));
        chartPie.setModel(list);
    }
    
    void SetChartLine()
    {
        
    }
}
