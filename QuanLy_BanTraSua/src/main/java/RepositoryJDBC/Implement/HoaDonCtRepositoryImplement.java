/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepositoryJDBC.Implement;

import DomainModel.HoaDon;
import DomainModel.HoaDonChiTiet;
import DomainModel.SanPham;
import RepositoryJDBC.Interface.HoaDonCTRepositoryInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonCtRepositoryImplement implements HoaDonCTRepositoryInterface{
    private static Connection cn = Utility.DBContext.getConnection();
    @Override
    public List<HoaDonChiTiet> getAll() {
        List<HoaDonChiTiet> lst_hdct = new ArrayList<>();
        String sql = "select hd.Ma as MaHD,sp.Ten as TenSP,hdct.SL_Mua,hdct.DonGia from HoaDonChiTiet hdct join SanPham sp on hdct.Id_SP = sp.Id join HoaDon hd on hdct.Id_HD = hd.Id";
        try {
            PreparedStatement pr = cn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setMa(rs.getString("MaHD"));
                SanPham sp = new SanPham();
                sp.setTen(rs.getString("TenSP"));
                HoaDonChiTiet hdct = new HoaDonChiTiet(hd, sp, rs.getInt("SL_Mua"), rs.getDouble("DonGia"));
                lst_hdct.add(hdct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_hdct;
    }
    
}
