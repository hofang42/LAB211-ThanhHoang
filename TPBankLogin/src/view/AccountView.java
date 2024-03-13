/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import java.util.Random;
import model.AccountModel;
import model.Locate;
import utils.Inputter;
import utils.Validator;

/**
 *
 * @author hoang
 */
public class AccountView {

    Inputter input = new Inputter();
    Validator valid = new Validator();

    public void setLocate(List<AccountModel> accountList, int choice) {

    }

    public void loginAccount(List<AccountModel> accountList, Locate loc) {
        String password = "";
        String account = "";
        switch (loc) {
            case VIE:
                AccountModel accountLoginVie;
                do {
                    do {
                        account = input.getStringNotEmpty("So tai khoan");
                        if (!valid.isValidAccount(account)) {
                            System.out.println("So tai khoan phai la 1 so va phai co 10 chu so");
                        }
                    } while (!valid.isValidAccount(account));

                    do {
                        password = input.getStringNotEmpty("Mat khau");
                        if (!valid.isValidPassword(password)) {
                            System.out.println("Mat khau phai trong khoang 8-31 ky tu va phai chua ky tu va so");
                        }
                    } while (!valid.isValidPassword(password));
                    accountLoginVie = findAccount(accountList, account, password);
                    if (accountLoginVie == null) {
                        System.out.println("Can not found");
                    }
                } while (accountLoginVie == null);
                String capchaVie = generateCaptcha(5);
                System.out.println(capchaVie);
                String userInputCapchatVie = "";
                do {
                    userInputCapchatVie = input.getString("Nhap 1 ky tu captcha: ");
                    if (!valid.checkCaptcha(capchaVie, userInputCapchatVie)) {
                        System.out.println("Captcha sai");
                    }
                } while (!valid.checkCaptcha(capchaVie, userInputCapchatVie));
                break;
            case ENG:
                AccountModel accountLoginEng;
                do {
                    do {
                        account = input.getStringNotEmpty("Account number");
                        if (!valid.isValidAccount(account)) {
                            System.out.println("Account number must is a number and must have 10 digits");
                        }
                    } while (!valid.isValidAccount(account));

                    do {
                        password = input.getStringNotEmpty("Password");
                        if (!valid.isValidPassword(password)) {
                            System.out.println("Password must be between 8 and 31 characters and must be alphanumeric");
                        }
                    } while (!valid.isValidPassword(password));
                    accountLoginEng = findAccount(accountList, account, password);
                    if (accountLoginEng == null) {
                        System.out.println("Can not found");
                    }
                } while (accountLoginEng == null);
                String capchaEng = generateCaptcha(5);
                System.out.println(capchaEng);
                String userInputCapchatEng = "";
                do {
                    userInputCapchatEng = input.getString("Enter a Captcha characters");
                    if (!valid.checkCaptcha(capchaEng, userInputCapchatEng)) {
                        System.out.println("Captcha incorrect");
                    }
                } while (!valid.checkCaptcha(capchaEng, userInputCapchatEng));
                break;
        }
    }

    private AccountModel findAccount(List<AccountModel> accountList, String account, String pass) {
        for (AccountModel acc : accountList) {
            if (acc.getAccount().equalsIgnoreCase(account) && acc.getPassword().equalsIgnoreCase(pass)) {
                return acc;
            }
        }
        return null;
    }

    private String generateCaptcha(int n) {
        //to generate random integers in the range [0-61]
        Random rand = new Random(62);

        // Characters to be included
        String chrs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        // Generate n characters from above set and
        // add these characters to captcha.
        String captcha = "";
        while (n-- > 0) {
            int index = (int) (Math.random() * 62);
            captcha += chrs.charAt(index);
        }

        return captcha;
    }
}
