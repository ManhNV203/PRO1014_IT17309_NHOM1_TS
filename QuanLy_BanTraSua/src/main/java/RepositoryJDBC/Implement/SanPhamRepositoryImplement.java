package RepositoryJDBC.Implement;

import DomainModel.SanPham;
import RepositoryJDBC.Interface.SanPhamRepositoryInterface;
import Utility.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SanPhamRepositoryImplement implements SanPhamRepositoryInterface {

    private static Connection con;

    public SanPhamRepositoryImplement() {
        this.con = DBContext.getConnection();
    }

    @Override
    public List<SanPham> getAllSanPham() {
        String sql = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[DonGia]\n"
                + "      ,[TrangThai]\n"
                + "      ,[Id_Vi]\n"
                + "      ,[Id_DM]\n"
                + "      ,[Id_Size]\n"
                + "  FROM [dbo].[SanPham]";
        List<SanPham> listSP = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setId(rs.getInt(1));
                sp.setMa(rs.getString(2));
                sp.setTen(rs.getString(3));
                sp.setDonGia(rs.getString(4));
                sp.setTrangThai(rs.getInt(5));
                sp.setId_Vi(rs.getInt(6));
                sp.setId_DanhMuc(rs.getInt(7));
                sp.setId_size(rs.getInt(8));
                listSP.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSP;
    }

    @Override
    public void addSanPham(SanPham sanPham) {
        String sql = "INSERT INTO [dbo].[SanPham]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[DonGia]\n"
                + "           ,[TrangThai]\n"
                + "           ,[Id_Vi]\n"
                + "           ,[Id_DM]\n"
                + "           ,[Id_Size])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sanPham.getMa());
            ps.setString(2, sanPham.getTen());
            ps.setString(3, sanPham.getDonGia());
            ps.setInt(4, sanPham.getTrangThai());
            ps.setInt(5, sanPham.getId_Vi());
            ps.setInt(6, sanPham.getId_DanhMuc());
            ps.setInt(7, sanPham.getId_size());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(SanPhamRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateSanPham(SanPham sanPham) {
        String sql = "UPDATE [dbo].[SanPham]\n"
                + "   SET [Ten] = ?\n"
                + "      ,[DonGia] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + "      ,[Id_Vi] = ?\n"
                + "      ,[Id_DM] = ?\n"
                + "      ,[Id_Size] = ?\n"
                + " WHERE [Ma] = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sanPham.getTen());
            ps.setString(2, sanPham.getDonGia());
            ps.setInt(3, sanPham.getTrangThai());
            ps.setInt(4, sanPham.getId_Vi());
            ps.setInt(5, sanPham.getId_DanhMuc());
            ps.setInt(6, sanPham.getId_size());
            ps.setString(7, sanPham.getMa());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(SanPhamRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteSanPham(SanPham sanPham) {
        String sql = "DELETE FROM [dbo].[SanPham]\n"
                + "      WHERE Ma= ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sanPham.getMa());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(SanPhamRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
