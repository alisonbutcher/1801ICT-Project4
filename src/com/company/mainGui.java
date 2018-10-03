package com.company;

import java.awt.*;
import javax.swing.*;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.JTextPane;

import java.awt.event.*;
import javax.swing.JOptionPane;
import javafx.print.PrinterJob;



/**
 *  Creates the GUI for the application
 */
public class mainGui {


    /**
     * Title of the text editor
     */
    private static final String APP_NAME = "Text Editor";


    /**
     * Main application frame
     */
    private static JFrame app;


    /**
     * Main Menu bar for the application
     */
    private static JMenuBar menuBar;


    /**
     * Top level items of menubar
     */
    private static JMenu fileMenu, editMenu, viewMenu, helpMenu;


    /**
     * Menu items of the File menu
     */
    private static JMenuItem mnuOpen, mnuClose, mnuSave, mnuPrint, mnuExit;


    /**
     * Menu items of the Edit menu
     */
    private static JMenuItem mnuCopy, mnuCut, mnuPaste, mnuSearch;


    /**
     * Menu items of the View menu
     */
    private static JMenuItem mnuShowSymbols;


    /**
     * Menu items of the Help menu
     */
    private static JMenuItem mnuHelp, mnuAbout;


    /**
     * Editor area for typing and editing text
     */
    private static JTextPane editor;


    /**
     * Scrollbar for editor window
     */
    private static JScrollPane editorScrollPane;


    /**
     * File Open/Save dialog
     */
    private static JFileChooser chooser = new JFileChooser();


    /**
     * Main GUI of Application
     *
     * @param args
     */
    public static void main(String[] args) {

        // Main App
        app = new JFrame(APP_NAME);

        // Add menu bar to App
        app.setJMenuBar(configureMenus());

        // Editor text area + scroll
        editor = new JTextPane();

        editor.setDocument(new DefaultStyledDocument());
        editorScrollPane = new JScrollPane(editor);
        app.add(editorScrollPane, BorderLayout.CENTER);



        // Configure App
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(990, 480);
        app.setLocation(150, 90);
        app.setVisible(true);

        // TODO: This will be called from the file open/save menu items

//        String test = fileDialog(false, app);

        about(app);

//       StyledDocument node = editor.getStyledDocument()
//
//        PrinterJob job = PrinterJob.createPrinterJob();
//        if (job != null && job.showPrintDialog(app){
//            boolean success = job.printPage(editor);
//            if (success) {
//                job.endJob();
//            }
//        }
    }


