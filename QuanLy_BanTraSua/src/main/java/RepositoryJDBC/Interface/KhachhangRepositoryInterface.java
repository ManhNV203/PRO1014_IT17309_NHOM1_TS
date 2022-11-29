/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RepositoryJDBC.Interface;

import DomainModel.KhachHang;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface KhachhangRepositoryInterface {
     public List<KhachHang> getAllKH();
     
     public void createKhachang(KhachHang kh);
    public void updateKhachhang(KhachHang kh) ;
    public void deleteKhachhang(KhachHang kh) ;
    public List<KhachHang> getBySDT(String sdt);
    
}
