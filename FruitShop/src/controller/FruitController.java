/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Hashtable;
import model.FruitModel;
import view.FruitView;
import view.Menu;

/**
 *
 * @author hoang
 */
public class FruitController extends Menu {

    private ArrayList<FruitModel> fruitList = new ArrayList<>();
    private Hashtable<String, ArrayList<FruitModel>> orders = new Hashtable();
    private FruitView fruView = new FruitView();

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
                fruView.viewOrders(orders);
                break;
            case 3:
                fruView.viewListOfFruit(fruitList);
                fruView.takeOrders(fruitList, orders);
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

}
