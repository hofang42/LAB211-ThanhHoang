/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.StudentModel;
import utils.FileLoad;
import view.Menu;
import view.StudentView;

/**
 *
 * @author hoang
 */
public class StudentController extends Menu {

    private StudentView stuView;
    private FileLoad file = new FileLoad();
    ArrayList<StudentModel> studentList = file.loadData("InputFile.txt");

    public StudentController() {
        super("WELCOME TO STUDENT MANAGEMENT", new String[]{"Create", "Find and sort", "Update/Delete", "Report", "Exit"});
        stuView = new StudentView();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                stuView.takeInfoStudent(studentList);
                break;
            case 2:
                stuView.findAndSort(studentList);
                break;
            case 3:
                stuView.updateOrDelete(studentList);
                break;
            case 4:
                stuView.report(studentList);
                break;
            case 5:
                break;
        }
    }

}
