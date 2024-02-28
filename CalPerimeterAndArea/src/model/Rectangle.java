/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoang
 */
public class Rectangle extends Shape{
    private double width,length;

    public Rectangle() {        
    }    
    
    public Rectangle(double width, double length, double area, double perimeter) {
        super(area, perimeter);
        this.width = width;
        this.length = length;               
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Width: " + width +"\n"+
                "Length: " + length+"\n"+
                super.toString();
    }
    
    
}
