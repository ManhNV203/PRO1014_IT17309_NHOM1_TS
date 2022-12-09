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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        String sql = "select hd.Id,hd.Ma,nv.HoTen AS Ten_nv ,hd.ngayTao,hd.TongTien,kh.HoTen AS Ten_Kh,km.Ma AS MA_Km,hd.TrangThai from HoaDon hd  join NhanVien nv on  hd.Id_NV = nv.Id \n"
                + "  join Khachhang kh on hd.id_KH = kh.Id \n"
                + " join KhuyenMai km on hd.id_KM = km.Id where hd.TrangThai=1 or hd.TrangThai=3";
        try {
            PreparedStatement pr = cn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {  
                KhuyenMai km = new KhuyenMai();
                km.setMa(rs.getString("MA_Km"));
                NhanVien nv = new NhanVien();
                nv.setHoTen(rs.getString("Ten_nv"));
                KhachHang kh = new KhachHang();
                kh.setHoTen(rs.getString("Ten_Kh"));
                HoaDon hd = new HoaDon(
                        rs.getInt("id"),
                        rs.getString("Ma"),
                        nv,
                        rs.getDate("ngayTao"), 
                        rs.getBigDecimal("TongTien"), 
                        kh,
                        km, 
                        rs.getInt("TrangThai"));
                lst_hd.add(hd);
            }
            // câu truy vấn thg Resulset nó đang trả về 0 có nghĩa là nó đang không có thg nào để duyệt trong rs.next
            //ông xem lại câu truy vấn đi
            // vãi
            System.out.println(lst_hd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_hd;
    }

    @Override
    public List<HoaDon> getListhdbh() {
        List<HoaDon> lst_hdbh = new ArrayList<>();
        String sql = "select hd.id as id,nv.id as idnv ,hd.Ma as Ma,nv.Ma as MaNv,hd.ngayTao,hd.TrangThai from HoaDon hd join NhanVien nv  on  hd.Id_NV = nv.Id where hd.TrangThai=0 ";
        try {
            PreparedStatement pr = cn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
           
            while (rs.next()) { 
                NhanVien nv = new NhanVien();
                nv.setMa(rs.getString("MaNv"));
                nv.setID(rs.getInt("idnv"));
                HoaDon hd = new HoaDon();
                hd.setMa(rs.getString("Ma"));
                hd.setId_NV(nv);
                hd.setId(rs.getInt("id"));
                hd.setNgayTao(rs.getDate("ngayTao"));
                hd.setTrangThai(rs.getInt("TrangThai"));
                lst_hdbh.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_hdbh;
    }

 
    @Override
    public boolean addHoaDon(HoaDon hd) {
       String sql = "insert into HoaDon (ma,Id_NV,ngayTao,TrangThai)values (?,?,?,?)";
        try {
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, hd.getMa());
            pr.setInt(2, hd.getId_NV().getID());
            pr.setDate(3, new java.sql.Date(hd.getNgayTao().getTime()));
            pr.setInt(4, hd.getTrangThai());
            pr.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Delete(int id) {
        String sql ="delete  from HoaDon where id=? ";
        try {
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setInt(1, id);
            pr.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean ThanhToan(String ma,double TongTien,String ID_KH,String ID_KM) {
        int check =0;
        String sql = "update HoaDon set TrangThai = ?,TongTien=?,id_KH = ?,id_KM = ? where Ma = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setObject(1, 3);
            ps.setObject(2, TongTien);
            ps.setObject(3, ID_KH);
            ps.setObject(4, ID_KM);
            ps.setObject(5, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check >0;
    }

    @Override
    public int getIDByMa(String ma) {
        int ID = 0;
        String sql = "select HoaDon.ID from HoaDon where Ma =?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ID = rs.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ID;
    }

    @Override
    public boolean HuyThanhToan(String ma) {
        int check = 0;
        String sql ="delete from HoaDon where Ma = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check >0;
    }
    
}
