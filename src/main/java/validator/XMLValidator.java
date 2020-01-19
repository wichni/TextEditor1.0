package validator;

import myFrame.MyFrame;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class XMLValidator {
    private static JTextArea topTextArea = MyFrame.getTopTextArea();
    private static JTextArea bottomTextArea = MyFrame.getBottomTextArea();

    public static void validate() {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.setProperty("http://java.sun.com/xml/jaxp/ properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
            saxParser.setProperty("http://java.sun.com/xml/jaxp/ properties/schemaSource", topTextArea.getText());
            saxParser.parse(new File(topTextArea.getText()), new DefaultHandler());
            styleText(false);
        } catch (ParserConfigurationException e) {
            styleText(true);
            MyFrame.getBottomTextArea().setText("XMI is invalid / ParserConfigurationException");
        } catch (SAXException e) {
            styleText(true);
            MyFrame.getBottomTextArea().setText("XML is invalid / SAXException");
        } catch (IOException e) {
            styleText(true);
            MyFrame.getBottomTextArea().setText("XML is invalid / IOException");
        }
    }

    private static void styleText(boolean isError) {
        if (isError) {
            bottomTextArea.setBackground(Color.RED);
            bottomTextArea.setText("XML is invalid");
        } else {
            bottomTextArea.setBackground(Color.GREEN);
            bottomTextArea.setText("XML is valid");
        }
    }
}