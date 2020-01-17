package Menu;

import javax.swing.*;

public class MyMenuBar extends JMenuBar {
    private FileMenu fileMenu = new FileMenu();
    private EditMenu editMenu = new EditMenu();
    private PopUpMenu editPopUp = new PopUpMenu();

    public MyMenuBar() {
    }

    public JMenu getFileMenu() {
        return fileMenu.setUpFileMenu();
    }

    public JMenu getEditMenu() {
        return editMenu.setUpEditMenu();
    }

    public JPopupMenu getPopUpEditMenu() {
        return editPopUp.setUpEditPopUpMenu();
    }

    public ValidationMenu getRadioButtonMenu() {
        return new ValidationMenu();
    }
}