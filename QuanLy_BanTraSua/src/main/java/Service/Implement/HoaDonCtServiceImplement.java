/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.HoaDon;
import DomainModel.HoaDonChiTiet;
import RepositoryJDBC.Implement.HoaDonCtRepositoryImplement;
import RepositoryJDBC.Interface.HoaDonCTRepositoryInterface;
import Service.Interface.HoaDonCtServiceInterface;
import ViewModel.HoaDonCTVmodel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonCtServiceImplement implements HoaDonCtServiceInterface{
    private HoaDonCTRepositoryInterface hdct;
    public HoaDonCtServiceImplement(){
        this.hdct = new HoaDonCtRepositoryImplement();
    }

    @Override
    public List<HoaDonCTVmodel> getall() {
        List<HoaDonChiTiet> lst_hdct = hdct.getAll();
        List<HoaDonCTVmodel> lst_hdctvmd = new ArrayList<>();
        for (HoaDonChiTiet hdctdm : lst_hdct) {
            HoaDonCTVmodel hdctvmd = new HoaDonCTVmodel();
            hdctvmd.setId_HD(hdctdm.getId_HD());
            hdctvmd.setId_SP(hdctdm.getId_SP());
            hdctvmd.setSL_Mua(hdctdm.getSL_Mua());
            hdctvmd.setDonGia(hdctdm.getDonGia());
            lst_hdctvmd.add(hdctvmd);
        }
        return lst_hdctvmd;
    }
}
