/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoang
 */
public class WordModel {

    private String vieWord;
    private String engWord;

    public WordModel(String vieWord) {
        this.vieWord = vieWord;
    }

    public String getVieWord() {
        return vieWord;
    }

    public void setVieWord(String vieWord) {
        this.vieWord = vieWord;
    }

    @Override
    public String toString() {
        return vieWord;
    }

    
}
