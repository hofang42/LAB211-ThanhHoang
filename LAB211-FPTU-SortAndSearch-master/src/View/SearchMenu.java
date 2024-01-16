package View;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Controller.Algorithm;
import Model.Element;
import Main.Main;

public class SearchMenu extends Menu {

    public SearchMenu(String msg, String[] mc) {
        super(msg, mc);
    }

    Algorithm al = new Algorithm();
    Element e = al.getEle();

    @Override
    public void execute(int n) {
        int giatri;
        int vitri;
        int arr[];
        switch (n) {
            case 1:
                giatri = al.getIntFromInput("Enter value: ");
                al.inputArray();
                System.out.println("Find value at :");
                vitri = al.linerSearch(giatri);
                if (vitri == -1) {
                    System.out.println("Not found");
                } else {
                    System.out.println("Value " + giatri + " found at : " + vitri);
                }
                break;
            case 2:
                giatri = al.getIntFromInput("Enter value: ");
                al.inputArray();
                arr = e.getArr();
                System.out.println("Array inserted");
                al.displayArr(e, arr);
                al.quickSort(arr, 0, arr.length - 1);
                System.out.println("\nArray after sort");
                al.displayArr(e, arr);
                System.out.println("\nFind value at :");
                vitri = al.binarySearch(arr, giatri, 0, arr.length - 1);
                if (vitri == -1) {
                    System.out.println("Not found");
                } else {
                    System.out.println("Value " + giatri + " found at : " + vitri);
                }
                break;
            case 3:
                new Main().run();
                break;
        }
    }

}
