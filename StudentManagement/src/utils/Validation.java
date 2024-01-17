/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.ArrayList;
import java.util.Scanner;
import model.CourseReport;

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

    public int getIntAcceptEnter(String msg) {
        int nInt = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print(msg + ": ");
                String input = sc.nextLine();

                // If the input is empty, consider it valid and break the loop
                if (input.trim().isEmpty()) {
                    isValidInput = true;
                } else {
                    nInt = Integer.parseInt(input);
                    isValidInput = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return nInt;
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
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
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

    public boolean checkReportExist(ArrayList<CourseReport> lr,CourseReport course ){
        for (CourseReport report : lr) {
            if (course.getStudentName().equalsIgnoreCase(report.getStudentName())
                    && course.getCourseName().equalsIgnoreCase(report.getCourseName())
                    && course.getTotalCourse() == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }

}
