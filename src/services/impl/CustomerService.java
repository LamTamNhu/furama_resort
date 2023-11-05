package services.impl;

import model.Employee;
import repository.impl.CustomerRepository;
import services.ICustomerService;

public class CustomerService implements ICustomerService {
    private final CustomerRepository repository = new CustomerRepository();

    @Override
    public Object getAll() {
        return repository.getAll();
    }

    @Override
    public void addEntry(Object entry) {

    }

    @Override
    public void editEntry(String id, Employee editedEmployee) {

    }

    @Override
    public void removeEntry(String id) {

    }

    @Override
    public Boolean findById(String id) {
        return null;
    }

    @Override
    public Boolean findByName(String name) {
        return null;
    }
}
