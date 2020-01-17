package Menu.editButtons;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

public class PasteButton extends JMenuItem {

    public JMenuItem setPasteButton() {
        JMenuItem pasteButton = new JMenuItem(new DefaultEditorKit.PasteAction());
        pasteButton.setText("Paste");
        pasteButton.setToolTipText("Paste (Ctrl + V)");

        return pasteButton;
    }
}
