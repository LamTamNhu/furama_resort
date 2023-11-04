package services;

import model.Employee;

public interface Service {
    Object getAll();

    void addEntry(Object entry);

    void editEntry(String id, Employee editedEmployee);

    void removeEntry(String id);

    Object findById(String id);

    Object findByName(String name);
}