    /**
     *  Configures and creates the menu system for the main app
     *
     * @return JMenuBar containing all the menu items
     */
    private static JMenuBar configureMenus() {

        // Configure Top level menus
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        viewMenu = new JMenu("View");
        helpMenu = new JMenu("Help");

        // Open Menu Item
        mnuOpen = new JMenuItem("Open");
        mnuOpen.setMnemonic(KeyEvent.VK_O);
        mnuOpen.getAccessibleContext().setAccessibleDescription(
                "Open a new file");
        fileMenu.add(mnuOpen);

        // Close Menu Item
        mnuClose = new JMenuItem("Close");
        mnuClose.setMnemonic(KeyEvent.VK_W);
        mnuClose.getAccessibleContext().setAccessibleDescription(
                "Close the file");
        fileMenu.add(mnuClose);

        // Save Menu Item
        mnuSave = new JMenuItem("Save");
        mnuSave.setMnemonic(KeyEvent.VK_S);
        mnuSave.getAccessibleContext().setAccessibleDescription(
                "Save file");
        fileMenu.add(mnuSave);

        // Print Menu Item
        mnuPrint = new JMenuItem("Print");
        mnuPrint.setMnemonic(KeyEvent.VK_P);
        mnuPrint.getAccessibleContext().setAccessibleDescription(
                "Print");
        fileMenu.add(mnuPrint);

        // Quit Menu Item
        mnuExit = new JMenuItem("Quit");
        mnuExit.setMnemonic(KeyEvent.VK_Q);
        mnuExit.getAccessibleContext().setAccessibleDescription(
                "Quit");
        fileMenu.add(mnuExit);

        // Copy Menu Item
        mnuCopy = new JMenuItem("Copy");
        mnuCopy.setMnemonic(KeyEvent.VK_C);
        mnuCopy.getAccessibleContext().setAccessibleDescription(
                "Copy");
        editMenu.add(mnuCopy);

        // Cut Menu Item
        mnuCut = new JMenuItem("Cut");
        mnuCut.setMnemonic(KeyEvent.VK_K);
        mnuCut.getAccessibleContext().setAccessibleDescription(
                "Cut");
        editMenu.add(mnuCut);

        // Paste Menu Item
        mnuPaste = new JMenuItem("Paste");
        mnuPaste.setMnemonic(KeyEvent.VK_V);
        mnuPaste.getAccessibleContext().setAccessibleDescription(
                "Paste");
        editMenu.add(mnuPaste);

        // Search Menu Item
        mnuSearch = new JMenuItem("Search / Replace");
        mnuSearch.setMnemonic(KeyEvent.VK_F);
        mnuSearch.getAccessibleContext().setAccessibleDescription(
                "Search / Replace");
        editMenu.add(mnuSearch);

        // Show / Hide Symbols
        mnuShowSymbols = new JMenuItem("Show/Hide Symbols");
        mnuShowSymbols.setMnemonic(KeyEvent.VK_G);
        mnuShowSymbols.getAccessibleContext().setAccessibleDescription(
                "Show/Hide Symbols");
        viewMenu.add(mnuShowSymbols);

        // Help Menu Item
        mnuHelp = new JMenuItem("Help");
        mnuHelp.getAccessibleContext().setAccessibleDescription(
                "Help");
        helpMenu.add(mnuHelp);

        // About Menu Item
        mnuAbout = new JMenuItem("About");
        mnuAbout.getAccessibleContext().setAccessibleDescription(
                "About");
        helpMenu.add(mnuAbout);

        // Create menuBar
        menuBar = new JMenuBar();

        // Add Menus to Menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);

        return menuBar;
    }


    /**
     * Open or Save file dialog
     *
     * @param UseSaveDialog True for a save dialog, false for an open dialog
     * @param parentWindow The window that is calling this method
     * @return The file and path selected in the dialog
     */
    public static String fileDialog(boolean UseSaveDialog, JFrame parentWindow) {

        int result;
        String fileAndPath = "";

        // Is it a save or open
        if (UseSaveDialog) {
            result = chooser.showSaveDialog(parentWindow);
        } else {
            result = chooser.showOpenDialog(parentWindow);
        }

        // Set file and pathname
        if (result == JFileChooser.APPROVE_OPTION) {

            fileAndPath = chooser.getSelectedFile().getName();
        }

        return fileAndPath;
    }


    private static void about(JFrame parent) {
////        JOptionPane ao = new JOptionPane();
//        ao.setMessage(
//                "Text Editor\n" +
//                "Version: 1.0\n" +
//                "Author: Alison Butcher\n\n" +
//                "A project for 1801ICT Programming Languages\n"
//        );
//
//        ao.setIcon(null);
//
//        ao.createDialog(parent,"Text Editor");
//        ao.show

//
//        JOptionPane.showMessageDialog(
//                null,
//                "Text Editor\n" +
//                "Version: 1.0\n" +
//                "Author: Alison Butcher\n\n" +
//                "A project for 1801ICT Programming Languages\n");

    }

//    // Write StyledDocument to file
//    DefaultStyledDocument doc = (DefaultStyledDocument) getEditorDocument();
//
//try (OutputStream fos = new FileOutputStream(file__);
//    ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//
//        oos.writeObject(doc);
//    }
//...
//
//    // Read StyledDocument from file
//    StyledDocument doc = null;
//
//try (InputStream fis = new FileInputStream(file);
//    ObjectInputStream ois = new ObjectInputStream(fis)) {
//
//        doc = (DefaultStyledDocument) ois.readObject();
//    }






}