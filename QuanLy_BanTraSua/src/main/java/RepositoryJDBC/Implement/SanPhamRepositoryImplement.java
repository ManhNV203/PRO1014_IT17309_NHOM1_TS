package RepositoryJDBC.Implement;

import DomainModel.DanhMuc;
import DomainModel.SanPham;
import DomainModel.Size;
import DomainModel.Vi;
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
                Vi v = new Vi();
                v.setId(rs.getInt(6));
                DanhMuc dm = new DanhMuc();
                dm.setId(rs.getInt(7));
                Size s = new Size();
                s.setId(rs.getInt(8));
                SanPham sp = new SanPham();
                sp.setId(rs.getInt(1));
                sp.setMa(rs.getString(2));
                sp.setTen(rs.getString(3));
                sp.setDonGia(rs.getString(4));
                sp.setTrangThai(rs.getInt(5));
                sp.setId_Vi(v);
                sp.setId_DanhMuc(dm);
                sp.setId_size(s);
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
            Integer idvi=null;
            if (sanPham.getId_Vi()!=null) {
                idvi = sanPham.getId_Vi().getId();
            }
            ps.setString(1, sanPham.getMa());
            ps.setString(2, sanPham.getTen());
            ps.setString(3, sanPham.getDonGia());
            ps.setInt(4, sanPham.getTrangThai());
            ps.setObject(5, idvi);
            ps.setObject(6, sanPham.getId_DanhMuc());
            ps.setObject(7, sanPham.getId_size());

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
            ps.setObject(4, sanPham.getId_Vi());
            ps.setObject(5, sanPham.getId_DanhMuc());
            ps.setObject(6, sanPham.getId_size());
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

    @Override
    public List<SanPham> locDanhmuc(Integer id) {
 
        String sql = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[DonGia]\n"
                + "      ,[TrangThai]\n"
                + "      ,[Id_Vi]\n"
                + "      ,[Id_DM]\n"
                + "      ,[Id_Size]\n"
                + "  FROM [dbo].[SanPham] \n"
                + "  where [Id_DM] = ?  ";

        List<SanPham> list_sp = new ArrayList<>();
        try {
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
               Vi v = new Vi();
                v.setId(rs.getInt(6));
                DanhMuc dm = new DanhMuc();
                dm.setId(rs.getInt(7));
                Size s = new Size();
                s.setId(rs.getInt(8));
                SanPham sp = new SanPham();
                sp.setId(rs.getInt(1));
                sp.setMa(rs.getString(2));
                sp.setTen(rs.getString(3));
                sp.setDonGia(rs.getString(4));
                sp.setTrangThai(rs.getInt(5));
                sp.setId_Vi(v);
                sp.setId_DanhMuc(dm);
                sp.setId_size(s);
                list_sp.add(sp);
            }

        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_sp;

    }

    @Override
    public List<SanPham> locVi(Integer id) {
 String sql = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[DonGia]\n"
                + "      ,[TrangThai]\n"
                + "      ,[Id_Vi]\n"
                + "      ,[Id_DM]\n"
                + "      ,[Id_Size]\n"
                + "  FROM [dbo].[SanPham] \n"
                + "  where [Id_Vi] = ?  ";

        List<SanPham> list_sp = new ArrayList<>();
        try {
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
             while (rs.next()) {
                 Vi v = new Vi();
                v.setId(rs.getInt(6));
                DanhMuc dm = new DanhMuc();
                dm.setId(rs.getInt(7));
                Size s = new Size();
                s.setId(rs.getInt(8));
                SanPham sp = new SanPham();
                sp.setId(rs.getInt(1));
                sp.setMa(rs.getString(2));
                sp.setTen(rs.getString(3));
                sp.setDonGia(rs.getString(4));
                sp.setTrangThai(rs.getInt(5));
                sp.setId_Vi(v);
                sp.setId_DanhMuc(dm);
                sp.setId_size(s);
                list_sp.add(sp);
            }

        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_sp;


    }


}
