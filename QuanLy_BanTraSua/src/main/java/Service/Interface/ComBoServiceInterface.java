
package Service.Interface;

import DomainModel.ComBo;
import java.util.List;


public interface ComBoServiceInterface {
    public List<ComBo> getallCombo();
    public void addComBo(ComBo comBo);
    public void updateComBo(ComBo comBo);
}
