/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepositoryJDBC.Implement;

import DomainModel.HoaDon;
import DomainModel.KhachHang;
import DomainModel.KhuyenMai;
import DomainModel.NhanVien;
import RepositoryJDBC.Interface.HoaDonRepositoryInterface;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonRepositoryImplement implements HoaDonRepositoryInterface{
    private static Connection cn = Utility.DBContext.getConnection();
    @Override
    public List<HoaDon> getList() {
        List<HoaDon> lst_hd = new ArrayList<>();
        String sql = "select hd.Id,hd.Ma,nv.HoTen AS Ten_nv ,hd.ngayTao,hd.TongTien,kh.Ma AS MA_Kh,km.Ma AS MA_Km,hd.TrangThai from HoaDon hd  join NhanVien nv on  hd.Id_NV = nv.Id \n"
                + "  join Khachhang kh on hd.id_KH = kh.Id \n"
                + " join KhuyenMai km on hd.id_KM = km.Id";
        try {
            PreparedStatement pr = cn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {  
                KhuyenMai km = new KhuyenMai();
                km.setMa(rs.getString("MA_Km"));
                NhanVien nv = new NhanVien();
                nv.setHoTen(rs.getString("Ten_nv"));
                KhachHang kh = new KhachHang();
                kh.setMa(rs.getString("MA_Kh"));
                HoaDon hd = new HoaDon(
                        rs.getString("id"),
                        rs.getString("Ma"),
                        nv,
                        rs.getString("ngayTao"), 
                        rs.getBigDecimal("TongTien"), 
                        kh,
                        km, 
                        rs.getInt("TrangThai"));
                lst_hd.add(hd);
            }
            System.out.println(lst_hd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_hd;
    }

    @Override
    public List<HoaDon> getListhdbh() {
        List<HoaDon> lst_hdbh = new ArrayList<>();
        String sql = "select hd.Ma,nv.Ma as MaNv,hd.ngayTao,hd.TrangThai from HoaDon hd join NhanVien nv  on  hd.Id_NV = nv.Id";
        try {
            PreparedStatement pr = cn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) { 
                NhanVien nv = new NhanVien();
                nv.setMa(rs.getString("MaNv"));
                HoaDon hd = new HoaDon(rs.getString("Ma"), nv, rs.getString("ngayTao"), rs.getInt("TrangThai"));
                lst_hdbh.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_hdbh;
    }
    
}
