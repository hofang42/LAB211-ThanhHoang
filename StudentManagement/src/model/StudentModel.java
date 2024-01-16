/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoang
 */
public class StudentModel implements Comparable<StudentModel>{
    protected int id;
    protected String studentName;
    protected int semester;
    protected String courseName;
    protected int totalCourse;

    public StudentModel() {
    }

    public StudentModel(String studentName, int semester, String courseName) {
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    
    
    @Override
    public String toString() {
        return String.format("%-15s%-15s%-15s%-15s\n", id,studentName, semester, courseName);
    }

    @Override
    public int compareTo(StudentModel o) {
        return o.studentName.compareTo(this.studentName);
    }
    
    
    
}
