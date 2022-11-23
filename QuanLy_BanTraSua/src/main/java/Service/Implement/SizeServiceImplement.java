
package Service.Implement;

import DomainModel.Size;
import RepositoryJDBC.Implement.SizeRepositoryImplement;
import RepositoryJDBC.Interface.SizeRepositoryInterface;
import Service.Interface.SizeServiceInterface;
import java.util.List;


public class SizeServiceImplement implements SizeServiceInterface{
    private SizeRepositoryInterface sizeRepositoryInterface;
    public SizeServiceImplement (){
        sizeRepositoryInterface = new SizeRepositoryImplement();
    }

    @Override
    public List<Size> getAllSize() {
        return sizeRepositoryInterface.getAllSize();
    }
}
