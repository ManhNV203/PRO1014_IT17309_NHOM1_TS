/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RepositoryJDBC.Interface;

import java.util.List;
import DomainModel.KhuyenMai;
import ViewModel.KhuyenmaiViewModel;

/**
 *
 * @author mr.quyen
 */
public interface KhuyenmaiRepositoryinterface {

    public List<KhuyenMai> getAllKM();

//    public List<KhuyenMai> getAllKMCombo();

    public void createKhuyenmai(KhuyenMai km);

    public void updateKhuyenmai(KhuyenMai km);

    public void deleteKhuyenmai(KhuyenMai km);

    public List<KhuyenmaiViewModel> GetSotiengiamnhohon100(Double Sotien);

    public List<KhuyenmaiViewModel> GetSotiengiamnhohon200(Double Sotien);
    
    public List<KhuyenMai> getMaKhuyenMai();

}
