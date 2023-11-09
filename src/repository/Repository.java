package repository;

public interface Repository {
    Object getAll();

    Object findById(String id);

    Object findByName(String name);

    boolean addEntry(Object entry);

    boolean removeByID(String id);

    void editEntry(String id, Object entry);

    void writeToFile();
}

