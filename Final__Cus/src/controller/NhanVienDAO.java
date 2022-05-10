/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.NhanVienDTO;

/**
 *
 * @author Thinh Ly
 */
public class NhanVienDAO extends KetNoiCSDL {

    public boolean delNhanVien(String tenNhanVien) throws Exception {
        String sql = "delete from NhanVien "
                + " where TenNhanVien = ?;";// câu lệnh nhập dữ liệu trong sql vào database 
        //NhanVien bảng TenNhanVien
        try ( PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, tenNhanVien);// thuc thi hàm sql

            return ps.executeUpdate() > 0;
        }

    }

    public boolean updateNhanVien(NhanVienDTO l) throws Exception {
        String sql = "update NhanVien set TenNhanVien = ?,DiaChi = ? , CCCD = ?, SDT = ? "
                + ", ChucVu = ? , GioiTinh = ?"
                + " where MaNhanVien = ?;";// câu lệnh nhập dữ liệu trong sql vào database 
        //NhanVien bảng TenNhanVien
        try ( PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(7, l.getMaNhanVien());
            ps.setString(1, l.getHoTen());// gắn giá trị vào cot TenNhanVien sql
            ps.setString(2, l.getDiaChi_NV());
            ps.setString(3, l.getCCCD());
            ps.setString(4, l.getSDT_NV());
            ps.setString(5, l.getChucVu());
            ps.setBoolean(6, l.getGioiTinh());

            return ps.executeUpdate() > 0;// add thành công
        }
    }

    public boolean AddNhanVien(NhanVienDTO nv) {
        String sql = "INSERT INTO NhanVien(TenNhanVien , DiaChi , CCCD , SDT , ChucVu , GioiTinh) "
                + " VALUES(?,?,?,?,?,?);";
        String sql1 = "Select MaNhanVien from NhanVien";
        try {
            PreparedStatement pss = conn.prepareStatement(sql);
            PreparedStatement ps2 = conn.prepareStatement(sql1);
            //ps.setString(0, s.getMaNhaCungCap()); 
            
            pss.setString(1, nv.getHoTen());
            pss.setString(2, nv.getDiaChi_NV());
            pss.setString(3, nv.getCCCD());
            pss.setString(4, nv.getSDT_NV());
            pss.setString(5, nv.getChucVu());
            pss.setBoolean(6, nv.getGioiTinh());
            

            return pss.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<NhanVienDTO> getListNhanVienDTOs() {
        ArrayList<NhanVienDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO();
                nv.setMaNhanVien(rs.getString("MaNhanVien"));
                nv.setHoTen(rs.getString("TenNhanVien"));
                nv.setDiaChi_NV(rs.getString("DiaChi"));
                nv.setCCCD(rs.getString("CCCD"));
                nv.setSDT_NV(rs.getString("SDT"));
                nv.setChucVu(rs.getString("ChucVu"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));

                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {
        new NhanVienDAO();
    }

    public void updateNhanVien(String maNhanVien) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
