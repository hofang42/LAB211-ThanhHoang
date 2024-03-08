/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import model.ExpenseModel;
import utils.Inputter;
import utils.Validator;

/**
 *
 * @author hoang
 */
public class ExpenseView {

    Inputter input = new Inputter();
    
        public void addNewExpense(ArrayList<ExpenseModel> listExpense) {
        String date = input.getDate("Enter Date");
        int quantity = input.getInt("Enter Amount");
        String content = input.getStringNotEmpty("Enter Content");

        ExpenseModel newExpense = new ExpenseModel(date.toUpperCase(), quantity, content);
        createExpense(newExpense, listExpense);
    }

    private void createExpense(ExpenseModel expense, ArrayList<ExpenseModel> arr) {
        int id = arr.size() + 1;
        expense.setId(id);
        arr.add(expense);
    }

    public void deleteExpense(ArrayList<ExpenseModel> listExpense) {
        int id = input.getInt("Enter ID");
        ExpenseModel expenseDel = getExpenseById(id, listExpense);
        if (expenseDel == null) {
            System.out.println("Can not found expense");
        }
        listExpense.remove(expenseDel);
    }

    private ExpenseModel getExpenseById(int id, ArrayList<ExpenseModel> expenseList) {
        for (ExpenseModel expense : expenseList) {
            if (expense.getId() == id) {
                return expense;
            }
        }
        return null;
    }

    public void displayExpense(ArrayList<ExpenseModel> listExpense) {
        if (listExpense.isEmpty()) {
            System.out.println("List Expenses empty");
            return;
        }
        int total = 0;
        System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount of money", "Content");
        for (ExpenseModel expense : listExpense) {
            System.out.printf("%-7d%-20s%-20d%-20s\n", expense.getId(), expense.getDate(),
                    expense.getQuantity(), expense.getContent());
            total += expense.getQuantity();
        }
        System.out.printf("Total: %-20d\n", total);
    }
}
