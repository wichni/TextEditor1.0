package Menu;

import javax.swing.*;
import java.awt.print.PrinterException;
import java.io.*;

public class FileAction {

    static void clearAction(JTextArea topTextArea, JTextArea bottomTextArea ) {
        topTextArea.setText("");
        bottomTextArea.setText("");
    }

    static void printAction(JTextArea textArea) {
        try {
            textArea.print();
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }

    static void saveFileAction(JTextArea textArea, JFileChooser fileChooser) {
        int choose = fileChooser.showSaveDialog(null);
        if (choose == JFileChooser.APPROVE_OPTION) {
            final File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));
                writer.write(textArea.getText());
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void openFileAction(JTextArea textArea, JFileChooser fileChooser) {
        int choose = fileChooser.showOpenDialog(null);
        if (choose == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder textFromFile = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    textFromFile.append(line);
                }
                textArea.setText("");
                textArea.append(textFromFile.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}