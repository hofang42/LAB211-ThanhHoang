/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author hoang
 */
public class StudentList {

    private ArrayList<StudentModel> studentList;

    public StudentList() {
        studentList = new ArrayList();
    }

    public ArrayList getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList studentList) {
        this.studentList = studentList;
    }

    public int size() {
        return studentList.size();
    }

    public void createStudent(StudentModel student) {
        int id = size() + 1;
        student.setId(id);
        studentList.add(student);
    }

    public ArrayList<StudentModel> search(Predicate<StudentModel> p) {
        ArrayList<StudentModel> student = new ArrayList<>();
        for (StudentModel s : studentList) {
            if (p.test(s)) {
                student.add(s);
            }
        }
        return student;
    }

    public String courseSelected(int courseId) {
        switch (courseId) {
            case 1:
                return "Java";
            case 2:
                return ".Net";
            case 3:
                return "C/C++";
            default:
                return "";
        }
    }
}
