package Menu.radioButton;

import javax.swing.*;

public class UrlButton extends JRadioButton {
    private JRadioButton urlButton = new JRadioButton();

    public JRadioButton buildUrlButton() {
        urlButton.setText("URL");

        return urlButton;
    }
}