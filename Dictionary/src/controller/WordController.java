/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import model.WordModel;
import utils.FileLoad;
import view.Menu;
import view.WordView;

/**
 *
 * @author hoang
 */
public class WordController extends Menu {

    public WordController() {
        super("======== Dictionary program ========", new String[]{"Add Word", "Delete Word", "Translate", "Exit"});
    }

    WordView wordView = new WordView();
    FileLoad file = new FileLoad();
//    HashMap<String, WordModel> dictionary = new HashMap<>();
    HashMap<String, WordModel> dictionary = file.loadData("dictionary.dat");

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                wordView.addWord(dictionary);
                file.writeToFile(dictionary);
                break;
            case 2:
                wordView.delWord(dictionary);
                break;
            case 3:
                wordView.transWord(dictionary);
                break;
            case 4:
                System.exit(0);
        }
    }

}
