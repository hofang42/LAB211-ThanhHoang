/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import model.CustomerModel;
import model.FruitList;
import model.FruitModel;
import utils.Validation;

/**
 *
 * @author hoang
 */
public class FruitView {

    private FruitList fruitList;
    private Validation val = new Validation();
    protected Hashtable<String, FruitList> orders = new Hashtable();
    private FruitList fuirtOrders = new FruitList();
    private Scanner sc = new Scanner(System.in);

    public FruitView() {
        fruitList = new FruitList();
    }

    //CREATE FRUIT
    public void takeInfoFruit() {
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
            fruitList.createFruit(fruit);
            System.out.print("Do you want to continue ? Y/N: ");
        } while (val.checkInputYN());
        System.out.println("-----------------------");
    }

    //VIEW ORDERS
    public void viewOrders() {
        for (Map.Entry<String, FruitList> entry : orders.entrySet()) {
            String customerName = entry.getKey();

            // Print customer name
            System.out.println("Customer: " + customerName);
            double oldAmount = 0;
            double amount = 0;
            // Print order details
            System.out.printf("%-7s | %-10s | %-6s | %-6s%n", "Product", "Quantity", "Price", "Amount");
            for (FruitModel fruit : fuirtOrders.getFruitList()) {
                oldAmount = amount;
                amount = calculateTotalAmount(fruit.getQuantity(), fruit.getPrice());
                System.out.printf("%-7d  %-12s  %-8d$  %-8.2f$%n",
                        fruit.getFruitId() - 1, fruit.getFruitName(), fruit.getQuantity(), amount);
            }

            // Print total amount
            System.out.printf("Total: " + (amount + oldAmount) + "$");
        }
    }

    public double calculateTotalAmount(int quantity, double price) {
        return quantity * price;
    }

    //SHOPPING
    public void viewListOfFruit() {
        System.out.printf("| %-8s | %-18s | %-18s | %-13s |%n", "++ Item ++", "++ Fruit Name ++", "++ Origin ++", "++ Price ++");

        for (FruitModel fruit : fruitList.getFruitList()) {
            System.out.printf("| %-12s %-22s %-22s %-17s |%n", fruit.getFruitId() - 1, fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice() + "$");
        }
    }

    public void takeOrders() {
        do {
            int itemId = 0, quantity = 0;
            System.out.print("Select item: ");
            itemId = val.checkInputIntLimit(0, fruitList.size() - 1);
            String fruitName = getNameById(itemId);
            System.out.println("You selected: " + fruitName);
            System.out.print("Please input quantity: ");
            quantity = val.checkInputIntLimit(1, getQuantityById(itemId));

            double amount = 0;
            FruitModel fruitTemp = new FruitModel(fruitName, getPriceById(itemId), quantity, getOriginById(itemId));
            fuirtOrders.createFruit(fruitTemp);

            System.out.printf("| %-10s | %-10s | %-6s | %-6s |%n", "Product", "Quantity", "Price", "Amount");
            for (FruitModel fruit : fuirtOrders.getFruitList()) {
                amount = calculateTotalAmount(quantity, fruit.getPrice());
                System.out.printf("| %-10s | %-10s | %-6s | %-6s |%n",
                        fruit.getFruitName(), quantity, fruit.getPrice(), amount);
            }
            System.out.println("Total: " + amount + "$");
            String customerName = val.getString("Input your name");
            System.out.print("Do you want to continue ? Y/N: ");
            orders.put(customerName, fuirtOrders);

            int newQuantity = getQuantityById(itemId) - quantity;
            fruitList.get(itemId).setQuantity(newQuantity);
        } while (val.checkInputYN());
    }

    public String getNameById(int id) {
        if (id >= 0 && id < fruitList.size()) {
            return fruitList.get(id).getFruitName();
        } else {
            return null;
        }
    }

    public double getPriceById(int id) {
        if (id >= 0 && id < fruitList.size()) {
            return fruitList.get(id).getPrice();
        } else {
            return -1;
        }
    }

    public String getOriginById(int id) {
        if (id >= 0 && id < fruitList.size()) {
            return fruitList.get(id).getOrigin();
        } else {
            return null;
        }
    }

    public int getQuantityById(int id) {
        if (id >= 0 && id < fruitList.size()) {
            return fruitList.get(id).getQuantity();
        } else {
            return -1;
        }
    }
}
