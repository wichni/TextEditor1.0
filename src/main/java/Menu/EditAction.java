package Menu;

import myFrame.MyFrame;

import javax.swing.*;
import javax.swing.undo.UndoManager;

public class EditAction {
    public static void copy(JTextArea textArea) {
        textArea.copy();
    }

    public static void cut(JTextArea textArea) {
        textArea.cut();
    }

    public static void paste(JTextArea textArea) {
        textArea.paste();
    }

    public static void undoChange() {
        UndoManager undoManager = new UndoManager();
        final JTextArea textArea = MyFrame.getTopTextArea();
        textArea.getDocument().addUndoableEditListener(e -> undoManager.addEdit(e.getEdit()));
    }
}
