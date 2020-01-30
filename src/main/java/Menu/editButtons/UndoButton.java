package Menu.editButtons;

import myFrame.MyFrame;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class UndoButton extends JMenuItem {
    private JTextPane textPane = MyFrame.getTextPane();
    private static UndoManager undoManager = new UndoManager();

    public JMenuItem setUndoButton() {
        JMenuItem undoButton = new JMenuItem();
        undoButton.setText("Undo");
        undoButton.setToolTipText("Undo (Ctrl + Z)");
        KeyStroke undoKeyStroke = KeyStroke.getKeyStroke(
                KeyEvent.VK_Z, Event.CTRL_MASK);

        Document document = textPane.getDocument();
        document.addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    undoManager.undo();
                } catch (CannotUndoException cue) {
                    System.out.println("Exception undo");
                }
            }
        });

        textPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(undoKeyStroke, "undoKeyStroke");
        textPane.getActionMap().put("undoKeyStroke", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    undoManager.undo();
                } catch (CannotUndoException cue) {}
            }
        });

        return undoButton;
    }

    public static UndoManager getUndoRedoManager() {
        return undoManager;
    }
}