/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
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

    TextView txtView = new TextView();
    TextModel txtModel = new TextModel();
    @Override
    public void execute(int n) {

        switch (n) {
            case 1:
                txtView.readDataInput(txtModel);
                break;
            case 2:
                txtView.normalizeData(txtModel);
                break;
            case 3:
                txtView.readDataOutput(txtModel);
                break;
        }
    }
}

    