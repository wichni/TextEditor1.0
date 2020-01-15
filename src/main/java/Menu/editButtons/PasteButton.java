package Menu.editButtons;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.DefaultEditorKit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasteButton extends JMenuItem {

    public JMenuItem setPasteButton() {
        JMenuItem pasteButton = new JMenuItem(new DefaultEditorKit.PasteAction());
        pasteButton.setText("Paste");
        pasteButton.setToolTipText("Paste (Ctrl + V)");

        return pasteButton;
    }
}
