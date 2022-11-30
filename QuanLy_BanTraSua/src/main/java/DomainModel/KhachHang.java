package DomainModel;

public class KhachHang {

    private String ID;
    private String Ma;
    private String HoTen;
    private String GioiTinh;
    private String DiaChi;
    private String SDT;
    private String MoTa;

    public KhachHang() {
    }

    public KhachHang(String ID, String Ma, String HoTen, String GioiTinh, String DiaChi, String SDT, String MoTa) {
        this.ID = ID;
        this.Ma = Ma;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.MoTa = MoTa;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "ID=" + ID + ", Ma=" + Ma + ", HoTen=" + HoTen + ", GioiTinh=" + GioiTinh + ", DiaChi=" + DiaChi + ", SDT=" + SDT + ", MoTa=" + MoTa + '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }


}
