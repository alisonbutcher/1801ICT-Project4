package com.company;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JTextField;


public class FileDialog extends JFrame {

    private JTextField fileName = new JTextField();
    private JTextField filePath = new JTextField();

    private JButton open = new JButton("Open");
    private JButton save = new JButton("Save");

    public FileDialog() {

        // Main File dialog
        JPanel fileDialog = new JPanel();

        // Add Save file listener
        save.addActionListener(new SaveListener());
        fileDialog.add(save);

        // Add Open file listener
        open.addActionListener(new OpenListener());
        fileDialog.add(open);

        // Main fileDialog container
        Container container = getContentPane();
        container.add(fileDialog, BorderLayout.SOUTH);

        // configure filename and directory
        filePath.setEditable(false);
        fileName.setEditable(false);

        // setup file dialog
        fileDialog = new JPanel();
        fileDialog.setLayout(new GridLayout(2, 1));
        fileDialog.add(fileName);
        fileDialog.add(filePath);

        // Create dialog
        container.add(fileDialog, BorderLayout.NORTH);
    }

    class OpenListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JFileChooser chooser = new JFileChooser();

            // Get file to Open
            int rVal = chooser.showOpenDialog(FileDialog.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {

                fileName.setText(chooser.getSelectedFile().getName());
                filePath.setText(chooser.getCurrentDirectory().toString());

            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                fileName.setText("");
                filePath.setText("");
            }
        }
    }

    class SaveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();
            int rVal = chooser.showSaveDialog(FileDialog.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                fileName.setText(chooser.getSelectedFile().getName());
                filePath.setText(chooser.getCurrentDirectory().toString());
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                fileName.setText("");
                filePath.setText("");
            }
        }
    }


    public static void CreateFileDialog() {
        FileDialog box = new FileDialog();
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        box.setSize(250, 140);
        box.setVisible(true);
    }
}