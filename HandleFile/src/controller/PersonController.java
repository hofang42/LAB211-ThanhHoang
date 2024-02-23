/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.FileModel;
import view.Menu;
import view.PersonView;

/**
 *
 * @author hoang
 */
public class PersonController extends Menu{

    public PersonController() {
        super("========== File Processing ==========", new String[]{"Find person info", "Copy Text to new file", "Exit"});
    }

    PersonView perView = new PersonView();
    FileModel fileModel = new FileModel();
    
    @Override
    public void execute(int n) {
        switch(n){
            case 1:
                perView.findPersonInfo(fileModel);
                break;
            case 2:  
                perView.copyWordOneTimes();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
    
}
