package RepositoryJDBC.Implement;

import DomainModel.Vi;
import RepositoryJDBC.Interface.ViRepositoryInterface;
import Utility.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViRepositoryImplement implements ViRepositoryInterface {

    private Connection connection;

    public ViRepositoryImplement() {
        connection = DBContext.getConnection();
    }

    @Override
    public List<Vi> getAllVi() {
        List<Vi> listVi = new ArrayList<>();
        String sql = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "  FROM [dbo].[Vi]";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vi vi = new Vi();
                vi.setId(rs.getInt("Id"));
                vi.setMa(rs.getString("Ma"));
                vi.setTen(rs.getString("Ten"));
                listVi.add(vi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listVi;
    }

    @Override
    public void addVi(Vi vi) {
        String sql = "INSERT INTO [dbo].[Vi]\n"
                + "           ([Ma]\n"
                + "           ,[Ten])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, vi.getMa());
            ps.setString(2, vi.getTen());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ViRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateVi(Vi vi) {
        String sql = "UPDATE [dbo].[Vi]\n"
                + "   SET [Ten] = ?\n"
                + " WHERE [Ma] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(2, vi.getMa());
            ps.setString(1, vi.getTen());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ViRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteVi(Vi vi) {
        String sql = "DELETE FROM [dbo].[Vi]\n"
                + "      WHERE Ma=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, vi.getMa());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ViRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
