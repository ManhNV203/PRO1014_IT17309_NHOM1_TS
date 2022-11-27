/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import Service.Implement.NhanVienServiceImplement;
import ViewModel.NhanVienViewModel;
import java.util.Objects;

/**
 *
 * @author ADMIN
 */
public class Validate {
    public boolean check(String... strings){
        for (String string : strings) {
            if("".equals(string)){
                return false;
            }
        }
        return true;
    }
    public boolean checkSDT(String sdt){
        String checkSDT = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        if(sdt.matches(checkSDT)){
            return true;
        }
        return false;
    }
    public boolean checkEmail(String email){
        String EMAIL_REGEX = "[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if(email.matches(EMAIL_REGEX)){
            return true;
        }
        return false;
    }
    public boolean checkMa(String ma){
        NhanVienServiceImplement service = new NhanVienServiceImplement();
        
        return service.checkMa(ma);
        
    }
}
