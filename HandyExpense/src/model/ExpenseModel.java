/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoang
 */
public class ExpenseModel {

    private int id;
    private String date;
    private int quantity;
    private String content;

    public ExpenseModel() {
    }

    public ExpenseModel(int id, String date, int quantity, String content) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.content = content;
    }

    public ExpenseModel(String date, int quantity, String content) {
        this.date = date;
        this.quantity = quantity;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
