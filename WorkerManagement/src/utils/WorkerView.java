/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import view.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import model.SalaryHistory;
import model.WorkerModel;
import utils.Inputter;
import utils.Validator;

/**
 *
 * @author hoang
 */
public class WorkerView {

    Inputter input = new Inputter();
    Validator valid = new Validator();

    public void addWorker(ArrayList<WorkerModel> workerList) {
        System.out.println("-------- Add Worker --------");
        String id = "";
        boolean cont, contAge;
        do {
            id = input.getStringNotEmpty("Enter Code");
            cont = valid.isValidId(id) && !valid.isExistId(id, workerList);
            if (!cont) {
                System.out.println("Invalid ID or ID already exists. Please enter a different ID.");
            }
        } while (!cont);
        String name = input.getStringNotEmpty("Enter Name");
        int YOB, age;
        do {
            YOB = input.getInt("Enter Year Of Birth");
            contAge = valid.isValidAge(YOB);
            age = Year.now().getValue() - YOB;
            if (!contAge) {
                System.out.println("Enter YOB in 18-50");
            }
        } while (!contAge);
        System.out.print("Enter Salary: ");
        double salary = input.getDoubleLimit(0);
        String workLoc = input.getStringNotEmpty("Enter work location");

        WorkerModel worker = new WorkerModel(id, name, age, salary, workLoc);
        workerList.add(worker);
    }

    public void upSalary(ArrayList<WorkerModel> workerList, ArrayList<SalaryHistory> salaryList) {
        if (workerList.isEmpty()) {
            return;
        }
        String id = "";
        boolean contId;
        do {
            id = input.getStringNotEmpty("Enter Code");
            contId = valid.isValidId(id);
            if (!contId) {
                System.out.println("Invalid ID");
            }
        } while (!contId);
        WorkerModel workerFound = getWorkerById(workerList, id);
        double salaryAfter;
        if (workerFound != null) {
            do {
                salaryAfter = workerFound.getSalary();
                workerFound.setSalary(input.getDouble("Enter Salary"));
                if (workerFound.getSalary() < salaryAfter) {
                    System.out.println("Must be greater than current salary.");
                }
            } while (workerFound.getSalary() < salaryAfter);
            SalaryHistory history = new SalaryHistory("UP", getCurrentDate(), workerFound.getId(),
                    workerFound.getName(), workerFound.getAge(), workerFound.getSalary(), workerFound.getWorkLocation());
            salaryList.add(history);
        } else {
            System.out.println("No Worker Found");
        }
    }

    public void downSalary(ArrayList<WorkerModel> workerList, ArrayList<SalaryHistory> salaryList) {
        if (workerList.isEmpty()) {
            return;
        }
        String id = "";
        boolean contId;
        do {
            id = input.getStringNotEmpty("Enter Code");
            contId = valid.isValidId(id);
            if (!contId) {
                System.out.println("Invalid ID");
            }
        } while (!contId);
        WorkerModel workerFound = getWorkerById(workerList, id);
        double salaryAfter;
        if (workerFound != null) {
            do {
                salaryAfter = workerFound.getSalary();
                workerFound.setSalary(input.getDouble("Enter Salary"));
                if (workerFound.getSalary() > salaryAfter) {
                    System.out.println("Must be smaller than current salary.");
                }
            } while (workerFound.getSalary() > salaryAfter);
            SalaryHistory history = new SalaryHistory("DOWN", getCurrentDate(), workerFound.getId(),
                    workerFound.getName(), workerFound.getAge(), workerFound.getSalary(), workerFound.getWorkLocation());
            salaryList.add(history);
        } else {
            System.out.println("No Worker Found");
        }
    }

    //get current date 
    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    public static String getCurrentYear() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    public void displayHistory(ArrayList<SalaryHistory> historyList) {
        if (historyList.isEmpty()) {
            return;
        }
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        Collections.sort(historyList);
        for (SalaryHistory history : historyList) {
            printHistory(history);
        }

    }

    public static void printHistory(SalaryHistory history) {
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", history.getId(),
                history.getName(), history.getAge(), history.getSalary(),
                history.getStatus(), history.getDate());
    }

    private WorkerModel getWorkerById(ArrayList<WorkerModel> workerList, String id) {
        for (WorkerModel w : workerList) {
            if (w.getId().equalsIgnoreCase(id)) {
                return w;
            }
        }
        return null;
    }
}
