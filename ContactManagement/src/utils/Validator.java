/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author hoang
 */
public class Validator {

    private final String VALID_PHONE = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
            + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";

    public boolean checkInt(String num) {
        try {
            Integer.parseInt(num);
            return true;  // Parsing successful
        } catch (NumberFormatException ex) {
            System.out.println("Invalid number Int");
            return false;  // Parsing failed
        }
    }

    public boolean isValidPhone(String num) {
        if (num.matches(VALID_PHONE)) {
                return true;
            }
        return false;
    }
}
