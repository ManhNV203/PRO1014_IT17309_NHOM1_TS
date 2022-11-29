/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;


import ViewModel.HoaDonVModel;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public interface HoaDonServiceInterface {
    public List<HoaDonVModel> getList();
    public List<HoaDonVModel > getListhdbh();
    public boolean ThanhToan(String ma);
    public boolean HuyThanhToan(String ma);
    public int getIDByMa(String ma);
}
