package controller;

import model.Employee;
import services.IEmployeeService;
import services.impl.EmployeeService;

public class EmployeeController extends PersonController {

    @Override
    public Object getAll() {
        return employeeService.getAll();
    }

    @Override
    public Object findById(String employeeId) {
        return employeeService.findById(employeeId);
    }

    @Override
    public void addEntry(Employee employeeToAdd) {
        employeeService.addEntry(employeeToAdd);
    }

    @Override
    public void editEntry(String idToEdit, Employee editedEmployee) {
        employeeService.editEntry(idToEdit,editedEmployee);
    }

    @Override
    public void removeEntry(String idToDelete) {
        employeeService.removeEntry(idToDelete);
    }

    @Override
    public Object findByName(String employeeName) {
        return employeeService.findByName(employeeName);
    }
}
