/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.time.Year;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.WorkerModel;

/**
 *
 * @author hoang
 */
public class Validator {

    private final String pattern = "W \\d+";

    public boolean isValidId(String id) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(id);
        return matcher.matches();
    }
    
    public boolean isExistId(String id, ArrayList<WorkerModel> workerList){
        for (WorkerModel w : workerList){
            if (w.getId().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }  
    
    public boolean isValidAge(int yearAge){
        return (Year.now().getValue() - yearAge > 18) && (Year.now().getValue() - yearAge < 50);
    }
}
