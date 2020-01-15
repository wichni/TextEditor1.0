package Menu.myMenu;

import Menu.radioButton.JsonButton;
import Menu.radioButton.UrlButton;
import Menu.radioButton.VerifyButton;

import javax.swing.*;

public class UrlAndJsonGroup extends JRadioButton{
    private JsonButton jsonButton = new JsonButton();
    private UrlButton urlButton = new UrlButton();
    private VerifyButton verifyButton = new VerifyButton();

    public JRadioButton setUrlButton() {
        urlButton.add(urlButton.buildUrlButton());
        setGroupButton();

        return urlButton;
    }

    public JRadioButton setJsonButton() {
        jsonButton.add(jsonButton.buildJsonButton());
        setGroupButton();

        return jsonButton;
    }

    public JRadioButton setVerifyButton() {
        verifyButton.add(verifyButton.buildVerifyButton());

        return verifyButton;
    }

    private ButtonGroup setGroupButton() {
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jsonButton.buildJsonButton());
        buttonGroup.add(urlButton.buildUrlButton());

        return buttonGroup;
    }
}