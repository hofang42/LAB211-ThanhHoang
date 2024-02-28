/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Circle;
import model.Rectangle;
import model.Triangle;
import utils.Inputter;

/**
 *
 * @author hoang
 */
public class ShapeView {

    Inputter input = new Inputter();

    public void takeInfo(Rectangle rectangle, Circle circle, Triangle triangle) {
        System.out.println("===== Calculator Shape Program =====");
        double width = input.getDouble("Please input side width of Rectangle");
        double length = input.getDouble("Please input length of Rectangle");
        rectangle.setWidth(width);rectangle.setLength(length);
        rectangle.setArea(width * length);rectangle.setPerimeter((width + length) * 2);
                
        double radius = input.getDouble("Please input radius of Circle");
        circle.setRadius(radius);
        circle.setArea(Math.PI*radius*radius);circle.setPerimeter(2*Math.PI*radius);
        
        double sideA = input.getDouble("Please input side A of Triangle");
        double sideB = input.getDouble("Please input side B of Triangle");
        double sideC = input.getDouble("Please input side C of Triangle");
        double s = (sideA + sideB + sideC)/2;
        triangle.setSideA(sideA);triangle.setSideB(sideB);triangle.setSideC(sideC);
        triangle.setArea(Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC)));
        triangle.setPerimeter(sideA+sideB+sideC);
        
    }
    
    public void printInfo(Rectangle rectangle, Circle circle, Triangle triangle){
        System.out.println("----- Rectangle -----");
        System.out.println(rectangle.toString());
        System.out.println("----- Circle -----");
        System.out.println(circle.toString());
        System.out.println("----- Triangle -----");
        System.out.println(triangle.toString());        
    }
}
