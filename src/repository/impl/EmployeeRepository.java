package repository.impl;

import model.Employee;
import repository.IEmployeeRepository;
import utils.CsvFileReader;
import utils.CsvFileWriter;

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

    public String getPATH() {
        return PATH;
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


