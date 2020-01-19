package myFrame;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private static JTextArea topTextArea = new JTextArea();
    private static JTextArea bottomTextArea = new JTextArea("Validation result");
    private static MyMenuBar myMenuBar = new MyMenuBar();
    int frameWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    int frameHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

    public MyFrame() throws HeadlessException {

        this.setTitle("Text editor");
        setFrameSize();
        setUpMenuBar();

        JPanel topPanel = new JPanel();

        JPanel bottomPanel = new JPanel();

        JScrollPane scroll = new JScrollPane(topTextArea);
        topPanel.setLayout(new BorderLayout());
        topPanel.add(scroll, BorderLayout.CENTER);

        JScrollPane scroll1 = new JScrollPane(bottomTextArea);
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(scroll1, BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, bottomPanel);
        this.add(splitPane);

        this.setJMenuBar(myMenuBar);

        setCloseOperation();
        setJFrameVisible();
    }

    public static JTextArea getTopTextArea() {
        return topTextArea;
    }

    public static JTextArea getBottomTextArea() {
        return bottomTextArea;
    }

    private void setCloseOperation() {
        this.setDefaultCloseOperation(3);
    }

    private void setJFrameVisible() {
        this.setVisible(true);
    }

    private void setUpMenuBar() {
        final JMenu fileMenu = myMenuBar.getFileMenu();
        final JMenu editMenu = myMenuBar.getEditMenu();
        final JMenu helpMenu = myMenuBar.getHelpMenu();
        final JMenu color = myMenuBar.getColorChange();
        final JPanel validationMenu = myMenuBar.getRadioButtonMenu();

        myMenuBar.add(fileMenu);
        myMenuBar.add(editMenu);
        myMenuBar.add(color);
        myMenuBar.add(validationMenu);
        myMenuBar.add(helpMenu);
    }

    private void setFrameSize() {
        this.setSize(frameWidth / 2, frameHeight / 2);
        this.setLocation(frameWidth / 4, frameHeight / 4);
    }
}