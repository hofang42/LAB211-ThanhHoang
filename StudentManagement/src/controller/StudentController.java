/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.StudentList;
import view.Menu;
import view.StudentView;

/**
 *
 * @author hoang
 */
public class StudentController extends Menu {

    private StudentList studentList;
    private StudentView stuView;

    public StudentController() {
        super("WELCOME TO STUDENT MANAGEMENT", new String[]{"Create", "Find and sort", "Update/Delete", "Report", "Exit"});
        studentList = new StudentList();
        stuView = new StudentView();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                stuView.takeInfoStudent();
                break;
            case 2:
                stuView.findAndSort();
                break;
            case 3:
                stuView.updateOrDelete();
                break;
            case 4:
                stuView.report();
                break;
            case 5:
                break;
        }
    }

}
