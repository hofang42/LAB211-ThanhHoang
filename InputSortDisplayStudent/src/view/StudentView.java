/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Collections;
import model.StudentModel;
import utils.Inputter;
import utils.Validation;

/**
 *
 * @author hoang
 */
public class StudentView {

    Inputter input = new Inputter();
    Validation valid = new Validation();

    public void takeInfoStudent(ArrayList<StudentModel> studentList) {
        System.out.println("===== Collection Sort program =====");        
        do {
            System.out.println("Please input student information");
            String name = input.getStringNotEmpty("Name");
            String classes = input.getStringNotEmpty("Classes");
            double mark = input.getInt("Mark");
            studentList.add(new StudentModel(name, classes, mark));
            System.out.print("Do you want to enter more student information?(Y/N):");
        } while (valid.checkInputYN());
    }
    
    public void printInfoStudent(ArrayList<StudentModel> studentList){
        int studentCount = 1;
        Collections.sort(studentList);
        for (StudentModel student : studentList){
            System.out.println("-------------- Student " +studentCount + " --------------");
            System.out.println(student.toString());
            studentCount++;
        }
    }
}
