
package DomainModel;


public class NhanVien {
    private String Id;
    private String Ma;
    private String HoTen;
    private String MatKhau;
    private String NgaySinh;
    private boolean GioiTinh;
    private String DiaChi;
    private String Email;
    private String SDT;
    private String Id_cv;

    public NhanVien() {
    }

    public NhanVien(String Id, String Ma, String HoTen, String MatKhau, String NgaySinh, boolean GioiTinh, String DiaChi, String Email, String SDT, String Id_cv) {
        this.Id = Id;
        this.Ma = Ma;
        this.HoTen = HoTen;
        this.MatKhau = MatKhau;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.SDT = SDT;
        this.Id_cv = Id_cv;
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

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getId_cv() {
        return Id_cv;
    }

    public void setId_cv(String Id_cv) {
        this.Id_cv = Id_cv;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "Id=" + Id + ", Ma=" + Ma + ", HoTen=" + HoTen + ", MatKhau=" + MatKhau + ", NgaySinh=" + NgaySinh + ", GioiTinh=" + GioiTinh + ", DiaChi=" + DiaChi + ", Email=" + Email + ", SDT=" + SDT + ", Id_cv=" + Id_cv + '}';
    }
    
}
