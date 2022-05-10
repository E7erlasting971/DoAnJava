/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import model.HoaDonDTO;

/**
 *
 * @author truongthanh
 */
public interface ThongKeService {
    public List<HoaDonDTO> getListHoaDonByNgay();
    public List<HoaDonDTO> getListHoaDonByThang();
    public List<HoaDonDTO> getListHoaDonByNam();
}
