/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.PersonModel;
import view.PersonView;

/**
 *
 * @author hoang
 */
public class PersonController {
    
    public PersonController() {
    }
    
    PersonView personView = new PersonView();
    ArrayList<PersonModel> listPerson = new ArrayList<>();

    public void excute() {
        for (int i = 0; i <= 2; i++) {
            personView.addPerson(listPerson);            
        }
        personView.printInfo(listPerson);
    }
}
