package Menu;

import myFrame.MyFrame;

import javax.swing.*;
import java.awt.event.*;

public class PopUpMenu extends JPopupMenu implements ActionListener {
    private static JPopupMenu editPopUp;
    private JMenuItem copy;
    private JMenuItem cut;
    private JMenuItem paste;
    private JMenuItem undo;

    public JPopupMenu setUpEditPopUpMenu() {
        editPopUp = new JPopupMenu();

        copy = new JMenuItem("Copy");
        cut = new JMenuItem("Cut");
        paste = new JMenuItem("Paste");
        undo = new JMenuItem("Undo");

        copy.addActionListener(this);
        cut.addActionListener(this);
        paste.addActionListener(this);
        undo.addActionListener(this);

        editPopUp.add(copy);
        editPopUp.add(cut);
        editPopUp.add(paste);
        editPopUp.add(undo);

        JTextArea textArea = MyFrame.getTopTextArea();

        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    editPopUp.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        return editPopUp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();
        final JTextArea textArea = MyFrame.getTopTextArea();

        if (source == copy) {
            EditAction.copy(textArea);
        } else if (source == cut) {
            EditAction.cut(textArea);
        } else if (source == paste) {
            EditAction.paste(textArea);
        } else if (source == undo) {
            EditAction.undoChange();
        }
    }
}
