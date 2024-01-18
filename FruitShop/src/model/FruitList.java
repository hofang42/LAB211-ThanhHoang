/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author hoang
 */
public class FruitList {

    private ArrayList<FruitModel> fruitList;

    public FruitList() {
        fruitList = new ArrayList<>();
    }

    public ArrayList<FruitModel> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<FruitModel> fruitList) {
        this.fruitList = fruitList;
    }

    public int size() {
        return fruitList.size();
    }

    public void createFruit(FruitModel fruit) {
        int id = size() + 1;
        fruit.setFruitId(id);
        fruitList.add(fruit);
    }

    public FruitModel get(int id){
        return fruitList.get(id);
    }
}
