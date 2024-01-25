/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

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
        float x = -b / a;
        System.out.println("Solution: x=" + x);
        System.out.print("Number is odd: ");
        if (val.checkOdd(a)) {
            System.out.print(a + " ");
        }
        if (val.checkOdd(b)) {
            System.out.print(b + " ");
        }
        if (val.checkOdd(x)) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.print("Number is even: ");
        if (val.checkEven(a)) {
            System.out.print(a + " ");
        }
        if (val.checkEven(b)) {
            System.out.print(b + " ");
        }
        if (val.checkEven(x)) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.print("Number is perfect square: ");
        if (val.checkSquareNumber(a)) {
            System.out.print(a + " ");
        }
        if (val.checkSquareNumber(b)) {
            System.out.print(b + " ");
        }
        if (val.checkSquareNumber(x)) {
            System.out.print(x + " ");
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
        float x1 = (float) (-b + Math.sqrt(delta)) / (2 * a);
        float x2 = (float) (-b - Math.sqrt(delta)) / (2 * a);
        System.out.println("Solution: x1 = " + x1 + " and x2 = " + x2);
        System.out.print("Number is odd: ");
        if (val.checkOdd(a)) {
            System.out.print(a + " ");
        }
        if (val.checkOdd(b)) {
            System.out.print(b + " ");
        }
        if (val.checkOdd(c)) {
            System.out.print(c + " ");
        }
        if (val.checkOdd(x1)) {
            System.out.print(x1 + " ");
        }
        if (val.checkOdd(x2)) {
            System.out.print(x2 + " ");
        }
        System.out.println();
        System.out.print("Number is even: ");
        if (val.checkEven(a)) {
            System.out.print(a + " ");
        }
        if (val.checkEven(b)) {
            System.out.print(b + " ");
        }
        if (val.checkEven(c)) {
            System.out.print(b + " ");
        }
        if (val.checkEven(x1)) {
            System.out.print(x1 + " ");
        }
        if (val.checkEven(x2)) {
            System.out.print(x1 + " ");
        }
        System.out.println();
        System.out.print("Number is perfect square: ");
        if (val.checkSquareNumber(a)) {
            System.out.print(a + " ");
        }
        if (val.checkSquareNumber(b)) {
            System.out.print(b + " ");
        }
        if (val.checkSquareNumber(c)) {
            System.out.print(c + " ");
        }       
        if (val.checkSquareNumber(x1)) {
            System.out.print(x1 + " ");
        }
        if (val.checkSquareNumber(x2)) {
            System.out.print(x2 + " ");
        }
        System.out.println();
    }
}
