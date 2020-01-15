package Menu.editButtons;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

public class CopyButton extends JMenuItem {

    public JMenuItem setCopyButton() {
        JMenuItem copyItem = new JMenuItem(new DefaultEditorKit.CopyAction());
        copyItem.setText("Copy");
        copyItem.setToolTipText("Copy (Ctrl + C)");

        return copyItem;
    }
}
