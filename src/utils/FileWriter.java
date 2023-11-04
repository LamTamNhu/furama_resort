package utils;

import java.io.*;

public class FileWriter {
    public static void writeObjectToFile(Object listToWrite, final String PATH) {
        ObjectOutputStream output = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH);
            output = new ObjectOutputStream(fileOutputStream);
            output.writeObject(listToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
