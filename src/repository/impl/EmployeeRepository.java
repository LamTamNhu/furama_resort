package repository.impl;

import model.Employee;
import repository.IEmployeeRepository;
import utils.CsvFileReader;
import utils.CsvFileWriter;
import utils.enums.Gender;
import utils.enums.Position;
import utils.enums.Qualification;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static List<Employee> employees = new ArrayList<>();
    private static final String PATH = "src/data/EmployeeList.csv";
    private static final String SEPARATOR = ",";

    private static List<String> convertListToCsvFormat() {

        List<String> convertedList = new ArrayList<>();
        StringBuilder employeeToString = new StringBuilder();
        for (Employee e : employees) {
            employeeToString.setLength(0);
            employeeToString.append(e.getName()).append(SEPARATOR);
            employeeToString.append(e.getBirthDate()).append(SEPARATOR);
            employeeToString.append(e.getGender()).append(SEPARATOR);
            employeeToString.append(e.getIdNumber()).append(SEPARATOR);
            employeeToString.append(e.getPhoneNumber()).append(SEPARATOR);
            employeeToString.append(e.getEmail()).append(SEPARATOR);
            employeeToString.append(e.getEmployeeId()).append(SEPARATOR);
            employeeToString.append(e.getQualification()).append(SEPARATOR);
            employeeToString.append(e.getPosition()).append(SEPARATOR);
            employeeToString.append(e.getSalary());

            convertedList.add(String.valueOf(employeeToString));
        }
        return convertedList;
    }

    public static List<Employee> convertCsvFormatToList(List<String> rawListFromCsv) {
        List<Employee> updatedList = new ArrayList<>();
        String[] parsedLine;
        for (String line : rawListFromCsv) {
            parsedLine = line.split(SEPARATOR);
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
            updatedList.add(new Employee(name, birthday, gender, idNumber, phoneNumber, email, employeeId, qualification, position, salary));
        }
        return updatedList;
    }

    private static void updateFromFile() {
        List<String> rawCsvFromFile = CsvFileReader.readObjectFromFile(PATH);
        if (rawCsvFromFile == null) {
            System.out.println("Can't update from empty file.");
            return;
        }
        employees = convertCsvFormatToList(rawCsvFromFile);
    }

    private static void writeToFile() {
        CsvFileWriter.writeObjectToFile(convertListToCsvFormat(), PATH);
    }


    @Override
    public List<Employee> getAll() {
        updateFromFile();
        return employees;
    }

    @Override
    public Object findById(String id) {
        updateFromFile();
        for (Employee e : employees) {
            if (id.equals(e.getEmployeeId())) {
                return e;
            }
        }
        return null;
    }

    @Override
    public Object findByName(String employeeName) {
        updateFromFile();
        List<Employee> result = new ArrayList<>();
        employeeName = employeeName.toUpperCase();
        String employeeNameInList;
        for (Employee e : employees) {
            employeeNameInList = e.getName().toUpperCase();
            if (employeeNameInList.contains(employeeName)) {
                result.add(e);
            }
        }
        return result;
    }

    @Override
    public void addEntry(Object employee) {
        updateFromFile();
        employees.add((Employee) employee);
        writeToFile();
    }

    @Override
    public void removeByID(String id) {
        updateFromFile();
        int length = employees.size();
        for (int i = 0; i < length; i++) {
            if (id.equals(employees.get(i).getEmployeeId())) {
                employees.remove(i);
                break;
            }
        }
        writeToFile();
    }

    @Override
    public void editEntry(String id, Object employee) {
        updateFromFile();
        int length = employees.size();
        for (int i = 0; i < length; i++) {
            if (id.equals(employees.get(i).getEmployeeId())) {
                employees.set(i, (Employee) employee);
            }
        }
        writeToFile();
    }
}


