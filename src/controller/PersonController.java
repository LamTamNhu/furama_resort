package controller;

import model.Employee;
import services.IEmployeeService;
import services.impl.EmployeeService;

public abstract class PersonController {
    IEmployeeService employeeService = new EmployeeService();

    public abstract Object getAll();

    public abstract Object findById(String employeeId);

    public abstract void addEntry(Employee employeeToAdd);

    public abstract void editEntry(String idToEdit, Employee editedEmployee);

    public abstract void removeEntry(String idToDelete);

    public abstract Object findByName(String employeeName);
}
