/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.SalaryHistory;
import model.WorkerModel;

/**
 *
 * @author hoang
 */
public class FileLoad {

    Validator val = new Validator();

    public ArrayList<SalaryHistory> loadData(String fileName) {
        ArrayList<SalaryHistory> workerList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] arr = line.split("\\|");
                    if (arr.length != 6) {
                        System.out.println("Invalid line: " + line);
                        continue;
                    }
                    String id = arr[0];
                    String name = arr[1];
                    int age = Integer.parseInt(arr[2]);
                    double salary = Double.parseDouble(arr[3]);
                    String status = arr[4];
                    String date = arr[5];                    

                    if (val.isValidId(id) && !val.isExistIdInHistory(id, workerList) && val.isValidAge(age)) {
                        SalaryHistory history = new SalaryHistory(status, date, id, name, age, salary);
                        workerList.add(history);
                    } else {
                        System.out.println("Invalid data: " + line);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error parsing: " + line);
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data");
            System.out.println(e.getMessage());
        }

        return workerList;
    }

    public void writeToFile(ArrayList<SalaryHistory> workerList){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("doctor.dat"))) {
            for (SalaryHistory s : workerList) {                

                // Access properties from DoctorModel
                String id = s.getId();
                String name = s.getName();
                int age = s.getAge();
                double salary = s.getSalary();
                String status = s.getStatus();
                String date = s.getDate();                

                // Using "|" as a separator between key and values
                writer.write(id + "|" + name + "|" + age + "|" + salary + "|" + status + "|" + date);
                writer.newLine();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
