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

    public void addCountryInfomation(ArrayList<EastAsiaCountries> arr) {
        String countryCode = "", countryName, countryTerrain;
        float totalArea = 0;
        int eAsize = arr.size();
        if (eAsize > 11) {
            System.out.println("East Asia just have 11 country");
        } else {
            while (true) {
                countryCode = (inputter.getString("Enter code of country"));
                if (!checkIfExistCode(arr, countryCode)) {
                    break;
                }
            }
            countryName = (inputter.getString("Enter name of country"));
            boolean flag = true;
            while (flag) {
                totalArea = (inputter.getInputFloat("Enter total Area"));
                if (totalArea > 0) {
                    flag = false;
                }
            }
            countryTerrain = (inputter.getString("Enter terrain of country"));
            EastAsiaCountries eACountry = new EastAsiaCountries(countryTerrain, countryCode, countryName, totalArea);
            arr.add(eACountry);
        }
    }

    public void getRecentlyEnterdInfomation(ArrayList<EastAsiaCountries> arr) {
        if (arr.isEmpty()) {
            System.out.println("No country just added");
        } else {
            System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
            arr.get(arr.size() - 1).display();
        }

    }

    public void searchInfomationByName(ArrayList<EastAsiaCountries> arr) {
        String countryName = inputter.getString("Enter the name you want to search for");
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        for (EastAsiaCountries country : arr) {
            if (country.getCountryName().equalsIgnoreCase(countryName)) {
                country.display();
            }
        }
    }

    public boolean checkIfExistCode(ArrayList<EastAsiaCountries> arr, String code) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getCountryCode().equalsIgnoreCase(code)) {
                System.out.println("Country code is exist");
                return true;
            }
        }
        return false;
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
