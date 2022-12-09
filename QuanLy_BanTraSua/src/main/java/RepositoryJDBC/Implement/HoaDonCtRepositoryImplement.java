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
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public List<HoaDonChiTiet> gethdct(String Mahd) {
        List<HoaDonChiTiet> lst_hdct = new ArrayList<>();
        String sql ="select hdct.Id, hd.Id as IDHD,hd.Ma as mahd, sp.Ma as Masp"
                + ",sp.Ten as TenSp,hdct.DonGia,hdct.SL_Mua,v.Ten as Vi,s.TheTich as TheTich"
                + ",dm.Ten as DanhMuc from HoaDonChiTiet hdct join SanPham sp"
                + " on hdct.Id_SP = sp.Id "
                + "join HoaDon hd on hdct.Id_HD = hd.Id "
                + "join Vi v on sp.Id_Vi = v.Id join Size s on sp.Id_Size=s.Id "
                + "join DanhMuc dm on sp.Id_DM=dm.Id where hd.Ma=?";
        try {
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, Mahd);
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
                hd.setId(rs.getInt("IDHD"));
                hd.setMa(rs.getString("mahd"));
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

    @Override
    public List getIDByMa(int ID) {
        List<Integer> list = new ArrayList<>();
        String sql = "select HoaDonChiTiet.ID from HoaDonChiTiet where ID_HD = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(rs.getInt("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean HuyHoaDon(int ID) {
        int check = 0;
        String sql = "delete from HoaDonChiTiet where ID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, ID);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check >0;
    }

    @Override
    public boolean deleteALL(int id) {
        
        int check = 0;
        String sql = "delete from HoaDonChiTiet where ID = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check >0;
    }

    @Override
    public boolean AddHdct(HoaDonChiTiet hdct) {
        String sql = "insert into HoaDonChiTiet (Id_HD,Id_SP,SL_Mua,DonGia) values (?,?,?,?)";
        try {
            PreparedStatement pr = cn.prepareStatement(sql);
            Integer idHD = null;
            if(hdct.getId_HD() != null){
                idHD = hdct.getId_HD().getId();
            }
            Integer idSP = null;
            if(hdct.getId_SP()!= null){
                idSP = hdct.getId_SP().getId();
            }
            pr.setInt(1, idHD);
            pr.setInt(2, idSP);
            pr.setInt(3, hdct.getSL_Mua());
            pr.setDouble(4, hdct.getDonGia());
            pr.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean UpdateSoLuong(HoaDonChiTiet hdct) {
        String sql = "update hoadonchitiet set SL_Mua=? where id=?";
        try {
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setDouble(1, hdct.getSL_Mua());
            pr.setInt(2, hdct.getId());
            pr.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
