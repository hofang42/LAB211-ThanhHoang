/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoang
 */
public class AccountModel {

    private String account;
    private String password;
    private Locate location;

    public AccountModel() {
    }

    public AccountModel(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public AccountModel(String account, String password, Locate location) {
        this.account = account;
        this.password = password;
        this.location = location;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Locate getLocation() {
        return location;
    }

    public void setLocation(Locate location) {
        this.location = location;
    }

}
