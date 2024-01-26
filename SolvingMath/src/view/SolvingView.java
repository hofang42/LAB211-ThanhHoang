/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import model.QuadraticModel;
import model.SuperlativeModel;
import utils.Inputter;
import utils.Validator;

/**
 *
 * @author hoang
 */
public class SolvingView {

    Inputter inputter = new Inputter();
    Validator val = new Validator();

    public void getCoefficientsSuperlative(SuperlativeModel spModel) {
        System.out.println("\n------- Calculate Equation --------");
        spModel.setA(inputter.getInputFloat("Enter A"));
        spModel.setB(inputter.getInputFloat("Enter B"));
    }

    public void superlativeEquation(SuperlativeModel spModel) {
        float a = spModel.getA();
        float b = spModel.getB();
        spModel.setX(-b / a);
        float x = spModel.getX();
        System.out.println("Solution: x=" + x);
        System.out.print("Number is odd: ");
        ArrayList<Float> arr = new ArrayList();
        arr.add(a);
        arr.add(b);
        arr.add(x);
        System.out.print("Number is odd: ");
        for (float num : arr) {
            if (val.checkOdd(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        System.out.print("Number is even: ");
        for (float num : arr) {
            if (val.checkEven(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        System.out.print("Number is perfect square: ");
        for (float num : arr) {
            if (val.checkSquareNumber(num)) {
                System.out.print(num + " ");
            }
        }
    }

    public void getCoefficientsQuadratic(QuadraticModel quadModel) {
        System.out.println("\n------- Calculate Quadratic Equation --------");
        quadModel.setA(inputter.getInputFloat("Enter A"));
        quadModel.setB(inputter.getInputFloat("Enter B"));
        quadModel.setC(inputter.getInputFloat("Enter C"));
    }

    public void quadraticEquation(QuadraticModel quadModel) {
        float a = quadModel.getA();
        float b = quadModel.getB();
        float c = quadModel.getC();
        float delta = b * b - 4 * a * c;            
        quadModel.setX1((float) (-b + Math.sqrt(delta)) / (2 * a));
        quadModel.setX2((float) (-b - Math.sqrt(delta)) / (2 * a));
        float x1 = quadModel.getX1();
        float x2 = quadModel.getX2();
        System.out.println("Solution: x1 = " + x1 + " and x2 = " + x2);
        ArrayList<Float> arr = new ArrayList();
        arr.add(a);
        arr.add(b);
        arr.add(c);
        arr.add(x1);
        arr.add(x2);
        System.out.print("Number is odd: ");
        for (float num : arr) {
            if (val.checkOdd(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        System.out.print("Number is even: ");
        for (float num : arr) {
            if (val.checkEven(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        System.out.print("Number is perfect square: ");
        for (float num : arr) {
            if (val.checkSquareNumber(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}
