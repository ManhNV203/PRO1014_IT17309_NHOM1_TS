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
    List<HoaDonCTVmodel> getall();
     public  void CREATEHDCT(HoaDonChiTiet hdct);
     
    public List<HoaDonCTVmodel>  LocDanhMuc(String id);
        
}
