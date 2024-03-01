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

    private String diskDriver;
    private String fileName;
    private String fileExtension;
    private String foldersName;
    private String path;
    private String pathWithAll;

    public FileModel(String diskDriver, String fileName, String fileExtension, String foldersName, String path, String pathWithAll) {
        this.diskDriver = diskDriver;
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.foldersName = foldersName;
        this.path = path;
        this.pathWithAll = pathWithAll;
    }

    public FileModel(String pathWithAll) {
        this.pathWithAll = pathWithAll;
    }

    public FileModel() {
    }

    public String getDiskDriver() {
        return diskDriver;
    }

    public void setDiskDriver(String diskDriver) {
        this.diskDriver = diskDriver;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getFoldersName() {
        return foldersName;
    }

    public void setFoldersName(String foldersName) {
        this.foldersName = foldersName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPathWithAll() {
        return pathWithAll;
    }

    public void setPathWithAll(String pathWithAll) {
        this.pathWithAll = pathWithAll;
    }
    
    

}
