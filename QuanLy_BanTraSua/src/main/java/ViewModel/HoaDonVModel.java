/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import DomainModel.KhachHang;
import DomainModel.KhuyenMai;
import DomainModel.NhanVien;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonVModel {
    private String id;
    private String Ma;
    private String Ma_nv;
    private String Ten_nv;
    private Date ngayTao;
    private BigDecimal TongTien;
    private String TenKh;
    private String makm;
    private int TrangThai;
    public HoaDonVModel() {
    }

    public HoaDonVModel(String id, String Ma, String Ma_nv, String Ten_nv, Date ngayTao, BigDecimal TongTien, String TenKh, String makm, int TrangThai) {
        this.id = id;
        this.Ma = Ma;
        this.Ma_nv = Ma_nv;
        this.Ten_nv = Ten_nv;
        this.ngayTao = ngayTao;
        this.TongTien = TongTien;
        this.TenKh = TenKh;
        this.makm = makm;
        this.TrangThai = TrangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getMa_nv() {
        return Ma_nv;
    }

    public void setMa_nv(String Ma_nv) {
        this.Ma_nv = Ma_nv;
    }

    public String getTen_nv() {
        return Ten_nv;
    }

    public void setTen_nv(String Ten_nv) {
        this.Ten_nv = Ten_nv;
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

    public String getTenKh() {
        return TenKh;
    }

    public void setTenKh(String TenKh) {
        this.TenKh = TenKh;
    }

    public String getMakm() {
        return makm;
    }

    public void setMakm(String makm) {
        this.makm = makm;
    }

    
    public String getTrangThai() {
        if (TrangThai==0) {
            return "Chưa Thanh Toán";
        }else if(TrangThai==1){
            return "Đã Hủy";
        }else{
            return "Đã Thanh Toán";
        }
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "HoaDonVModel{" + "id=" + id + ", Ma=" + Ma + ", Ma_nv=" + Ma_nv + ", Ten_nv=" + Ten_nv + ", ngayTao=" + ngayTao + ", TongTien=" + TongTien + ", TenKh=" + TenKh + ", makm=" + makm + ", TrangThai=" + TrangThai + '}';
    }

    

    

   

    

    
    

 
    
    
}
