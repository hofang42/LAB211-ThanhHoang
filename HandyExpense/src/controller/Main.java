/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author hoang
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String inputDate = "15/06/2004";
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date = inputFormat.parse(inputDate);

            SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy");
            String formattedDate = outputFormat.format(date);

            System.out.println("Formatted date: " + formattedDate);
        } catch (java.text.ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
    }
}

