package org.example;

import myFrame.MyFrame;

import javax.swing.*;

import static java.awt.EventQueue.invokeLater;

public class App extends JFrame {

    public static void main(String[] args) {
        invokeLater(new Runnable() {
            public void run() {
                new MyFrame();
            }
        });
    }
}