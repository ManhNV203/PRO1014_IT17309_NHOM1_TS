
package DomainModel;

import java.math.BigDecimal;

public class KhuyenMai {
    private String Id ;
    private String Ma;
    private  BigDecimal  SoTienGiam;
    private String ngayBatDau;
    private String ngayketThuc ;
    private String dieukien;

    public KhuyenMai() {
    }

    public KhuyenMai(String Id, String Ma, BigDecimal SoTienGiam, String ngayBatDau, String ngayketThuc, String dieukien) {
        this.Id = Id;
        this.Ma = Ma;
        this.SoTienGiam = SoTienGiam;
        this.ngayBatDau = ngayBatDau;
        this.ngayketThuc = ngayketThuc;
        this.dieukien = dieukien;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public BigDecimal getSoTienGiam() {
        return SoTienGiam;
    }

    public void setSoTienGiam(BigDecimal SoTienGiam) {
        this.SoTienGiam = SoTienGiam;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayketThuc() {
        return ngayketThuc;
    }

    public void setNgayketThuc(String ngayketThuc) {
        this.ngayketThuc = ngayketThuc;
    }

    public String getDieukien() {
        return dieukien;
    }

    public void setDieukien(String dieukien) {
        this.dieukien = dieukien;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "Id=" + Id + ", Ma=" + Ma + ", SoTienGiam=" + SoTienGiam + ", ngayBatDau=" + ngayBatDau + ", ngayketThuc=" + ngayketThuc + ", dieukien=" + dieukien + '}';
    }
}
