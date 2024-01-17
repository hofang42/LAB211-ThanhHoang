/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Collections;
import model.StudentList;
import model.StudentModel;
import utils.Validation;

/**
 *
 * @author hoang
 */
public class StudentView {

    private StudentList studentList;
    private Validation val = new Validation();

    public StudentView() {
        studentList = new StudentList();
    }

    public void takeInfoStudent() {
        String studentName = val.getString("Enter Student Name");
        int semester = val.getInt("Enter Semester");
        System.out.print("Course Name:\n1. Java\t2. Net\t3. C/C++\nEnter course: ");
        int courseNameInt = val.checkInputIntLimit(1, 3);
        String courseName = "";
        if (courseNameInt == 1) {
            courseName = "Java";
        }
        if (courseNameInt == 2) {
            courseName = ".Net";
        }
        if (courseNameInt == 3) {
            courseName = "C/C++";
        }
        StudentModel student = new StudentModel(studentName, semester, courseName);
        studentList.createStudent(student);
    }

    public ArrayList<StudentModel> searchStudentByName() {
        String keyword = val.getString("Input Student name");
        System.out.println("The students found: ");
        return studentList.search(p -> p.getStudentName().equals(keyword));
    }

    public StudentModel searchStudentByID(int id, ArrayList<StudentModel> stu) {
        StudentModel studentFound = new StudentModel();
        for (StudentModel s : stu) {
            if (s.getId() == id) {
                studentFound = s;
            }
        }
        return studentFound;
    }

    public void printStudentList(ArrayList<StudentModel> stu) {
        System.out.printf("%-15s%-15s%-15s%-15s\n", "ID", "Student name", "semester", "Course Name");
        for (StudentModel s : stu) {
            System.out.println(s);
        }
    }

    public void findAndSort() {
        ArrayList<StudentModel> listStudentFound = searchStudentByName();
        if (listStudentFound.isEmpty()) {
            System.out.println("List empty.");
            return;
        }

        if (listStudentFound.isEmpty()) {
            System.out.println("Student is not exist.");
        } else {
            Collections.sort(listStudentFound, (student1, student2)
                    -> student1.getStudentName().compareTo(student2.getStudentName()));
            printStudentList(listStudentFound);
        }
    }

    public void updateOrDelete() {
        if (studentList.size() == 0) {
            System.out.println("List empty.");
            return;
        }
        int id = val.getInt("Enter ID");
        StudentModel studentFound = searchStudentByID(id, studentList.getStudentList());
        boolean choice = val.checkInputUD();
        if (studentFound == null) {
            System.out.println("Not found student.");
            return;
        } else {
            if (choice) {
                String newStudentName = val.getString("Enter Student Name");
                int newSemester = val.getInt("Enter Semester");
                System.out.print("Course Name:\n1. Java\t2. Net\t3. C/C++\nEnter course: ");
                int courseNameInt = val.checkInputIntLimit(1, 3);
                String newCourseName = "";
                if (courseNameInt == 1) {
                    newCourseName = "Java";
                }
                if (courseNameInt == 2) {
                    newCourseName = ".Net";
                }
                if (courseNameInt == 3) {
                    newCourseName = "C/C++";
                }
                studentFound.setStudentName(newStudentName);
                studentFound.setSemester(newSemester);
                studentFound.setCourseName(newCourseName);
                System.out.println("Update success.");
                return;
            } else {
                studentList.getStudentList().remove(studentFound);
                System.out.println("Delete success.");
                return;
            }
        }
    }
}
