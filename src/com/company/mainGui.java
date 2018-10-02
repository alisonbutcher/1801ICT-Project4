package com.company;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.DefaultStyledDocument;
import java.awt.event.*;
import java.security.Key;

public class mainGui {

    // Name of application
    private static final String APP_NAME = "Text Editor";

    // Main app frame
    private static JFrame app = new JFrame(APP_NAME);

    // App Menu bar
    private static JMenuBar menuBar = new JMenuBar();

    // Menus
    private static JMenu fileMenu = new JMenu("File");
    private static JMenu editMenu = new JMenu("Edit");
    private static JMenu viewMenu = new JMenu("View");
    private static JMenu helpMenu = new JMenu("Help");

    // File menu items
    private static JMenuItem mnuOpen = new JMenuItem("Open");
    private static JMenuItem mnuClose = new JMenuItem("Close");
    private static JMenuItem mnuSave = new JMenuItem("Save");
    private static JMenuItem mnuPrint = new JMenuItem("Print");
    private static JMenuItem mnuExit = new JMenuItem("Quit");

    // Edit menu items
    private static JMenuItem mnuCopy = new JMenuItem("Copy");
    private static JMenuItem mnuCut = new JMenuItem("Cut");
    private static JMenuItem mnuPaste = new JMenuItem("Paste");
    private static JMenuItem mnuSearch = new JMenuItem("Search/Replace");

    // View Menu items
    private static JMenuItem mnuShowSymbols = new JMenuItem("Show Special Characters");

    // Help Menu Items
    private static JMenuItem mnuHelp = new JMenuItem("Help");
    private static JMenuItem mnuAbout = new JMenuItem("About");

    // Text Editing Area + scrollbar
    private static JTextPane editor = new JTextPane();
    private static JScrollPane editorScrollPane = new JScrollPane(editor);


    public static void main(String[] args) {

        // Open Menu Item
        mnuOpen.setMnemonic(KeyEvent.VK_O);
        mnuOpen.getAccessibleContext().setAccessibleDescription(
                "Open a new file");
        fileMenu.add(mnuOpen);

        mnuClose.setMnemonic(KeyEvent.VK_W);
        mnuClose.getAccessibleContext().setAccessibleDescription(
                "Close the file");
        fileMenu.add(mnuClose);

        mnuSave.setMnemonic(KeyEvent.VK_S);
        mnuSave.getAccessibleContext().setAccessibleDescription(
                "Save file");
        fileMenu.add(mnuSave);

        mnuPrint.setMnemonic(KeyEvent.VK_P);
        mnuPrint.getAccessibleContext().setAccessibleDescription(
                "Print");
        fileMenu.add(mnuPrint);

        mnuExit.setMnemonic(KeyEvent.VK_Q);
        mnuExit.getAccessibleContext().setAccessibleDescription(
                "Quit");


        // Build Edit Menu
        mnuCopy.setMnemonic(KeyEvent.VK_C);
        mnuCopy.getAccessibleContext().setAccessibleDescription(
                "Copy");
        editMenu.add(mnuCopy);

        mnuCut.setMnemonic(KeyEvent.VK_K);
        mnuCut.getAccessibleContext().setAccessibleDescription(
                "Cut");
        editMenu.add(mnuCut);

        mnuPaste.setMnemonic(KeyEvent.VK_V);
        mnuPaste.getAccessibleContext().setAccessibleDescription(
                "Paste");
        editMenu.add(mnuPaste);

        mnuSearch.setMnemonic(KeyEvent.VK_F);
        mnuSearch.getAccessibleContext().setAccessibleDescription(
                "Search / Replace");
        editMenu.add(mnuSearch);


        // Build View Menu
        mnuShowSymbols.setMnemonic(KeyEvent.VK_G);
        mnuShowSymbols.getAccessibleContext().setAccessibleDescription(
                "Show/Hide Symbols");
        viewMenu.add(mnuShowSymbols);

        // Build Help Menu
        mnuHelp.getAccessibleContext().setAccessibleDescription(
                "Help");
        helpMenu.add(mnuHelp);

        mnuAbout.getAccessibleContext().setAccessibleDescription(
                "About");
        mnuHelp.add(mnuAbout);

        // Add Menus to Menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);

        // Add menu bar to App
        app.setJMenuBar(menuBar);

        // Output text area:
        editor.setDocument(new DefaultStyledDocument());
        app.add(editorScrollPane, BorderLayout.CENTER);

        // Configure App
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(990, 480);
        app.setLocation(150, 90);

        app.setVisible(true);


    }
}