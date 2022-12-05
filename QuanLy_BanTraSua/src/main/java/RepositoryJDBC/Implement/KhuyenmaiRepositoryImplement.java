/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepositoryJDBC.Implement;

import DomainModel.KhuyenMai;
import RepositoryJDBC.Interface.KhuyenmaiRepositoryinterface;
import Utility.DBContext;
import ViewModel.KhuyenmaiViewModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mr.quyen
 */
public class KhuyenmaiRepositoryImplement implements KhuyenmaiRepositoryinterface {

    private static final Connection con = DBContext.getConnection();

    @Override
    public List<KhuyenMai> getAllKM() {
        List<KhuyenMai> list = new ArrayList<>();

        String query = "select a.Id, a.Ma, a.SoTienGiam ,a.ngayBatDau , a.ngayketThuc  , a.DieuKien\n"
                + "          from [dbo].[KhuyenMai] a ";

        PreparedStatement ptm;
        try {
            ptm = con.prepareStatement(query);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
//                KhuyenmaiViewModel kmvml = new KhuyenmaiViewModel();
               list.add(new KhuyenMai(rs.getString(1), rs.getString(2), Double.parseDouble(rs.getString(3)), rs.getDate(4), rs.getDate(5), rs.getString(6)));

            }

        } catch (Exception e) {
            Logger.getLogger(KhuyenmaiViewModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    public static void main(String[] args) {
        KhuyenmaiRepositoryImplement km = new KhuyenmaiRepositoryImplement();
        List<KhuyenMai> list = km.getMaKhuyenMai();
        System.out.println(list);
    }

    @Override
    public void createKhuyenmai(KhuyenMai km) {
        List<KhuyenMai> list = new ArrayList<>();
        String query = "INSERT INTO [dbo].[KhuyenMai]\n"
                + "           ([Ma]\n"
                + "           ,[SoTienGiam]\n"
                + "           ,[ngayBatDau]\n"
                + "           ,[ngayketThuc]\n"
                + "           ,[DieuKien])\n"
                + "     VALUES"
                + "(?,?,?,?,?)";

        PreparedStatement ptm;
        try {
            ptm = con.prepareStatement(query);
            ptm.setString(1, km.getMa());
            ptm.setDouble(2, km.getSoTienGiam());
            ptm.setDate(3, new Date(km.getNgayBatDau().getTime()));
            ptm.setDate(4, new Date(km.getNgayketThuc().getTime()));
            ptm.setString(5, km.getDieukien());

            ptm.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(KhuyenMai.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void updateKhuyenmai(KhuyenMai km) {
        String query = "UPDATE [dbo].[KhuyenMai]\n"
                + "   SET \n"
                + "      [SoTienGiam] = ?\n"
                + "      ,[ngayBatDau] =?\n"
                + "      ,[ngayketThuc] = ?\n"
                + "      ,[DieuKien] =?\n"
                + " WHERE [Ma] = ?\n";

        try {
            PreparedStatement ptm = con.prepareStatement(query);

            ptm.setString(5, km.getMa());
            ptm.setDouble(1, km.getSoTienGiam());
            ptm.setDate(2, new Date(km.getNgayBatDau().getTime()));
            ptm.setDate(3, new Date(km.getNgayketThuc().getTime()));
            ptm.setString(4, km.getDieukien());

            ptm.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(KhuyenMai.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void deleteKhuyenmai(KhuyenMai km) {
        String query = "DELETE FROM [dbo].[KhuyenMai]\n"
                + "      WHERE Ma= ?\n";

        try {
            PreparedStatement pt = con.prepareStatement(query);
            pt.setString(1, km.getMa());
            pt.executeUpdate();
            pt.close();
        } catch (Exception e) {
            Logger.getLogger(KhuyenMai.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<KhuyenmaiViewModel> GetSotiengiamnhohon100(Double Sotien) {
        String sql = " select * from KhuyenMai a where a.SoTienGiam <  ?   ";
        List<KhuyenmaiViewModel> list = new ArrayList<>();
        try {

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setDouble(1, Sotien);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                KhuyenmaiViewModel km = new KhuyenmaiViewModel();
                km.setId(rs.getString(1));
                km.setMa(rs.getString(2));
                km.setSoTienGiam(rs.getDouble(3));
                km.setNgayBatDau(rs.getDate(4));
                km.setNgayketThuc(rs.getDate(5));
                km.setDieukien(rs.getString(6));
                list.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<KhuyenmaiViewModel> GetSotiengiamnhohon200(Double Sotien) {

        String sql = " select * from KhuyenMai a where a.SoTienGiam <  ?   ";
        List<KhuyenmaiViewModel> list = new ArrayList<>();
        try {

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setDouble(1, Sotien);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                KhuyenmaiViewModel km = new KhuyenmaiViewModel();
                km.setId(rs.getString(1));
                km.setMa(rs.getString(2));
                km.setSoTienGiam(rs.getDouble(3));
                km.setNgayBatDau(rs.getDate(4));
                km.setNgayketThuc(rs.getDate(5));
                km.setDieukien(rs.getString(6));
                list.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }

    @Override
    public List<KhuyenMai> getMaKhuyenMai() {
        List<KhuyenMai> listKM = new ArrayList<>();
        String sql = "select KhuyenMai.Ma,KhuyenMai.SoTienGiam from KhuyenMai";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhuyenMai km = new KhuyenMai();
                km.setMa(rs.getString("Ma"));
                km.setSoTienGiam(rs.getDouble("SoTienGiam"));
                listKM.add(km);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listKM;
    }

  


   

}
