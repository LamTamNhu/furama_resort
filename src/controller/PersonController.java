package controller;

import model.Employee;
import services.IEmployeeService;
import services.Service;
import services.impl.EmployeeService;

public abstract class PersonController {

    public abstract Object getAll();

    public abstract Object findById(String databaseId);

    public abstract void addEntry(Object entryToAdd);

    public abstract void editEntry(String idToEdit, Object entryToEdit);

    public abstract void removeEntry(String idToDelete);

    public abstract Object findByName(String name);
}
