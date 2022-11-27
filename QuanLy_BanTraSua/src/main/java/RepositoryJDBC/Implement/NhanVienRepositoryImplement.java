/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepositoryJDBC.Implement;

import DomainModel.NhanVien;
import RepositoryJDBC.Interface.NhanVienRepositoryInterface;
import Utility.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class NhanVienRepositoryImplement implements NhanVienRepositoryInterface{

    @Override
    public List<NhanVien> all() {
        String sql = "select * from NhanVien  ";
        List<NhanVien> listNhanVien = new ArrayList<>();
        try{
             Connection c = DBContext.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                NhanVien nv = new NhanVien();
                nv.setID(rs.getInt(1));
                nv.setMa(rs.getString(2));
                nv.setHoTen(rs.getString(3));
                nv.setMatKhau(rs.getString(4));
                nv.setNgaySinh(rs.getDate(5));
                nv.setGioiTinh(rs.getString(6));
                nv.setDiaChi(rs.getString(7));
                nv.setEmail(rs.getString(8));
                nv.setSDT(rs.getString(9));
                listNhanVien.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return listNhanVien;
    }
//    public static void main(String[] args) {
//        NhanVienRepositoryImplement nv = new NhanVienRepositoryImplement();
//        List<NhanVien> n = new ArrayList<>();
//        n = nv.getByName("vũ");
//        System.out.println(n.toString());
//    }

    @Override
    public boolean add(NhanVien nv) {
        String sql = "insert into NhanVien(Ma,HoTen,MatKhau,NgaySinh,GioiTinh,DiaChi,Email,SDT) values (?,?,?,?,?,?,?,?) ";
        int check = 0;
        try {
            Connection c = DBContext.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getHoTen());
            ps.setObject(3, nv.getMatKhau());
            ps.setObject(4, nv.getNgaySinh());
            ps.setObject(5, nv.getGioiTinh());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(7, nv.getEmail());
            ps.setObject(8, nv.getSDT());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return check >0;
    }

    @Override
    public boolean update(String ma, NhanVien nv) {
        String sql = "update NhanVien set HoTen = ?,MatKhau = ?,NgaySinh = ?,GioiTinh = ?,DiaChi = ?,Email = ?,SDT = ? where Ma = ? ";
        int check = 0;
        try {
            Connection c = DBContext.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setObject(8, nv.getMa());
            ps.setObject(1, nv.getHoTen());
            ps.setObject(2, nv.getMatKhau());
            ps.setObject(3, nv.getNgaySinh());
            ps.setObject(4, nv.getGioiTinh());
            ps.setObject(5, nv.getDiaChi());
            ps.setObject(6, nv.getEmail());
            ps.setObject(7, nv.getSDT());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return check >0;
    }

    @Override
    public boolean delete(String ma) {
        String sql = "delete NhanVien where Ma = ? ";
        int check = 0;
        try {
            Connection c = DBContext.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setObject(1, ma);
            
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return check >0;
    }

    @Override
    public NhanVien getone(String ma) {
        String sql = "select * from NhanVien where Ma = ?";
        NhanVien nv = new NhanVien();
        
        try {
            Connection c = DBContext.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                
                nv.setID(rs.getInt(1));
                nv.setMa(rs.getString(2));
                nv.setHoTen(rs.getString(3));
                nv.setMatKhau(rs.getString(4));
                nv.setNgaySinh(rs.getDate(5));
                nv.setGioiTinh(rs.getString(6));
                nv.setDiaChi(rs.getString(7));
                nv.setEmail(rs.getString(8));
                nv.setSDT(rs.getString(9));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return nv;
    }

    @Override
    public List<NhanVien> getBySex(String sex) {
        String sql = "select * from NhanVien where GioiTinh = ? ";
        List<NhanVien> listNhanVien = new ArrayList<>();
        try {
            Connection c = DBContext.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, sex);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                NhanVien nv = new NhanVien();
                nv.setID(rs.getInt(1));
                nv.setMa(rs.getString(2));
                nv.setHoTen(rs.getString(3));
                nv.setMatKhau(rs.getString(4));
                nv.setNgaySinh(rs.getDate(5));
                nv.setGioiTinh(rs.getString(6));
                nv.setDiaChi(rs.getString(7));
                nv.setEmail(rs.getString(8));
                nv.setSDT(rs.getString(9));
                listNhanVien.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return listNhanVien;
    }

    @Override
    public List<NhanVien> getByName(String name) {
        String sql = "select * from NhanVien where HoTen = ? ";
        List<NhanVien> listNhanVien = new ArrayList<>();
        try {
            Connection c = DBContext.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                NhanVien nv = new NhanVien();
                nv.setID(rs.getInt(1));
                nv.setMa(rs.getString(2));
                nv.setHoTen(rs.getString(3));
                nv.setMatKhau(rs.getString(4));
                nv.setNgaySinh(rs.getDate(5));
                nv.setGioiTinh(rs.getString(6));
                nv.setDiaChi(rs.getString(7));
                nv.setEmail(rs.getString(8));
                nv.setSDT(rs.getString(9));
                listNhanVien.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return listNhanVien;
    }

    

    
    
}
