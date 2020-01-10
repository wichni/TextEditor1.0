package Menu;

import Menu.editButtons.CutButton;

import javax.swing.*;

public class MyMenuBar extends JMenuBar {
    private static JMenu fileMenu;
    private static JMenu editMenu;
    private static JMenu helpButton;
    private CutButton cutButton = new CutButton();

    public JMenu setFileMenu() {
        fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem printItem = new JMenuItem("Print");
        JMenuItem newItem = new JMenuItem("New");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(printItem);
        return fileMenu;
    }

    public JMenu setEditMenu() {
        editMenu = new JMenu("Edit");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        JMenuItem optionItem = new JMenuItem("Option");
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.addSeparator();
        editMenu.add(optionItem);
        return editMenu;
    }

    public JMenu setHelpMenu() {
        helpButton = new JMenu("Help");
        helpButton.addSeparator();
        JMenuItem faqButton = new JMenuItem("FAQ");
        helpButton.add(faqButton);

        return helpButton;
    }
}