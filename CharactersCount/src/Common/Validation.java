/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Validation {

    public String getString(String msg) {
        System.out.print(msg + " : ");
        return new Scanner(System.in).nextLine();
    }
}
