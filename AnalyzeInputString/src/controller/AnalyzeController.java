/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.StringModel;
import view.AnalyzeView;

/**
 *
 * @author hoang
 */
public class AnalyzeController {
    AnalyzeView analyzeView =new AnalyzeView();
    StringModel data = new StringModel();
    
    public void excute(){        
        analyzeView.getStringInput(data);        
        analyzeView.getNumber(data);
        analyzeView.getCharacter(data);
    }
}
