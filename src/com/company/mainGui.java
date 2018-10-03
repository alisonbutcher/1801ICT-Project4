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
     * Main GUI of Application
     *
     * @param args
     */
    public static void main(String[] args) {

        GuiApplication app = new GuiApplication();

//
//        // Main App
//        app = new JFrame(APP_NAME);
//
//        // Add menu bar to App
//        app.setJMenuBar(configureMenus());
//
//        // Editor text area + scroll
//        editor = new JTextPane();
//        editor.setContentType("text/plain");
//
//        editor.setDocument(new DefaultStyledDocument());
//        editorScrollPane = new JScrollPane(editor);
//        app.add(editorScrollPane, BorderLayout.CENTER);
//
//
//
//        // Configure App
//        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        app.setSize(990, 480);
//        app.setLocation(150, 90);
//        app.setVisible(true);
//
//        // TODO: This will be called from the file open/save menu items

//        String test = fileDialog(false, app);

//        about(app);
//        try {
//            boolean tr = editor.print();
//        } catch (Exception pex){
//
//        }


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



//
//    /**
//     * Open or Save file dialog
//     *
//     * @param UseSaveDialog True for a save dialog, false for an open dialog
//     * @param parentWindow The window that is calling this method
//     * @return The file and path selected in the dialog
////     */
//    public static String fileDialog(boolean UseSaveDialog, JFrame parentWindow) {
//
//        int result;
//        String fileAndPath = "";
//
//        // Is it a save or open
//        if (UseSaveDialog) {
//            result = chooser.showSaveDialog(parentWindow);
//        } else {
//            result = chooser.showOpenDialog(parentWindow);
//        }
//
//        // Set file and pathname
//        if (result == JFileChooser.APPROVE_OPTION) {
//
//            fileAndPath = chooser.getSelectedFile().getName();
//        }
//
//        return fileAndPath;
//    }


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