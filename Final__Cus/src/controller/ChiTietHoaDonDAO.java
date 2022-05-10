/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ChiTietHoaDonDTO;

/**
 *
 * @author truongthanh
 */
public class ChiTietHoaDonDAO extends KetNoiCSDL{
    public boolean addChiTietHoaDon(ChiTietHoaDonDTO cthd){
        
        String sql = "INSERT INTO CTHD(MaSP, TenSP, SoLuong, DonGia, MaHD) "
                + " VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(0, hd.getMaHoaDon());
            ps.setString(1, cthd.getMaSanPham());
            ps.setString(2, cthd.getTenSanPham());
            ps.setString(3, cthd.getSoLuong());
            ps.setString(4, cthd.getDonGia());
            ps.setString(5, cthd.getMaHoaDon());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    public ArrayList<ChiTietHoaDonDTO> getListChiTietHoaDonDTOs() {

        ArrayList<ChiTietHoaDonDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM CTHD";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();
                
                cthd.setMaCTHD(rs.getString("MaCTHD"));
                cthd.setMaSanPham(rs.getString("MaSP"));
                cthd.setTenSanPham(rs.getString("TenSP"));
                cthd.setSoLuong(rs.getString("SoLuong"));
                cthd.setDonGia(rs.getString("DonGia"));
                cthd.setMaHoaDon(rs.getString("MaHD"));
                
                list.add(cthd);
            }
            //return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    
    
    public static void main(String[] args) {
        new HoaDonDAO();
    }
}
