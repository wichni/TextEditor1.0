package myFrame;

import javax.swing.*;
import java.awt.*;
import Menu.MenuBar;


public class MyFrame extends JFrame {
    private static JTextArea textArea = new JTextArea();
    private static MenuBar menuBar = new MenuBar();

    public MyFrame() throws HeadlessException {
        setUpMenuBar();
        this.setTitle("Text editor");
        this.add(textArea);
        this.setJMenuBar(menuBar);
        setCloseOperation();
        setFrameSize();
        setJFrameVisible();
    }

    private void setCloseOperation() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setJFrameVisible() {
        this.setVisible(true);
    }

    private void setUpMenuBar() {
        final JMenu fileMenu = menuBar.getFileMenu();
        menuBar.add(fileMenu);
    }

    private void setFrameSize() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;

        this.setSize(width / 2, height / 2);
        this.setLocation(width / 4, height / 4);
    }

    public static JTextArea getTextArea() {
        return textArea;
    }
}