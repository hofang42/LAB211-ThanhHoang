/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author hoang
 */
public class Validator {

    private String pattern_Plan = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";

    public boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean isValidPlanTime(String planTime) {
        return planTime.matches(pattern_Plan);
    }
}
