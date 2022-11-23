/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import DomainModel.HoaDon;
import DomainModel.SanPham;

/**
 *
 * @author FPTSHOP
 */
public class HoaDonCTVmodel {
    private HoaDon Id_HD;
    private SanPham Id_SP;
    private int SL_Mua;
    private double DonGia;

    public HoaDonCTVmodel() {
    }

    public HoaDonCTVmodel(HoaDon Id_HD, SanPham Id_SP, int SL_Mua, double DonGia) {
        this.Id_HD = Id_HD;
        this.Id_SP = Id_SP;
        this.SL_Mua = SL_Mua;
        this.DonGia = DonGia;
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
        return "HoaDonCTVmodel{" + "Id_HD=" + Id_HD + ", Id_SP=" + Id_SP + ", SL_Mua=" + SL_Mua + ", DonGia=" + DonGia + '}';
    }

    
}
