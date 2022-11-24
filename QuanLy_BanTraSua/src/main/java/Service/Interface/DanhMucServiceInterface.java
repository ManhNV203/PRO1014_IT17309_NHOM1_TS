
package Service.Interface;

import DomainModel.DanhMuc;
import java.util.List;


public interface DanhMucServiceInterface {
    public List<DanhMuc> getallDM();
    public void addDanhMuc(DanhMuc danhMuc);
    public void updateDanhMuc(DanhMuc danhMuc);
    public void deleteDanhMuc(DanhMuc danhMuc);
}
