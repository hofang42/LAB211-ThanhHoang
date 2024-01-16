/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

import java.util.HashMap;

/**
 *
 * @author hoang
 */
public class CounterModel {
    private HashMap<Character, Integer> charCounter = new HashMap<>();
    private HashMap<String, Integer> wordCounter = new HashMap<>();
    private String inputString;

    public CounterModel() {
    }

    public CounterModel(String inputString) {
        this.inputString = inputString;
    }
    public HashMap<Character, Integer> getCharCounter() {
        return charCounter;
    }

    public void setCharCounter(HashMap<Character, Integer> charCounter) {
        this.charCounter = charCounter;
    }

    public HashMap<String, Integer> getWordCounter() {
        return wordCounter;
    }

    public void setWordCounter(HashMap<String, Integer> wordCounter) {
        this.wordCounter = wordCounter;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

}
