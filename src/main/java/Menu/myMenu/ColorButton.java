package Menu.myMenu;

import myFrame.MyFrame;

import javax.swing.*;
import java.awt.*;

public class ColorButton extends JMenuItem{
    private static JTextArea textArea = MyFrame.getTopTextArea();

    public JMenuItem blackColor() {
        JMenuItem blackButton = new JMenuItem();
        blackButton.setText("Black");
        blackButton.setForeground(Color.BLACK);

        return blackButton;
    }

    public JMenuItem blueColor() {
        JMenuItem blueButton = new JMenuItem();
        blueButton.setText("Blue");
        blueButton.setForeground(Color.BLUE);

        return blueButton;
    }

    public JMenuItem redColor() {
        JMenuItem redButton = new JMenuItem();
        redButton.setText("Red");
        redButton.setForeground(Color.RED);

        return redButton;
    }
}
