/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoang
 */
public class CalculatorModel {
    private double num1, num2;
    private String operator;
    private double tempMem = 0;

    public CalculatorModel() {
    }

    public CalculatorModel(double num1, String operator) {
        this.num1 = num1;
        this.operator = operator;
    }
    
    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    } 
    
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getTempMem() {
        return tempMem;
    }

    public void setTempMem(double tempMem) {
        this.tempMem = tempMem;
    }
    
    
            
}
