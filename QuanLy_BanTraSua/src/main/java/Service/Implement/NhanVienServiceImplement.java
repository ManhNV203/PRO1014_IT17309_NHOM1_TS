/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.NhanVien;
import RepositoryJDBC.Implement.NhanVienRepositoryImplement;
import RepositoryJDBC.Interface.NhanVienRepositoryInterface;
import Service.Interface.NhanVienServiceInterface;
import ViewModel.NhanVienViewModel;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ADMIN
 */
public class NhanVienServiceImplement implements NhanVienServiceInterface{
    private NhanVienRepositoryInterface Repo;
    public NhanVienServiceImplement(){
    this.Repo = new NhanVienRepositoryImplement();
}

    @Override
    public List<NhanVienViewModel> all() {
        List<NhanVien> listNV = new ArrayList<>();
        List<NhanVienViewModel> listNVVMD = new ArrayList<>();
        listNV = Repo.all();
        for (NhanVien nv : listNV) {
            NhanVienViewModel VMD = new NhanVienViewModel();
            VMD.setDiaChi(nv.getDiaChi());
            VMD.setEmail(nv.getEmail());
            VMD.setGioiTinh(nv.getGioiTinh());
            VMD.setHoTen(nv.getHoTen());
            VMD.setMa(nv.getMa());
            VMD.setMatKhau(nv.getMatKhau());
            VMD.setNgaySinh(nv.getNgaySinh());
            VMD.setSDT(nv.getSDT());
            
            listNVVMD.add(VMD);
        }
        return listNVVMD;
        
    }
//    public static void main(String[] args) {
//        NhanVienServiceImplement nv = new NhanVienServiceImplement();
//        List<NhanVienViewModel> n = new ArrayList<>();
//        n = nv.all();
//        System.out.println(n.toString());
//    }
    
    @Override
    public boolean add(NhanVienViewModel nvVMD) {
        boolean check ;
            NhanVien nvMD = new NhanVien();
            nvMD.setDiaChi(nvVMD.getDiaChi());
            nvMD.setEmail(nvVMD.getEmail());
            nvMD.setGioiTinh(nvVMD.getGioiTinh());
            nvMD.setHoTen(nvVMD.getHoTen());
            nvMD.setMa(nvVMD.getMa());
            nvMD.setMatKhau(nvVMD.getMatKhau());
            nvMD.setNgaySinh(nvVMD.getNgaySinh());
            nvMD.setSDT(nvVMD.getSDT());
            check = Repo.add(nvMD);
            return check;
    }

    @Override
    public boolean update(String ma, NhanVienViewModel nvVMD) {
        boolean check ;
            NhanVien nvMD = new NhanVien();
            nvMD.setDiaChi(nvVMD.getDiaChi());
            nvMD.setEmail(nvVMD.getEmail());
            nvMD.setGioiTinh(nvVMD.getGioiTinh());
            nvMD.setHoTen(nvVMD.getHoTen());
            nvMD.setMa(nvVMD.getMa());
            nvMD.setMatKhau(nvVMD.getMatKhau());
            nvMD.setNgaySinh(nvVMD.getNgaySinh());
            nvMD.setSDT(nvVMD.getSDT());
            check = Repo.update(ma, nvMD);
            return check;
    }

    @Override
    public boolean delete(String ma) {
        boolean check; 
        check = Repo.delete(ma);
        return check;
    }

    @Override
    public NhanVienViewModel getone(String ma) {
        try {
            NhanVien nvMD = new NhanVien();
        NhanVienViewModel nvVMD = new NhanVienViewModel();
        nvMD = Repo.getone(ma);
        nvVMD.setDiaChi(nvMD.getDiaChi());
            nvVMD.setEmail(nvMD.getEmail());
            nvVMD.setGioiTinh(nvMD.getGioiTinh());
            nvVMD.setHoTen(nvMD.getHoTen());
            nvVMD.setMa(nvMD.getMa());
            nvVMD.setMatKhau(nvMD.getMatKhau());
            nvVMD.setNgaySinh(nvMD.getNgaySinh());
            nvVMD.setSDT(nvMD.getSDT());
            return nvVMD;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

    @Override
    public List<NhanVienViewModel> getByName(String name) {
        List<NhanVien> listNV = new ArrayList<>();
        List<NhanVienViewModel> listNVVMD = new ArrayList<>();
        listNV = Repo.getByName(name);
        for (NhanVien nv : listNV) {
            NhanVienViewModel VMD = new NhanVienViewModel();
            VMD.setDiaChi(nv.getDiaChi());
            VMD.setEmail(nv.getEmail());
            VMD.setGioiTinh(nv.getGioiTinh());
            VMD.setHoTen(nv.getHoTen());
            VMD.setMa(nv.getMa());
            VMD.setMatKhau(nv.getMatKhau());
            VMD.setNgaySinh(nv.getNgaySinh());
            VMD.setSDT(nv.getSDT());
            
            listNVVMD.add(VMD);
        }
        return listNVVMD;
    }
//        public static void main(String[] args) {
//        NhanVienServiceImplement nv = new NhanVienServiceImplement();
//        List<NhanVienViewModel> n = new ArrayList<>();
//        n = nv.getByName("vũ");
//        System.out.println(n.toString());
//    }

    @Override
    public List<NhanVienViewModel> getBySex(String sex) {
        List<NhanVien> listNV = new ArrayList<>();
        List<NhanVienViewModel> listNVVMD = new ArrayList<>();
        listNV = Repo.getBySex(sex);
        for (NhanVien nv : listNV) {
            NhanVienViewModel VMD = new NhanVienViewModel();
            VMD.setDiaChi(nv.getDiaChi());
            VMD.setEmail(nv.getEmail());
            VMD.setGioiTinh(nv.getGioiTinh());
            VMD.setHoTen(nv.getHoTen());
            VMD.setMa(nv.getMa());
            VMD.setMatKhau(nv.getMatKhau());
            VMD.setNgaySinh(nv.getNgaySinh());
            VMD.setSDT(nv.getSDT());
            
            listNVVMD.add(VMD);
        }
        return listNVVMD;
    }

    @Override
    public boolean checkMa(String ma) {
         NhanVien nv = Repo.getone(ma);
         if(Objects.isNull(nv)){
             return true;
         }else{
             return false;
         }
    }

   
    
}
