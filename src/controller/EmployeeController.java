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
}
