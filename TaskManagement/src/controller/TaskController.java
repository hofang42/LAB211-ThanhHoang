/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.TaskModel;
import view.Menu;
import view.TaskView;

/**
 *
 * @author hoang
 */
public class TaskController extends Menu {

    public TaskController() {
        super("====== Task Program ======", new String[]{"Add Task", "Delete Task", "Display Task", "Exit"});
    }
    TaskView taskView = new TaskView();
    ArrayList<TaskModel> taskList = new ArrayList<>();

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                taskView.addTask(taskList);
                break;
            case 2:
                taskView.deleteTask(taskList);
                break;
            case 3:
                taskView.printList(taskList);
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

}
