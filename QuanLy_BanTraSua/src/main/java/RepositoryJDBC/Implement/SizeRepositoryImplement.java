package RepositoryJDBC.Implement;

import DomainModel.Size;
import RepositoryJDBC.Interface.SizeRepositoryInterface;
import Utility.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SizeRepositoryImplement implements SizeRepositoryInterface {

    private Connection connection;

    public SizeRepositoryImplement() {
        connection = DBContext.getConnection();
    }

    @Override
    public List<Size> getAllSize() {
        List<Size> listSize = new ArrayList<>();
        String sql = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[TheTich]\n"
                + "  FROM [dbo].[Size]";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Size sz = new Size();
                sz.setId(rs.getInt("Id"));
                sz.setMa(rs.getString("Ma"));
                sz.setTheTich(rs.getString("TheTich"));
                listSize.add(sz);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SizeRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSize;
    }

    @Override
    public void addSize(Size size) {
        String sql = "INSERT INTO [dbo].[Size]\n"
                + "           ([Ma]\n"
                + "           ,[TheTich])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, size.getMa());
            ps.setString(2, size.getTheTich());
            ps.execute();
        } catch (SQLException ex) {
            
            Logger.getLogger(SizeRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateSize(Size size) {
        String sql = "UPDATE [dbo].[Size]\n"
                + "   SET [TheTich] = ?\n"
                + " WHERE [Ma] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, size.getTheTich());
            ps.setString(2, size.getMa());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SizeRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteSize(Size size) {
        String sql = "DELETE FROM [dbo].[Size]\n"
                + "      WHERE Ma= ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, size.getMa());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SizeRepositoryImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
