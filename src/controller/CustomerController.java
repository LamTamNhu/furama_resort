package controller;

import model.Employee;
import services.ICustomerService;
import services.impl.CustomerService;

public class CustomerController extends PersonController {
    private final ICustomerService customerService = new CustomerService();

    @Override
    public Object getAll() {
        return customerService.getAll();
    }

    @Override
    public Object findById(String employeeId) {
        return null;
    }

    @Override
    public void addEntry(Employee employeeToAdd) {

    }

    @Override
    public void editEntry(String idToEdit, Employee editedEmployee) {

    }

    @Override
    public void removeEntry(String idToDelete) {

    }

    @Override
    public Object findByName(String employeeName) {
        return null;
    }
}
