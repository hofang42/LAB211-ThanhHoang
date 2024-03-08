/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import model.TaskModel;
import utils.Inputter;
import utils.Validator;

/**
 *
 * @author hoang
 */
public class TaskView {

    Inputter input = new Inputter();
    Validator valid = new Validator();

    public void addTask(ArrayList<TaskModel> taskList) {
        String requirementName = input.getStringNotEmpty("Requirement Name");
        String typeTaskId = input.getTaskTypeName("Task Type");
        String date = input.getDate("Date");
        double from, to;
        do {
            System.out.print("From: ");
            from = input.getDoubleLimit(8, 17.5);
            if (!valid.isValidPlanTime(String.valueOf(from))) {
                System.out.println("Please enter within 8 h-17 h 30 > 8.0, 8.5, 9.0, ⇔ 9.5 ...-> 17.5 ");
            }
        } while (!valid.isValidPlanTime(String.valueOf(from)));
        do {
            System.out.print("To: ");
            to = input.getDoubleLimit(from, 17.5);
            if (!valid.isValidPlanTime(String.valueOf(to))) {
                System.out.println("Please enter within 8 h-17 h 30 > 8.0, 8.5, 9.0, ⇔ 9.5 ...-> 17.5 ");
            }
        } while (!valid.isValidPlanTime(String.valueOf(to)));
        String assignee = input.getStringNotEmpty("Assignee");
        String reviewer = input.getStringNotEmpty("Reviewer");

        TaskModel newTask = new TaskModel(typeTaskId, requirementName, date, from, to, assignee, reviewer);
        createTask(newTask, taskList);
    }

    public void createTask(TaskModel task, ArrayList<TaskModel> arr) {
        int id = arr.size() + 1;
        task.setIdTask(id);
        arr.add(task);
    }

    public void deleteTask(ArrayList<TaskModel> taskList) {
        int id = input.getInt("ID");
        TaskModel taskDel = getTaskById(id, taskList);
        if (taskDel == null) {
            System.out.println("No task found");
            return;
        }
        taskList.remove(taskDel);
    }

    private TaskModel getTaskById(int id, ArrayList<TaskModel> taskList) {
        for (TaskModel task : taskList) {
            if (task.getIdTask() == id) {
                return task;
            }
        }
        return null;
    }

    public void printList(ArrayList<TaskModel> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (TaskModel task : taskList) {
            double planTime = task.getPlanTo() - task.getPlanFrom();
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    task.getIdTask(),
                    task.getRequirementName(),
                    task.getTaskTypeId(),
                    task.getDate(),
                    planTime,
                    task.getAssignee(),
                    task.getReviewer()
            );

        }
    }
}
