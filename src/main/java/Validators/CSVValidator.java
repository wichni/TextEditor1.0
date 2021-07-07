package Validators;

import myFrame.MyFrame;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.swing.*;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class CSVValidator {
    private final static String validMSG = "CSV is valid!";
    private final static String invalidMSG = "CSV is invalid!";

    private static JTextArea getTextArea() {
        return MyFrame.getTopTextArea();
    }

    public static void validate() {
        boolean valid = true;
        Reader reader = null;

        if (getTextArea().getText().isEmpty()) {
            getTextArea().setText("Please enter text here");
        } else {
            reader = new StringReader(getTextArea().getText());
            try {
                final CSVParser parse = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);

                final int headerSize = parse.getHeaderMap().size();

                for (CSVRecord strings : parse) {
                    if (!(headerSize == strings.size())) {
                        valid = false;
                        break;
                    }
                }
            } catch (IOException e) {
                valid = false;
                e.printStackTrace();
            }
            if (valid) {
                MyFrame.getBottomTextArea().setText(validMSG);
            } else {
                MyFrame.getBottomTextArea().setText(invalidMSG);
            }
        }
    }
}
