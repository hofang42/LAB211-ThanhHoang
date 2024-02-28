/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoang
 */
public class Triangle extends Shape{
    private double sideA, sideB, sideC;

    public Triangle() {
    }

    
    
    public Triangle(double sideA, double sideB, double sideC, double area, double perimeter) {
        super(area, perimeter);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    @Override
    public String toString() {
        return "Side A: " + sideA +"\n"+
                "Side B: "+sideB+"\n"+
                "Side C: "+sideC+"\n"+
                super.toString();
    }
    
    
}
