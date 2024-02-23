/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoang
 */
public class FileModel {
    private String filePath;
    private String destinatePath;

    public FileModel() {
    }
  
    public FileModel(String filePath) {
        this.filePath = filePath;
    }

    public FileModel(String filePath, String destinatePath) {
        this.filePath = filePath;
        this.destinatePath = destinatePath;
    }

    
    
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDestinatePath() {
        return destinatePath;
    }

    public void setDestinatePath(String destinatePath) {
        this.destinatePath = destinatePath;
    }
    
    
}
