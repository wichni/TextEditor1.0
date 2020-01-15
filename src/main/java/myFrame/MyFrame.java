package myFrame;

import Menu.MyMenuBar;
import Menu.editButtons.CopyButton;
import Menu.editButtons.CutButton;
import Menu.editButtons.PasteButton;
import Menu.radioButton.JsonButton;
import Menu.radioButton.UrlButton;
import Menu.radioButton.VerifyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame {
    private static JFrame jFrame = new JFrame("Text editor");
    private final MyMenuBar menuBar = new MyMenuBar();
    private final JTextArea textArea = new JTextArea();
    private final JScrollPane scrollPane = new JScrollPane(textArea);

    public MyFrame() throws HeadlessException {
    }

    public void initEditor() {
        jFrame.getContentPane().add(scrollPane);
        setMenuBar();
        setMouseAdapter();
        setFrameSize();
        setCloseOperation();
        setJFrameVisible();
    }

    private void setCloseOperation() {
        jFrame.setDefaultCloseOperation(3);
    }

    private void setJFrameVisible() {
        jFrame.setVisible(true);
    }

    private MyMenuBar setMenuBar() {
        menuBar.add(menuBar.setFileMenu());
        menuBar.add(menuBar.setEditMenu());
        menuBar.add(menuBar.setColorChange());
        menuBar.add(menuBar.setHelpMenu());
        menuBar.add(menuBar.setUrlButton());
        menuBar.add(menuBar.setJsonButton());
        jFrame.setJMenuBar(menuBar);

        return menuBar;
    }

    private JButton setMouseAdapter() {
        JButton button = new JButton();
        JPopupMenu popupMenu = new JPopupMenu();
        CutButton cutButton = new CutButton();
        CopyButton copyButton = new CopyButton();
        PasteButton pasteButton = new PasteButton();
        popupMenu.add(cutButton.setCutButton());
        popupMenu.add(copyButton.setCopyButton());
        popupMenu.add(pasteButton.setPasteButton());

        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        return button;
    }

    private void setFrameSize() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        jFrame.setSize(width / 2, height / 2);
        jFrame.setLocation(width / 4, height / 4);
    }
}