/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import View.Menu;
import View.SearchMenu;
import View.SortMenu;
import java.util.InputMismatchException;

/**
 *
 * @author hoang
 */
public class Main extends Menu {

    /**
     * @param args the command line arguments
     */
    public Main() {
        super("LAB211 Sort", new String[]{"Sort", "Search", "Exit"});
//        SortMenu sortM = new SortMenu(title, options);
//        sortM.run();
    }
    String title = "Sort Menu";
    String title2 = "Search Menu";
    String options[] = {"Bubble Sort", "Quick Sort", "Back to Main Menu"};
    String[] option2 = {"Liner search", "Binary search", "Back to the menu"};

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                SortMenu sortM = new SortMenu(title, options);
                sortM.run();
                break;
            case 2:
                SearchMenu search = new SearchMenu(title2, option2);
                search.run();
            case 3:
                System.exit(0);
            default:
                System.out.println("Please enter valid number");
        }
    }

    public static void main(String[] args) {
        boolean cont = true;
        while (cont) {
            try {
                Main m = new Main();
                m.run();
                cont = false;
            } catch (InputMismatchException e) {
                System.out.println("is not a number");

            }
        }
    }
}
