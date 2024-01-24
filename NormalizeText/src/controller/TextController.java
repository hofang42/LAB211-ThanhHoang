/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TextModel;
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
    String inputFile = "input.txt", outputFile = "output.txt";

    TextModel txtModel = new TextModel(inputFile, outputFile);
    TextView txtView = new TextView();

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                try {
                    System.out.println("Input File");
                    System.out.println(txtModel.readDocument(inputFile));
                    txtView.displaySuccess();
                } catch (IOException ex) {
                    txtView.displayError("Error");
                }
            }
            break;
            case 2:
                normalizeText(inputFile, outputFile);
                break;
            case 3: {
                try {
                    System.out.println(txtModel.readDocument(outputFile));
                    txtView.displaySuccess();
                } catch (IOException ex) {
                    txtView.displayError("Error");
                }
            }
            break;

        }
    }

    public void normalizeText(String inputFile, String outputFile) {
        BufferedReader br = null;
        try {
            int countLine = countLine();
            int count = 1;
            br = new BufferedReader(new FileReader(new File(inputFile)));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outputFile, true)));
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
                pw.print(line);
                if (count < countLine) {
                    pw.print(System.getProperty("line.separator"));
                }
                count++;
            }
            br.close();
            pw.close();
            txtView.displaySuccess();
        } catch (FileNotFoundException ex) {
            txtView.displayError("Can't not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
        StringBuffer stringBuffer = new StringBuffer();
        String[] strings = line.split("\\s*\\" + character + "\\s*");

        for (int i = 0; i < strings.length; i++) {
            stringBuffer.append(strings[i].trim());
            if (i < strings.length - 1) {
                stringBuffer.append(" " + character + " ");
            }
        }

        return stringBuffer.toString().trim();
    }

    public String formatSpecialCharacters(String line) {
        StringBuffer strBuffer = new StringBuffer(line);
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
        StringBuffer strBuffer = new StringBuffer(line);
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
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) == '"' && countQuetes % 2 == 0) {
                stringBuffer.deleteCharAt(i + 1);
                countQuetes++;
            } else if (stringBuffer.charAt(i) == '"' && countQuetes % 2 == 1
                    && i != 0) {
                stringBuffer.deleteCharAt(i - 1);
                countQuetes++;
            }
        }
        return stringBuffer.toString().trim();
    }

    public String firstUpercase(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                stringBuffer.setCharAt(i, Character.toUpperCase(line.charAt(i)));
                break;
            }
        }
        return stringBuffer.toString().trim();
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
            System.err.println("File not found.");
        } catch (IOException ex) {
            ex.printStackTrace();
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
