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
import java.util.HashMap;
import java.util.Map;
import model.WordModel;

/**
 *
 * @author hoang
 */
public class FileLoad {

    Validator val = new Validator();

    public HashMap<String, WordModel> loadData(String fileName) {
        HashMap<String, WordModel> doctorList = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] arr = line.split("\\|");
                    if (arr.length != 2) {
                        System.out.println("Invalid line: " + line);
                        continue;
                    }
                    String engWord = arr[0];
                    String vieWord = arr[1];

                    WordModel newWord = new WordModel(vieWord);
                    doctorList.put(engWord, newWord);

                } catch (NumberFormatException e) {
                    System.out.println("Error parsing: " + line);
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data");
            System.out.println(e.getMessage());
        }

        return doctorList;
    }

    public void writeToFile(HashMap<String, WordModel> codeMap) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dictionary.dat"))) {
            for (Map.Entry<String, WordModel> entry : codeMap.entrySet()) {
                String key = entry.getKey();
                WordModel values = entry.getValue();

                String vieWord = values.getVieWord();

                writer.write(key + "|" + vieWord);
                writer.newLine();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
