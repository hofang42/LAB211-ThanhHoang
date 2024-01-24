/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import model.TextModel;
import utils.FileWorking;

/**
 *
 * @author hoang
 */
public class TextView {

    FileWorking fileW = new FileWorking();

    public TextView() {
    }

    public void displayError(String message) {
        System.out.println("Error: " + message);
    }

    public void displaySuccess() {
        System.out.println("Text normalization successful");
    }

    public void readDataInput(TextModel txtModel) {
        try {
            System.out.println("Input File");
            System.out.println(fileW.readDocument(txtModel.getInputFile()));
            displaySuccess();
        } catch (IOException ex) {
            displayError("Error");
        }
    }

    public void normalizeData(TextModel txtModel) {
        String tempNormalizeText = "";
        tempNormalizeText = normalizeText(txtModel.getInputFile(), txtModel);
        {
            try {
                fileW.writeToFile(tempNormalizeText);
            } catch (IOException ex) {
                displayError("");
            } catch (NullPointerException ex) {
                displayError("Null");
            }
        }
        displaySuccess();
    }

    public void readDataOutput(TextModel txtModel) {
        try {
            System.out.println("Output File");
            System.out.println(fileW.readDocument(txtModel.getOutputFile()));
        } catch (IOException ex) {
            displayError("");
        } catch (NullPointerException ex) {
            displayError("Null");
        }
    }

    public String normalizeText(String inputFile, TextModel txtModel) {
        StringBuilder normalizedText = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)))) {
            int countLine = countLine(txtModel);
            int count = 1;
            String line;
            while ((line = br.readLine()) != null) {
                if (isLineEmpty(line)) {
                    continue;
                }
                line = formatOneSpace(line);
                line = formatSpecialCharacters(line);
                line = afterDotUpperCase(line);
//                line = noSpaceQuotes(line);
                line = spaceQuotes(line);
                line = firstUpercase(line);
                line = lastAddDot(line);

                normalizedText.append(line);

                if (count < countLine) {
                    normalizedText.append(System.getProperty("line.separator"));
                }
                count++;
            }
        } catch (FileNotFoundException ex) {
            displayError("Can't not found");
        } catch (IOException ex) {
            displayError("");
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

//    public String noSpaceQuotes(String line) {
//        int countQuetes = 0;
//        StringBuilder stringBuilder = new StringBuilder(line);
//        for (int i = 0; i < stringBuilder.length(); i++) {
//            if (stringBuilder.charAt(i) == '"' && countQuetes % 2 == 0) {
//                stringBuilder.deleteCharAt(i + 1);
//                countQuetes++;
//            } else if (stringBuilder.charAt(i) == '"' && countQuetes % 2 == 1
//                    && i != 0) {
//                stringBuilder.deleteCharAt(i - 1);
//                countQuetes++;
//            }
//        }
//        return stringBuilder.toString().trim();
//    }
    public String spaceQuotes(String line) {
        StringBuilder stringBuilder = new StringBuilder(line);
        boolean inQuotes = false;

        for (int i = 0; i < stringBuilder.length(); i++) {
            char currentChar = stringBuilder.charAt(i);

            if (currentChar == '"') {
                inQuotes = !inQuotes;
            } else if (currentChar == ' ' && inQuotes) {
                stringBuilder.deleteCharAt(i);
                i--;
            }
        }

        return stringBuilder.toString().trim();
    }

    public String firstUpercase(String line) {
        line = line.toLowerCase();
        String firstLetter = line.substring(0, 1);
        String remainingLetters = line.substring(1, line.length());
        // change the first letter to uppercase
        firstLetter = firstLetter.toUpperCase();
        // join the two substrings
        line = firstLetter + remainingLetters;

        StringBuilder sb = new StringBuilder(line);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '.') {
                char pos = sb.charAt(i + 2);
                sb.setCharAt(i + 2, Character.toUpperCase(pos));
            }
        }

        return sb.toString();
    }

    public String lastAddDot(String line) {
        if (line.endsWith(".")) {
            return line;
        } else {
            return line + ".";
        }
    }

    public int countLine(TextModel txtModel) {
        int countLine = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(txtModel.getInputFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    countLine++;
                }
            }
        } catch (FileNotFoundException ex) {
            displayError("File not found");
        } catch (IOException ex) {
            displayError("");
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
