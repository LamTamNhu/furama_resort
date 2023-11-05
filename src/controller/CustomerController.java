package controller;

import services.Service;
import services.impl.CustomerService;

public class CustomerController extends PersonController {
    private final Service customerService = new CustomerService();

    @Override
    public Object getAll() {
        return customerService.getAll();
    }

    @Override
    public Object findById(String customerId) {
        return null;
    }

    @Override
    public void addEntry(Object customerToAdd) {
        customerService.addEntry(customerToAdd);
    }

    @Override
    public void editEntry(String idToEdit, Object editedCustomer) {

    }

    @Override
    public void removeEntry(String idToDelete) {

    }

    @Override
    public Object findByName(String name) {
        return null;
    }
}
