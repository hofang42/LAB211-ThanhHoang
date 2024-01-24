/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import model.TextModel;
import utils.FileWorking;
import view.Menu;
import view.TextView;

/**
 *
 * @author hoang
 */
public class TextController extends Menu {

    public TextController() {
        super("Nomalize Text", new String[]{"Load input file", "Nomarlize text", "Print output file"});
    }

    TextView txtView = new TextView();
    TextModel txtModel = new TextModel("input.txt", "output.txt");
    FileWorking fileW = new FileWorking();

    @Override
    public void execute(int n) {
        String tempNormalizeText = "";
        switch (n) {
            case 1: {
                try {
                    System.out.println("Input File");
                    System.out.println(fileW.readDocument(txtModel.getInputFile()));
                    txtView.displaySuccess();
                } catch (IOException ex) {
                    txtView.displayError("Error");
                }
            }
            break;
            case 2:
                tempNormalizeText = normalizeText(txtModel.getInputFile());
            {
                try {
                    fileW.writeToFile(tempNormalizeText);
                } catch (IOException ex) {
                   txtView.displayError("");
                } catch (NullPointerException ex){
                    txtView.displayError("Null");
                }
            }
                txtView.displaySuccess();
                break;
            case 3: {
                try {
                    System.out.println("Output File");
                    System.out.println(fileW.readDocument(txtModel.getOutputFile()));                    
                } catch (IOException ex) {
                    txtView.displayError("");
                } catch (NullPointerException ex) {
                    txtView.displayError("Null");
                }
            }
            break;

        }
    }

    public String normalizeText(String inputFile) {
        StringBuilder normalizedText = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)))) {
            int countLine = countLine();
            int count = 1;
            String line;
            while ((line = br.readLine()) != null) {
                if (isLineEmpty(line)) {
                    continue;
                }
                line = formatOneSpace(line);
                line = formatSpecialCharacters(line);
                line = afterDotUpperCase(line);
                line = noSpaceQuotes(line);
                line = firstUpercase(line);
                line = lastAddDot(line);

                normalizedText.append(line);

                if (count < countLine) {
                    normalizedText.append(System.getProperty("line.separator"));
                }
                count++;
            }

//            txtView.displaySuccess();
        } catch (FileNotFoundException ex) {
            txtView.displayError("Can't not found");
        } catch (IOException ex) {
            txtView.displayError("");
        }

        return normalizedText.toString();
    }

    public String formatOneSpace(String line) {
        line = line.toLowerCase();
        line = line.replaceAll("\\s+", " ");
        line = formatOneSpaceSpecial(line, ".");
        line = formatOneSpaceSpecial(line, ",");
        line = formatOneSpaceSpecial(line, ":");
        line = formatOneSpaceSpecial(line, "\"");
        return line.trim();
    }

    public String formatOneSpaceSpecial(String line, String character) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = line.split("\\s*\\" + character + "\\s*");

        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(strings[i].trim());
            if (i < strings.length - 1) {
                stringBuilder.append(" " + character + " ");
            }
        }

        return stringBuilder.toString().trim();
    }

    public String formatSpecialCharacters(String line) {
        StringBuilder strBuffer = new StringBuilder(line);
        for (int i = 0; i < strBuffer.length() - 1; i++) {
            if (strBuffer.charAt(i) == ' ' && strBuffer.charAt(i + 1) == '.'
                    || strBuffer.charAt(i + 1) == ','
                    || strBuffer.charAt(i + 1) == ':') {
                strBuffer.deleteCharAt(i);
            }
        }
        return strBuffer.toString().trim();
    }

    public String afterDotUpperCase(String line) {
        StringBuilder strBuffer = new StringBuilder(line);
        boolean capitalizeNext = true;

        for (int i = 0; i < strBuffer.length(); i++) {
            if (capitalizeNext && Character.isLetter(strBuffer.charAt(i))) {
                strBuffer.setCharAt(i, Character.toUpperCase(strBuffer.charAt(i)));
                capitalizeNext = false;
            }

            if (strBuffer.charAt(i) == '.') {
                capitalizeNext = true;
            }
        }

        return strBuffer.toString().trim();
    }

    public String noSpaceQuotes(String line) {
        int countQuetes = 0;
        StringBuilder stringBuilder = new StringBuilder(line);
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '"' && countQuetes % 2 == 0) {
                stringBuilder.deleteCharAt(i + 1);
                countQuetes++;
            } else if (stringBuilder.charAt(i) == '"' && countQuetes % 2 == 1
                    && i != 0) {
                stringBuilder.deleteCharAt(i - 1);
                countQuetes++;
            }
        }
        return stringBuilder.toString().trim();
    }

    public String firstUpercase(String line) {
        StringBuilder stringBuilder = new StringBuilder(line);
        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                stringBuilder.setCharAt(i, Character.toUpperCase(line.charAt(i)));
                break;
            }
        }
        return stringBuilder.toString().trim();
    }

    public String lastAddDot(String line) {
        if (line.endsWith(".")) {
            return line;
        } else {
            return line + ".";
        }
    }

    public int countLine() {
        int countLine = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(txtModel.getInputFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    countLine++;
                }
            }
        } catch (FileNotFoundException ex) {
            txtView.displayError("File not found");
        } catch (IOException ex) {
            txtView.displayError("");
        }
        return countLine;
    }

    public boolean isLineEmpty(String line) {
        if (line.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

}
