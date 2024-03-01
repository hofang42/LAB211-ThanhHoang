/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoang
 */
public class PersonModel implements Comparable<PersonModel>{
    private String name;
    private String addesss;
    private double salary;

    public PersonModel(String name, String addesss, double salary) {
        this.name = name;
        this.addesss = addesss;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddesss() {
        return addesss;
    }

    public void setAddesss(String addesss) {
        this.addesss = addesss;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(PersonModel o) {
        if (this.salary < o.salary) return -1;
        else if (this.salary > o.salary) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Name: " + name+"\n"
                +"Address: " +addesss+"\n"
                +"Salary: "+salary+"\n";
    }

    
}
