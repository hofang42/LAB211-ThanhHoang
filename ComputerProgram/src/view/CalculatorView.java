/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.CalculatorModel;
import utils.Inputter;

/**
 *
 * @author hoang
 */
public class CalculatorView {

    Inputter input = new Inputter();

    public CalculatorView() {
    }

//    public void normalCalculator(CalculatorModel calModel) {
//        System.out.println("-------- Normal Calculator -------");
////        double num1 = input.getInputDouble("Enter number");
//        double num2 = 0;
//        double tmp = num1;
//        while (true) {
//            String operator = input.getOperator("Enter Operator");
//            switch (operator) {
//                case "+":
//                    num2 = input.getInputDouble("Enter number");
//                    tmp += num2;
//                    System.out.println("Memory: " + tmp);
//                    break;
//                case "-":
//                    num2 = input.getInputDouble("Enter number");
//                    tmp -= num2;
//                    System.out.println("Memory: " + tmp);
//                    break;
//                case "*":
//                    num2 = input.getInputDouble("Enter number");
//                    tmp *= num2;
//                    System.out.println("Memory: " + tmp);
//                    break;
//                case "/":
//                    num2 = input.getInputDouble("Enter number");
//                    tmp /= num2;
//                    System.out.println("Memory: " + tmp);
//                    break;
//                case "^":
//                    num2 = input.getInputDouble("Enter number");
//                    tmp = Math.pow(tmp, num2) ;
//                    System.out.println("Memory: " + tmp);
//                    break;
//                case "=":
//                    System.out.println("Result: " + tmp);                
//            }
//        }        
//    }
    
     public void normalCalculator(CalculatorModel calModel) {
        System.out.println("-------- Normal Calculator -------");
        calModel.setNum1(input.getInputDouble("Enter number"));
        calModel.setTempMem(calModel.getNum1());
        boolean flag = true;
        while (flag) {
            String operator = input.getOperator("Enter Operator");
            switch (operator) {
                case "+":
                    calModel.setNum2(input.getInputDouble("Enter number"));
                    calModel.setTempMem(calModel.getTempMem() + calModel.getNum2());
                    System.out.println("Memory: " + calModel.getTempMem());
                    break;
                case "-":
                    calModel.setNum2(input.getInputDouble("Enter number"));
                    calModel.setTempMem(calModel.getTempMem() - calModel.getNum2());
                    System.out.println("Memory: " + calModel.getTempMem());
                    break;
                case "*":
                    calModel.setNum2(input.getInputDouble("Enter number"));
                    calModel.setTempMem(calModel.getTempMem() * calModel.getNum2());
                    System.out.println("Memory: " + calModel.getTempMem());
                    break;
                case "/":
                    calModel.setNum2(input.getInputDouble("Enter number"));
                    calModel.setTempMem(calModel.getTempMem() / calModel.getNum2());
                    System.out.println("Memory: " + calModel.getTempMem());
                    break;
                case "^":
                    calModel.setNum2(input.getInputDouble("Enter number"));
                    calModel.setTempMem(Math.pow(calModel.getTempMem(), calModel.getNum2()));
                    System.out.println("Memory: " + calModel.getTempMem());                    
                    break;
                case "=":
                    System.out.println("Result: " + calModel.getTempMem()); 
                    flag = false;
                    break;
            }
        }        
    }
}
