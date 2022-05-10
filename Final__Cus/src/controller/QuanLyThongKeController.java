/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import model.HoaDonDTO;
import model.ThongKeService;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author truongthanh
 */
public class QuanLyThongKeController {
    private ThongKeService thongKeService =null;
    public QuanLyThongKeController(){
        thongKeService = new ThongKeServiceImpl();
    }
    
    public void setDataToChartDoanhThuTheoNgay (JPanel jpnlItem){
        List<HoaDonDTO> list = thongKeService.getListHoaDonByNgay();
        
        if (list !=null){
            DefaultCategoryDataset dataset= new DefaultCategoryDataset();
            for (HoaDonDTO item : list){
                dataset.addValue(item.getTongTien(), "Tổng tiền", item.getNgayMua());// tên của cột hiển thị
            }
            JFreeChart chart= ChartFactory.createBarChart
            ("Thống kê doanh thu theo ngày", "Thời gian", 
             "Tiền (VNĐ)", dataset);// xuất ra tương ứng tên biểu đồ, cột ngang, cột dọc
            // chiều cao của biểu đồ có thể tùy chỉnh
            ChartPanel chartPanel= new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnlItem.getWidth(), 600));// height là chỗ để chỉnh chiều cao
            
            jpnlItem.removeAll();
            jpnlItem.setLayout(new CardLayout());
            jpnlItem.add (chartPanel);
            jpnlItem.validate();
            jpnlItem.repaint();
        }
    }
    public void setDataToChartDoanhThuTheoNam (JPanel jpnlItem){
        List<HoaDonDTO> list = thongKeService.getListHoaDonByNam();
        
        if (list !=null){
            DefaultCategoryDataset dataset= new DefaultCategoryDataset();
            for (HoaDonDTO item : list){
                //String temp1String= item.getMonth();
                String tempString=  item.getNam();
                dataset.addValue(item.getTongTien(), "Tổng tiền", tempString);// tên của cột hiển thị
            }
            JFreeChart chart= ChartFactory.createBarChart
            ("Thống kê doanh thu theo năm", "Thời gian", 
             "Tiền (VNĐ)", dataset);// xuất ra tương ứng tên biểu đồ, cột ngang, cột dọc
            ChartPanel chartPanel= new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnlItem.getWidth(), 600));// chiều cao của biểu đồ
            
            jpnlItem.removeAll();
            jpnlItem.setLayout(new CardLayout());
            jpnlItem.add (chartPanel);
            jpnlItem.validate();
            jpnlItem.repaint();
        }
    }
    public void setDataToChartDoanhThuTheoThang (JPanel jpnlItem){
        List<HoaDonDTO> list = thongKeService.getListHoaDonByThang();
        
        if (list !=null){
            DefaultCategoryDataset dataset= new DefaultCategoryDataset();
            for (HoaDonDTO item : list){
                String temp1String= item.getThang();
                String tempString=  item.getNam();
                String ThangNam = temp1String + "-" +tempString ;
                dataset.addValue(item.getTongTien(), "Tổng tiền", ThangNam);// tên của cột hiển thị
            }
            JFreeChart chart= ChartFactory.createBarChart
            ("Thống kê doanh thu theo tháng", "Thời gian", 
             "Tiền (VNĐ)", dataset);// xuất ra tương ứng tên biểu đồ, cột ngang, cột dọc
            ChartPanel chartPanel= new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnlItem.getWidth(), 600));// chiều cao của biểu đồ
            
            jpnlItem.removeAll();
            jpnlItem.setLayout(new CardLayout());
            jpnlItem.add (chartPanel);
            jpnlItem.validate();
            jpnlItem.repaint();
        }
    }
}
