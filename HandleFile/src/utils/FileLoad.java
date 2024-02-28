/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.PersonModel;

/**
 *
 * @author hoang
 */
public class FileLoad {

    Validator val = new Validator();

    public ArrayList<PersonModel> loadData(String fileName) {
        ArrayList<PersonModel> personList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] arr = line.split(";");
                    if (arr.length != 3) {
                        System.out.println("Invalid line: " + line);
                        continue;
                    }
                    String name = arr[0];
                    String address = arr[1];
                    double money = Double.parseDouble(arr[2]);

                    personList.add(new PersonModel(name, address, money));

                } catch (NumberFormatException e) {
                    System.out.println("Error parsing: " + line);
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data");
            System.out.println(e.getMessage());
        }

        return personList;
    }

    public void writeToFile(ArrayList<PersonModel> personList, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\Code\\LAB211\\HandleFile\\src\\"+filePath))) {
            for (PersonModel s : personList) {
                String name = s.getName();
                String address = s.getAddress();
                double money = s.getMoney();
                writer.write(name + ";" + address + ";" + money);
                writer.newLine();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
