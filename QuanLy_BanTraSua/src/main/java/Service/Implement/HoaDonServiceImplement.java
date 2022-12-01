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
public class HoaDonServiceImplement implements HoaDonServiceInterface {

    private HoaDonRepositoryInterface hdrp;

    public HoaDonServiceImplement() {
        this.hdrp = new HoaDonRepositoryImplement();
    }

    @Override
    public List<HoaDonVModel> getList() {
        List<HoaDon> lst_hd = hdrp.getList();
        List<HoaDonVModel> lst_hdvmd = new ArrayList<>();
        for (HoaDon hddm : lst_hd) {
            HoaDonVModel hdvmd = new HoaDonVModel();
            hdvmd.setId(hddm.getId());
            hdvmd.setMa(hddm.getMa());
            hdvmd.setTen_nv(hddm.getId_NV().getHoTen());
            hdvmd.setTenKh(hddm.getId_KH().getHoTen());
            hdvmd.setMakm(hddm.getId_KM().getMa());
            hdvmd.setNgayTao(hddm.getNgayTao());
            hdvmd.setTongTien(hddm.getTongTien());
            hdvmd.setTrangThai(hddm.getTrangThai());
            lst_hdvmd.add(hdvmd);
        }
        return lst_hdvmd;
    }

    @Override
    public List<HoaDonVModel> getListhdbh() {
        List<HoaDon> lst_hd = hdrp.getListhdbh();
        List<HoaDonVModel> lst_hdvmd = new ArrayList<>();
        for (HoaDon hd : lst_hd) {
            HoaDonVModel hdvmd = new HoaDonVModel();
            hdvmd.setId(hd.getId());
            hdvmd.setMa(hd.getMa());
            hdvmd.setMa_nv(hd.getId_NV().getMa());
            hdvmd.setNgayTao(hd.getNgayTao());
            hdvmd.setTrangThai(hd.getTrangThai());
            lst_hdvmd.add(hdvmd);

        }
        return lst_hdvmd;
    }

    @Override
    public boolean addHoaDon(HoaDon hd) {
        return hdrp.addHoaDon(hd);
    }

    public static void main(String[] args) {
        HoaDonServiceInterface hdsv = new HoaDonServiceImplement();
        System.out.println(hdsv.getListhdbh());

    }

    @Override
    public boolean Delete(HoaDon hd) {
        return hdrp.Delete(hd);
    }

    @Override
    public boolean ThanhToan(String ma) {
        boolean check;
        check = hdrp.ThanhToan(ma);
        return check;
    }

    @Override
    public boolean HuyThanhToan(String ma) {
        boolean check;
        check = hdrp.HuyThanhToan(ma);
        return check;
    }

    @Override
    public int getIDByMa(String ma) {
        return hdrp.getIDByMa(ma);
    }

}
