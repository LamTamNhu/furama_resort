package utils.file_io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriter {
    public static void writeObjectToFile(List<String> listToWrite, final String PATH) {
        BufferedWriter writer = null;
        try {
            FileWriter fileWriter = new FileWriter(PATH);
            writer = new BufferedWriter(fileWriter);
            for (String e : listToWrite) {
                writer.write(e);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
