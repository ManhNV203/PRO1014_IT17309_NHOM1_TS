/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RepositoryJDBC.Interface;

import DomainModel.HoaDon;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public interface HoaDonRepositoryInterface {
    public List<HoaDon> getList();
    public List<HoaDon> getListhdbh();
    public boolean addHoaDon(HoaDon hd);
    public boolean Delete(int id);
     public boolean ThanhToan(String ma,double TongTien,String ID_KH,String ID_KM);
    public int getIDByMa(String ma);
    public boolean HuyThanhToan(String ma);
    
    
}
