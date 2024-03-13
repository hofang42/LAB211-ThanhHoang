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
import model.AccountModel;
import model.Locate;

/**
 *
 * @author hoang
 */
public class FileLoad {

    Validator val = new Validator();

    public ArrayList<AccountModel> loadData(String fileName) {
        ArrayList<AccountModel> accList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] arr = line.split("\\|");
                    if (arr.length != 2) {
                        System.out.println("Invalid line: " + line);
                        continue;
                    }
                    String acoount = arr[0];
                    String pass = arr[1];

//                    if (val.isValidAccount(acoount) && val.isValidPassword(pass)) {
                        AccountModel account = new AccountModel(acoount, pass);
                        accList.add(account);
//                    } else {
//                        System.out.println("Invalid data: " + line);
//                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error parsing: " + line);
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data");
            System.out.println(e.getMessage());
        }
        System.out.println(accList.size());
        return accList;
    }

//    public void writeToFile(ArrayList<AccountModel> accList) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("doctor.dat"))) {
//            for (AccountModel s : workerList) {
//
//                String id = s.getId();
//                String name = s.getName();
//                int age = s.getAge();
//                double salary = s.getSalary();
//                String status = s.getStatus();
//                String date = s.getDate();
//
//                writer.write(id + "|" + name + "|" + age + "|" + salary + "|" + status + "|" + date);
//                writer.newLine();
//            }
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//    }
}
