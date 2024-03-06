/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.DataInput;
import utils.Inputter;
import utils.Validator;

/**
 *
 * @author hoang
 */
public class FormatView {

    public FormatView() {
        System.out.println("===== Validate Program =====");
    }    
    
    Inputter input = new Inputter();
    Validator valid = new Validator();

    public void checkPhone(DataInput data) {
        boolean contDigit, contLength;
        do {
            data.setPhone(input.getStringNotEmpty("Phone number"));
            contLength = valid.validPhone(data.getPhone());
            contDigit = valid.isNumberic(data.getPhone());
            if (!contDigit){
                System.out.println("Phone number must is a number");
                continue;
            }            
            if (!contLength){
                System.out.println("Phone number must be 10 digits");
            }             
        } while(!contLength || !contDigit);        
    }
    public void checkDate(DataInput data){
        boolean cont;
        do {
            data.setDate(input.getStringNotEmpty("Date"));
            cont = valid.validDate(data.getDate());
            if (!cont){
                System.out.println("Date to correct format(dd/mm/yyyy)");
            }
        } while(!cont);   
    }
    
    public void checkEmail(DataInput data){
        boolean cont;
        do {
            data.setEmail(input.getStringNotEmpty("Email"));
            cont = valid.validEmail(data.getEmail());
            if (!cont){
                System.out.println("Email must is correct format");
            }
        } while(!cont);   
    }
}
