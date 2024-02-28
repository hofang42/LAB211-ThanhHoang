/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.StudentModel;
import view.StudentView;

/**
 *
 * @author hoang
 */
public class StudentController {
    ArrayList<StudentModel> studentList = new ArrayList<>();
    StudentView studentView = new StudentView();
    
    public void excute(){
        studentView.takeInfoStudent(studentList);
        studentView.printInfoStudent(studentList);
    }
}
