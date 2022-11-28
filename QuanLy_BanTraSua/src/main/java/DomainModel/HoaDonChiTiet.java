
package DomainModel;


public class HoaDonChiTiet {
    private int id;
    private HoaDon Id_HD;
    private SanPham Id_SP;
    private int SL_Mua;
    private double DonGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int id, HoaDon Id_HD, SanPham Id_SP, int SL_Mua, double DonGia) {
        this.id = id;
        this.Id_HD = Id_HD;
        this.Id_SP = Id_SP;
        this.SL_Mua = SL_Mua;
        this.DonGia = DonGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HoaDon getId_HD() {
        return Id_HD;
    }

    public void setId_HD(HoaDon Id_HD) {
        this.Id_HD = Id_HD;
    }

    public SanPham getId_SP() {
        return Id_SP;
    }

    public void setId_SP(SanPham Id_SP) {
        this.Id_SP = Id_SP;
    }

    public int getSL_Mua() {
        return SL_Mua;
    }

    public void setSL_Mua(int SL_Mua) {
        this.SL_Mua = SL_Mua;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "id=" + id + ", Id_HD=" + Id_HD + ", Id_SP=" + Id_SP + ", SL_Mua=" + SL_Mua + ", DonGia=" + DonGia + '}';
    }

   
    
}
