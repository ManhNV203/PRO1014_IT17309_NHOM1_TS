
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
}
