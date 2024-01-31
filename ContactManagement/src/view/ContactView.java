/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import model.ContactModel;
import utils.Inputter;
import utils.Validator;

/**
 *
 * @author hoang
 */
public class ContactView {

    public ContactView() {
    }

    Inputter input = new Inputter();
    
    public void addNewContact(ArrayList<ContactModel> arr) {
        String contName = input.getString("Enter Name");
        String[] nameParts = contName.split("\\s", 2);

        String firstName = nameParts[0];
        String lastName = nameParts.length > 1 ? nameParts[1] : ""; // handle the case when there is no last name
        String group = input.getString("Enter Group");
        String address = input.getString("Enter Address");
        System.out.print("Enter Phone: ");
        String phone = input.checkInputPhone();

        ContactModel newCont = new ContactModel(contName, group, address, phone, firstName, lastName);
        createContact(newCont, arr);
        System.out.println("Successful");
    }

    private void createContact(ContactModel contact, ArrayList<ContactModel> arr) {
        int id = arr.size() + 1;
        contact.setID(id);
        arr.add(contact);
    }
    
    public void printAllContact(ArrayList<ContactModel> arr) {
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        for (ContactModel contact : arr) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getID(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }
    
    public void deleteContactd(ArrayList<ContactModel> arr) {        
        int idDelete = input.getInt("Enter id");
        ContactModel contactDelete = getContactById(arr, idDelete);
        if (contactDelete == null) {
            System.out.println("Not found contact.");
            return;
        } else {
            arr.remove(contactDelete);
        }
        System.out.println("Delete successful.");
    }
    
    private ContactModel getContactById(ArrayList<ContactModel> arr, int idDelete) {
        for (ContactModel contact : arr) {
            if (contact.getID()== idDelete) {
                return contact;
            }
        }
        return null;
    }
}
