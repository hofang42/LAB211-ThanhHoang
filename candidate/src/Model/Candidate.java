/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class Candidate {
    protected int id;
    protected String fName;
    protected String lName;
    protected String bDate;
    protected String address;
    protected String phone;
    protected String email;
    protected int type;

    public Candidate(int id, String fName, String lName, String bDate, String address, String phone, String email, int type) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.bDate = bDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

    public Candidate(String fName, String lName, String bDate, String address, String phone, String email) {
        this.fName = fName;
        this.lName = lName;
        this.bDate = bDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public boolean checkCandidateExist(String keyword, int type) {
        String candidateString = (fName + lName).toLowerCase();
        return candidateString.contains(keyword) && this.type == type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
     public String toString() {
        return fName + lName + "|" + bDate + "|"
                + address + "|" + phone + "|" + email + "|"
                + type;
    }
     
     
}
