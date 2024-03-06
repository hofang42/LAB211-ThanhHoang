/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.DataInput;
import view.FormatView;

/**
 *
 * @author hoang
 */
public class FormatController {
    FormatView formatView = new FormatView();
    DataInput data = new DataInput();
    
    public void excute(){
        formatView.checkPhone(data);
        formatView.checkEmail(data);
        formatView.checkDate(data);
    }
}
