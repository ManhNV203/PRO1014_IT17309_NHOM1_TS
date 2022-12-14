
package DomainModel;

import java.util.Date;


public class NhanVien {
    private int ID;
    private String ma;
    private String hoTen;
    private String matKhau;
    private Date ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String email;
    private String SDT;
    

    public NhanVien() {
    }

    public NhanVien(int ID, String ma, String hoTen, String matKhau, Date ngaySinh, String gioiTinh, String diaChi, String email,String SDT) {
        this.ID = ID;
        this.ma = ma;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.email = email;
        this.SDT = SDT;

    }

    public int getID() {
        return ID;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getSDT() {
        return SDT;
    }

    public String getMa() {
        return ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getEmail() {
        return email;
    }

    

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "ID=" + ID + ", ma=" + ma + ", hoTen=" + hoTen + ", matKhau=" + matKhau + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", email=" + email + ", SDT=" + SDT + '}';
    }

    
    
    
    
}
