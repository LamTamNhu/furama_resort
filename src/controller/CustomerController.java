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
        return customerService.findById(customerId);
    }

    @Override
    public void addEntry(Object customerToAdd) {
        customerService.addEntry(customerToAdd);
    }

    @Override
    public void editEntry(String idToEdit, Object editedCustomer) {
        customerService.editEntry(idToEdit, editedCustomer);
    }

    @Override
    public boolean removeEntry(String idToDelete) {
        return customerService.removeEntry(idToDelete);
    }

    @Override
    public Object findByName(String name) {
        return customerService.findByName(name);
    }
}
