package services.impl;

import model.Employee;
import repository.impl.EmployeeRepository;
import services.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    EmployeeRepository repository = new EmployeeRepository();


    @Override
    public Object getAll() {
        return repository.getAll();
    }

    @Override
    public void addEntry(Object entry) {
    }

    @Override
    public void editEntry(String id) {

    }

    @Override
    public void removeEntry(String id) {

    }

    @Override
    public Object findById(String id) {
        return null;
    }

    @Override
    public Object findByName(String name) {
        return null;
    }
}
