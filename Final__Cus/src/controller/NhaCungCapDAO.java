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
import model.NhaCungCapDTO;
/**
 *
 * @author Thinh Ly
 */
public class NhaCungCapDAO extends KetNoiCSDL{
//    private Connection conn ;
//    
//    public  NhaCungCapDAO()
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
 
    
     public boolean delNhaCungCap(String tenNhaCungCap) throws Exception{
        String sql = "delete from NhaCungCap "
                + " where TenNhaCungCap = ?;";// câu lệnh nhập dữ liệu trong sql vào database 
                                //LoaiSanPham bảng TenLoaiSanPham
        try (PreparedStatement ps = conn.prepareStatement(sql);)
        {
            ps.setString(1, tenNhaCungCap);// thuc thi hàm sql
            
            return ps.executeUpdate() > 0;
        } 
        
    }
     
         public boolean updateNhaCungCap(NhaCungCapDTO l) throws Exception{
        String sql = "update NhaCungCap set TenNhaCungCap = ? , KhuVuc = ? "
       
                + " where MaNhaCungCap = ?;";// câu lệnh nhập dữ liệu trong sql vào database 
                                //NhaCungCap bảng TenNhaCungCap
        try (PreparedStatement ps = conn.prepareStatement(sql);)
        {
            ps.setString(3, l.getMaNhaCungCap());
            ps.setString(1, l.getTenNhaCungCap());// gắn giá trị vào cot TenNhaCungCap sql
            ps.setString(2, l.getKhuVuc());//gắn giá trị vào cot KhuVuc sql
            return ps.executeUpdate() > 0;// add thành công
        } 
    }
    public boolean AddNhaCungCap(NhaCungCapDTO n)
    {
         String sql = "INSERT INTO NhaCungCap(TenNhaCungCap , KhuVuc) "
                + " VALUES(?,?);";
        String sql1 ="Select MaNhaCungCap from NhaCungCap";
        try {
            PreparedStatement pss = conn.prepareStatement(sql);
            PreparedStatement ps2 = conn.prepareStatement(sql1);
            //ps.setString(0, s.getMaNhaCungCap()); 
            n.getMaNhaCungCap();
            pss.setString(1, n.getTenNhaCungCap());
            pss.setString(2, n.getKhuVuc());
            return pss.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
   public ArrayList<NhaCungCapDTO> getListNhaCungCapDTOs(){
        ArrayList<NhaCungCapDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM NhaCungCap";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhaCungCapDTO ncc = new NhaCungCapDTO();
                ncc.setMaNhaCungCap(rs.getString("MaNhaCungCap"));
                ncc.setTenNhaCungCap(rs.getString("TenNhaCungCap"));
                ncc.setKhuVuc(rs.getString("KhuVuc"));
                
                list.add(ncc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
   
    public static void main(String[] args) {
        {
            new NhaCungCapDAO();
        }
    }
}
