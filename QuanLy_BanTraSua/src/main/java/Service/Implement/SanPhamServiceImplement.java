
package Service.Implement;

import DomainModel.DanhMuc;
import DomainModel.SanPham;
import DomainModel.Size;
import DomainModel.Vi;
import RepositoryJDBC.Implement.DanhMucRepositoryImplement;
import RepositoryJDBC.Implement.SanPhamRepositoryImplement;
import RepositoryJDBC.Implement.SizeRepositoryImplement;
import RepositoryJDBC.Implement.ViRepositoryImplement;
import RepositoryJDBC.Interface.DanhMucRepositoryInterface;
import RepositoryJDBC.Interface.SanPhamRepositoryInterface;
import RepositoryJDBC.Interface.SizeRepositoryInterface;
import RepositoryJDBC.Interface.ViRepositoryInterface;
import Service.Interface.SanPhamServiceInterface;
import ViewModel.SanPhamViewModel;
import java.util.ArrayList;
import java.util.List;


public class SanPhamServiceImplement implements SanPhamServiceInterface{
    private SanPhamRepositoryInterface sanPhamRepositoryInterface;
    private ViRepositoryInterface viRepositoryInterface;
    private DanhMucRepositoryInterface danhMucRepositoryInterface;
    private SizeRepositoryInterface sizeRepositoryInterface;
    public SanPhamServiceImplement(){
        sanPhamRepositoryInterface = new SanPhamRepositoryImplement();
        viRepositoryInterface = new ViRepositoryImplement();
        danhMucRepositoryInterface = new DanhMucRepositoryImplement();
        sizeRepositoryInterface = new SizeRepositoryImplement();
    }

    @Override
    public List<SanPhamViewModel> getAllSP() {
        List<SanPham> listSanPham = sanPhamRepositoryInterface.getAllSanPham();
        List<SanPhamViewModel> listSanPhamVModel = new ArrayList<>();
        List<DanhMuc> listDanhMuc = danhMucRepositoryInterface.getListAllDM();
        List<Size> listSize = sizeRepositoryInterface.getAllSize();
        List<Vi> listVI = viRepositoryInterface.getAllVi();
        for (SanPham sanPham : listSanPham) {
            SanPhamViewModel spview = new SanPhamViewModel();
            spview.setId(sanPham.getId());
            spview.setMa(sanPham.getMa());
            spview.setTen(sanPham.getTen());
            spview.setDonGia(sanPham.getDonGia());
            Integer idVi = sanPham.getId_Vi().getId();
            for (Vi vi : listVI) {
                if(vi.getId().equals(idVi)){
                    spview.setTenVi(vi.getTen());
                }
            }
            Integer iddm= sanPham.getId_DanhMuc().getId();
            for (DanhMuc danhMuc : listDanhMuc) {
                if(danhMuc.getId().equals(iddm)){
                    spview.setTenDM(danhMuc.getTenDM());
                }
            }
            Integer idsize = sanPham.getId_size().getId();
            for (Size size : listSize) {
                if(size.getId().equals(idsize)){
                    spview.setTenSize(size.getTheTich());
                }
            }
            if(sanPham.getTrangThai()==0){
                spview.setTrangThai("Hết Hàng");
            }else{
                spview.setTrangThai("Còn Hàng");
            }
            listSanPhamVModel.add(spview);
            
        }
        return listSanPhamVModel;
    }

    @Override
    public void addSanPham(SanPham sanPham) {
        sanPhamRepositoryInterface.addSanPham(sanPham);
    }

    @Override
    public void updateSanPham(SanPham sanPham) {
        sanPhamRepositoryInterface.updateSanPham(sanPham);
    }

    @Override
    public void deleteSanPham(SanPham sanPham) {
        sanPhamRepositoryInterface.deleteSanPham(sanPham);
    }
    public static void main(String[] args) {
        SanPhamRepositoryImplement sp = new SanPhamRepositoryImplement();
        System.out.println(sp.getAllSanPham());
    }

}
