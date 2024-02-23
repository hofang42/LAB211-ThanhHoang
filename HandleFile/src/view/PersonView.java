/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Collections;
import model.FileModel;
import model.PersonModel;
import utils.FileLoad;
import utils.Inputter;

/**
 *
 * @author hoang
 */
public class PersonView {

    Inputter input = new Inputter();
    FileLoad file = new FileLoad();

    public void findPersonInfo(FileModel fileModel) {
        String filePath = input.getStringNotEmpty("Enter Path");
        double money = input.getDouble("Enter Money");
        FileModel file = new FileModel(filePath);
        ArrayList<PersonModel> personFound = getPerson(file, money);        
        printPersonFound(personFound);
    }

    private ArrayList getPerson(FileModel fileModel, double money) {
        ArrayList<PersonModel> listPerson = file.loadData(fileModel.getFilePath());
        ArrayList<PersonModel> listFound = new ArrayList<>();
        for (PersonModel p : listPerson) {
            if (p.getMoney() > money) {
                listFound.add(p);
            }
        }
        return listFound;
    }

    private void printPersonFound(ArrayList<PersonModel> personFound) {
        System.out.printf("%-20s%-20s%-20s\n", "Name", "Address", "Money");
        for (PersonModel person : personFound) {
            System.out.printf("%-20s%-20s%-20.1f\n", person.getName(),
                    person.getAddress(), person.getMoney());
        }
        Collections.sort(personFound);
        try{
            System.out.println("Max: " + personFound.get(0).getName());
        System.out.println("Min: " + personFound.get(personFound.size() - 1).getName());
        } catch(IndexOutOfBoundsException e){
            System.out.println("Empty");
        }        
    }
    
    public void copyWordOneTimes(){
        String filePath = input.getStringNotEmpty("Enter Source");
        String desFilePath = input.getStringNotEmpty("Enter new file name");
        FileModel fileModel = new FileModel(filePath, desFilePath);
        ArrayList<PersonModel> personList = getPerson(fileModel, 0);
        file.writeToFile(personList, desFilePath);        
    }
}
