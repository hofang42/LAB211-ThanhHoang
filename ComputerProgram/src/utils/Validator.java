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
public class Validator {
    private final Pattern OPERATOR_PATTERN = Pattern.compile("[+\\-*/^=]");
    
    public boolean validOperator(String operator){
        while (true) {
            if (operator.isEmpty()) {
                System.err.println("Input cannot be empty");
            } else if (OPERATOR_PATTERN.matcher(operator).matches()) {
                return true;
            } else {
                System.err.println("Please input (+, -, *, /, ^, =)");
            }
            System.out.print("Enter Operator: ");
        }
    }
}
