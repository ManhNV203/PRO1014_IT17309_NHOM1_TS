
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
    
}
