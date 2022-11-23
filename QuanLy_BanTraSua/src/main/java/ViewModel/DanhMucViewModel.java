
package ViewModel;


public class DanhMucViewModel {
    private Integer id;
    private String ma;
    private String ten;

    public DanhMucViewModel() {
    }

    public DanhMucViewModel(Integer id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return "DanhMucViewModel{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + '}';
    }
    
}
