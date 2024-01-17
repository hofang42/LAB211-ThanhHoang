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
import model.StudentList;
import model.StudentModel;

/**
 *
 * @author hoang
 */
public class FileLoad {

    Validation val = new Validation();

    public void loadData(StudentList stuList) {

        try {

            BufferedReader br = new BufferedReader(new FileReader("InputFile.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] arr = line.split("\\|");
                    if (arr.length != 3) {
                        System.out.println("Invalid line: " + line);
                        continue;
                    }
                    boolean isName = val.isName(arr[0]);
                    boolean isSem = val.checkInt(arr[1]);
                    boolean isCourse = val.isCourse(arr[2]);                    

                    if (isName && isSem && isCourse) {

                        String name = arr[0];
                        int semester = Integer.parseInt(arr[1]);
                        String course = arr[2];

                        StudentModel st = new StudentModel(name, semester, course);
                        stuList.createStudent(st);

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

    }

}
