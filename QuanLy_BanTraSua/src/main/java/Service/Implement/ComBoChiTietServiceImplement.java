
package Service.Implement;

import DomainModel.ComBoChiTiet;
import RepositoryJDBC.Implement.ComBoChiTietRepositoryImplement;
import RepositoryJDBC.Interface.ComBoChiTietRepositoryInterface;
import Service.Interface.ComBoChiTietServiceInterface;
import ViewModel.ComBoChiTietViewModel;
import java.util.ArrayList;
import java.util.List;


public class ComBoChiTietServiceImplement implements ComBoChiTietServiceInterface{
    private ComBoChiTietRepositoryInterface comBoChiTietRepositoryInterface;
    public ComBoChiTietServiceImplement(){
        comBoChiTietRepositoryInterface = new ComBoChiTietRepositoryImplement();
    }

    @Override
    public List<ComBoChiTietViewModel> getAllComBo() {
        return comBoChiTietRepositoryInterface.getAllComBo();
        
    }

    @Override
    public void addComBo(ComBoChiTiet comBoChiTiet) {
        comBoChiTietRepositoryInterface.addComBo(comBoChiTiet);
    }

    @Override
    public void updateComBo(ComBoChiTiet comBoChiTiet) {
        comBoChiTietRepositoryInterface.updateComBo(comBoChiTiet);
    }

    @Override
    public void deleteComBo(ComBoChiTiet comBoChiTiet) {
        comBoChiTietRepositoryInterface.deleteComBo(comBoChiTiet);
    }
    
}
