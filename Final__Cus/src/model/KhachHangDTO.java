/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Thinh Ly
 */
public class KhachHangDTO extends ConNguoiDTO{

    private String MaKhachHang ;
//    private String TenKhachHang;
    private String DiaChi ;
    private String SDT ;
    
    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

//    public String getTenKhachHang() {
//        return TenKhachHang;
//    }
//
//    public void setTenKhachHang(String TenKhachHang) {
//        this.TenKhachHang = TenKhachHang;
//    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }


  

   
    
    
}
