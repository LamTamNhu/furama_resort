package services;

public interface Service {
    Object getAll();

    void addEntry(Object entry);

    void editEntry(String id, Object editedEmployee);

    void removeEntry(String id);

    Object findById(String id);

    Object findByName(String name);
}
