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
import javax.swing.JOptionPane;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonCtServiceImplement implements HoaDonCtServiceInterface {

    private HoaDonCTRepositoryInterface hdctRepository;

    public HoaDonCtServiceImplement() {
        this.hdctRepository = new HoaDonCtRepositoryImplement();
    }



    @Override
    public List<HoaDonCTVmodel> gethdct() {
        List<HoaDonChiTiet> lst_hdct = hdctRepository.gethdct();
        List<HoaDonCTVmodel> lst_hdctvmd = new ArrayList<>();
        for (HoaDonChiTiet hdctdm : lst_hdct) {
            HoaDonCTVmodel hdctvmd = new HoaDonCTVmodel();
            hdctvmd.setId(hdctdm.getId());
            hdctvmd.setMa_hd(hdctdm.getId_HD().getMa());
            hdctvmd.setMa_SP(hdctdm.getId_SP().getMa());
            hdctvmd.setTenSP(hdctdm.getId_SP().getTen());
            hdctvmd.setID_VI(hdctdm.getId_SP().getId_Vi().getTen());
            hdctvmd.setID_SIZE(hdctdm.getId_SP().getId_size().getTheTich());
            hdctvmd.setID_dM(hdctdm.getId_SP().getId_DanhMuc().getTenDM());
            hdctvmd.setDonGia(hdctdm.getDonGia());
            hdctvmd.setSL_Mua(hdctdm.getSL_Mua());
            lst_hdctvmd.add(hdctvmd);
        }
        return lst_hdctvmd;
    }
    
    public static void main(String[] args) {
        HoaDonCTRepositoryInterface hoaDonCTRepositoryInterface = new HoaDonCtRepositoryImplement();
        System.out.println(hoaDonCTRepositoryInterface.gethdct());
    }

    @Override
    public boolean deleteHDCT(HoaDonChiTiet hdct) {
        if (hdctRepository.delete(hdct)==false) {
            JOptionPane.showMessageDialog(null,"Xoa thanh cong");
            return true;
        }else{
            JOptionPane.showMessageDialog(null,"Xoa khong thanh cong");
            return false;
        }
    }
}
