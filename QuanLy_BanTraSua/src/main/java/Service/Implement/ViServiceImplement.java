
package Service.Implement;

import DomainModel.Vi;
import RepositoryJDBC.Implement.ViRepositoryImplement;
import RepositoryJDBC.Interface.ViRepositoryInterface;
import Service.Interface.ViServiceInterface;
import java.util.List;


public class ViServiceImplement implements ViServiceInterface{
    private ViRepositoryInterface viRepositoryInterface;
    public ViServiceImplement(){
        viRepositoryInterface = new ViRepositoryImplement();
    }

    @Override
    public List<Vi> getAllVi() {
        return viRepositoryInterface.getAllVi();
    }

    @Override
    public void addVi(Vi vi) {
        viRepositoryInterface.addVi(vi);
    }

    @Override
    public void updateVi(Vi vi) {
        viRepositoryInterface.updateVi(vi);
    }

    @Override
    public void deleteVi(Vi vi) {
        viRepositoryInterface.deleteVi(vi);
    }
}
