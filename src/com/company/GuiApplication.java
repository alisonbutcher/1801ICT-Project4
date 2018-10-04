package com.company;

import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.*;

public class GuiApplication implements ActionListener, ItemListener{

    /**
     * Title of the text editor
     */
    private static final String APP_NAME = "Text Editor";


    /**
     * Main application frame
     */
    private JFrame app;

    /**
     * Main text editor area
     */
    private JTextPane editor;


    /**
     * fileName contains the name of the current file
     */
    private String fileName;


    /**
     *  filePath contains the location and name of the current file
     */
    private String filePath;

    /**
     * fileName contains the name of the current file
     */
    private String fileData;


    /**
     * The visual presentation part of the application
     */
    public GuiApplication() {

        // Main App
        app = new JFrame(APP_NAME);

        // Editor window
        editor = new JTextPane();
        editor.setContentType("text/plain");
        editor.setDocument(new DefaultStyledDocument());
        editor.setFont(new Font("Unifont", Font.PLAIN, 16));

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

        editor.setText("This is a test of the print function");// + (char) 9226 + (char) 9229 + (char) 9248 + (char) 8677);

        Functions d = new Functions();
        editor.setText(d.showUnicode("This is a test of the\tprint function" + System.lineSeparator()));
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
        mnuOpen = new JMenuItem("Open", KeyEvent.VK_O);
        mnuOpen.getAccessibleContext().setAccessibleDescription("Open a new file");
        mnuOpen.addActionListener(this);
        fileMenu.add(mnuOpen);


        // Close Menu Item
        mnuClose = new JMenuItem("Close", KeyEvent.VK_W);
        mnuClose.getAccessibleContext().setAccessibleDescription("Close the file");
        mnuClose.addActionListener(this);
        fileMenu.add(mnuClose);


        // Save Menu Item
        mnuSave = new JMenuItem("Save", KeyEvent.VK_S);
        mnuSave.getAccessibleContext().setAccessibleDescription("Save file");
        mnuSave.addActionListener(this);
        fileMenu.add(mnuSave);


        // Print Menu Item
        mnuPrint = new JMenuItem("Print", KeyEvent.VK_P);
        mnuPrint.getAccessibleContext().setAccessibleDescription("Print");
        mnuPrint.addActionListener(this);
        fileMenu.add(mnuPrint);


        // Quit Menu Item
        mnuExit = new JMenuItem("Quit", KeyEvent.VK_Q);
        mnuExit.getAccessibleContext().setAccessibleDescription("Quit");
        mnuExit.addActionListener(this);
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
        mnuSearch.addActionListener(this);
        editMenu.add(mnuSearch);


        mnuShowSymbols = new JCheckBoxMenuItem("Show/Hide Symbols");
        mnuShowSymbols.setMnemonic(KeyEvent.VK_G);
        mnuShowSymbols.getAccessibleContext().setAccessibleDescription("Show/Hide Symbols");
        mnuShowSymbols.addItemListener(this);
        viewMenu.add(mnuShowSymbols);

        // Help Menu Item
        mnuHelp = new JMenuItem("Help", KeyEvent.VK_H);
        mnuHelp.getAccessibleContext().setAccessibleDescription("Help");
        mnuHelp.addActionListener(this);
        helpMenu.add(mnuHelp);


        // About Menu Item
        mnuAbout = new JMenuItem("About");
        mnuAbout.getAccessibleContext().setAccessibleDescription("About");
        mnuAbout.addActionListener(this);
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
     * Save file dialog
     *
     * @param parentWindow The window that is calling this method
     * @param editorWindow is the editor area JTextPane object
     * @return The file and path selected in the dialog
    */
    private boolean saveDialog(JFrame parentWindow, JTextPane editorWindow) {
        JFileChooser chooser = new JFileChooser();

        int result = chooser.showSaveDialog(parentWindow);

        fileData = editorWindow.getText();

        if (result == JFileChooser.APPROVE_OPTION) {
            fileName = chooser.getSelectedFile().getName();
            filePath = chooser.getSelectedFile().getPath();
            FileIO out = new FileIO();
            out.WriteFile(filePath, fileData);
        }

        return true;  // TODO: Return based on what happens
    }

    /**
     * Provides an Open file Dialog
     * @param parentWindow is the main application window
     * @return String representing entire contents of file
     */
    private String openDialog(JFrame parentWindow) {
        JFileChooser chooser = new JFileChooser();
        String data = "";
        int result = chooser.showOpenDialog(parentWindow);

        if (result == JFileChooser.APPROVE_OPTION) {
            fileName = chooser.getSelectedFile().getName();
            filePath = chooser.getSelectedFile().getPath();
            FileIO in = new FileIO();
            data = in.ReadFile(filePath);
        }

        return data;
    }



    private void printDialog(JTextPane editorWindow) {

        try {
            boolean tr = editorWindow.print();
        } catch (Exception pex){
            JOptionPane.showMessageDialog(app, "Print Error");
        }

    }


    private void aboutDialog(JFrame parentWindow) {
        String msg = "Text Editor\nVersion: 1.0\n";
        msg += "Author: Alison Butcher\n\n";
        msg += "A project for 1801ICT Programming Languages\n";

        JOptionPane.showMessageDialog(parentWindow, msg);
    }

    // Handles events for show / hide symbols
    public void itemStateChanged(ItemEvent e) {
        Functions u = new Functions();

        if (e.getStateChange() == 2) {
            editor.setText(u.hideUnicode(editor.getText()));
        } else {
            editor.setText(u.showUnicode(editor.getText()));
        }
    }

    // Handles events from menu
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case"Open":
                editor.setText(openDialog(app));
                break;
            case "Save":
                saveDialog(app, editor);
                break;
            case "Print":
                printDialog(editor);
                break;
            case "Quit":
                System.exit(0);
                break;
            case "Close":
                editor.setText("");
                break;
            case "About":
                aboutDialog(app);
                break;
            default:
                break;

        }
    }





}
