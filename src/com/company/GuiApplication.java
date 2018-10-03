package com.company;

import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GuiApplication {

    /**
     * Title of the text editor
     */
    private static final String APP_NAME = "Text Editor";


    /**
     * Main application frame
     */
    private JFrame app;


    /**
     * fileName contains the name of the current file
     */
    private String fileName;


    /**
     *  filePath contains the location of the current file
     */
    private String filePath;

    private String fileData;


    /**
     * The visual presentation part of the application
     */
    public GuiApplication() {

        // Main App
        app = new JFrame(APP_NAME);

        // Editor window
        JTextPane editor = new JTextPane();
        editor.setContentType("text/plain");
        editor.setDocument(new DefaultStyledDocument());

        // Scrolling Pane
        JScrollPane editorScrollPane = new JScrollPane(editor);

        // Attach editor/scrollbar to the application
        app.add(editorScrollPane, BorderLayout.CENTER);

        // Add top menu bar to App
        app.setJMenuBar(TopMenu());


        // Configure App
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(990, 480);
        app.setLocation(150, 90);

        // Display
        app.setVisible(true);

        editor.setText("This is a test of the print function");

        printDialog(editor);

        saveDialog(app, editor);
    }



    /**
     *  Configures and creates the menu system for the main app
     *
     * @return JMenuBar containing all the menu items
     */
    private JMenuBar TopMenu() {


        /**
         * Main Menu bar for the application
         */
        JMenuBar menuBar;


        /**
         * Top level items of menu bar
         */
        JMenu fileMenu, editMenu, viewMenu, helpMenu;


        /**
         * Menu items of the File menu
         */
        JMenuItem mnuOpen, mnuClose, mnuSave, mnuPrint, mnuExit;


        /**
         * Menu items of the Edit menu
         */
        JMenuItem mnuCopy, mnuCut, mnuPaste, mnuSearch;


        /**
         * Menu items of the View menu
         */
        JMenuItem mnuShowSymbols;


        /**
         * Menu items of the Help menu
         */
        JMenuItem mnuHelp, mnuAbout;


        // Configure Top level menus
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        viewMenu = new JMenu("View");
        helpMenu = new JMenu("Help");


        // Open Menu Item
        //        mnuOpen = new JMenuItem("Open", KeyEvent.VK_O);
        mnuOpen = new JMenuItem("Open", KeyEvent.VK_O);
        mnuOpen.getAccessibleContext().setAccessibleDescription("Open a new file");
        fileMenu.add(mnuOpen);


        // Close Menu Item
        mnuClose = new JMenuItem("Close", KeyEvent.VK_W);
        mnuClose.getAccessibleContext().setAccessibleDescription("Close the file");
        fileMenu.add(mnuClose);


        // Save Menu Item
        mnuSave = new JMenuItem("Save", KeyEvent.VK_S);
        mnuSave.getAccessibleContext().setAccessibleDescription("Save file");
        fileMenu.add(mnuSave);


        // Print Menu Item
        mnuPrint = new JMenuItem("Print", KeyEvent.VK_P);
        mnuPrint.getAccessibleContext().setAccessibleDescription("Print");
        fileMenu.add(mnuPrint);


        // Quit Menu Item
        mnuExit = new JMenuItem("Quit", KeyEvent.VK_Q);
        mnuExit.getAccessibleContext().setAccessibleDescription("Quit");
        fileMenu.add(mnuExit);


        // Copy Menu Item
        mnuCopy = new JMenuItem("Copy", KeyEvent.VK_C);
        mnuCopy.getAccessibleContext().setAccessibleDescription("Copy");;
        editMenu.add(mnuCopy);


        // Cut Menu Item
        mnuCut = new JMenuItem("Cut", KeyEvent.VK_K);
        mnuCut.getAccessibleContext().setAccessibleDescription("Cut");
        editMenu.add(mnuCut);


        // Paste Menu Item
        mnuPaste = new JMenuItem("Paste", KeyEvent.VK_V);
        mnuPaste.getAccessibleContext().setAccessibleDescription("Paste");
        editMenu.add(mnuPaste);


        // Search Menu Item
        mnuSearch = new JMenuItem("Search / Replace", KeyEvent.VK_F);
        mnuSearch.getAccessibleContext().setAccessibleDescription("Search / Replace");
        editMenu.add(mnuSearch);


        // Show / Hide Symbols
        mnuShowSymbols = new JMenuItem("Show/Hide Symbols", KeyEvent.VK_G);
        mnuShowSymbols.getAccessibleContext().setAccessibleDescription("Show/Hide Symbols");
        viewMenu.add(mnuShowSymbols);


        // Help Menu Item
        mnuHelp = new JMenuItem("Help", KeyEvent.VK_H);
        mnuHelp.getAccessibleContext().setAccessibleDescription("Help");
        helpMenu.add(mnuHelp);


        // About Menu Item
        mnuAbout = new JMenuItem("About");
        mnuAbout.getAccessibleContext().setAccessibleDescription("About");
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
     * @param isSaveDialog True for a save dialog, false for an open dialog
     * @param parentWindow The window that is calling this method
     * @return The file and path selected in the dialog
    */
//    private boolean fileDialog(boolean isSaveDialog, JFrame parentWindow) {
//
////        JFileChooser chooser = new JFileChooser();
////        boolean fileChosen = false;
////        int result;
////
////        // Is it a save or open
////        if (isSaveDialog) {
////            result = chooser.showSaveDialog(parentWindow);
////        } else {
////            result = chooser.showOpenDialog(parentWindow);
////        }
////
////        // Set file and pathname
////        if (result == JFileChooser.APPROVE_OPTION) {
////
////            fileName = chooser.getSelectedFile().getName();
////            filePath = chooser.getSelectedFile().getPath();
////
////            if result  =
////        }
////        //TODO: This will call classes to handle opening new file or saving
////        return fileChosen;
//    }


    private boolean saveDialog(JFrame parentWindow, JTextPane editorWindow) {
        JFileChooser chooser = new JFileChooser();

        int result = chooser.showSaveDialog(parentWindow);

        fileData = editorWindow.getText();

        if (result == JFileChooser.APPROVE_OPTION) {
            fileName = chooser.getSelectedFile().getName();
            filePath = chooser.getSelectedFile().getPath();
            FileIO out = new FileIO();
            out.WriteFile(fileName, filePath, fileData);
        }

        return true;  // TODO: Return based on what happens
    }




    private void printDialog(JTextPane editorWindow) {

        // TODO: Clean up the error handling
        try {
            boolean tr = editorWindow.print();
        } catch (Exception pex){

        }

    }








}
