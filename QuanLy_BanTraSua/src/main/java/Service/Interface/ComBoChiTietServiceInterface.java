package Service.Interface;

import DomainModel.ComBoChiTiet;
import ViewModel.ComBoChiTietViewModel;
import java.util.List;

public interface ComBoChiTietServiceInterface {

    public List<ComBoChiTietViewModel> getAllComBo();

    public void addComBo(ComBoChiTiet comBoChiTiet);

    public void updateComBo(ComBoChiTiet comBoChiTiet);

    public void deleteComBo(ComBoChiTiet comBoChiTiet);
}
