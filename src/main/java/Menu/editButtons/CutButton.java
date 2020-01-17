package Menu.editButtons;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

public class CutButton extends JMenuItem{

    public JMenuItem setCutButton() {
        JMenuItem cutItem = new JMenuItem(new DefaultEditorKit.CutAction());
        cutItem.setText("Cut");
        cutItem.setToolTipText("Cut (Ctrl + X)");

        return cutItem;
    }
}