/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hoang
 */
public class Validator<T> {

    private final String pattern_Password = "[0-9a-zA-Z]{8,31}";

    public boolean isValidPassword(String password) {
        Pattern regex = Pattern.compile(pattern_Password);
        Matcher matcher = regex.matcher(password);
        return matcher.matches();
    }

    public boolean checkCaptcha(String captcha, String user_captcha) {
        return captcha.contains(user_captcha);
    }

    public boolean isValidAccount(String account) {
        if (account.length() != 10) {
            System.out.println("Account number must be 10 characters long.");
            return false;
        }
        try {
            Long.parseLong(account);
            return true;  // Parsing successful
        } catch (NumberFormatException ex) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return false;  // Parsing failed
        }
    }
}
