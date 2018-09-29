package ru.sayakhov.methods;

import java.io.*;

public class ReaderEncoder {
    public static String readInput(String fileName) {
        StringBuffer buffer = new StringBuffer();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis, "UTF8");
            Reader in = new BufferedReader(isr);
            int ch;
            while ((ch = in.read()) > -1) {
                buffer.append((char)ch);
            }
            in.close();
            return buffer.toString();
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
