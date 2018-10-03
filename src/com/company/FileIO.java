package com.company;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class FileIO {

    public FileIO () {

    }


    public String ReadFile(String fileName, String filePath) {


        // Build filename / path
        String path = filePath + fileName;


        String data = "";
        byte[] bytes;



        // Perform File Open / Read (new Java 8)
        try {

            bytes = Files.readAllBytes(Paths.get(path));
            data = new String(bytes, "UTF-8");


        } catch (IOException ioe) {

            // TODO: Error saving file message box

        }
        return data;
    }


    public void WriteFile(String fileName, String filePath, String fileData) {

        int noerrors = -1;

        // Build filename / path
        String path = filePath + fileName;

        // Put string into byte array
        byte[] data = fileData.getBytes();


        // Perform Save to file
        try {

            Files.write(Paths.get(path), data);

        } catch (IOException ioe) {

            // TODO: Error saving file message box
        } finally {

        }

    }


    private boolean validateFilePath() {
        return true;
    }


}
