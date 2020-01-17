package org.example;

import myFrame.MyFrame;

import javax.swing.*;

import static javax.swing.SwingUtilities.invokeLater;

public class App extends JFrame {

    public static void main(String[] args) {
        invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame();
            }
        });
    }
}