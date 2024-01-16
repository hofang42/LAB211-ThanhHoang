/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controller.CounterController;
import java.util.InputMismatchException;

/**
 *
 * @author hoang
 */
public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                CounterController cc = new CounterController();
                cc.run();
            } catch (InputMismatchException e) {
                System.err.println("Please enter valid number !!!");
            }
        }

    }
}
