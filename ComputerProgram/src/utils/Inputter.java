/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author hoang
 */
public class Inputter {
    private final Pattern OPERATOR_PATTERN = Pattern.compile("[+\\-*/^=]");
    Scanner sc = new Scanner(System.in);

    public double getInputDouble(String msg) {
        //loop until user input correct
        while (true) {
            try {
                System.out.print(msg + ": ");
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number");
            }

        }
    }
    
    public String getOperator(String msg){
        while (true) {
            System.out.print(msg + ": ");
            String operator = sc.nextLine().trim();
            if (operator.isEmpty()) {
                System.err.println("Input cannot be empty");
            } else if (OPERATOR_PATTERN.matcher(operator).matches()) {
                return operator;
            } else {
                System.out.println("Please input (+, -, *, /, ^, =)");
            }
//            System.out.print("Enter again: ");
        }
    }
}
