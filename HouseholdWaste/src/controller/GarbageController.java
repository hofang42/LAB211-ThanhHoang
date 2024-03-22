/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.GarbageCollectModel;
import view.GarbageCollectView;

/**
 *
 * @author hoang
 */
public class GarbageController {
    
    GarbageCollectView view = new GarbageCollectView();
    GarbageCollectModel model = new GarbageCollectModel();
    
    public void excute(){
        view.collectGarbage(model);
    }

   
}
