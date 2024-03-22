/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.TaxCalculatorModel;
import view.TaxCalculatorView;

/**
 *
 * @author hoang
 */
public class TaxCalculatorController {

    TaxCalculatorView view = new TaxCalculatorView();
    TaxCalculatorModel model = view.getInfo();

    double tax = model.calculateTax();
    double deductions = model.calculateDeductions();

    public void excute() {
        view.displayResults(tax, deductions);
    }

}
