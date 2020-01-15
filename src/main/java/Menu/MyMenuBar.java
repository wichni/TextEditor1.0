package Menu;

import javax.swing.*;
import java.awt.event.*;

public class MyMenuBar extends JMenuBar {
    private static JMenu fileMenu;
    private JCheckBoxMenuItem readOnly = new JCheckBoxMenuItem("Read-only");
    private JMenuItem saveItem = new JMenuItem("Save");
    private JMenu optionItem = new JMenu("Option");

    public JMenu setFileMenu() {
        fileMenu = new JMenu("File");
        JMenuItem printItem = new JMenuItem("Print");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(printItem);
        fileMenu.add(optionItem);
        optionItem.add(readOnly);
        setReadOnly();
        return fileMenu;
    }

    private void setReadOnly() {
        readOnly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (readOnly.isSelected()) {
                    saveItem.setEnabled(false);
                } else
                    saveItem.setEnabled(true);
            }
        });
    }
}