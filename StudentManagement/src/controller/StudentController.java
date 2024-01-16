/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.StudentList;
import utils.MethodsSupport;
import view.Menu;

/**
 *
 * @author hoang
 */
public class StudentController extends Menu {

    private StudentList studentList;
    private MethodsSupport med;

    public StudentController() {
        super("WELCOME TO STUDENT MANAGEMENT", new String[]{"Create", "Find and sort", "Update/Delete", "Report", "Exit"});
        studentList = new StudentList();
        med = new MethodsSupport();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                med.takeInfoStudent();
                break;
            case 2:
                med.findAndSort();
                break;
            case 3:
                med.updateOrDelete();
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

}
