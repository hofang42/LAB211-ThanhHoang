/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoang
 */
public class Person {

    protected int age;
    protected boolean isStudent;
    protected boolean isOnlyChild;
    protected boolean sex;

    public Person(int age, boolean isStudent, boolean isOnlyChild) {
        this.age = age;
        this.isStudent = isStudent;
        this.isOnlyChild = isOnlyChild;
    }

    public Person(int age, boolean isStudent, boolean isOnlyChild, boolean sex) {
        this.age = age;
        this.isStudent = isStudent;
        this.isOnlyChild = isOnlyChild;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isIsStudent() {
        return isStudent;
    }

    public void setIsStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }

    public boolean isIsOnlyChild() {
        return isOnlyChild;
    }

    public void setIsOnlyChild(boolean isOnlyChild) {
        this.isOnlyChild = isOnlyChild;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

}
