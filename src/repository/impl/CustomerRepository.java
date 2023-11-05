package repository.impl;

import model.Customer;
import repository.ICustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final List<Customer> customers = new ArrayList<>();
    private final String PATH = "src/controller/CustomerController.java";
    private final String SEPARATOR = ",";

    private void updateFromFile() {

    }

    private void writeToFile() {
    }

    @Override
    public Object getAll() {
        return null;
    }

    @Override
    public Object findById(String id) {
        return null;
    }

    @Override
    public Object findByName(String productName) {
        return null;
    }

    @Override
    public void addEntry(Object product) {

    }

    @Override
    public void removeByID(String id) {

    }

    @Override
    public void editEntry(String id, Object product) {

    }
}
