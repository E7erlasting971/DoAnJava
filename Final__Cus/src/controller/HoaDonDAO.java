/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.HoaDonDTO;

/**
 *
 * @author truongthanh
 */
public class HoaDonDAO extends KetNoiCSDL {
    public boolean addHoaDon(HoaDonDTO hd){
        
        String sql = "INSERT INTO HoaDon(NgayMua, TongTien,MaKhachHang, MaNhanVien) "
                + " VALUES(?,?,?,?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(0, hd.getMaHoaDon());
            ps.setDate(1, (Date) hd.getNgayMua());
            ps.setInt(2, hd.getTongTien());
            ps.setString(3, hd.getMaKhachHang());
            ps.setString(4, hd.getMaNhanVien());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    public ArrayList<HoaDonDTO> getListHoaDonDTOs() {
        ArrayList<HoaDonDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMaHoaDon(rs.getString("MaHoaDon"));
                hd.setNgayMua(rs.getDate("NgayMua"));
                hd.setTongTien(rs.getInt("TongTien"));
                hd.setMaKhachHang(rs.getString("MaKhachHang"));
                hd.setMaNhanVien(rs.getString("MaNhanVien"));

                list.add(hd);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
         return list;
    }

    public ArrayList<HoaDonDTO> findByID(String MaHoaDon) throws Exception {
        String sql = "select * from HoaDon where MaHoaDon LIKE '%' + ? + '%'";
        ArrayList<HoaDonDTO> list = new ArrayList<>();
        try ( PreparedStatement pss = conn.prepareStatement(sql);) {
            pss.setString(1, MaHoaDon);
            ResultSet rs = pss.executeQuery();
            while (rs.next()) {
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMaHoaDon(rs.getString("MaHoaDon"));
                hd.setTongTien(rs.getInt("TongTien"));
                hd.setNgayMua(rs.getDate("NgayMua"));
                hd.setMaKhachHang(rs.getString("MaKhachHang"));
                hd.setMaNhanVien(rs.getString("MaNhanVien"));

                list.add(hd);
            }
            return list;
        }
    }
    
    
    public static void main(String[] args) {
        new HoaDonDAO();
    }
}
