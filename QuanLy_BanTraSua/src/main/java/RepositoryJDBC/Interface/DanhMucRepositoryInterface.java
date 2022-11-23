
package RepositoryJDBC.Interface;

import DomainModel.DanhMuc;
import java.util.List;


public interface DanhMucRepositoryInterface {
    public List<DanhMuc> getListAllDM();
    public void addDM(DanhMuc danhMuc);
    public void updateDM(DanhMuc danhMuc);
    public void deleteDM(DanhMuc danhMuc);
}
