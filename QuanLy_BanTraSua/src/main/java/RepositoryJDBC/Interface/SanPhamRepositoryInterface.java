
package RepositoryJDBC.Interface;

import DomainModel.SanPham;
import java.util.List;


public interface SanPhamRepositoryInterface {
    public List<SanPham> getAllSanPham();
    public void addSanPham(SanPham sanPham);
    public void updateSanPham(SanPham sanPham);
    public void deleteSanPham(SanPham sanPham);
    
    public List<SanPham> LocDanhMucSP(Integer id);
    public List<SanPham> LocVISp(Integer id);
    
}
