/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.HoaDonChiTiet;
import ViewModel.HoaDonCTVmodel;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public interface HoaDonCtServiceInterface {

    
     List<HoaDonCTVmodel> gethdct(String Mahd);
     boolean deleteHDCT(HoaDonChiTiet hdct);
      boolean HuyThanhToan(String ma);
     boolean deleteALL(int id);
     boolean AddHdct(HoaDonChiTiet hdct);
     boolean UpdateSoLuong(HoaDonChiTiet hdct);
}
