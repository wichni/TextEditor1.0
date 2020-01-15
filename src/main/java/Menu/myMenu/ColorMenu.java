package Menu.myMenu;

import javax.swing.*;

public class ColorMenu {
    private static JMenu colorButton;

    public JMenu setColorChange() {
        colorButton = new JMenu("Color");

        return colorButton;
    }
}