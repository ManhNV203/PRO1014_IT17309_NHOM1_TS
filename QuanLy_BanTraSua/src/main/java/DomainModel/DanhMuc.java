package DomainModel;

public class DanhMuc {

    private Integer id;
    private String ma;
    private String tenDM;

    public DanhMuc() {
    }

    public DanhMuc(Integer id, String ma, String tenDM) {
        this.id = id;
        this.ma = ma;
        this.tenDM = tenDM;
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

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    @Override
    public String toString() {
        return "DanhMuc{" + "id=" + id + ", ma=" + ma + ", tenDM=" + tenDM + '}';
    }

}
