/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoang
 */
public class GarbageCollectModel {

    private int time;
    private double totalCost;
    private double totalGarbage;
    private final double maxCapacity = 10 * 1000;

    public GarbageCollectModel() {
        time = 0;
        totalCost = 0;
        totalGarbage = 0;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getTotalGarbage() {
        return totalGarbage;
    }

    public void setTotalGarbage(double totalGarbage) {
        this.totalGarbage = totalGarbage;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }
}
