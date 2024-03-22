/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author hoang
 */
public class TaxCalculatorModel {

    private double income;
    private List<Child> children;
    private List<Parent> parents;

    public TaxCalculatorModel(double income, List<Child> children, List<Parent> parents) {
        this.income = income;
        this.children = children;
        this.parents = parents;
    }

    public double calculateTax() {
        double deductions = calculateDeductions();
        double taxableIncome = income - deductions;
        return calculateTaxAmount(taxableIncome);
    }

    public double calculateDeductions() {
        double deductions = 11000000; // Self deduction
        deductions += calculateChildDeductions();
        deductions += calculateParentDeductions();
        return deductions;
    }

    private double calculateChildDeductions() {
        double childDeductions = 0;
        int eligibleChildCount = 0;
        for (Child child : children) {
            if (child.age < 18 || (child.age >= 18 && child.isStudent)) {
                eligibleChildCount++;
                if (eligibleChildCount <= 2) {
                    childDeductions += (child.age < 18) ? 4400000 : 6000000;
                }
            }
        }
        return childDeductions;
    }

    private double calculateParentDeductions() {
        double parentDeductions = 0;
        int eligibleMotherCount = 0;
        int eligibleFatherCount = 0;

        for (Parent parent : parents) {
            if (parent.isMother && parent.age >= 55) {
                eligibleMotherCount++;
            } else if (!parent.isMother && parent.age >= 60) {
                eligibleFatherCount++;
            }
        }

        if (isOnlyChild()) {
            parentDeductions = (eligibleMotherCount * 4400000) + (eligibleFatherCount * 4400000);
        }

        return parentDeductions;
    }

    private boolean isOnlyChild() {
        return true; // Assuming the person is an only child
    }

    private double calculateTaxAmount(double taxableIncome) {
        double taxRate;
        if (taxableIncome <= 4000000) {
            taxRate = 0.05;
        } else if (taxableIncome <= 6000000) {
            taxRate = 0.1;
        } else if (taxableIncome <= 10000000) {
            taxRate = 0.15;
        } else {
            taxRate = 0.2;
        }
        return taxableIncome * taxRate;
    }
}
