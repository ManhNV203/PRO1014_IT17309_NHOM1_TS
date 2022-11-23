/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

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
}
