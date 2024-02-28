/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoang
 */
public class Circle extends Shape{
    
    private double radius;

    public Circle() {
    }
        
    public Circle(double radius, double area, double perimeter) {
        super(area, perimeter);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Radius: " + radius +"\n"+ super.toString() ;
    }
    
    
    
}
