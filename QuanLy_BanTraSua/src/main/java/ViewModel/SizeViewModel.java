
package ViewModel;


public class SizeViewModel {
    private Integer id;
    private String ma;
    private String theTich;

    public SizeViewModel() {
    }

    public SizeViewModel(Integer id, String ma, String theTich) {
        this.id = id;
        this.ma = ma;
        this.theTich = theTich;
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

    public String getTheTich() {
        return theTich;
    }

    public void setTheTich(String theTich) {
        this.theTich = theTich;
    }

    @Override
    public String toString() {
        return "SizeViewModel{" + "id=" + id + ", ma=" + ma + ", theTich=" + theTich + '}';
    }

    
    
}
