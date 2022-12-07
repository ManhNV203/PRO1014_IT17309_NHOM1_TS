/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import DomainModel.DanhMuc;
import DomainModel.HoaDon;
import DomainModel.SanPham;
import DomainModel.Size;
import DomainModel.Vi;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonCTVmodel {
    private int id;
    private String ma_hd;
    private String Ma_SP;
    private String TenSP;
    private int SL_Mua;
    private double DonGia;
    private String ID_VI;
    private String ID_SIZE;
    private String ID_dM;
    private double tongtien;
    public HoaDonCTVmodel() {
    }

    public HoaDonCTVmodel(int id, String ma_hd, String Ma_SP, String TenSP, int SL_Mua, double DonGia, String ID_VI, String ID_SIZE, String ID_dM, double tongtien) {
        this.id = id;
        this.ma_hd = ma_hd;
        this.Ma_SP = Ma_SP;
        this.TenSP = TenSP;
        this.SL_Mua = SL_Mua;
        this.DonGia = DonGia;
        this.ID_VI = ID_VI;
        this.ID_SIZE = ID_SIZE;
        this.ID_dM = ID_dM;
        this.tongtien = tongtien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa_hd() {
        return ma_hd;
    }

    public void setMa_hd(String ma_hd) {
        this.ma_hd = ma_hd;
    }

    public String getMa_SP() {
        return Ma_SP;
    }

    public void setMa_SP(String Ma_SP) {
        this.Ma_SP = Ma_SP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
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

    public String getID_VI() {
        return ID_VI;
    }

    public void setID_VI(String ID_VI) {
        this.ID_VI = ID_VI;
    }

    public String getID_SIZE() {
        return ID_SIZE;
    }

    public void setID_SIZE(String ID_SIZE) {
        this.ID_SIZE = ID_SIZE;
    }

    public String getID_dM() {
        return ID_dM;
    }

    public void setID_dM(String ID_dM) {
        this.ID_dM = ID_dM;
    }

    public double getTongtien() {
        return tongtien=SL_Mua*DonGia;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    @Override
    public String toString() {
        return "HoaDonCTVmodel{" + "id=" + id + ", ma_hd=" + ma_hd + ", Ma_SP=" + Ma_SP + ", TenSP=" + TenSP + ", SL_Mua=" + SL_Mua + ", DonGia=" + DonGia + ", ID_VI=" + ID_VI + ", ID_SIZE=" + ID_SIZE + ", ID_dM=" + ID_dM + ", tongtien=" + tongtien + '}';
    }

    

   

    
    
    
}
