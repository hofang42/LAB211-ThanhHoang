/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import model.DoctorModel;
import utils.DoctorFile;
import view.DoctorView;
import view.Menu;

/**
 *
 * @author hoang
 */
public class DoctorController extends Menu{

    public DoctorController() {
        super("========== Doctor Monagement ==========", new String[]{"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Print out list Doctor", "Save to file" ,"Exit"});
    }

    DoctorFile file = new DoctorFile();
//    HashMap<String, DoctorModel> doctorList = new HashMap<>();
    HashMap<String, DoctorModel> doctorList = file.loadData("doctor.dat");
    DoctorView docView = new DoctorView();
    
    
    @Override
    public void execute(int n) {
        switch(n){
            case 1:
                docView.addDoctor(doctorList);
                break;
            case 2:
                docView.updateDoctor(doctorList);
                break;
            case 3:
                docView.deleteDoctor(doctorList);
                break;
            case 4:
                docView.searchDoctor(doctorList);
                break;
            case 5:
                docView.printAllDoctor(doctorList);
            case 6:
                file.writeToFile(doctorList);
                break;
            case 7:
                break;
//                System.exit(0);
        }
    }
    
}
