/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.ContactModel;
import utils.FileLoad;
import view.ContactView;
import view.Menu;

/**
 *
 * @author hoang
 */
public class ContactController extends Menu{

    public ContactController() {
        super("======== Contact Program ========", new String[] {"Add a Contact", "Display all Contact", "Delete a Contact", "Exit"});
    }
    private FileLoad file = new FileLoad();
//    ArrayList<ContactModel> contactList = new ArrayList<>();
     ArrayList<ContactModel> contactList = file.loadData("input.txt");
    ContactView contView = new ContactView();
    
    
    @Override
    public void execute(int n) {
        switch(n){
            case 1:
                contView.addNewContact(contactList);
                break;
            case 2:
                contView.printAllContact(contactList);
                break;
            case 3:
                contView.deleteContactd(contactList);
                break;
            case 4:
                System.exit(0);
                break;
                
        }
    }
    
}
