package utils;

import model.Employee;
import utils.enums.Gender;
import utils.enums.Position;
import utils.enums.Qualification;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private static Employee createFromParsed(String[] parsedLine) {
        String name = parsedLine[0];
        String birthday = parsedLine[1];
        Gender gender = Gender.valueOf(parsedLine[2]);
        String idNumber = parsedLine[3];
        String phoneNumber = parsedLine[4];
        String email = parsedLine[5];
        String employeeId = parsedLine[6];
        Qualification qualification = Qualification.valueOf(parsedLine[7]);
        Position position = Position.valueOf(parsedLine[8]);
        Double salary = Double.valueOf(parsedLine[9]);
        return new Employee(name, birthday, gender, idNumber, phoneNumber, email, employeeId, qualification, position, salary);
    }

    public static Object readObjectFromFile(final String PATH) {
        BufferedReader reader = null;
        final String SEPARATE_VALUE = ",";
        try {
            java.io.FileReader fileReader = new java.io.FileReader(PATH);
            reader = new BufferedReader(fileReader);
            String line;
            String[] parsedLine;
            List<Employee> result = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                parsedLine = line.split(SEPARATE_VALUE);
                result.add(createFromParsed(parsedLine));
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
