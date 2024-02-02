/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import model.DoctorModel;

/**
 *
 * @author hoang
 */
public class FileSave {

    public void writeToFile(String normalizedText) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("doctor.dat"))) {
            StringReader stringReader = new StringReader(normalizedText);
            BufferedReader bufferedReader = new BufferedReader(stringReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException ioException) {
            throw new IOException("An error occurred while writing to the output file", ioException);
        }
    }
}
