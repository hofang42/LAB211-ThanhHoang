/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.QuadraticModel;
import model.SuperlativeModel;
import view.Menu;
import view.SolvingView;

/**
 *
 * @author hoang
 */
public class SolvingController extends Menu {

    public SolvingController() {
        super("\n======== Equation Program ========", new String[]{"Calculate Superlative Equation", "Calculate Quadratic Equation", "Exit"});
    }

    SuperlativeModel spModel = new SuperlativeModel();
    QuadraticModel quadModel = new QuadraticModel();
    SolvingView solView = new SolvingView();

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                solView.getCoefficientsSuperlative(spModel);
                solView.superlativeEquation(spModel);
                break;
            case 2:
                solView.getCoefficientsQuadratic(quadModel);
                solView.quadraticEquation(quadModel);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                break;

        }
    }

}
