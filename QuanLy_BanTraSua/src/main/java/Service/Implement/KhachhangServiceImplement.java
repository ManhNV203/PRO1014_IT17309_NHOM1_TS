/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.KhachHang;
import RepositoryJDBC.Implement.KhachhangRepositoryImplement;
import RepositoryJDBC.Interface.KhachhangRepositoryInterface;
import Service.Interface.KhachhangServiceInterface;
import ViewModel.KhachhangViewmodel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public class KhachhangServiceImplement implements KhachhangServiceInterface {

    public KhachhangRepositoryInterface khrpitf;

    public KhachhangServiceImplement() {
        khrpitf = new KhachhangRepositoryImplement();
    }

    @Override
    public List<KhachhangViewmodel> getallKH() {
        List<KhachHang> lst_kh = khrpitf.getAllKH();
        List<KhachhangViewmodel> lst_khvmd = new ArrayList<>();
        for (KhachHang kh : lst_kh) {
            KhachhangViewmodel khvmd = new KhachhangViewmodel();
            khvmd.setID(kh.getID());
            khvmd.setMa(kh.getMa());
            khvmd.setHoTen(kh.getHoTen());
            khvmd.setGioiTinh(kh.getGioiTinh());
            khvmd.setDiaChi(kh.getDiaChi());
            khvmd.setSDT(kh.getSDT());
            khvmd.setMoTa(kh.getMoTa());
            lst_khvmd.add(khvmd);
        }
        return lst_khvmd;
    }

    @Override
    public void CREATEKhachhang(KhachHang kh) {
        khrpitf.createKhachang(kh);

    }

    @Override
    public void deleteKhachhang(KhachHang kh) {
        khrpitf.deleteKhachhang(kh);
    }

    @Override
    public void UPdatekhachhang(KhachHang kh) {
        khrpitf.updateKhachhang(kh);
    }

}
