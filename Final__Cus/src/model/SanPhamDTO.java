/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Thinh Ly
 */
public class SanPhamDTO extends LoaiSanPhamDTO {

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public int getGiaSanPham() {
        return GiaSanPham;
    }

    public void setGiaSanPham(int GiaSanPham) {
        this.GiaSanPham = GiaSanPham;
    }

    public String getSLHienCo() {
        return SLHienCo;
    }

    public void setSLHienCo(String SLHienCo) {
        this.SLHienCo = SLHienCo;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

//    public String getMaLoaiSanPham() {
//        return MaLoaiSanPham;
//    }
//
//    public void setMaLoaiSanPham(String MaLoaiSanPham) {
//        this.MaLoaiSanPham = MaLoaiSanPham;
//    }

    public String getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public void setMaNhaCungCap(String MaNhaCungCap) {
        this.MaNhaCungCap = MaNhaCungCap;
    }

    private String MaSanPham;
    private String TenSanPham;
    private int GiaSanPham;
    private String SLHienCo;
    private Date NgayNhap;
    //private String MaLoaiSanPham;
    private String MaNhaCungCap;
}
