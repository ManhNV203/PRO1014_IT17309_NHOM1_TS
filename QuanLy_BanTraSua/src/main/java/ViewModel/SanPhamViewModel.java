
package ViewModel;


public class SanPhamViewModel {
    private Integer id;
    private String  ma;
    private String  ten;
    private String donGia;
    private String trangThai;
    private String tenVi;
    private String tenDM;
    private String tenSize;

    public SanPhamViewModel() {
    }

    public SanPhamViewModel(Integer id, String ma, String ten, String donGia, String trangThai, String tenVi, String tenDM, String tenSize) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.donGia = donGia;
        this.trangThai = trangThai;
        this.tenVi = tenVi;
        this.tenDM = tenDM;
        this.tenSize = tenSize;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenVi() {
        return tenVi;
    }

    public void setTenVi(String tenVi) {
        this.tenVi = tenVi;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    @Override
    public String toString() {
        return "SanPhamViewModel{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", donGia=" + donGia + ", trangThai=" + trangThai + ", tenVi=" + tenVi + ", tenDM=" + tenDM + ", tenSize=" + tenSize + '}';
    }

    
    
}
