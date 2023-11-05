package controller;

import model.Employee;
import services.IEmployeeService;
import services.impl.EmployeeService;

public class EmployeeController {
    IEmployeeService employeeService = new EmployeeService();

    public Object getAll() {
        return employeeService.getAll();
    }

    public Object findById(String employeeId) {
        return employeeService.findById(employeeId);
    }

    public void addEmployee(Employee employeeToAdd) {
        employeeService.addEntry(employeeToAdd);
    }

    public void editEmployee(String idToEdit, Employee editedEmployee) {
        employeeService.editEntry(idToEdit,editedEmployee);
    }

    public void removeEmployee(String idToDelete) {
        employeeService.removeEntry(idToDelete);
    }

    public Object findByName(String employeeName) {
        return employeeService.findByName(employeeName);
    }
}
