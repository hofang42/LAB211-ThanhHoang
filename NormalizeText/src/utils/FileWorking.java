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
import model.TextModel;

/**
 *
 * @author hoang
 */
public class FileWorking {

    TextModel txtModel = new TextModel();
    
    public String readDocument(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder document = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                document.append(line).append("\n");
            }
            return document.toString();
        } catch (IOException e) {
            throw new IOException("Error reading input file", e);
        }
    }

    public void writeToFile(String normalizedText) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(txtModel.getOutputFile()))) {
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
