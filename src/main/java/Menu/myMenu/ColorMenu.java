package Menu.myMenu;

import myFrame.MyFrame;

import javax.swing.*;

public class ColorMenu extends JMenu {
    private static JMenu colorMenu;
    private JTextArea textArea = MyFrame.getTopTextArea();
    private ColorButton black = new ColorButton();
    private ColorButton blue = new ColorButton();
    private ColorButton red = new ColorButton();

    public JMenu setColorChange() {
        colorMenu = new JMenu("Color");
        colorMenu.add(black.blackColor());
        colorMenu.add(blue.blueColor());
        colorMenu.add(red.redColor());

        return colorMenu;
    }
}