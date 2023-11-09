package services.impl;

import services.IContactService;

public class ContactService implements IContactService {
    @Override
    public Object getAll() {
        return null;
    }

    @Override
    public boolean addEntry(Object entry) {

        return false;
    }

    @Override
    public void editEntry(String id, Object editedEmployee) {

    }

    @Override
    public boolean removeEntry(String id) {
        return true;
    }

    @Override
    public Boolean findById(String id) {
        return null;
    }

    @Override
    public Boolean findByName(String name) {
        return null;
    }

    @Override
    public void writeToFile() {

    }
}
