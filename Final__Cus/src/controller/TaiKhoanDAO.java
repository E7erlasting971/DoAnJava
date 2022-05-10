/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.TaiKhoanDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Thinh Ly
 */
public class TaiKhoanDAO extends KetNoiCSDL {
    
    public TaiKhoanDTO checkTaiKhoan(String tenDangNhap, String matKhau)throws Exception {
        String sql = " select TenDangNhap , MatKhau  from TaiKhoan"
                + " where TenDangNhap =? and MatKhau = ?";

        try (
                //KetNoiCSDL.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, tenDangNhap);
            pstmt.setString(2, matKhau);
            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    TaiKhoanDTO tk = new TaiKhoanDTO();
                    tk.setTenDangNhap(tenDangNhap);
                    tk.setMatKhau(matKhau);
                    return tk;
                }
            }
        }
        return null;
    }

    public boolean AddTaiKhoan(TaiKhoanDTO tk) {
        String sql = "INSERT INTO TaiKhoan(TenDangNhap , MatKhau , CauHoiBaoMat , TraLoiCauHoi ) "
                + " VALUES(?,?,?,?);";
        String sql1 = "Select MaTaiKhoan from TaiKhoan";
        try {
            PreparedStatement pss = conn.prepareStatement(sql);
            PreparedStatement ps2 = conn.prepareStatement(sql1);
            //ps.setString(0, s.getMaNhaCungCap()); 
            tk.getMaTaiKhoan();
            pss.setString(1, tk.getTenDangNhap());
            pss.setString(2, tk.getMatKhau());
            pss.setString(3, tk.getCauHoiBaoMat());
            pss.setString(4, tk.getTraLoiCauHoi());

            return pss.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

//    public ArrayList<TaiKhoanDTO> getListTaiKhoanDTOs() {
//        ArrayList<TaiKhoanDTO> list = new ArrayList<>();
//        String sql = "SELECT * FROM TaiKhoan";
//
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                TaiKhoanDTO tk = new TaiKhoanDTO();
//                tk.setMaTaiKhoan(rs.getString("MaTaiKhoan"));
//                tk.setTenDangNhap(rs.getString("TenDangNhap"));
//                tk.setMatKhau(rs.getString("MatKhau"));
//
//                list.add(tk);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return list;
//    }
}
