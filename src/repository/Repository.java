package repository;

import java.util.List;

public interface Repository {
    Object getAll();

    Object findById(String id);

    Object findByName(String productName);

    Boolean addEntry(Object product);

    Boolean removeByID(Integer id);

    Boolean editEntry(Integer id, Object product);
}

