/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.HoaDon;
import DomainModel.HoaDonChiTiet;
import RepositoryJDBC.Implement.HoaDonCtRepositoryImplement;
import RepositoryJDBC.Implement.HoaDonRepositoryImplement;
import RepositoryJDBC.Interface.HoaDonCTRepositoryInterface;
import RepositoryJDBC.Interface.HoaDonRepositoryInterface;
import Service.Interface.HoaDonCtServiceInterface;
import ViewModel.HoaDonCTVmodel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonCtServiceImplement implements HoaDonCtServiceInterface {

    private HoaDonCTRepositoryInterface hdctRepository;
    private HoaDonRepositoryInterface hdRepository;

    public HoaDonCtServiceImplement() {
        this.hdctRepository = new HoaDonCtRepositoryImplement();
        this.hdRepository = new HoaDonRepositoryImplement();
    }



    @Override
    public List<HoaDonCTVmodel> gethdct(String mahd) {
        List<HoaDonChiTiet> lst_hdct = hdctRepository.gethdct(mahd);
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
//        System.out.println(hoaDonCTRepositoryInterface.gethdct());
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

    @Override
    public boolean HuyThanhToan(String ma) {
       boolean check = false;
        List<Integer> list = new ArrayList<>();
        list = hdctRepository.getIDByMa(hdRepository.getIDByMa(ma));
        if(Objects.isNull(list)){
            return false;
        }
        for (Integer id : list) {
            check = hdctRepository.HuyHoaDon(id);
        }
        
        return check;
    }

    @Override
    public boolean deleteALL(int id) {
        return hdctRepository.deleteALL(id);
    }

    @Override
    public boolean AddHdct(HoaDonChiTiet hdct) {
        return hdctRepository.AddHdct(hdct);
    }
}
