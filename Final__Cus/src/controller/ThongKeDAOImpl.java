/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HoaDonDTO;

import model.ThongKeDAO;

/**
 *
 * @author truongthanh
 */
public class ThongKeDAOImpl implements ThongKeDAO{
    @Override
    public List<HoaDonDTO> getListHoaDonByNgay() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn1 = DriverManager.getConnection
            ("jdbc:sqlserver://localhost:1433;databasename=QLTBDT;"
            + "username=sa;password=123;encrypt=true;trustServerCertificate=true");
            String sql = "SELECT NgayMua, sum(TongTien) as Doanh_thu_1_ngay FROM HoaDon GROUP BY NgayMua";
            List<HoaDonDTO> list = new ArrayList<>();
            PreparedStatement ps = conn1.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                HoaDonDTO temp= new HoaDonDTO();
                temp.setNgayMua(rs.getDate("NgayMua"));
                temp.setTongTien(rs.getInt("Doanh_thu_1_ngay"));
                list.add(temp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HoaDonDTO> getListHoaDonByNam() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn1 = DriverManager.getConnection
            ("jdbc:sqlserver://localhost:1433;databasename=QLTBDT;"
            + "username=sa;password=123;encrypt=true;trustServerCertificate=true");
                String sql = "SELECT YEAR(NgayMua) as Nam_temp, sum(TongTien) as Doanh_thu_1_nam "
                    + "FROM HoaDon GROUP BY YEAR(NgayMua)";
            List<HoaDonDTO> list = new ArrayList<>();
            PreparedStatement ps = conn1.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                HoaDonDTO temp= new HoaDonDTO();
                //temp.setDay(rs.getString("Month_temp"));
                temp.setNam(rs.getString("Nam_temp"));
                temp.setTongTien(rs.getInt("Doanh_thu_1_nam"));
                list.add(temp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HoaDonDTO> getListHoaDonByThang() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn1 = DriverManager.getConnection
            ("jdbc:sqlserver://localhost:1433;databasename=QLTBDT;"
            + "username=sa;password=123;encrypt=true;trustServerCertificate=true");
                String sql = "SELECT YEAR(NgayMua) as Nam_temp, MONTH(NgayMua) as Thang_temp, "
                        + "sum(TongTien) as Doanh_thu_1_thang "
                    + "FROM HoaDon GROUP BY YEAR(NgayMua), MONTH(NgayMua)";
            List<HoaDonDTO> list = new ArrayList<>();
            PreparedStatement ps = conn1.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                HoaDonDTO temp= new HoaDonDTO();
                temp.setThang(rs.getString("Thang_temp"));
                temp.setNam(rs.getString("Nam_temp"));
                temp.setTongTien(rs.getInt("Doanh_thu_1_thang"));
                list.add(temp);
            }
            return list;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
