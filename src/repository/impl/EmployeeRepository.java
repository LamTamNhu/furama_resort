package repository.impl;

import model.human.Employee;
import repository.IEmployeeRepository;
import utils.file_io.CsvFileReader;
import utils.file_io.CsvFileWriter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final List<Employee> employees = new ArrayList<>();
    private final String PATH = "src/data/employee.csv";


    private void updateFromFile() {
        List<String> rawCsvList = CsvFileReader.readObjectFromFile(PATH);
        if (rawCsvList == null) {
            System.out.println("Reading from empty csv file.");
            return;
        }
        employees.clear();
        for (String line : rawCsvList) {
            Employee employeeToAdd = new Employee();
            employeeToAdd.setAttributesFromCsvFormat(line);
            employees.add(employeeToAdd);
        }
    }

    private void writeToFile() {
        List<String> listToWrite = new ArrayList<>();
        for (Employee e : employees) {
            listToWrite.add(e.convertAttributesToCsvFormat());
        }
        CsvFileWriter.writeObjectToFile(listToWrite, PATH);
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
    public Object findByName(String name) {
        updateFromFile();
        List<Employee> result = new ArrayList<>();
        name = name.toUpperCase();
        String employeeNameInList;
        for (Employee e : employees) {
            employeeNameInList = e.getName().toUpperCase();
            if (employeeNameInList.contains(name)) {
                result.add(e);
            }
        }
        return result;
    }

    @Override
    public void addEntry(Object entry) {
        updateFromFile();
        employees.add((Employee) entry);
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
    public void editEntry(String id, Object entry) {
        updateFromFile();
        int length = employees.size();
        for (int i = 0; i < length; i++) {
            if (id.equals(employees.get(i).getEmployeeId())) {
                employees.set(i, (Employee) entry);
            }
        }
        writeToFile();
    }
}


