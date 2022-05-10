/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.KhachHangDTO;
import model.SanPhamDTO;

/**
 *
 * @author Thinh Ly
 */
public class SanPhamDAO extends KetNoiCSDL {

    public boolean delSanPham(String tenSanPham) throws Exception {
        String sql = "delete from SanPham "
                + " where TenSanPham = ?;";// câu lệnh nhập dữ liệu trong sql vào database 
        //NhanVien bảng TenSanPham
        try ( PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, tenSanPham);// thuc thi hàm sql

            return ps.executeUpdate() > 0;
        }

    }

    public boolean updateSanPham(SanPhamDTO l) throws Exception {
        String sql = "update SanPham set TenSanPham = ?,GiaSanPham = ? , SLHienCo = ?, NgayNhap = ? "
                + ", MaLoaiSanPham = ? , MaNhaCungCap = ?"
                + " where MaSanPham = ?;";// câu lệnh nhập dữ liệu trong sql vào database 
        //NhanVien bảng TenSanPham
        try ( PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(7, l.getMaSanPham());
            ps.setString(1, l.getTenSanPham());// gắn giá trị vào cot TenNhanVien sql
            ps.setInt(2, l.getGiaSanPham());
            ps.setString(3, l.getSLHienCo());
            ps.setDate(4, new Date(l.getNgayNhap().getTime()));
            ps.setString(5, l.getMaLoaiSanPham());
            ps.setString(6, l.getMaNhaCungCap());

            return ps.executeUpdate() > 0;// add thành công
        }
    }

    public boolean AddSanPham(SanPhamDTO sp) {
        String sql = "INSERT INTO SanPham(TenSanPham , GiaSanPham , SLHienCo ,"
                + " NgayNhap , MaLoaiSanPham , MaNhaCungCap) "
                + " VALUES(?,?,?,?,?,?);";
        try {
            PreparedStatement pss = conn.prepareStatement(sql);
            //ps.setString(0, s.getMaNhaCungCap()); 
            sp.getMaSanPham();
            pss.setString(1, sp.getTenSanPham());
            pss.setInt(2, sp.getGiaSanPham());
            pss.setString(3, sp.getSLHienCo());
            pss.setDate(4, new Date(sp.getNgayNhap().getTime()));
            pss.setString(5, sp.getMaLoaiSanPham());
            pss.setString(6, sp.getMaNhaCungCap());

            return pss.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<SanPhamDTO> getListSanPhamDTOs() {
        ArrayList<SanPhamDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamDTO sp = new SanPhamDTO();
                sp.setMaSanPham(rs.getString("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setGiaSanPham(rs.getInt("GiaSanPham"));
                sp.setSLHienCo(rs.getString("SLHienCo"));
                sp.setNgayNhap(rs.getDate("NgayNhap"));
                sp.setMaLoaiSanPham(rs.getString("MaLoaiSanPham"));
                sp.setMaNhaCungCap(rs.getString("MaNhaCungCap"));

                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<SanPhamDTO> findByProductName(String TenSanPham) throws Exception {
        String sql = "select * from SanPham where TenSanPham LIKE '%' + ? + '%'";
        ArrayList<SanPhamDTO> list = new ArrayList<>();
        try ( PreparedStatement pss = conn.prepareStatement(sql);) {
            pss.setString(1, TenSanPham);
            ResultSet rs = pss.executeQuery();
            while (rs.next()) {
                SanPhamDTO k = new SanPhamDTO();
                k.setMaSanPham(rs.getString("MaSanPham"));
                k.setTenSanPham(rs.getString("TenSanPham"));
                k.setGiaSanPham(rs.getInt("GiaSanPham"));
                k.setSLHienCo(rs.getString("SLHienCo"));
                k.setNgayNhap(rs.getDate("NgayNhap"));
                k.setMaLoaiSanPham(rs.getString("MaLoaiSanPham"));
                k.setMaNhaCungCap(rs.getString("MaNhaCungCap"));
                list.add(k);
            }
            return list;
        }
    }

}
