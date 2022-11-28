package RepositoryJDBC.Implement;

import DomainModel.ComBoChiTiet;
import RepositoryJDBC.Interface.ComBoChiTietRepositoryInterface;
import Utility.DBContext;
import ViewModel.ComBoChiTietViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComBoChiTietRepositoryImplement implements ComBoChiTietRepositoryInterface {

    private Connection connection;

    public ComBoChiTietRepositoryImplement() {
        connection = DBContext.getConnection();
    }

    @Override
    public List<ComBoChiTietViewModel> getAllComBo() {
        List<ComBoChiTietViewModel> listAllCBCT = new ArrayList<>();
        String sql = "SELECT dbo.ComBo.Ma, dbo.SanPham.Ma AS Expr1, dbo.SanPham.Ten, dbo.SanPham.DonGia\n"
                + "FROM     dbo.ComBo INNER JOIN\n"
                + "                  dbo.ComBoChiTiet ON dbo.ComBo.Id = dbo.ComBoChiTiet.Id_ComBo INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ComBoChiTiet.Id_SP = dbo.SanPham.Id";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ComBoChiTietViewModel comBoChiTietViewModel = new ComBoChiTietViewModel();
                comBoChiTietViewModel.setMa_CB(rs.getString(1));
                comBoChiTietViewModel.setMa_SP(rs.getString(2));
                comBoChiTietViewModel.setTen_SP(rs.getString(3));
                comBoChiTietViewModel.setDonGia(rs.getString(4));
                listAllCBCT.add(comBoChiTietViewModel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComBoChiTietRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAllCBCT;
    }

    @Override
    public void addComBo(ComBoChiTiet comBoChiTiet) {
        String sql = "INSERT INTO [dbo].[ComBoChiTiet]\n"
                + "           ([Id_ComBo]\n"
                + "           ,[Id_SP])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, comBoChiTiet.getId_CB());
            ps.setInt(2, comBoChiTiet.getId_SP());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ComBoChiTietRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateComBo(ComBoChiTiet comBoChiTiet) {
        String sql = "UPDATE [dbo].[ComBoChiTiet]\n"
                + "   SET [Id_SP] = ?\n"
                + " WHERE [Id_ComBo] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, comBoChiTiet.getId_CB());
            ps.setInt(2, comBoChiTiet.getId_SP());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ComBoChiTietRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteComBo(ComBoChiTiet comBoChiTiet) {
        String sql = "DELETE FROM [dbo].[ComBoChiTiet]\n"
                + "      WHERE Id_ComBo= ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, comBoChiTiet.getId_CB());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ComBoChiTietRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
