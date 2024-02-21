/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.time.Year;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.SalaryHistory;
import model.WorkerModel;

/**
 *
 * @author hoang
 */
public class Validator<T> {

    private final String pattern = "W \\d+";

    public boolean isValidId(String id) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(id);
        return matcher.matches();
    }

    public boolean isExistId(String id, ArrayList<WorkerModel> workerList) {
        for (WorkerModel w : workerList) {
            if (w.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean isExistIdInHistory(String id, ArrayList<SalaryHistory> workerList) {
        for (WorkerModel w : workerList) {
            if (w.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidYOB(int YOB) {
        return (Year.now().getValue() - YOB >= 18) && (Year.now().getValue() - YOB <= 50);
    }

    public boolean isValidAge(int age) {
        return age >= 18 && age <= 50;
    }
}
