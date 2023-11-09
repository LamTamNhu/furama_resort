package services;

public interface Service {
    Object getAll();

    boolean addEntry(Object entry);

    void editEntry(String id, Object editedEmployee);

    boolean removeEntry(String id);

    Object findById(String id);

    Object findByName(String name);

    void writeToFile();
}
