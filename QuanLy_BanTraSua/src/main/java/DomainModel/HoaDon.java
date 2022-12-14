
package DomainModel;

import java.math.BigDecimal;
import java.util.Date;


public class HoaDon {
    private int id;
    private String Ma;
    private NhanVien Id_NV;
    private Date ngayTao;
    private BigDecimal TongTien;
    private KhachHang id_KH;
    private KhuyenMai id_KM;
    private int TrangThai;

    public HoaDon() {
    }

    public HoaDon(int id, String Ma, NhanVien Id_NV, Date ngayTao, BigDecimal TongTien, KhachHang id_KH, KhuyenMai id_KM, int TrangThai) {
        this.id = id;
        this.Ma = Ma;
        this.Id_NV = Id_NV;
        this.ngayTao = ngayTao;
        this.TongTien = TongTien;
        this.id_KH = id_KH;
        this.id_KM = id_KM;
        this.TrangThai = TrangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public NhanVien getId_NV() {
        return Id_NV;
    }

    public void setId_NV(NhanVien Id_NV) {
        this.Id_NV = Id_NV;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public BigDecimal getTongTien() {
        return TongTien;
    }

    public void setTongTien(BigDecimal TongTien) {
        this.TongTien = TongTien;
    }

    public KhachHang getId_KH() {
        return id_KH;
    }

    public void setId_KH(KhachHang id_KH) {
        this.id_KH = id_KH;
    }

    public KhuyenMai getId_KM() {
        return id_KM;
    }

    public void setId_KM(KhuyenMai id_KM) {
        this.id_KM = id_KM;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", Ma=" + Ma + ", Id_NV=" + Id_NV + ", ngayTao=" + ngayTao + ", TongTien=" + TongTien + ", id_KH=" + id_KH + ", id_KM=" + id_KM + ", TrangThai=" + TrangThai + '}';
    }

    
    
    
}
