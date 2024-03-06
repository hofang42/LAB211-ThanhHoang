/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author hoang
 */
public class Validator {

    public boolean validPhone(String phone) {
        return phone.matches("\\d{10}");
    }

    public boolean validEmail(String email) {
        return email.matches("^(.+)@(\\S+)\\.\\S+");
    }

    public boolean validDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean isNumberic(String phone) {
        try {
            Long.parseLong(phone);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
