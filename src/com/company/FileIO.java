package com.company;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;



public class FileIO {

    public FileIO () {}


    public String ReadFile(String filePath) {


        String data = "";
        byte[] bytes;


        // Perform File Open / Read (new Java 8 style)
        try {
            bytes = Files.readAllBytes(Paths.get(filePath));
            data = new String(bytes, "UTF-8");


        } catch (IOException ioe) {

            JOptionPane.showMessageDialog(null, "In Catch Block");

            // TODO: Error saving file message box

        }
        return data;
    }


    public void WriteFile(String filePath, String fileData) {

        // Put string into byte array
        byte[] data = fileData.getBytes();


        // Perform File Save (new Java 8 style)
        try {

            Files.write(Paths.get(filePath), data);

        } catch (IOException ioe) {

            JOptionPane.showMessageDialog(null, "Error Writing file");
        }

    }


    private boolean validateFilePath() {
        return true;
    }


}
