package Menu.editButtons;

import Menu.MyMenuBar;
import myFrame.MyFrame;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CutButton extends JFrame {
    final JTextField textField = new JTextField(15);
    private JTextArea textArea = new JTextArea();

    public JMenuItem setCutButton() {
        JMenuItem cutItem = new JMenuItem("Cut");
        cutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("Cut"))
                    textArea.cut();
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
        return cutItem;
    }
}
