/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepositoryJDBC.Implement;

import DomainModel.DanhMuc;
import DomainModel.HoaDon;
import DomainModel.HoaDonChiTiet;
import DomainModel.SanPham;
import DomainModel.Size;
import DomainModel.Vi;
import RepositoryJDBC.Interface.HoaDonCTRepositoryInterface;
import ViewModel.HoaDonCTVmodel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.spec.PSource;

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
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt("id"),hd, sp, rs.getInt("SL_Mua"), rs.getDouble("DonGia"));
                lst_hdct.add(hdct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_hdct;
    }

    @Override
    public List<HoaDonChiTiet> gethdct() {
        List<HoaDonChiTiet> lst_hdct = new ArrayList<>();
        String sql ="select hdct.Id, hd.Id as IDHD, sp.Ma as Masp,sp.Ten as TenSp,hdct.DonGia,hdct.SL_Mua,v.Ten as Vi,s.TheTich as TheTich,dm.Ten as DanhMuc from HoaDonChiTiet hdct join SanPham sp on hdct.Id_SP = sp.Id join HoaDon hd on hdct.Id_HD = hd.Id join Vi v on sp.Id_Vi = v.Id join Size s on sp.Id_Size=s.Id join DanhMuc dm on sp.Id_DM=dm.Id ";
        try {
            PreparedStatement pr = cn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {  
                Vi v = new Vi();
                v.setTen(rs.getString("Vi"));
                DanhMuc dm = new DanhMuc();
                dm.setTenDM(rs.getString("DanhMuc"));
                Size s = new Size();
                s.setTheTich(rs.getString("TheTich"));
                SanPham sp = new SanPham();
                sp.setMa(rs.getString("Masp"));
                sp.setTen(rs.getString("TenSp"));
                sp.setId_Vi(v);
                sp.setId_size(s);
                sp.setId_DanhMuc(dm);
                HoaDon hd = new HoaDon();
                hd.setId(rs.getString("IDHD"));
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt("id"),hd, sp, rs.getInt("SL_Mua"), rs.getDouble("DonGia"));
                lst_hdct.add(hdct);
                System.out.println(hdct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_hdct;
    }

    @Override
    public boolean delete(HoaDonChiTiet hdct) {
        String sql = "delete from hoadonchitiet where id=?";
        Boolean kq = null;
        try {
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setInt(1, hdct.getId());
            kq = pr.execute();
            System.out.println(kq);
            return kq;
        } catch (Exception e) {
            e.printStackTrace();
             return false;
        }
       
    }
    
}
