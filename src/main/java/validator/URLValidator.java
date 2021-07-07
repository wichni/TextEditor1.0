package validator;

import myFrame.MyFrame;
import org.apache.commons.validator.routines.UrlValidator;

import javax.swing.*;

public class URLValidator {
    private final static String validMSG = "URL is valid!";
    private final static String invalidMSG = "URL is invalid!";

    private static JTextArea getTextArea() {
        return MyFrame.getTopTextArea();
    }

    public static void validate() {
        boolean valid = true;

        UrlValidator urlValidator = new UrlValidator();
        valid = urlValidator.isValid(getTextArea().getText());
        if (valid) {
            MyFrame.getBottomTextArea().setText(validMSG);
        } else {
            MyFrame.getBottomTextArea().setText(invalidMSG);
        }
    }
}