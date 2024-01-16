/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.Validation;
import Model.CounterModel;
import View.Menu;
import java.util.StringTokenizer;

/**
 *
 * @author hoang
 */
public class CounterController extends Menu {

    public CounterController() {
        super("Letter and character count. ", new String[]{"Characters Count & Word Count", "Exit"});
    }

    Validation valid = new Validation();

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                String str = valid.getString("Enter string");
                countFunction(str);
                display();
                break;
            case 2:
                System.exit(0);
                break;
        }
    }

    CounterModel strInput = new CounterModel();

    public void countFunction(String inputString) {
        for (char ch : inputString.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                continue;
            }
            if (!strInput.getCharCounter().containsKey(ch)) {
                strInput.getCharCounter().put(ch, 1);
            } else {
                strInput.getCharCounter().put(ch, ((int) strInput.getCharCounter().get(ch)) + 1);
            }
        }
        StringTokenizer tokenizer = new StringTokenizer(inputString);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!strInput.getWordCounter().containsKey(token)) {
                strInput.getWordCounter().put(token, 1);
            } else {
                strInput.getWordCounter().put(token, ((int) strInput.getWordCounter().get(token)) + 1);
            }
        }
    }

    public void display() {
        System.out.println("Number of characters: " + strInput.getCharCounter());
        System.out.println("Number of words: " + strInput.getWordCounter());
        System.out.println();
    }
}
