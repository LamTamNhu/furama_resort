package controller;

import services.Service;
import services.impl.EmployeeService;

public class EmployeeController extends PersonController {
    private final Service employeeService = new EmployeeService();

    @Override
    public Object getAll() {
        return employeeService.getAll();
    }

    @Override
    public Object findById(String employeeId) {
        return employeeService.findById(employeeId);
    }

    @Override
    public void addEntry(Object employeeToAdd) {
        employeeService.addEntry(employeeToAdd);
    }

    @Override
    public void editEntry(String idToEdit, Object editedEmployee) {
        employeeService.editEntry(idToEdit, editedEmployee);
    }

    @Override
    public boolean removeEntry(String idToDelete) {
        return employeeService.removeEntry(idToDelete);
    }

    @Override
    public Object findByName(String employeeName) {
        return employeeService.findByName(employeeName);
    }
}
