package Menu;

import Json.CSVValidator;
import Json.JsonValidator;
import Menu.Json.URLValidator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValidationMenu extends JPanel implements ActionListener {
    private JPanel radioPanel;
    ButtonGroup buttonGroup;
    JRadioButton jsonButton;
    JRadioButton csvButton;
    JRadioButton urlButton;
    private String jsonString = "JSON";
    private String URLString = "URL";
    private String csvString = "CSV";
    private String verify = "Verify";

    public ValidationMenu() {
        jsonButton = new JRadioButton(jsonString);
        jsonButton.setSelected(true);
        jsonButton.setActionCommand(jsonString);

        urlButton = new JRadioButton(URLString);
        urlButton.setActionCommand(URLString);

        csvButton = new JRadioButton(csvString);
        csvButton.setActionCommand(csvString);

        JButton verifyButton = new JButton(verify);
        verifyButton.setActionCommand(verify);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(jsonButton);
        buttonGroup.add(urlButton);
        buttonGroup.add(csvButton);
        buttonGroup.add(verifyButton);

        jsonButton.addActionListener(this);
        urlButton.addActionListener(this);
        csvButton.addActionListener(this);
        verifyButton.addActionListener(this);

        radioPanel = new JPanel();
        radioPanel.add(jsonButton);
        radioPanel.add(urlButton);
        radioPanel.add(csvButton);
        radioPanel.add(verifyButton);

        add(radioPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jsonButton.isSelected() && e.getActionCommand().equals(verify)) {
            JsonValidator.validate();
        } else if (urlButton.isSelected() && e.getActionCommand().equals(verify)) {
            URLValidator.validate();
        }else if (csvButton.isSelected() && e.getActionCommand().equals(verify)) {
            CSVValidator.validate();
        }
    }
}