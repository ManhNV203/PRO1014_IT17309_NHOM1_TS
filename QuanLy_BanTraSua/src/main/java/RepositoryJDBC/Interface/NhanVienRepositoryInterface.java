/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RepositoryJDBC.Interface;

import DomainModel.NhanVien;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface NhanVienRepositoryInterface {
    public List<NhanVien> all();
    boolean add(NhanVien nv) ;
    boolean update(String ma,NhanVien nv) ;
    boolean delete(String ma) ;
    NhanVien getone(String ma);
    public List<NhanVien> getByName(String name);
    public List<NhanVien> getBySex(String sex);
    
}
