/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;


import RepositoryJDBC.Interface.HoaDonRepositoryInterface;
import Service.Interface.HoaDonServiceInterface;
import ViewModel.HoaDonVModel;
import java.util.List;
import DomainModel.HoaDon;
import RepositoryJDBC.Implement.HoaDonRepositoryImplement;
import java.util.ArrayList;
/**
 *
 * @author FPTSHOP
 */
public class HoaDonServiceImplement implements HoaDonServiceInterface{
    private HoaDonRepositoryInterface hd ;
    public HoaDonServiceImplement(){
        this.hd = new HoaDonRepositoryImplement();
    }
    
    @Override
    public List<HoaDonVModel> getList() {
        List<HoaDon> lst_hd = hd.getList();
        List<HoaDonVModel> lst_hdvmd = new ArrayList<>();
        for (HoaDon hddm : lst_hd) {
            HoaDonVModel hdvmd = new HoaDonVModel();
            hdvmd.setMa(hddm.getMa());
            hdvmd.setId_NV(hddm.getId_NV());
            hdvmd.setNgayTao(hddm.getNgayTao());
            hdvmd.setTongTien(hddm.getTongTien());
            hdvmd.setId_KH(hddm.getId_KH());
            hdvmd.setId_KM(hddm.getId_KM());
            hdvmd.setTrangThai(hddm.getTrangThai());
            lst_hdvmd.add(hdvmd);
        }
        return lst_hdvmd;
    }

    @Override
    public List<HoaDonVModel> getListhdbh() {
        List<HoaDon> lst_hd = hd.getListhdbh();
        List<HoaDonVModel> lst_hdvmd = new ArrayList<>();
        for (HoaDon hd : lst_hd) {
            HoaDonVModel hdvmd = new HoaDonVModel();
            hdvmd.setMa(hd.getMa());
            hdvmd.setId_NV(hd.getId_NV());
            hdvmd.setNgayTao(hd.getNgayTao());
            hdvmd.setTrangThai(hd.getTrangThai());
            lst_hdvmd.add(hdvmd);
            
        }
        return lst_hdvmd;
    }
    
}
