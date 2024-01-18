/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author hoang
 */
public class CustomerModel {
    private String customerName;
    private ArrayList customerList = new ArrayList();

    public CustomerModel() {
    }

    public CustomerModel(String customerName) {
        this.customerName = customerName;
        customerList.add(this);
    }
    
    
}
