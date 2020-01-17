package Menu.myMenu;

import javax.swing.*;

public class ColorMenu extends JFrame {
    private static JMenu colorButton;

    public JMenu setColorChange() {
        colorButton = new JMenu("Color");

        return colorButton;
    }
}