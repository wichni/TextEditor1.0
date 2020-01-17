package myFrame;

import javax.swing.*;
import java.awt.*;
import Menu.MyMenuBar;
import Menu.ValidationMenu;


public class MyFrame extends JFrame {
    private static MyMenuBar myMenuBar = new MyMenuBar();
    private static JScrollPane scrollPane;
    private static int frameWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int frameHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    private static JTextArea topTextArea = new JTextArea("Please enter your code");
    private static JTextArea bottomTextArea = new JTextArea("Validation result");

    public MyFrame() throws HeadlessException {

        this.setTitle("Syntax validator");
        setFrameSize();
        setScroll();
        setUpMenuBar();

        JPanel topPanel = new JPanel();

        JPanel bottomPanel = new JPanel();

        topPanel.add(topTextArea);
        bottomPanel.add(bottomTextArea);

        topPanel.setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane(topTextArea);
        topPanel.add(scroll, BorderLayout.CENTER);

        bottomPanel.setLayout(new BorderLayout());
        JScrollPane scroll1 = new JScrollPane(bottomTextArea);
        bottomPanel.add(scroll1, BorderLayout.CENTER);


        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,topPanel, bottomPanel);

        this.add(splitPane);

        this.setJMenuBar(myMenuBar);

        bottomPanel.setVisible(true);
        topPanel.setVisible(true);

        setCloseOperation();
        setJFrameVisible();
    }

    private void setScroll() {
        scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    }

    private void setCloseOperation() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setJFrameVisible() {
        this.setVisible(true);
    }

    private void setUpMenuBar() {
        final JMenu fileMenu = myMenuBar.getFileMenu();
        final JMenu editMenu = myMenuBar.getEditMenu();
        final JPopupMenu editPopUpMenu = myMenuBar.getPopUpEditMenu();
        final ValidationMenu validationMenu = myMenuBar.getRadioButtonMenu();

        myMenuBar.add(fileMenu);
        myMenuBar.add(editMenu);
        myMenuBar.add(editPopUpMenu);
        myMenuBar.add(validationMenu);
    }

    private void setFrameSize() {
        this.setSize(frameWidth / 2, frameHeight / 2);
        this.setLocation(frameWidth / 4, frameHeight / 4);
    }

    public static JTextArea getTopTextArea() {
        return topTextArea;
    }

    public static JTextArea getBottomTextArea() {
        return bottomTextArea;
    }

    public static void setBottomTextArea(JTextArea bottomTextArea) {
        MyFrame.bottomTextArea = bottomTextArea;
    }

    public static void setTopTextArea(JTextArea topTextArea) {
        MyFrame.topTextArea = topTextArea;
    }
}