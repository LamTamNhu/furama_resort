package repository;

import java.util.List;

public interface Repository {
    Object getAll();

    Object findById(String id);

    Object findByName(String productName);

    void addEntry(Object product);

    void removeByID(String id);

    void editEntry(String id, Object product);
}

