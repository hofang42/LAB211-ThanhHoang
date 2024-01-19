/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.FruitModel;
import view.FruitView;
import view.Menu;

/**
 *
 * @author hoang
 */
public class FruitController extends Menu{

    ArrayList<FruitModel> fruitList = new ArrayList<>();
    
    FruitView fruView = new FruitView();
    
    public FruitController() {
        super("FRUIT SHOP SYSTEM", new String[]{"Create Fruit", "View orders", "Shopping(for buyer)", "Exit"});
    }
       
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                fruView.takeInfoFruit(fruitList);
                break;
            case 2:
                fruView.viewOrders(fruitList);
                break;
            case 3:
                fruView.viewListOfFruit(fruitList);
                fruView.takeOrders(fruitList);
                break;
            case 4:
                System.exit(0);
                break;            
        }
    }
    
}
