package ru.sayakhov.methods;

import java.io.*;

public class WriteEncoder {
    public static void writeOutput(String str, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            Writer out = new OutputStreamWriter(fos, "ISO-8859-5");
            out.write(str);
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
