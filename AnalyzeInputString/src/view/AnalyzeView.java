/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import model.StringModel;
import utils.Inputter;
import utils.Validator;

/**
 *
 * @author hoang
 */
public class AnalyzeView {

    Validator valid = new Validator();
    Inputter input = new Inputter();

    public AnalyzeView() {
        System.out.println("===== Analysis String Program =====");
    }

    public void getStringInput(StringModel data) {

        data.setInputString(input.getStringNotEmpty("Input String"));
    }

    public void getNumber(StringModel data) {
        HashMap<String, ArrayList<Integer>> hmNumber = new LinkedHashMap<>();

        ArrayList<Integer> perfectSquareNum = new ArrayList<>();
        ArrayList<Integer> oddNum = new ArrayList<>();
        ArrayList<Integer> evenNum = new ArrayList<>();
        ArrayList<Integer> allNum = new ArrayList<>();

        String number[] = data.toString().replaceAll("\\D+", ",").split(",");

        for (String s : number) {
            if (valid.isNumberic(s)) {
                int tempNum = Integer.parseInt(s);
                if (tempNum % 2 == 0) {
                    evenNum.add(tempNum);
                } else {
                    oddNum.add(tempNum);
                }

                double sqrt = Math.sqrt(tempNum);
                if (sqrt * sqrt == tempNum) {
                    perfectSquareNum.add(tempNum);
                }

                allNum.add(tempNum);
            }
        }

        hmNumber.put("Perfect Square Numbers: ", perfectSquareNum);
        hmNumber.put("Odd Numbers: ", oddNum);
        hmNumber.put("Even Numbers: ", evenNum);
        hmNumber.put("All Numbers: ", allNum);

        for (HashMap.Entry m : hmNumber.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

    public void getCharacter(StringModel data) {
        HashMap<String, StringBuilder> hmChar = new LinkedHashMap<>();

        StringBuilder upperCase = new StringBuilder();
        StringBuilder lowerCase = new StringBuilder();
        StringBuilder special = new StringBuilder();
        StringBuilder allChar = new StringBuilder();
        upperCase.append(data.toString().replaceAll("\\W|[0-9]|[a-z]", ""));
        lowerCase.append(data.toString().replaceAll("\\W|[0-9]|[A-Z]", ""));
        special.append(data.toString().replaceAll("\\w", ""));
        allChar.append(data.toString().replaceAll("[0-9]", ""));
        
        hmChar.put("Uppercase: ", upperCase);
        hmChar.put("Lowercase: ", lowerCase);
        hmChar.put("Special: ", special);
        hmChar.put("All Character: ", allChar);
        for (HashMap.Entry m : hmChar.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}
