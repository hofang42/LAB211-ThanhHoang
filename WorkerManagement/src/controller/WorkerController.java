/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.SalaryHistory;
import model.WorkerModel;
import view.Menu;
import view.WorkerView;

/**
 *
 * @author hoang
 */
public class WorkerController extends Menu {

    public WorkerController() {
        super("======== Worker Management ========", new String[]{"Add Worker", "Up salary", "Down salary", "Display Information salary", "Exit"});

    }

    ArrayList<WorkerModel> workerList = new ArrayList<>();
    ArrayList<SalaryHistory> historySalary = new ArrayList<>();
    WorkerView workerView = new WorkerView();
    

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                workerView.addWorker(workerList);
                break;
            case 2:
                workerView.upSalary(workerList, historySalary);
                break;
            case 3:
                workerView.downSalary(workerList, historySalary);
                break;
            case 4:
                workerView.displayWorker(historySalary);
                break;
            case 5:
                System.exit(0);
                break;
        }
    }

}
