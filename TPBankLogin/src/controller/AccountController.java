/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.AccountModel;
import model.Locate;
import utils.FileLoad;
import view.AccountView;
import view.Menu;

/**
 *
 * @author hoang
 */
public class AccountController extends Menu{

    public AccountController() {
        super("-------Login Program-------", new String[]{"Vietnamese", "English", "Exit"});
    }
    
//    List<AccountModel> accList = new ArrayList<>();
    AccountView accView = new AccountView();
    List<AccountModel> accList = new FileLoad().loadData("BankAccount.txt");
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:       
                accView.loginAccount(accList, Locate.VIE);
                break;
            case 2:
                accView.loginAccount(accList, Locate.ENG);
                break;
            case 3:
                System.exit(0);
        }
    }
    
}
