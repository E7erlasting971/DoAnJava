/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

//import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
//import com.microsoft.sqlserver.jdbc.SQLServerDriver;
//import com.sun.jdi.connect.spi.Connection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.LoaiSanPhamDTO;

//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author truongthanh
 */
public class LoaiSanPhamDAO extends KetNoiCSDL{
    
       public boolean delLoaiSanPham(String tenLoaiSP) throws Exception{
        String sql = "delete from LoaiSanPham "
                + " where TenLoaiSanPham = ?;";// câu lệnh nhập dữ liệu trong sql vào database 
                                //LoaiSanPham bảng TenLoaiSanPham
        try (PreparedStatement ps = conn.prepareStatement(sql);)
        {
            ps.setString(1, tenLoaiSP);// thuc thi hàm sql
            
            return ps.executeUpdate() > 0;
        } 
        
    }
       
         public boolean updateLoaiSanPham(LoaiSanPhamDTO l) throws Exception{
        String sql = "update LoaiSanPham set TenLoaiSanPham = ? "
                + " where MaLoaiSanPham = ?;";// câu lệnh nhập dữ liệu trong sql vào database 
                                //LoaiSanPham bảng TenLoaiSanPham
        try (PreparedStatement ps = conn.prepareStatement(sql);)
        {
            ps.setString(2, l.getMaLoaiSanPham());
            ps.setString(1, l.getTenLoaiSanPham());// gắn giá trị vào cot TenLoaiSP sql
            return ps.executeUpdate() > 0;// add thành công
        } 
    }
    
    public boolean addLoaiSanPham(LoaiSanPhamDTO s){
        
        String sql = "INSERT INTO LoaiSanPham(TenLoaiSanPham) "
                + " VALUES(?);";
        String sql1 ="Select MaLoaiSanPham from LoaiSanPham";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            //ps.setString(0, s.getMaLoaiSanPham()); 
            s.getMaLoaiSanPham();
            ps.setString(1, s.getTenLoaiSanPham());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public ArrayList<LoaiSanPhamDTO> getListLoaiSanPhamDTOs(){
        ArrayList<LoaiSanPhamDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM LoaiSanPham";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LoaiSanPhamDTO l = new LoaiSanPhamDTO();
                l.setMaLoaiSanPham(rs.getString("MaLoaiSanPham"));
                l.setTenLoaiSanPham(rs.getString("TenLoaiSanPham"));
                
                list.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    
    public static void main(String[] args) {
        new LoaiSanPhamDAO();
    }
    
     public void updateLoaiSanPham(String maLoaiSP) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
