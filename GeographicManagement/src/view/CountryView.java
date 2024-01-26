/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Collections;
import model.EastAsiaCountries;
import utils.Inputter;

/**
 *
 * @author hoang
 */
public class CountryView {
    
    Inputter inputter = new Inputter();
    
    public void addCountryInfomation(ArrayList<EastAsiaCountries> arr){
        EastAsiaCountries eACountry = new EastAsiaCountries();
        eACountry.setCountryCode(inputter.getString("Enter code of country"));
        eACountry.setCountryName(inputter.getString("Enter name of country"));
        boolean flag = true;
        while(flag){
            eACountry.setTotalArea(inputter.getInputFloat("Enter total Area"));
            if (eACountry.getTotalArea() > 0) flag = false;
        }
        eACountry.setCountryTerrain(inputter.getString("Enter terrain of country"));
        arr.add(eACountry);
    }
    
    public void getRecentlyEnterdInfomation(ArrayList<EastAsiaCountries> arr) {  
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area","Terrain");
        arr.get(arr.size() - 1).display();
    }
    
    public void searchInfomationByName(ArrayList<EastAsiaCountries> arr){        
        String countryName = inputter.getString("Enter the name you want to search for");
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area","Terrain");
        for (EastAsiaCountries country : arr) {
            if (country.getCountryName().equalsIgnoreCase(countryName)) {
                country.display();
            }
        }
    }
    
     public void printCountrySorted(ArrayList<EastAsiaCountries> lc) {
        Collections.sort(lc);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (EastAsiaCountries country : lc) {
            country.display();
        }
    }
}
