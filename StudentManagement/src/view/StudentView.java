/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import model.StudentModel;
import utils.FileLoad;
import utils.Validation;

/**
 *
 * @author hoang
 */
public class StudentView {

    private Validation val = new Validation();
    private StudentModel stuModel = new StudentModel();


    
    public StudentView() {
        
    }

    public void takeInfoStudent(ArrayList<StudentModel> arr) {
        String studentName = "";
        boolean flag = true;
        while (flag) {
            studentName = val.getString("Enter Student Name");
            if (studentName.isBlank()) {
                System.out.println("Do not leave blank");
                flag = true;
            } else {
                flag = false;
            }
        }

        int semester = val.getInt("Enter Semester");
        System.out.print("Course Name:\n1. Java\t2. .Net\t3. C/C++\nEnter course: ");
        int courseNameInt = val.checkInputIntLimit(1, 3);
        String courseName = courseSelected(courseNameInt);
        StudentModel student = new StudentModel(studentName, semester, courseName);
        createStudent(student, arr);
    }

    public ArrayList<StudentModel> searchStudentByName(ArrayList<StudentModel> arr) {
        String keyword = val.getString("Input Student name");
        System.out.println("The students found: ");

        ArrayList<StudentModel> result = new ArrayList<>();

        for (StudentModel student : arr) {
            if (student.getStudentName().equals(keyword)) {
                result.add(student);
            }
        }

        return result;
    }

    public void createStudent(StudentModel student, ArrayList<StudentModel> arr) {
        int id = arr.size() + 1;
        student.setId(id);
        arr.add(student);
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

    public void findAndSort(ArrayList<StudentModel> arr) {
        ArrayList<StudentModel> listStudentFound = searchStudentByName(arr);
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

    public void updateOrDelete(ArrayList<StudentModel> arr) {
        if (arr.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        int id = val.getInt("Enter ID");
        StudentModel studentFound = searchStudentByID(id, arr);
        boolean choice = val.checkInputUD();
        if (studentFound == null) {
            System.out.println("Not found student.");
            return;
        } else {    
            if (choice) {
                String newStudentName = val.getString("Enter Student Name");
                if (newStudentName.isBlank()) {
                    newStudentName = studentFound.getStudentName();
                }

                String newSemesterStr = val.getString("Enter Semester");
                int newSemester = 0;

                if (!newSemesterStr.isBlank()) {
                    try {
                        newSemester = Integer.parseInt(newSemesterStr);
                    } catch (NumberFormatException e) {
                    }
                } else {
                    newSemester = studentFound.getSemester();
                }

                int newCourseName = val.getIntAcceptEnter("Course Name:\n1. Java\t2. .Net\t3. C/C++\nEnter course: ");
                String newCourseNameStr = courseSelected(newCourseName);

                if (newCourseNameStr.isBlank()) {
                    newCourseNameStr = studentFound.getCourseName();
                }
                studentFound.setStudentName(newStudentName);
                studentFound.setSemester(newSemester);
                studentFound.setCourseName(newCourseNameStr);

                System.out.println("Update success.");

            } else {
                arr.remove(studentFound);
                System.out.println("Delete success.");
            }

        }
    }

    public boolean isUpdated(String value) {
        return !value.isBlank();
    }

    public String courseSelected(int id) {
        switch (id) {
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

    //REPORT
    public void report(ArrayList<StudentModel> arr) {
        ArrayList<StudentModel> listReport = arr;
        if (listReport.isEmpty()) {
            System.out.println("List empty.");
            return;
        }

        Map<String, Map<String, Integer>> reportMap = new HashMap<>();

        for (StudentModel student : listReport) {
            String studentName = student.getStudentName();
            String courseName = student.getCourseName();

            reportMap.computeIfAbsent(studentName, k -> new HashMap<>());
            reportMap.get(studentName).merge(courseName, 1, Integer::sum);
        }

        System.out.printf("%-15s|%-15s|%-15s\n", "Student name", "Course", "Total of Course");

        for (Map.Entry<String, Map<String, Integer>> entry : reportMap.entrySet()) {
            String studentName = entry.getKey();
            for (Map.Entry<String, Integer> courseEntry : entry.getValue().entrySet()) {
                String courseName = courseEntry.getKey();
                int total = courseEntry.getValue();
                System.out.printf("%-15s|%-15s|%-15d\n", studentName, courseName, total);
            }
        }
    }
}
