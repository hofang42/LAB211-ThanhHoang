/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Collections;
import model.PersonModel;
import utils.Inputter;

/**
 *
 * @author hoang
 */
public class PersonView {

    Inputter input = new Inputter();

    public PersonView() {
        System.out.println("===== Management Person Programer =====");

    }

    public void addPerson(ArrayList<PersonModel> listPerson) {
        System.out.println("Input Information of Person");
        String name = input.getStringNotEmpty("Plese input name");
        String address = input.getStringNotEmpty("Plese input address");
        double salary;
        boolean cont;
        do {
            salary = input.getDouble("Please input salary");
            if (salary < 0) {
                System.out.println("Salary is greater than zero");
                cont = true;
            } else {
                cont = false;
            }

        } while (cont);
        PersonModel person = new PersonModel(name, address, salary);
        listPerson.add(person);
    }

    public void printInfo(ArrayList<PersonModel> listPerson) {
        Collections.sort(listPerson);
        for (PersonModel person : listPerson) {
            System.out.println("Infomation of Person you have entered:");
            System.out.println(person.toString());
        }

    }

}
