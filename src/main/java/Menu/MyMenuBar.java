package Menu;

import Menu.editButtons.CopyButton;
import Menu.editButtons.CutButton;
import Menu.editButtons.PasteButton;
import Menu.editButtons.UndoButton;
import Menu.radioButton.JsonButton;
import Menu.radioButton.UrlButton;

import javax.swing.*;
import java.awt.event.*;

public class MyMenuBar extends JMenuBar {
    private static JMenu fileMenu;
    private static JMenu editMenu;
    private static JMenu helpButton;
    private static JMenu colorButton;
    private JTextArea textArea = new JTextArea();
    private CutButton cutButton = new CutButton();
    private CopyButton copyButton = new CopyButton();
    private PasteButton pasteButton = new PasteButton();
    private UndoButton undoButton = new UndoButton();
    private JCheckBoxMenuItem readOnly = new JCheckBoxMenuItem("Read-only");
    private JMenuItem saveItem = new JMenuItem("Save");
    private JMenu optionItem = new JMenu("Option");
    private JsonButton jsonButton = new JsonButton();
    private UrlButton urlButton = new UrlButton();

    public JMenu setFileMenu() {
        fileMenu = new JMenu("File");
        JMenuItem printItem = new JMenuItem("Print");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(printItem);
        fileMenu.add(optionItem);
        optionItem.add(readOnly);
        setReadOnly();
        return fileMenu;
    }

    public JMenu setEditMenu() {
        editMenu = new JMenu("Edit");
        editMenu.add(cutButton.setCutButton());
        editMenu.add(copyButton.setCopyButton());
        editMenu.add(pasteButton.setPasteButton());
        editMenu.add(undoButton.setUndoButton());

        return editMenu;
    }

    public JMenu setColorChange() {
        colorButton = new JMenu("Color");

        return colorButton;
    }

    public JMenu setHelpMenu() {
        helpButton = new JMenu("Help");
        helpButton.addSeparator();
        JMenuItem faqButton = new JMenuItem("FAQ");
        helpButton.add(faqButton);

        return helpButton;
    }

    public JRadioButton setUrlButton() {
        urlButton.add(urlButton.buildUrlButton());
        setGroupButton();

        return urlButton;
    }

    public JRadioButton setJsonButton() {
        jsonButton.add(jsonButton.buildJsonButton());
        setGroupButton();

        return jsonButton;
    }

    private ButtonGroup setGroupButton() {
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jsonButton.buildJsonButton());
        buttonGroup.add(urlButton.buildUrlButton());

        return buttonGroup;
    }

    private void setReadOnly() {
        readOnly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (readOnly.isSelected()) {
                    saveItem.setEnabled(false);
                } else
                    saveItem.setEnabled(true);
            }
        });
    }
}