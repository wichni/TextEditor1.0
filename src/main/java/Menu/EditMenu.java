package Menu;

import myFrame.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditMenu extends JMenu implements ActionListener {
    private static JMenu editMenu;
    private static JPopupMenu editPopUp;
    private JMenuItem copy;
    private JMenuItem cut;
    private JMenuItem paste;
    private JMenuItem undo;


    public EditMenu() throws HeadlessException {
    }

    public JMenu setUpEditMenu() {

        setMenuLabel();

        setMenuItems();

        addListeners();

        addItemsToJMenu();

        return editMenu;
    }

    private void addItemsToJMenu() {
        editMenu.add(copy);
        editMenu.add(cut);
        editMenu.add(paste);
        editMenu.add(undo);
    }

    private void addListeners() {
        copy.addActionListener(this);
        cut.addActionListener(this);
        paste.addActionListener(this);
        undo.addActionListener(this);
    }

    private void setMenuItems() {
        copy = new JMenuItem("Copy");
        cut = new JMenuItem("Cut");
        paste = new JMenuItem("Paste");
        undo = new JMenuItem("Undo");
    }

    private void setMenuLabel() {
        editMenu = new JMenu("Edit");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();
        final JTextArea textArea = MyFrame.getTopTextArea();

        if (source == copy) {
            EditAction.copy(textArea);
        } else if (source == cut) {
            EditAction.cut(textArea);
        } else if (source == paste) {
            EditAction.paste(textArea);
        } else if (source == undo) {
            EditAction.undoChange();
        }
    }
}