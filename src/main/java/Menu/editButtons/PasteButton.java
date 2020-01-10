package Menu.editButtons;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasteButton extends JFrame {
    final JTextField textField = new JTextField(15);
    private JTextArea textArea = new JTextArea();

    public void setPasteButton() {
        JMenuItem pasteItem = new JMenuItem("Paste");
        pasteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("Paste"))
                    textArea.paste();
            }
        });

        textArea.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent ce) {
                System.out.println("All text: " + textArea.getText());
                if (textArea.getSelectedText() != null)
                    System.out.println("Selected text: " + textArea.getSelectedText());
                else
                    System.out.println("Selected text: ");
            }
        });
    }
}
