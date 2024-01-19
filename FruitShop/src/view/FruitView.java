/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import model.FruitList;
import model.FruitModel;
import utils.Validation;

/**
 *
 * @author hoang
 */
public class FruitView {

//    private FruitList fruitList;
    private Validation val = new Validation();
    protected Hashtable<String, ArrayList<FruitModel>> orders = new Hashtable();
    private final ArrayList<FruitModel> fuirtOrders = new ArrayList<>();

    public FruitView() {
    }

    //CREATE FRUIT
    public void takeInfoFruit(ArrayList<FruitModel> ls) {
        do {
            String fruitName = "", origin = "";
            boolean flagFName = true, flagOrigin = true;
            while (flagFName) {
                fruitName = val.getString("Enter Fruit Name");
                if (fruitName.isBlank()) {
                    System.out.println("Do not leave blank");
                    flagFName = true;
                } else {
                    flagFName = false;
                }
            }
            double price = val.getDouble("Enter price");
            int quantity = val.getInt("Enter quantity");

            while (flagOrigin) {
                origin = val.getString("Enter origin");
                if (fruitName.isBlank()) {
                    System.out.println("Do not leave blank");
                    flagOrigin = true;
                } else {
                    flagOrigin = false;
                }
            }

            FruitModel fruit = new FruitModel(fruitName, price, quantity, origin);
            createFruit(ls, fruit);
            System.out.print("Do you want to continue ? Y/N: ");
        } while (val.checkInputYN());
        System.out.println();
        System.out.println("-----------------------");
    }

    public void createFruit(ArrayList<FruitModel> ls, FruitModel fruit) {
        int id = ls.size() + 1;
        fruit.setFruitId(id);
        ls.add(fruit);
    }

    //VIEW ORDERS
    public void viewOrders(ArrayList<FruitModel> ls) {
        for (Map.Entry<String, ArrayList<FruitModel>> entry : orders.entrySet()) {
            String customerName = entry.getKey();

            System.out.println("Customer: " + customerName);
            double Totalamount = 0;
            // Print order details
            System.out.printf("%-7s | %-10s | %-6s | %-6s%n", "Product", "Quantity", "Price", "Amount");
            for (FruitModel fruit : fuirtOrders) {

                double amount = calculateTotalAmount(fruit.getQuantity(), fruit.getPrice());
                System.out.printf("%-10s  %-10s  $%-8s  $%-7s%n",
                        fruit.getFruitName(), fruit.getQuantity(), fruit.getPrice(), amount);
                Totalamount += amount;
            }

            // Print total amount
            System.out.printf("Total: " + Totalamount + "$\n");
        }
    }

    public double calculateTotalAmount(int quantity, double price) {
        return quantity * price;
    }

    //SHOPPING
    public void viewListOfFruit(ArrayList<FruitModel> ls) {
        System.out.printf("| %-8s | %-18s | %-18s | %-13s |%n", "++ Item ++", "++ Fruit Name ++", "++ Origin ++", "++ Price ++");

        for (FruitModel fruit : ls) {
            System.out.printf("| %-12s %-22s %-22s $%-17s |%n", fruit.getFruitId() - 1, fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
        }
    }

    public void takeOrders(ArrayList<FruitModel> ls) {
        do {
            int itemId = 0, quantity = 0;
            System.out.print("Select item: ");
            itemId = val.checkInputIntLimit(0, ls.size() - 1);
            String fruitName = getNameById(ls, itemId);
            System.out.println("You selected: " + fruitName);
            if (isStocksEmpty(ls, itemId)) {
                System.out.println("Stock is empty");
                break;
            }

            System.out.print("Please input quantity: ");
            quantity = val.checkInputIntLimit(1, getQuantityById(ls, itemId));

            double amount = 0;
            FruitModel fruitTemp = new FruitModel(fruitName, getPriceById(ls, itemId), quantity, getOriginById(ls, itemId));
            fuirtOrders.add(fruitTemp);

            System.out.printf("| %-10s | %-10s | %-6s | %-6s |%n", "Product", "Quantity", "Price", "Amount");
            for (FruitModel fruit : fuirtOrders) {
                amount = calculateTotalAmount(quantity, fruit.getPrice());
                System.out.printf("| %-10s | %-12s | %-9s | %-6s |%n",
                        fruit.getFruitName(), quantity, fruit.getPrice(), amount);
                System.out.println("Total: " + amount + "$");
            }
            String customerName = val.getString("Input your name");
            orders.put(customerName, fuirtOrders);
            System.out.print("Do you want to continue ? Y/N: ");

            int newQuantity = getQuantityById(ls, itemId) - quantity;
            ls.get(itemId).setQuantity(newQuantity);
//            deleteFruit(itemId);
        } while (val.checkInputYN());
    }

    public String getNameById(ArrayList<FruitModel> ls, int id) {
        if (id >= 0 && id <= ls.size()) {
            return ls.get(id).getFruitName();
        } else {
            return null;
        }
    }

    public double getPriceById(ArrayList<FruitModel> ls, int id) {
        if (id >= 0 && id <= ls.size()) {
            return ls.get(id).getPrice();
        } else {
            return -1;
        }
    }

    public String getOriginById(ArrayList<FruitModel> ls, int id) {
        if (id >= 0 && id <= ls.size()) {
            return ls.get(id).getOrigin();
        } else {
            return null;
        }
    }

    public int getQuantityById(ArrayList<FruitModel> ls, int id) {
        if (id >= 0 && id <= ls.size()) {
            return ls.get(id).getQuantity();
        } else {
            return -1;
        }
    }

    public boolean isStocksEmpty(ArrayList<FruitModel> ls, int id) {
        return getQuantityById(ls, id) == 0;
    }

//    public void deleteFruit(int id){
//        if (getQuantityById(id) == 0) fruitList.delete(id);
//    }
}
