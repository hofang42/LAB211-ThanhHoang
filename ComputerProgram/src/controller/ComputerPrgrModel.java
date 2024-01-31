/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.BodyCalModel;
import model.CalculatorModel;
import view.BodyCalView;
import view.CalculatorView;
import view.Menu;

/**
 *
 * @author hoang
 */
public class ComputerPrgrModel extends Menu{

    public ComputerPrgrModel() {
        super("=========== Calculator Program ===========", new String[] {"Normal Calculator", "BMI Calculator", "Exit"});
    }

    CalculatorView calView = new CalculatorView();
    CalculatorModel calModel = new CalculatorModel();
    
    BodyCalView bodyView = new BodyCalView();
    BodyCalModel bodyModel = new BodyCalModel();
    @Override
    public void execute(int n) {
        switch(n){
            case 1:
//                calView.normalCalculator();
                calView.normalCalculator(calModel);
                break;
            case 2:
                bodyView.getInfoBody(bodyModel);
                bodyView.calBMI(bodyModel);
                bodyView.showInfo(bodyModel);
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
    
}
