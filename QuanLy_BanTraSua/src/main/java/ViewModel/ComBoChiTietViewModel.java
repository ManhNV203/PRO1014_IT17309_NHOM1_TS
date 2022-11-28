
package ViewModel;


public class ComBoChiTietViewModel {
    private String ma_CB;
    private String ma_SP;
    private String ten_SP;
    private String DonGia;
    private Integer soLuong;

    public ComBoChiTietViewModel() {
    }

    public String getMa_CB() {
        return ma_CB;
    }

    public void setMa_CB(String ma_CB) {
        this.ma_CB = ma_CB;
    }

    public ComBoChiTietViewModel(String ma_CB) {
        this.ma_CB = ma_CB;
    }

    public ComBoChiTietViewModel(String ma_SP, String ten_SP, String DonGia, Integer soLuong) {
        this.ma_SP = ma_SP;
        this.ten_SP = ten_SP;
        this.DonGia = DonGia;
        this.soLuong = soLuong;
    }

    public String getMa_SP() {
        return ma_SP;
    }

    public void setMa_SP(String ma_SP) {
        this.ma_SP = ma_SP;
    }

    public String getTen_SP() {
        return ten_SP;
    }

    public void setTen_SP(String ten_SP) {
        this.ten_SP = ten_SP;
    }

    public String getDonGia() {
        return DonGia;
    }

    public void setDonGia(String DonGia) {
        this.DonGia = DonGia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "ComBoChiTietViewModel{" + "ma_SP=" + ma_SP + ", ten_SP=" + ten_SP + ", DonGia=" + DonGia + ", soLuong=" + soLuong + '}';
    }
    
}
