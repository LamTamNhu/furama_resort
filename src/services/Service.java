package services;

import java.util.List;

public interface Service {
    Object getAll();

    void addEntry(Object entry);

    void editEntry(String id);

    void removeEntry(String id);

    Object findById(String id);

    Object findByName(String name);
}
