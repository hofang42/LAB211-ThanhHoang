/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.StudentModel;
import view.StudentView;

/**
 *
 * @author hoang
 */
public class FileLoad {

    Validation val = new Validation();    

    public ArrayList<StudentModel> loadData(String fileName) {
        ArrayList<StudentModel> stuList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] arr = line.split("\\|");
                    if (arr.length != 4) {
                        System.out.println("Invalid line: " + line);
                        continue;
                    }
                    int id = Integer.parseInt(arr[0]);
                    String name = arr[1];
                    int semester = Integer.parseInt(arr[2]);
                    String course = arr[3];

                    if (val.checkInt(String.valueOf(id)) && val.isName(name) && val.checkInt(String.valueOf(semester)) && val.isCourse(course)) {
                        StudentModel st = new StudentModel(id, name, semester, course);
                        stuList.add(st);
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

        return stuList;
    }
}
