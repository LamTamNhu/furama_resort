package services.impl;

import repository.impl.CustomerRepository;
import services.ICustomerService;

public class CustomerService implements ICustomerService {
    private final CustomerRepository repository = new CustomerRepository();

    @Override
    public Object getAll() {
        return repository.getAll();
    }

    @Override
    public boolean addEntry(Object entry) {
        repository.addEntry(entry);
        return false;
    }

    @Override
    public void editEntry(String id, Object editedEmployee) {
        repository.editEntry(id, editedEmployee);
    }

    @Override
    public boolean removeEntry(String id) {
        return repository.removeByID(id);
    }

    @Override
    public Object findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Object findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void writeToFile() {

    }
}
