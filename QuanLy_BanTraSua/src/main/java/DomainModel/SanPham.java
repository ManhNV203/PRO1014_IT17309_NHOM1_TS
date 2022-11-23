
package DomainModel;


public class SanPham {
    private String id;
    private String ma;
    private String ten;
    private String donGia;
    private Integer trangThai;
    private String vi;
    private String id_DanhMuc;
    private String id_size;
    private String id_NguyenLieu;

    public SanPham() {
    }

    public SanPham(String id, String ma, String ten, String donGia, Integer trangThai, String vi, String id_DanhMuc, String id_size, String id_NguyenLieu) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.donGia = donGia;
        this.trangThai = trangThai;
        this.vi = vi;
        this.id_DanhMuc = id_DanhMuc;
        this.id_size = id_size;
        this.id_NguyenLieu = id_NguyenLieu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getVi() {
        return vi;
    }

    public void setVi(String vi) {
        this.vi = vi;
    }

    public String getId_DanhMuc() {
        return id_DanhMuc;
    }

    public void setId_DanhMuc(String id_DanhMuc) {
        this.id_DanhMuc = id_DanhMuc;
    }

    public String getId_size() {
        return id_size;
    }

    public void setId_size(String id_size) {
        this.id_size = id_size;
    }

    public String getId_NguyenLieu() {
        return id_NguyenLieu;
    }

    public void setId_NguyenLieu(String id_NguyenLieu) {
        this.id_NguyenLieu = id_NguyenLieu;
    }

    @Override
    public String toString() {
        return "SanPham{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", donGia=" + donGia + ", trangThai=" + trangThai + ", vi=" + vi + ", id_DanhMuc=" + id_DanhMuc + ", id_size=" + id_size + ", id_NguyenLieu=" + id_NguyenLieu + '}';
    }
}
