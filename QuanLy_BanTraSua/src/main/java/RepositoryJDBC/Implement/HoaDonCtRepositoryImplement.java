/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepositoryJDBC.Implement;

import DomainModel.HoaDon;
import DomainModel.HoaDonChiTiet;
import DomainModel.SanPham;
import RepositoryJDBC.Interface.HoaDonCTRepositoryInterface;
import ViewModel.HoaDonCTVmodel;
import ViewModel.SanPhamViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonCtRepositoryImplement implements HoaDonCTRepositoryInterface {

    private static Connection cn = Utility.DBContext.getConnection();

    @Override
    public List<HoaDonChiTiet> getAll() {
        List<HoaDonChiTiet> lst_hdct = new ArrayList<>();
        String sql = "select hd.Ma as MaHD,sp.Ten as TenSP,hdct.SL_Mua,hdct.DonGia from HoaDonChiTiet hdct join SanPham sp on hdct.Id_SP = sp.Id join HoaDon hd on hdct.Id_HD = hd.Id";
        try {
            PreparedStatement pr = cn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
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

    @Override
    public void CreateHDCT(HoaDonChiTiet hdct) {
        String sql = " ";

        try {
            PreparedStatement ptm = cn.prepareStatement(sql);
            ptm.setString(1, hdct.getId_HD().toString());
            ptm.setString(2, hdct.getId_SP().toString());
            ptm.setString(3, String.valueOf(hdct.getSL_Mua()));
            ptm.setString(4, String.valueOf(hdct.getDonGia()));
            ptm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
       

    }

    @Override
    public List<HoaDonCTVmodel> LocDanhmuc(String id) {
  String sql = " SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[DonGia]\n"
                + "      ,[TrangThai]\n"
                + "      ,[Id_Vi]\n"
                + "      ,[Id_DM]\n"
                + "      ,[Id_Size]\n"
                + "  FROM [dbo].[SanPham] where [Id_Vi] = '?'\n"
                + "\n"
                + "GO";
        List<HoaDonCTVmodel> list = new ArrayList<>();
        try {

            PreparedStatement pt = cn.prepareStatement(sql);
            pt.setString(1, id);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMa(rs.getString("MaHD"));
                SanPham sp = new SanPham();
                sp.setTen(rs.getString("TenSP"));
                HoaDonCTVmodel hdct = new HoaDonCTVmodel(hd, sp, rs.getInt("SL_Mua"), rs.getDouble("DonGia"));
                list.add(hdct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}
