/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoang
 */
public class DoctorModel{

    private String code;
    private String name;
    private String specialization;
    private int availalbility;

    public DoctorModel(String code, String name, String specialization, int availalbility) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availalbility = availalbility;
    }

    public DoctorModel(String name, String specialization, int availalbility) {
        this.name = name;
        this.specialization = specialization;
        this.availalbility = availalbility;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailalbility() {
        return availalbility;
    }

    public void setAvailalbility(int availalbility) {
        this.availalbility = availalbility;
    }
    
}
