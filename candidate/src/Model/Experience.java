/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hoang
 */
public class Experience extends Candidate {
    private String expYear;
    private String proSkill;

    public Experience(String expYear, String proSkill, Candidate c) {
        super(c.id, c.fName, c.lName, c.bDate, c.address, c.phone, c.email, c.type);
        this.expYear = expYear;
        this.proSkill = proSkill;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
    
    
}
