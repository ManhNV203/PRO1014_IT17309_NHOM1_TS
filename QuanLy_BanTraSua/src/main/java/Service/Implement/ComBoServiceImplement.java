
package Service.Implement;

import DomainModel.ComBo;
import RepositoryJDBC.Implement.ComBoRepositoryImplement;
import RepositoryJDBC.Interface.ComBoRepositoryInterface;
import Service.Interface.ComBoServiceInterface;
import java.util.List;


public class ComBoServiceImplement implements ComBoServiceInterface{
    private ComBoRepositoryInterface comBoRepositoryInterface;
    public ComBoServiceImplement(){
        comBoRepositoryInterface = new ComBoRepositoryImplement();
    }
    @Override
    public List<ComBo> getallCombo() {
        return comBoRepositoryInterface.getallCombo();
    }

    @Override
    public void addComBo(ComBo comBo) {
        comBoRepositoryInterface.addComBo(comBo);
    }

    @Override
    public void updateComBo(ComBo comBo) {
        comBoRepositoryInterface.updateComBo(comBo);
    }

}
