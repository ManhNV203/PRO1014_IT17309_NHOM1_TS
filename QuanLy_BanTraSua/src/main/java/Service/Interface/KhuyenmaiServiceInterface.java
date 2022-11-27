/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.KhuyenMai;
import ViewModel.KhuyenmaiViewModel;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface KhuyenmaiServiceInterface {

    public List<KhuyenmaiViewModel> getAllKM();

   
    public void createKhuyenmai(KhuyenMai km);

    public void updateKhuyenmai(KhuyenMai km);

    public void deleteKhuyenmai(KhuyenMai km);

    public List<KhuyenmaiViewModel> GetSotiengiamnhohon100(Double Sotien);

    public List<KhuyenmaiViewModel> GetSotiengiamnhohon200(Double Sotien);
}
