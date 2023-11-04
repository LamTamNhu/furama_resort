package repository.impl;

import model.Employee;
import repository.IEmployeeRepository;
import utils.FileReader;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static List<Employee> employees = new ArrayList<>();

    private static void updateFromFile() {
        Object updatedList = FileReader.readObjectFromFile("src/data/EmployeeList.csv");
        employees = (List<Employee>) updatedList;
    }

    @Override
    public List<Employee> getAll() {
        updateFromFile();
        return employees;
    }

    @Override
    public Object findById(String id) {
        for (Employee e : employees) {
            if (id.equals(e.getEmployeeId())) {
                return e;
            }
        }
        return null;
    }

    @Override
    public Object findByName(String productName) {
        return null;
    }

    @Override
    public Boolean addEntry(Object product) {
        return null;
    }

    @Override
    public Boolean removeByID(Integer id) {
        return false;
    }

    @Override
    public Boolean editEntry(Integer id, Object product) {
        return false;
    }
}


