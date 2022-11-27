
package RepositoryJDBC.Interface;

import DomainModel.ComBo;
import java.util.List;


public interface ComBoRepositoryInterface {
    public List<ComBo> getallCombo();
    public void addComBo(ComBo comBo);
    public void updateComBo(ComBo comBo);
}
