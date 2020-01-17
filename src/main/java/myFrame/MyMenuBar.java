package myFrame;

import Menu.ValidationMenu;
import Menu.myMenu.ColorMenu;
import Menu.myMenu.EditMenu;
import Menu.myMenu.HelpMenu;
import Menu.FileMenu;

import javax.swing.*;

public class MyMenuBar extends JMenuBar {
    private FileMenu fileMenu = new FileMenu();
    private EditMenu editMenu = new EditMenu();
    private HelpMenu helpMenu = new HelpMenu();
    private ColorMenu colorMenu = new ColorMenu();

    public JMenu getFileMenu() {
        return fileMenu.setUpFileMenu();
    }

    public JMenu getEditMenu() {
        return editMenu.setUpEditMenu();
    }

    public JMenu getColorChange() {
        return colorMenu.setColorChange();
    }

    public JMenu getHelpMenu() {
        return helpMenu.setHelpMenu();
    }

    public ValidationMenu getRadioButtonMenu() {
        return new ValidationMenu();
    }
}
