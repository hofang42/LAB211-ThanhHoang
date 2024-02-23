/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.HashMap;
import java.util.Map;
import model.WordModel;
import utils.Inputter;
import utils.Validator;

/**
 *
 * @author hoang
 */
public class WordView {

    Inputter input = new Inputter();
    Validator valid = new Validator();

    public void addWord(HashMap<String, WordModel> dictionary) {
        System.out.println("---------- Add ----------");
        String engWord = "";
        do {
            engWord = input.getStringNotEmpty("Enter English");
            if (valid.isExistWord(dictionary, engWord)) {
                System.out.print("Do you want to update Vietnamese meaning? Y/N: ");
                while (valid.checkInputYN()) {
                    updateWord(dictionary, engWord);
                    return;
                }
            }
        } while (valid.isExistWord(dictionary, engWord));

        String vieWord = input.getStringNotEmpty("Enter Vietnamese");
        WordModel newWord = new WordModel(vieWord);

        dictionary.put(engWord, newWord);
        System.out.println("Successful");
    }

    public void delWord(HashMap<String, WordModel> dictionary) {
        System.out.println("---------- Delete ----------");
        String delWord = input.getStringNotEmpty("Enter English");
        for (Map.Entry<String, WordModel> entry : dictionary.entrySet()) {
            String engWord = entry.getKey();
            if (engWord.equalsIgnoreCase(delWord)) {
                dictionary.remove(delWord);
                System.out.println("Successful");
            }
        }
    }

    public void transWord(HashMap<String, WordModel> dictionary) {
        System.out.println("---------- Translate ----------");
        String transWord = input.getStringNotEmpty("Enter English");
        if (dictionary.get(transWord) == null) {
            System.out.println("Word is not in dictionary");
            return;
        }
        System.out.println("Vietnamese: " + dictionary.get(transWord).toString());
    }

    public void updateWord(HashMap<String, WordModel> dictionary, String engWord) {
        String newVNMeaning = input.getStringNotEmpty("Enter new Vietnamese");
        WordModel updateWord = dictionary.get(engWord);
        WordModel newMeaning = new WordModel(newVNMeaning);
        dictionary.replace(engWord, updateWord, newMeaning);
    }
}
