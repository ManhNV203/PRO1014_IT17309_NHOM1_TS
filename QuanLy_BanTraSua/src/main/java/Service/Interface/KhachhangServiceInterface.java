/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.KhachHang;
import ViewModel.KhachhangViewmodel;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface KhachhangServiceInterface {
    public List<KhachhangViewmodel> getallKH();

    
    public void CREATEKhachhang(KhachHang kh);
    
    public void deleteKhachhang(KhachHang kh);
    
    public  void UPdatekhachhang(KhachHang kh);
    
    public boolean addSDTKhachHang(String SDT,String hoTen);
    
    public KhachhangViewmodel getBySDT(String SDT);
}
