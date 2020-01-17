package Json;

import myFrame.MyFrame;

import javax.swing.*;
import java.util.regex.Pattern;

public class CSVValidator {
    private final static String validMSG = "CSV id valid!";
    private final static String invalidMSG = "CSV id invalid!";

    private static JTextArea getTextArea() {
        return MyFrame.getTopTextArea();
    }

//TODO doesnt work... try different approach...


    public static void validate() {
        boolean valid=true;
        boolean matches = true;

        final String[] split = getTextArea().getText().split("\n");



        for (String s : split) {
            System.out.println(s);
            matches = Pattern.matches("^(([\"]([^\"\']*)[\"])|(\"([^\"\']*)\"~\\d))$", s);
        }
        valid = matches;
        if (valid) {
            MyFrame.getBottomTextArea().setText(validMSG);
        } else {
            MyFrame.getBottomTextArea().setText(invalidMSG);
        }
    }
}