/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.HashMap;
import java.util.Map;
import model.WordModel;

/**
 *
 * @author hoang
 */
public class Validator {

    public boolean isExistWord(HashMap<String, WordModel> dictionary, String newWord) {
        for (Map.Entry<String, WordModel> entry : dictionary.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(newWord)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = new Inputter().checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
}
