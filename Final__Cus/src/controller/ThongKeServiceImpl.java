
package controller;

import java.util.List;
import model.HoaDonDTO;
import model.ThongKeDAO;
import model.ThongKeService;

/**
 *
 * @author truongthanh
 */
public class ThongKeServiceImpl implements ThongKeService{
    
    private ThongKeDAO thongKeDAO = null;
    
    public ThongKeServiceImpl(){
        thongKeDAO = new ThongKeDAOImpl();
    }
    
    public List<HoaDonDTO> getListHoaDonByNgay() {
        return thongKeDAO.getListHoaDonByNgay();
    }
    
    public List<HoaDonDTO> getListHoaDonByNam() {
        return thongKeDAO.getListHoaDonByNam();
    }
    
    public List<HoaDonDTO> getListHoaDonByThang() {
        return thongKeDAO.getListHoaDonByThang();
    }
}
