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
public class Validator {



    //check number is odd or not
    public boolean checkOdd(double n) {
        if (n % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    //check number is even or not
    public boolean checkEven(double n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    //check number is squarenumber or not
    public boolean checkSquareNumber(double n) {
        if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
            return true;
        } else {
            return false;
        }
    }
}
