/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Circle;
import model.Rectangle;
import model.Triangle;
import view.ShapeView;

/**
 *
 * @author hoang
 */
public class ShapeController {
    Rectangle rectangle = new Rectangle();
    Triangle triangle = new Triangle();
    Circle circle = new Circle();
    
    ShapeView shapeView = new ShapeView();
    
    public void excute(){        
        shapeView.takeInfo(rectangle, circle, triangle);
        shapeView.printInfo(rectangle, circle, triangle);
    }
}
