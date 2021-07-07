package Menu.myMenu;

import myFrame.MyFrame;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ColorMenu extends JMenu {
    private static JMenu colorMenu;
    private JTextPane textPane = new JTextPane();

    public JMenu setColorChange() {
        colorMenu = new JMenu("Color");
        createButton("Black", Color.BLACK);
        createButton("Blue", Color.BLUE);
        createButton("Red", Color.RED);
        createButton("Green", Color.GREEN);
        createButton("Yellow", Color.YELLOW);
        createButton("Pink", Color.PINK);
        createButton("Magenta", Color.MAGENTA);

        return colorMenu;
    }

    public void createButton(String name, final Color color) {
        JMenuItem button = new JMenuItem(name);
        button.setForeground(color);
        button.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    Action colorForeground = new StyledEditorKit.ForegroundAction(name, color);
                    colorForeground.actionPerformed(null);
                } else {
                    Highlighter.HighlightPainter colorPainter = new DefaultHighlighter.DefaultHighlightPainter(color);
                    try {
                        textPane.getHighlighter().addHighlight(textPane.getSelectionStart(), textPane.getSelectionEnd(), colorPainter);
                    } catch (BadLocationException ble) {
                    }
                }
            }
        });
        ButtonGroup groupColor = new ButtonGroup();
        groupColor.add(button);
        colorMenu.add(button);
    }
}