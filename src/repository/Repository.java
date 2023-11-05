package repository;

import java.util.List;

public interface Repository {
    Object getAll();

    Object findById(String id);

    Object findByName(String name);

    void addEntry(Object entry);

    void removeByID(String id);

    void editEntry(String id, Object entry);
}

