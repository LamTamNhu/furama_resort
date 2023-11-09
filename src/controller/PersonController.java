package controller;

public abstract class PersonController {

    public abstract Object getAll();

    public abstract Object findById(String databaseId);

    public abstract void addEntry(Object entryToAdd);

    public abstract void editEntry(String idToEdit, Object entryToEdit);

    public abstract boolean removeEntry(String idToDelete);

    public abstract Object findByName(String name);
}
