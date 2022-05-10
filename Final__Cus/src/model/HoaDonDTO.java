/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author truongthanh
 */
public class HoaDonDTO extends NhanVienDTO{
    private String MaHoaDon;
    private int TongTien;
    private Date NgayMua;
    private String MaKhachHang;
    //private String MaNhanVien;
    private String Ngay;
    private String Thang;
    private String Nam;

    public String getNgay() {
        return Ngay;
    }

    public void setDay(String Ngay) {
        this.Ngay = Ngay;
    }

    public String getThang() {
        return Thang;
    }

    public void setThang(String Thang) {
        this.Thang = Thang;
    }

    public String getNam() {
        return Nam;
    }

    public void setNam(String Nam) {
        this.Nam = Nam;
    }
    

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public Date getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(Date NgayMua) {
        this.NgayMua = NgayMua;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

//    public String getMaNhanVien() {
//        return MaNhanVien;
//    }
//
//    public void setMaNhanVien(String MaNhanVien) {
//        this.MaNhanVien = MaNhanVien;
//    }
    
}
