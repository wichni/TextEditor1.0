package Menu.myMenu;

import javax.swing.*;

public class HelpMenu {
    private static JMenu helpButton;

    public JMenu setHelpMenu() {
        helpButton = new JMenu("Help");
        helpButton.addSeparator();
        JMenuItem faqButton = new JMenuItem("FAQ");
        helpButton.add(faqButton);

        return helpButton;
    }
}