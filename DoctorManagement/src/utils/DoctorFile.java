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
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import model.DoctorModel;

/**
 *
 * @author hoang
 */
public class DoctorFile {

    Validation val = new Validation();

    public HashMap<String, DoctorModel> loadData(String fileName) {
        HashMap<String, DoctorModel> doctorList = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] arr = line.split("\\|");
                    if (arr.length != 4) {
                        System.out.println("Invalid line: " + line);
                        continue;
                    }
                    String code = arr[0];
                    String name = arr[1];
                    String spec = arr[2];
                    int avai = Integer.parseInt(arr[3]);

                    if (val.isValidCode(code)) {
                        DoctorModel doctor = new DoctorModel(name, spec, avai);
                        doctor.setCode(code);
                        doctorList.put(code, doctor);
                    } else {
                        System.out.println("Invalid data: " + line);
                    }

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

    public void writeToFile(HashMap<String, DoctorModel> codeMap){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("doctor.dat"))) {
            for (Map.Entry<String, DoctorModel> entry : codeMap.entrySet()) {
                String key = entry.getKey();
                DoctorModel values = entry.getValue();

                // Access properties from DoctorModel
                String name = values.getName();
                String spec = values.getSpecialization();
                int avai = values.getAvailalbility();

                // Using "|" as a separator between key and values
                writer.write(key + "|" + name + "|" + spec + "|" + avai);
                writer.newLine();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
