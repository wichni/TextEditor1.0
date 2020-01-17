package myFrame;

import Menu.myMenu.ColorMenu;
import Menu.myMenu.EditMenu;
import Menu.myMenu.HelpMenu;
import Menu.myMenu.UrlAndJsonGroup;

import javax.swing.*;

public class MenuBarMenu extends JMenuBar {
    private EditMenu editMenu = new EditMenu();
    private HelpMenu helpMenu = new HelpMenu();
    private ColorMenu colorMenu = new ColorMenu();
    private UrlAndJsonGroup group = new UrlAndJsonGroup();

    public JMenu getEditMenu() {
        return editMenu.setUpEditMenu();
    }

    public JMenu getColorChange() {
        return colorMenu.setColorChange();
    }

    public JMenu getHelpMenu() {
        return helpMenu.setHelpMenu();
    }

    public JRadioButton getUrl() {
        return group.setUrlButton();
    }

    public JRadioButton getJson() {
        return group.setJsonButton();
    }

    public JButton getVerify() {
        return group.setVerifyButton();
    }
}
