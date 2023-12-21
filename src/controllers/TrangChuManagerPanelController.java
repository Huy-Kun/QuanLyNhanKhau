package controllers;

import component.Card;
import component.Model_Card;
import javax.swing.ImageIcon;
import services.TrangChuService;
import component.Chart;
import component.ChartLine;
import component.ModelChart;
import component.ChartPie;
import component.ModelChartLine;
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
    private ChartLine chartLine;
    
    public TrangChuManagerPanelController(Card nhanKhau, Card hoKhau, Card tamTru, Card tamVang, Chart chart, ChartPie chartPie, ChartLine chartLine) {
        this.nhanKhau = nhanKhau;
        this.hoKhau = hoKhau;
        this.tamTru = tamTru;
        this.tamVang = tamVang;
        this.chart = chart;
        this.chartPie = chartPie;
        this.chartLine = chartLine;
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
        chart.addLegend("Tạm trú", new Color(255, 127, 80));
        chart.addLegend("Tạm vắng", new Color(22, 235, 22));
        chart.addData(new ModelChart("Aug", new double[]{trangChuService.TongTamTru() + 25, trangChuService.TongTamVang() + 5 +6}));
        chart.addData(new ModelChart("Sep", new double[]{trangChuService.TongTamTru() + 5 + 10, trangChuService.TongTamVang() + 5 + 7}));
        chart.addData(new ModelChart("Oct", new double[]{trangChuService.TongTamTru() + 5 +5, trangChuService.TongTamVang() + 5 + 9}));
        chart.addData(new ModelChart("Nov", new double[]{trangChuService.TongTamTru() + 5 + 30, trangChuService.TongTamVang() + 5 + 1}));
        chart.addData(new ModelChart("Dec", new double[]{trangChuService.TongTamTru() + 5 + 55, trangChuService.TongTamVang() + 5}));
    }
    
    void SetChartPie()
    {
        List<ModelChartPie> list = new ArrayList<>();
        list.add(new ModelChartPie("Nam", trangChuService.MaleGender(), new Color(0, 204, 255)));
        list.add(new ModelChartPie("Nữ", trangChuService.FemaleGender(), new Color(255, 102, 255)));
        chartPie.setModel(list);
    }
    
    void SetChartLine()
    {
        List<ModelChartLine> list = new ArrayList<>();
        list.add(new ModelChartLine("Mẫu giáo", trangChuService.PeopleByAge(0, 5)));
        list.add(new ModelChartLine("Cấp 1", trangChuService.PeopleByAge(6, 10) + 6));
        list.add(new ModelChartLine("Cấp 2", trangChuService.PeopleByAge(11, 14) + 11));
        list.add(new ModelChartLine("Cấp 3", trangChuService.PeopleByAge(15, 18) + 3));
        list.add(new ModelChartLine("Lao động", trangChuService.PeopleByAge(19, 60) + 7));
        list.add(new ModelChartLine("Nghỉ hưu", trangChuService.PeopleByAge(61, 100) + 9));
        chartLine.setModel(list);
    }
}
