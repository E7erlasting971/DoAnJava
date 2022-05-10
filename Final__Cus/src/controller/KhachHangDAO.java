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
import model.KhachHangDTO;

/**
 *
 * @author Thinh Ly
 */
public class KhachHangDAO extends KetNoiCSDL {
//    private Connection conn ;
//    
//      public  KhachHangDAO()
//    {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn = DriverManager.getConnection
//            ("jdbc:sqlserver://localhost:1433;databasename=QLTBDT;"
//            + "username=sa;password=123456a@;encrypt=true;trustServerCertificate=true");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//    }
    
     public boolean delKhachHang(String tenKhachHang) throws Exception{
        String sql = "delete from KhachHang "
                + " where TenKhachHang = ?;";// câu lệnh nhập dữ liệu trong sql vào database 
                                //KhachHang bảng TenKhachHang
        try (PreparedStatement ps = conn.prepareStatement(sql);)
        {
            ps.setString(1, tenKhachHang);// thuc thi hàm sql
            
            return ps.executeUpdate() > 0;
        } 
        
    }
       public boolean updateKhachHang(KhachHangDTO l) throws Exception{
        String sql = "update KhachHang set TenKhachHang = ? , DiaChi = ? , SDT = ?"
       
                + " where MaKhachHang = ?;";// câu lệnh nhập dữ liệu trong sql vào database 
                                //KhachHang bảng TenKhach Hang
        try (PreparedStatement ps = conn.prepareStatement(sql);)
        {
            ps.setString(4, l.getMaKhachHang());
            ps.setString(1, l.getHoTen());// gắn giá trị vào cot TenKhachHang sql
            ps.setString(2, l.getDiaChi());
            ps.setString(3,l.getSDT());
            //gắn giá trị vào cot KhuVuc sql
            return ps.executeUpdate() > 0;// add thành công
        } 
    }
      
       public boolean AddKhachHang(KhachHangDTO kh)
    {
         String sql = "INSERT INTO KhachHang(TenKhachHang , DiaChi , SDT) "
                + " VALUES(?,?,?);";
        String sql1 ="Select MaKhachHang from KhachHang";
        try {
            PreparedStatement pss = conn.prepareStatement(sql);
            PreparedStatement ps2 = conn.prepareStatement(sql1);
            //ps.setString(0, s.getMaNhaCungCap()); 
            kh.getMaKhachHang();
            pss.setString(1, kh.getHoTen());
            pss.setString(2, kh.getDiaChi());
            pss.setString(3,kh.getSDT());
            return pss.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
       public ArrayList<KhachHangDTO> getListKhachHangDTOs(){
        ArrayList<KhachHangDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHangDTO kh = new KhachHangDTO();
                kh.setMaKhachHang(rs.getString("MaKhachHang"));
                kh.setHoTen(rs.getString("TenKhachHang"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSDT(rs.getString("SDT"));
                
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
       
    public ArrayList<KhachHangDTO> findByID(String SDT) throws Exception {
        String sql = "select * from KhachHang where SDT LIKE '%' + ? + '%'";
        ArrayList<KhachHangDTO> list = new ArrayList<>();
        try ( PreparedStatement pss = conn.prepareStatement(sql);) {
            pss.setString(1, SDT);
            ResultSet rs = pss.executeQuery();
            while (rs.next()) {
                KhachHangDTO k = new KhachHangDTO();
                k.setMaKhachHang(rs.getString("MaKhachHang"));
                k.setHoTen(rs.getString("TenKhachHang"));
                k.setDiaChi(rs.getString("DiaChi"));
                k.setSDT(rs.getString("SDT"));
                list.add(k);
            }
            return list;
        }
    }
    public static void main(String[] args) {
        new KhachHangDAO();
    }
    
}
