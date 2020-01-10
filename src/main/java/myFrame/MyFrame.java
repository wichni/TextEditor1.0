package myFrame;

import Menu.MyMenuBar;
import Menu.editButtons.CopyButton;
import Menu.editButtons.CutButton;
import Menu.editButtons.PasteButton;

import javax.swing.*;
import java.awt.*;

public class MyFrame {
    private static JFrame jFrame = new JFrame("Text editor");
    private final MyMenuBar menuBar = new MyMenuBar();
    private final JTextArea textArea = new JTextArea();

    public MyFrame() throws HeadlessException {
    }

    public void initEditor() {
        jFrame.add(textArea);
        setMenuBar();
        setFrameSize();
        setCloseOperation();
        setJFrameVisible();
    }

    private void setCloseOperation() {
        jFrame.setDefaultCloseOperation(3);
    }

    private void setJFrameVisible() {
        jFrame.setVisible(true);
    }

    private MyMenuBar setMenuBar() {
        menuBar.add(menuBar.setFileMenu());
        menuBar.add(menuBar.setEditMenu());
        menuBar.add(menuBar.setHelpMenu());
        jFrame.setJMenuBar(menuBar);

        return menuBar;
    }

    private void setFrameSize() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        jFrame.setSize(width / 2, height / 2);
        jFrame.setLocation(width / 4, height / 4);
    }
}