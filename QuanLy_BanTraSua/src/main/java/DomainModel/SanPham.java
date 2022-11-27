
package DomainModel;


public class SanPham {
    private Integer id;
    private String ma;
    private String ten;
    private String donGia;
    private Integer trangThai;
    private Vi id_Vi;
    private DanhMuc id_DanhMuc;
    private Size id_size;

    public SanPham() {
    }

    public SanPham(Integer id, String ma, String ten, String donGia, Integer trangThai, Vi id_Vi, DanhMuc id_DanhMuc, Size id_size) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.donGia = donGia;
        this.trangThai = trangThai;
        this.id_Vi = id_Vi;
        this.id_DanhMuc = id_DanhMuc;
        this.id_size = id_size;
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

    public Vi getId_Vi() {
        return id_Vi;
    }

    public void setId_Vi(Vi id_Vi) {
        this.id_Vi = id_Vi;
    }

    public DanhMuc getId_DanhMuc() {
        return id_DanhMuc;
    }

    public void setId_DanhMuc(DanhMuc id_DanhMuc) {
        this.id_DanhMuc = id_DanhMuc;
    }

    public Size getId_size() {
        return id_size;
    }

    public void setId_size(Size id_size) {
        this.id_size = id_size;
    }

    @Override
    public String toString() {
        return "SanPham{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", donGia=" + donGia + ", trangThai=" + trangThai + ", id_Vi=" + id_Vi + ", id_DanhMuc=" + id_DanhMuc + ", id_size=" + id_size + '}';
    }

    
    

    
}
