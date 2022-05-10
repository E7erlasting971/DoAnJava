/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Thinh Ly
 */
public class TaiKhoanDTO {

//    public TaiKhoanDTO(String TenDangNhap, String MatKhau, String MaTaiKhoan) {
//        this.TenDangNhap = TenDangNhap;
//        this.MatKhau = MatKhau;
//        this.MaTaiKhoan = MaTaiKhoan;
//    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getMaTaiKhoan() {
        return MaTaiKhoan;
    }

    public void setMaTaiKhoan(String MaTaiKhoan) {
        this.MaTaiKhoan = MaTaiKhoan;
    }

    public String getCauHoiBaoMat() {
        return CauHoiBaoMat;
    }

    public void setCauHoiBaoMat(String CauHoiBaoMat) {
        this.CauHoiBaoMat = CauHoiBaoMat;
    }

    public String getTraLoiCauHoi() {
        return TraLoiCauHoi;
    }

//    public TaiKhoanDTO(String TenDangNhap, String MatKhau, String MaTaiKhoan) {
//        this.TenDangNhap = TenDangNhap;
//        this.MatKhau = MatKhau;
//        this.MaTaiKhoan = MaTaiKhoan;
//    }
    public void setTraLoiCauHoi(String TraLoiCauHoi) {
        this.TraLoiCauHoi = TraLoiCauHoi;
    }

   

 
    private  String TenDangNhap ;
    private String MatKhau ;
    private String MaTaiKhoan ;
    private String CauHoiBaoMat ;
    private String TraLoiCauHoi ;
    
    
}
