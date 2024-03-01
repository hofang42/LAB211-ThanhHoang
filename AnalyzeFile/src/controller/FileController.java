/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.FileModel;
import view.FileView;

/**
 *
 * @author hoang
 */
public class FileController {

    public FileController() {
        
    }
    
    FileView fileView = new FileView();
    FileModel file = new FileModel();
    
    public void excute(){
        fileView.getInputPath(file);
        fileView.printInfo(file);
    }
   
}
