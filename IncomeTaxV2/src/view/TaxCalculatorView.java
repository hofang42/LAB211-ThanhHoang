/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import model.Child;
import model.Parent;
import model.TaxCalculatorModel;
import utils.Inputter;

/**
 *
 * @author hoang
 */
public class TaxCalculatorView {

    Inputter input = new Inputter();

    public TaxCalculatorModel getInfo() {
        double income = input.getDouble("Enter your total income");

        List<Child> children = new ArrayList<>();
        int childCount = input.getInt("Enter the number of children");

        for (int i = 0; i < childCount; i++) {
            int age = input.getInt("Enter the age of child");

            boolean isStudent = getBoolean(input.getInt("Is this child a student? (1.true/2.false)"));

            children.add(new Child(age, isStudent));
        }

        List<Parent> parents = new ArrayList<>();
        int parentCount = input.getInt("Enter the number of parents");

        for (int i = 0; i < parentCount; i++) {
            boolean sex = getBoolean(input.getInt("Is this mother? (1.true/2.false)"));
            int age = input.getInt("Enter the age of parent " + (i + 1));

            parents.add(new Parent(age, sex));
        }
        return new TaxCalculatorModel(income, children, parents);
    }

    public void displayResults(double tax, double deductions) {
        if (tax < 0) {
            tax = 0;
        }
        System.out.printf("Tax to be paid: %.2f VND%n", tax);
        System.out.printf("Total deductions: %.2f VND%n", deductions);
    }

    public boolean getBoolean(int num) {
        return num == 1;
    }
}
