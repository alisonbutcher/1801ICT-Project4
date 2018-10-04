package com.company;

import javax.swing.JOptionPane;
import java.io.UnsupportedEncodingException;

public class Functions {

    public Functions () {}

    public String showUnicode(String data) {
        String newString = "";

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);

            if (c == ' '){
                newString += (char) 9248;       // Space
            } else if (c == '\t') {
                newString += (char) 8677;       // Tab
            } else if (c == '\n') {
                newString += (char) 9226 + System.getProperty("line.separator");       // Linefeed
            } else if (c == '\r') {
                newString += (char) 9229;       // Carriage Return
            } else {
                newString += data.charAt(i);
            }
        }
        return newString;
    }


    public String hideUnicode(String data) {
        String newString = "";

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);

            if (c == (char) 9248){
                newString += " ";              // Space
            } else if (c == (char) 8677) {
                newString += "\t";             // Tab
            } else if (c == (char) 9226) {
                newString += "\n";
                i = i +2 ;// Linefeed
            } else if (c == (char) 9229) {
                newString += "\r";             // Carriage Return
            } else {
                newString += data.charAt(i);
            }
        }
        return newString;
    }


    public void search(String data) {

    }

    public void replace(String data) {

    }

}
