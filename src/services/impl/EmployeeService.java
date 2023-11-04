package services.impl;

import model.Employee;
import repository.impl.EmployeeRepository;
import services.IEmployeeService;

public class EmployeeService implements IEmployeeService {
    EmployeeRepository repository = new EmployeeRepository();


    @Override
    public Object getAll() {
        return repository.getAll();
    }

    @Override
    public void addEntry(Object entry) {
        repository.addEntry(entry);
    }

    @Override
    public void editEntry(String id, Employee editedEmployee) {
        repository.editEntry(id, editedEmployee);
    }

    @Override
    public void removeEntry(String id) {

    }

    @Override
    public Object findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Object findByName(String name) {
        return null;
    }
}
