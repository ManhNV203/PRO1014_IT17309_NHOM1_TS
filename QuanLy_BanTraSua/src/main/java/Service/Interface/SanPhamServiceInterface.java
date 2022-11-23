
package Service.Interface;

import DomainModel.SanPham;
import ViewModel.SanPhamViewModel;
import java.util.List;


public interface SanPhamServiceInterface {
    public List<SanPhamViewModel> getAllSP();
    public void addSanPham(SanPham sanPham);
    public void updateSanPham(SanPham sanPham);
    public void deleteSanPham(SanPham sanPham);
}
