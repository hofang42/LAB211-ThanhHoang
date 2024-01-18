/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Validation {

    private final Scanner sc = new Scanner(System.in);

    public String getString(String msg) {
        System.out.print(msg + ": ");
        return sc.nextLine();
    }    
    
    public int getInt(String msg) {
        int nInt = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print(msg + ": ");
                String n = sc.nextLine();
                nInt = Integer.parseInt(n);
                isValidInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return nInt;
    }

    public double getDouble(String msg) {
        Scanner sc = new Scanner(System.in);
        double number;
        while (true) {
            System.out.print(msg + ": ");
            try {
                number = sc.nextDouble();
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Please enter the double number > 0 ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Only enter the double number > 0 ");
                sc.next();
            }
        }
    }

    public String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Fruit is out of stocks, Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public boolean checkInputUD() {
        while (true) {
            String result = getString("Do you want to update (U) or delete (D) student");
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.out.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }

    public boolean checkInt(String msg) {
        try {
            Integer.parseInt(msg);
            return true;  // Parsing successful
        } catch (NumberFormatException ex) {
            System.out.println("Invalid number Int");
            return false;  // Parsing failed
        }
    }

    public boolean isValid(String data, String regex) {
        return data.trim().matches(regex);
    }

    public boolean isName(String data) {
        return !data.isEmpty();
    }

    public boolean isCourse(String data) {
        return data.equalsIgnoreCase("java")
                || data.equalsIgnoreCase("c/c++")
                || data.equalsIgnoreCase(".net");
    }
}
