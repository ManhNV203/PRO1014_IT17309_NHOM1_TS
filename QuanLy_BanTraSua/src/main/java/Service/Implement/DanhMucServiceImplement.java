
package Service.Implement;

import DomainModel.DanhMuc;
import RepositoryJDBC.Implement.DanhMucRepositoryImplement;
import RepositoryJDBC.Interface.DanhMucRepositoryInterface;
import Service.Interface.DanhMucServiceInterface;
import java.util.List;


public class DanhMucServiceImplement implements DanhMucServiceInterface{
    private DanhMucRepositoryInterface danhMucRepositoryInterface;
    public DanhMucServiceImplement(){
        danhMucRepositoryInterface = new DanhMucRepositoryImplement();
    }
    @Override
    public List<DanhMuc> getallDM() {
        return danhMucRepositoryInterface.getListAllDM();
    }

    @Override
    public void addDanhMuc(DanhMuc danhMuc) {
        danhMucRepositoryInterface.addDM(danhMuc);
    }

    @Override
    public void updateDanhMuc(DanhMuc danhMuc) {
        danhMucRepositoryInterface.updateDM(danhMuc);
    }

    @Override
    public void deleteDanhMuc(DanhMuc danhMuc) {
        danhMucRepositoryInterface.deleteDM(danhMuc);
    }
    
}
