/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.NhanVien;
import ViewModel.NhanVienViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface NhanVienServiceInterface {
    public List<NhanVienViewModel> all();
    boolean add(NhanVienViewModel nvVMD) ;
    boolean update(String ma,NhanVienViewModel nvVMD) ;
    boolean delete(String ma) ;
    NhanVienViewModel getone(String ma);
    public List<NhanVienViewModel> getByName(String name);
    public List<NhanVienViewModel> getBySex(String sex);
    boolean checkMa(String ma);
}
