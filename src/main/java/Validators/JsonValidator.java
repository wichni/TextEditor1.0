package Validators;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import myFrame.MyFrame;

import javax.swing.*;

public class JsonValidator {
    private static ObjectMapper objectMapper = new ObjectMapper();

    private static JTextArea getTextArea() {
        return MyFrame.getTopTextArea();
    }

    public static void validate() {
        final String uglyJson = getTextArea().getText();
        boolean checker = true;

        try {
            Object json = objectMapper.readValue(uglyJson, Object.class);
            String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
            MyFrame.getTopTextArea().setText(prettyJson);
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            checker = false;
            final String message = e.getMessage();
            MyFrame.getBottomTextArea().setText(getErrorMessage(message));
        } catch (
                JsonProcessingException e) {
            e.printStackTrace();
        }
        if (checker) {
            MyFrame.getBottomTextArea().setText("Validation successful");
        }
    }

    private static String getErrorMessage(String message) {

        String line = "************************************************************************";
        System.out.println(message);

        final int endIndex = message.indexOf(" at ");
        return line + "\n" + message.substring(0, endIndex) +
                "\n" + message.substring((message.indexOf(";") + 1), message.length() - 1).trim()
                + "\n"
                + line;

    }
}