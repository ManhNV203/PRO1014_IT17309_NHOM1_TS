
package DomainModel;

import java.math.BigDecimal;
import java.util.Date;

public class KhuyenMai {
    private String Id ;
    private String Ma;
    private  double SoTienGiam;
    private Date ngayBatDau;
    private Date ngayketThuc ;
    private String dieukien;

    public KhuyenMai() {
    }

    public KhuyenMai(String Id, String Ma, double SoTienGiam, Date ngayBatDau, Date ngayketThuc, String dieukien) {
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

    public double getSoTienGiam() {
        return SoTienGiam;
    }

    public void setSoTienGiam(double SoTienGiam) {
        this.SoTienGiam = SoTienGiam;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayketThuc() {
        return ngayketThuc;
    }

    public void setNgayketThuc(Date ngayketThuc) {
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
