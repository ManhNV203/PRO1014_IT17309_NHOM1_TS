/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RepositoryJDBC.Interface;

import DomainModel.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public interface HoaDonCTRepositoryInterface {
    public List<HoaDonChiTiet> getAll();
}
