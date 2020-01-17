package Menu.editButtons;

import myFrame.MyFrame;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UndoButton extends JMenuItem {
    private JTextArea textArea = MyFrame.getTopTextArea();
    private UndoManager undoManager = new UndoManager();

    public JMenuItem setUndoButton() {
        JMenuItem undoButton = new JMenuItem();
        undoButton.setText("Undo");
        undoButton.setToolTipText("Undo (Ctrl + Z)");

        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (undoManager.canUndo()) {
                    undoManager.undo();
                }
            }
        });
        return undoButton;
    }
}