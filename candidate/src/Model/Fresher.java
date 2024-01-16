/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hoang
 */
public class Fresher extends Candidate {
    private String graduationDate;
    private String rankGraduation;
    private String universityName;

    public Fresher(String graduationDate, String rankGraduation, String universityName, int id, String fName, String lName, String bDate, String address, String phone, String email, int type) {
        super(id, fName, lName, bDate, address, phone, email, type);
        this.graduationDate = graduationDate;
        this.rankGraduation = rankGraduation;
        this.universityName = universityName;
    }
    
     public Fresher(String graduationDate, String rankGraduation, String universityName, Candidate c) {
        super(c.id, c.fName, c.lName, c.bDate, c.address, c.phone, c.email, c.type);
        this.graduationDate = graduationDate;
        this.rankGraduation = rankGraduation;
        this.universityName = universityName;
    }


    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getRankGraduation() {
        return rankGraduation;
    }

    public void setRankGraduation(String rankGraduation) {
        this.rankGraduation = rankGraduation;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    
    
    
}
