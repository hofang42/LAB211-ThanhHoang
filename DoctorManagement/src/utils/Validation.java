/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author hoang
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.DoctorModel;

public class Validation {

    private static final String PATTERN_CODE = "DOC\\s(\\d+)";
    
    public boolean isExistCode(HashMap<String, DoctorModel> doctorList, String code) {
        for (Map.Entry<String, DoctorModel> entry : doctorList.entrySet()) {
            DoctorModel doctor = entry.getValue();
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidCode(String code){
        Pattern pattern = Pattern.compile(PATTERN_CODE);
        Matcher matcher = pattern.matcher(code);
        return matcher.matches();
    }
}
