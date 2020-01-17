package myFrame;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private static JTextArea textArea = new JTextArea();
    private static MyMenuBar barMenu = new MyMenuBar();
    private final JScrollPane scrollPane = new JScrollPane(textArea);

    public MyFrame() throws HeadlessException {
        this.getContentPane().add(scrollPane);
        this.setTitle("Text editor");
        this.setJMenuBar(barMenu);
        setUpMenuBar();
        setFrameSize();
        setCloseOperation();
        setJFrameVisible();
    }

    public static JTextArea getTextArea() {
        return textArea;
    }

    private void setCloseOperation() {
        this.setDefaultCloseOperation(3);
    }

    private void setJFrameVisible() {
        this.setVisible(true);
    }

    private void setUpMenuBar() {
        final JMenu editMenu = barMenu.getEditMenu();
        final JMenu helpMenu = barMenu.getHelpMenu();
        final JRadioButton url = barMenu.getUrl();
        final JRadioButton json = barMenu.getJson();
        final JButton verify = barMenu.getVerify();
        final JMenu color = barMenu.getColorChange();
        barMenu.add(editMenu);
        barMenu.add(color);
        barMenu.add(url);
        barMenu.add(json);
        barMenu.add(verify);
        barMenu.add(helpMenu);
    }

    private void setFrameSize() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(width / 2, height / 2);
        this.setLocation(width / 4, height / 4);
    }
}