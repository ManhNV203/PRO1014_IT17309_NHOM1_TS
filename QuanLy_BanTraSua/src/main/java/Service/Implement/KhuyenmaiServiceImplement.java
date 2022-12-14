/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.KhuyenMai;
import RepositoryJDBC.Implement.KhuyenmaiRepositoryImplement;
import RepositoryJDBC.Interface.KhuyenmaiRepositoryinterface;
import Service.Interface.KhuyenmaiServiceInterface;
import ViewModel.KhuyenmaiViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mr.quyen
 */
public class KhuyenmaiServiceImplement implements KhuyenmaiServiceInterface {

    public  KhuyenmaiRepositoryinterface kmrps;

    public KhuyenmaiServiceImplement() {
        kmrps = new KhuyenmaiRepositoryImplement();
    }

    @Override
    public List<KhuyenmaiViewModel> getAllKM() {
        List<KhuyenMai> listkmdomodel = kmrps.getAllKM();
        List<KhuyenmaiViewModel> listkmview = new ArrayList<>();
        for (KhuyenMai kmdomain : listkmdomodel) {
            KhuyenmaiViewModel kmview = new KhuyenmaiViewModel();
            kmview.setId(kmdomain.getId());
            kmview.setMa(kmdomain.getMa());
            kmview.setSoTienGiam(kmdomain.getSoTienGiam());
            kmview.setNgayBatDau(kmdomain.getNgayBatDau());
            kmview.setNgayketThuc(kmdomain.getNgayketThuc());
            kmview.setDieukien(kmdomain.getDieukien());
            listkmview.add(kmview);

        }

        return listkmview;
    }

    @Override
    public void createKhuyenmai(KhuyenMai km) {
        kmrps.createKhuyenmai(km);
    }

    @Override
    public void updateKhuyenmai(KhuyenMai km) {
        kmrps.updateKhuyenmai(km);
    }

    @Override
    public void deleteKhuyenmai(KhuyenMai km) {
        kmrps.deleteKhuyenmai(km);
    }

    @Override
    public List<KhuyenmaiViewModel> GetSotiengiamnhohon100(Double Sotien) {
        
        
        return kmrps.GetSotiengiamnhohon100(Sotien);
    }

    @Override
    public List<KhuyenmaiViewModel> GetSotiengiamnhohon200(Double Sotien) {
        return kmrps.GetSotiengiamnhohon200(Sotien);
    }

    @Override
    public List<KhuyenmaiViewModel> getMaKM() {
        List<KhuyenmaiViewModel> listVMD = new ArrayList<>();
        List<KhuyenMai> listMD = new ArrayList<>();
        listMD = kmrps.getMaKhuyenMai();
        for (KhuyenMai khuyenMai : listMD) {
            KhuyenmaiViewModel KMVMD = new KhuyenmaiViewModel();
            KMVMD.setMa(khuyenMai.getMa());
            KMVMD.setSoTienGiam(khuyenMai.getSoTienGiam());
            listVMD.add(KMVMD);
        }
        return listVMD;
    }

    @Override
    public KhuyenmaiViewModel getID(String ma) {
        KhuyenmaiViewModel KMVMD = new KhuyenmaiViewModel();
        KhuyenMai KMMD = kmrps.getID(ma);
        if (Objects.isNull(KMMD)) {
            return null;
        }

        KMVMD.setId(KMMD.getId());
        

        return KMVMD;
    }
    public static void main(String[] args) {
        KhuyenmaiServiceImplement km = new KhuyenmaiServiceImplement();
        System.out.println(km.getID("KM4").toString());
    }
    
    }




