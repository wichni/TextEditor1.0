package myFrame;

import javax.swing.*;
import java.awt.*;

public class MyFrame {
    private static JFrame jFrame = new JFrame("Text editor");

    public MyFrame() throws HeadlessException {
    }

    public void initEditor() {
        MenuBar menuBar = setMenuBar();
        jFrame.setJMenuBar(menuBar);
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

    private MenuBar setMenuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.add(menuBar.setFileMenu());
        menuBar.add(menuBar.setEditMenu());
        menuBar.add(menuBar.setHelpMenu());
        return menuBar;
    }

    private void setFrameSize() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        jFrame.setSize(width / 2, height / 2);
        jFrame.setLocation(width / 4, height / 4);
    }
}