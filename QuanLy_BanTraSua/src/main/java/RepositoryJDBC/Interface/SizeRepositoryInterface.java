
package RepositoryJDBC.Interface;

import DomainModel.Size;
import java.util.List;


public interface SizeRepositoryInterface {
    public List<Size> getAllSize();
    public void addSize(Size size);
    public void updateSize(Size size);
    public void deleteSize(Size size);
}
