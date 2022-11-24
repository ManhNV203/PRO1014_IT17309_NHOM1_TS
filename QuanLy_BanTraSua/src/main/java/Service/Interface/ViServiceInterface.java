
package Service.Interface;

import DomainModel.Vi;
import java.util.List;


public interface ViServiceInterface {
    public List<Vi> getAllVi();
    public void addVi(Vi vi);
    public void updateVi(Vi vi);
    public void deleteVi(Vi vi);
}
