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
    private String name;
    private String classes;
    private double mark;

    public StudentModel() {
    }    
    
    public StudentModel(String name, String classes, double mark) {
        this.name = name;
        this.classes = classes;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Name: " + name+
                "\nClasses: " +classes.toUpperCase()+
                "\nMark: "+mark;
    }

    @Override
    public int compareTo(StudentModel o) {
        return this.name.compareTo(o.name);
    }
    
    
}
