/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.EastAsiaCountries;
import view.CountryView;
import view.Menu;

/**
 *
 * @author hoang
 */
public class ManageEastAsiaCountries extends Menu{

    ArrayList<EastAsiaCountries> arrEastAsia = new ArrayList<>();
    CountryView countryView = new CountryView();
    
    public ManageEastAsiaCountries() {
        super("\t\t\t\tMENU",
                new String[]{"Input the infomation of 11 countries in East Asia",
                    "Display the information of country you've just input",
                    "Search the information of country by user-entered name",
                    "Display the information of countries sorted name in ascending order",
                    "Exit"});
    }

    @Override
    public void execute(int n) {
         switch(n){
             case 1:
                 countryView.addCountryInfomation( arrEastAsia);
                 break;
             case 2:
                 countryView.getRecentlyEnterdInfomation(arrEastAsia);
                 break;
             case 3:
                 countryView.searchInfomationByName(arrEastAsia);
                 break;
             case 4:
                 countryView.printCountrySorted(arrEastAsia);
                 break;
             case 5:
                 System.exit(0);
                     
         }
    }

}
