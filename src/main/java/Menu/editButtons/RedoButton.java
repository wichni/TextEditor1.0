package Menu.editButtons;

import myFrame.MyFrame;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RedoButton extends JMenuItem{
    private JTextArea textArea = MyFrame.getTextArea();
    private UndoManager redoManager = new UndoManager();

    public JMenuItem setRedoButton() {
        JMenuItem redoButton = new JMenuItem();
        redoButton.setText("Redo");
        redoButton.setToolTipText("Redo (Ctrl + Y)");

        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                redoManager.addEdit(e.getEdit());
            }
        });

        redoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (redoManager.canRedo()) {
                    redoManager.redo();
                }
            }
        });
        return redoButton;
    }
}