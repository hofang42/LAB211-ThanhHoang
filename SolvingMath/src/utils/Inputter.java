/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Inputter {

    Scanner sc = new Scanner(System.in);

    public float getInputFloat(String msg) {
        //loop until user input correct
        while (true) {
            try {
                System.out.print(msg + ": ");
                float result = Float.parseFloat(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number");
            }

        }
    }
}
