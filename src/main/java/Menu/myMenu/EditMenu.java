package Menu.myMenu;

import Menu.editButtons.*;
import myFrame.MyFrame;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditMenu extends JMenu {
    private static JMenu editMenu;
    private JTextPane textPane = MyFrame.getTextPane();
    private CutButton cutButton;
    private CopyButton copyButton;
    private PasteButton pasteButton;
    private UndoButton undoButton;
    private RedoButton redoButton;

    public JMenu setUpEditMenu() {
        setMenuLabel();
        setMenuItems();
        addItemToJMenu();
        setMouseAdapter();

        return editMenu;
    }

    private void addItemToJMenu() {
        editMenu.add(cutButton.setCutButton());
        editMenu.add(copyButton.setCopyButton());
        editMenu.add(pasteButton.setPasteButton());
        editMenu.add(undoButton.setUndoButton());
        editMenu.add(redoButton.setRedoButton());
    }

    private void setMenuLabel() {
        editMenu = new JMenu("Edit");
    }

    private void setMenuItems() {
        cutButton = new CutButton();
        copyButton = new CopyButton();
        pasteButton = new PasteButton();
        undoButton = new UndoButton();
        redoButton = new RedoButton();
    }

    private JButton setMouseAdapter() {
        JButton button = new JButton();
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(cutButton.setCutButton());
        popupMenu.add(copyButton.setCopyButton());
        popupMenu.add(pasteButton.setPasteButton());
        popupMenu.add(undoButton.setUndoButton());
        popupMenu.add(redoButton.setRedoButton());

        textPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        return button;
    }
}