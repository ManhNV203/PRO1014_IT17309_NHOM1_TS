/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import DomainModel.KhachHang;
import DomainModel.KhuyenMai;
import DomainModel.NhanVien;
import java.math.BigDecimal;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonVModel {
    
    private String Ma;
    private NhanVien Id_NV;
    private String ngayTao;
    private BigDecimal TongTien;
    private KhachHang id_KH;
    private KhuyenMai id_KM;
    private int TrangThai;

    public HoaDonVModel() {
    }

    public HoaDonVModel(String Ma, NhanVien Id_NV, String ngayTao, BigDecimal TongTien, KhachHang id_KH, KhuyenMai id_KM, int TrangThai) {
        this.Ma = Ma;
        this.Id_NV = Id_NV;
        this.ngayTao = ngayTao;
        this.TongTien = TongTien;
        this.id_KH = id_KH;
        this.id_KM = id_KM;
        this.TrangThai = TrangThai;
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

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
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
        return "HoaDonVModel{" + "Ma=" + Ma + ", Id_NV=" + Id_NV + ", ngayTao=" + ngayTao + ", TongTien=" + TongTien + ", id_KH=" + id_KH + ", id_KM=" + id_KM + ", TrangThai=" + TrangThai + '}';
    }

    
    
}
