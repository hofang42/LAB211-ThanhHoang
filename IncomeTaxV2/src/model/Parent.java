/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoang
 */
public class Parent extends Person {

    public boolean isMother;

    public Parent(int age, boolean isMother) {
        super(age, false, false);
        this.isMother = isMother;
    }
}
