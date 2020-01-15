package Menu;

import myFrame.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FileMenu extends JMenu implements ActionListener {
    private static JMenu fileMenu;
    private JMenuItem open;
    private JMenuItem save;
    private JMenuItem print;
    private JMenuItem newFile;

    public FileMenu() throws HeadlessException {
    }

    public JMenu setUpFileMenu() {

        setMenuLabel();

        setMenuItems();

        addListeners();

        addItemsToJMenu();

        return fileMenu;
    }

    private void addItemsToJMenu() {
        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.add(print);
        fileMenu.add(newFile);
    }

    private void addListeners() {
        open.addActionListener(this);
        save.addActionListener(this);
        print.addActionListener(this);
        newFile.addActionListener(this);
    }

    private void setMenuItems() {
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        print = new JMenuItem("Print");
        newFile = new JMenuItem("newFile");
    }

    private void setMenuLabel() {
        fileMenu = new JMenu("File");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();
        final JTextArea textArea = MyFrame.getTextArea();
        JFileChooser fileChooser = new JFileChooser();

        if (source == open) {
            FileAction.openFileAction(textArea, fileChooser);
        } else if (source == save) {
            FileAction.saveFileAction(textArea, fileChooser);
        } else if (source == print) {
            FileAction.printAction(textArea);
        } else if (source == newFile) {
            FileAction.clearAction(textArea);
        }
    }
}