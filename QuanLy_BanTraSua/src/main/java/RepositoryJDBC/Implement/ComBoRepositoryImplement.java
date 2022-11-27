package RepositoryJDBC.Implement;

import DomainModel.ComBo;
import RepositoryJDBC.Interface.ComBoRepositoryInterface;
import Utility.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComBoRepositoryImplement implements ComBoRepositoryInterface {

    private Connection connection;

    public ComBoRepositoryImplement() {
        this.connection = DBContext.getConnection();
    }

    @Override
    public List<ComBo> getallCombo() {
        List<ComBo> listAllCB = new ArrayList<>();
        String sql = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[DonGia]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[ComBo]";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ComBo comBo = new ComBo();
                comBo.setId(rs.getInt("Id"));
                comBo.setMa(rs.getString("Ma"));
                comBo.setTen(rs.getString("Ten"));
                comBo.setDonGia(rs.getString("DonGia"));
                comBo.setTrangThai(rs.getInt("TrangThai"));
                listAllCB.add(comBo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComBoRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAllCB;
    }


    @Override
    public void addComBo(ComBo comBo) {
        String sql = "INSERT INTO [dbo].[ComBo]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[DonGia]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,? )";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, comBo.getMa());
            ps.setString(2, comBo.getTen());
            ps.setString(3, comBo.getDonGia());
            ps.setInt(4, comBo.getTrangThai());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ComBoRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateComBo(ComBo comBo) {
        String sql = "UPDATE [dbo].[ComBo]\n"
                + "   SET [Ten] = ?\n"
                + "      ,[DonGia] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE [Ma] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, comBo.getMa());
            ps.setString(2, comBo.getTen());
            ps.setString(3, comBo.getDonGia());
            ps.setInt(4, comBo.getTrangThai());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ComBoRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
