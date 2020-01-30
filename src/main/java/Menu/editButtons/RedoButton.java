package Menu.editButtons;

import myFrame.MyFrame;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class RedoButton extends JMenuItem {
    private JTextPane textPane = MyFrame.getTextPane();
    private UndoManager redoManager = UndoButton.getUndoRedoManager();

    public JMenuItem setRedoButton() {
        JMenuItem redoButton = new JMenuItem();
        redoButton.setText("Redo");
        redoButton.setToolTipText("Redo (Ctrl + Y)");
        KeyStroke redoKeyStroke = KeyStroke.getKeyStroke(
                KeyEvent.VK_Y, Event.CTRL_MASK);

        Document document = textPane.getDocument();
        document.addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                redoManager.addEdit(e.getEdit());
            }
        });

        redoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    redoManager.redo();
                } catch (CannotRedoException cre) {
                    System.out.println("Exception redo");
                }
            }
        });

        textPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(redoKeyStroke, "redoKeyStroke");
        textPane.getActionMap().put("redoKeyStroke", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    redoManager.redo();
                } catch (CannotRedoException cre) {}
            }
        });
        return redoButton;
    }
}