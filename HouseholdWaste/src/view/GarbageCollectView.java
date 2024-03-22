/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.GarbageCollectModel;
import utils.Inputter;

/**
 *
 * @author hoang
 */
public class GarbageCollectView {

    Inputter input = new Inputter();

    public void collectGarbage(GarbageCollectModel garbageCollect) {
        String[] garbageInput = input.getString("Enter the amount of garbage at each station separated by spaces").split("\\s");

        for (String s : garbageInput) {
            int garbage = Integer.parseInt(s);
            addGarbage(garbageCollect, garbage);
            System.out.println("Total garbage: " + garbageCollect.getTotalGarbage());
            System.out.println("Total Time: " + garbageCollect.getTime());
            System.out.println("Total Cost: " + garbageCollect.getTotalCost());
        }

        finalizeCollection(garbageCollect);
        displayTotalCost(garbageCollect);
    }

    public void addGarbage(GarbageCollectModel garbageCollect, int garbage) {

        garbageCollect.setTotalGarbage(garbageCollect.getTotalGarbage() + garbage);
        garbageCollect.setTime(garbageCollect.getTime() + 8); // Time to load garbage at a station
        if (garbageCollect.getTotalGarbage() >= garbageCollect.getMaxCapacity()) {
            dumpGarbage(garbageCollect);
        }
    }

    public void dumpGarbage(GarbageCollectModel garbageCollect) {
//        double remainingGarbage = garbageCollect.getTotalGarbage() - garbageCollect.getMaxCapacity();
        int dumpTime = 30; // Time to go to and from the dump
        double costPerHour = 120000;
        double dumpCost = 57000;

        double timeToDump = ((double) (garbageCollect.getTime() + dumpTime)) / 60; // Convert minutes to hours
        double dumpCostTotal = timeToDump * costPerHour + dumpCost;

        garbageCollect.setTotalCost(garbageCollect.getTotalCost() + dumpCostTotal);
        garbageCollect.setTotalGarbage(0);
//        garbageCollect.setTime();
        garbageCollect.setTime(garbageCollect.getTime() + dumpTime); // Update total time
    }

    public void finalizeCollection(GarbageCollectModel garbageCollect) {
        if (garbageCollect.getTotalGarbage() > 0) {
            int dumpTime = 30; // Time to go to and from the dump
            double costPerHour = 120000;
            double dumpCost = 57000;

            double timeToDump = ((double) (garbageCollect.getTime() + dumpTime)) / 60;// Convert minutes to hours
            double dumpCostTotal = timeToDump * costPerHour + dumpCost;

            garbageCollect.setTotalCost(garbageCollect.getTotalCost() + dumpCostTotal);
//            garbageCollect.setTime(0);
            garbageCollect.setTime(garbageCollect.getTime() + dumpTime); // Update total time
        }
    }

    public void displayTotalCost(GarbageCollectModel garbageCollect) {
        System.out.println("The total cost is " + garbageCollect.getTotalCost() + " VND");
    }
}
