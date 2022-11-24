
package Service.Interface;

import DomainModel.Size;
import java.util.List;


public interface SizeServiceInterface {
    public List<Size> getAllSize();
    public void addSize(Size size);
    public void updateSize(Size size);
    public void deleteSize(Size size);
}
