/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.FileModel;
import utils.Inputter;

/**
 *
 * @author hoang
 */
public class FileView {

    Inputter input = new Inputter();

    public FileView() {
        System.out.println("===== Analysis Path Program =====");
    }

    public void getInputPath(FileModel file) {
        String path = input.getStringNotEmpty("Please input Path");
        file.setPathWithAll(path);
        String fileName = getFileName(file);
        String fileExtension = getFileExtension(file);
        String fileDisk = getDiskDriver(file);
        String foldersName = getFoldersName(file);
        String filePath = getFilePath(file);
        file.setDiskDriver(fileDisk);
        file.setFileExtension(fileExtension);
        file.setFileName(fileName);
        file.setFoldersName(foldersName);
        file.setPath(filePath);
    }

    public String getFileName(FileModel file) {
        String fileName = "";
        int lastIndex = file.getPathWithAll().lastIndexOf("\\");        
        int lastIndexExtension = file.getPathWithAll().lastIndexOf(".");
        if (lastIndexExtension == -1) lastIndexExtension = lastIndex+1;
        try {
            fileName = file.getPathWithAll().substring(lastIndex + 1, lastIndexExtension);
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public String getFileExtension(FileModel file) {
        String fileExtension = "";
        int lastIndexExtension = file.getPathWithAll().lastIndexOf(".");
        try {
            fileExtension = file.getPathWithAll().substring(lastIndexExtension + 1, file.getPathWithAll().length());
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return fileExtension;
    }

    public String getDiskDriver(FileModel file) {
        int indexDisk = file.getPathWithAll().indexOf(":\\");
        String disk = "";
        try {
            disk = file.getPathWithAll().substring(0, indexDisk);
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return disk;
    }

    public String getFoldersName(FileModel file) {
        int indexDisk = file.getPathWithAll().indexOf(":\\");
        int lastIndex = file.getPathWithAll().lastIndexOf("\\");
        String foldersName = "";
        try {
            foldersName = file.getPathWithAll().substring(indexDisk + 2, lastIndex);
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return foldersName;
    }

    public String getFilePath(FileModel file) {
        String path = "";
        try {
            path = file.getPathWithAll().substring(0, file.getPathWithAll().lastIndexOf("\\"));
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return path;
    }

    public void printInfo(FileModel file) {
        try {
            System.out.println("----- Result Analysis -----");
            System.out.println("Disk: " + file.getDiskDriver());
            System.out.println("Extension: " + file.getFileExtension());
            System.out.println("File Name: " + file.getFileName());
            System.out.println("Path: " + file.getPath());
            System.out.println("Folders: " + "[" + file.getFoldersName() + "]");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Can not find file");
        }

    }
}
