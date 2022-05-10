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
public class NhanVienDTO extends ConNguoiDTO{
    
    private String MaNhanVien;
//    private String TenNhanVien;
    private String DiaChi_NV;
    private String CCCD;
    private String SDT_NV;
    private String ChucVu;
    private Boolean GioiTinh;
    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }
//
//    public String getTenNhanVien() {
//        return TenNhanVien;
//    }
//
//    public void setTenNhanVien(String TenNhanVien) {
//        this.TenNhanVien = TenNhanVien;
//    }

    public String getDiaChi_NV() {
        return DiaChi_NV;
    }

    public void setDiaChi_NV(String DiaChi_NV) {
        this.DiaChi_NV = DiaChi_NV;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getSDT_NV() {
        return SDT_NV;
    }

    public void setSDT_NV(String SDT_NV) {
        this.SDT_NV = SDT_NV;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public Boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(Boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
   

    

}
