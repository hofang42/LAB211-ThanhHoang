/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.ExpenseModel;
import view.ExpenseView;
import view.Menu;

/**
 *
 * @author hoang
 */
public class ExpenseController extends Menu {
    
    public ExpenseController() {
        super("=======Handy Expense program======", new String[]{"Add an expense", "Display all expenses", "Delete an expense", "Quit"});
    }
    
    ExpenseView expenseView = new ExpenseView();
    ArrayList<ExpenseModel> listExpense = new ArrayList<>();
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                expenseView.addNewExpense(listExpense);
                break;
            case 2:
                expenseView.displayExpense(listExpense);
                break;
            case 3:
                expenseView.deleteExpense(listExpense);
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
    
}
