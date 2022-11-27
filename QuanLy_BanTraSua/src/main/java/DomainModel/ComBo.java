package DomainModel;

public class ComBo {

    private Integer id;
    private String ma;
    private String ten;
    private String donGia;
    private Integer trangThai;

    public ComBo() {
    }

    public ComBo(Integer id, String ma, String ten, String donGia, Integer trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.donGia = donGia;
        this.trangThai = trangThai;
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

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "ComBo{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", donGia=" + donGia + ", trangThai=" + trangThai + '}';
    }

}
