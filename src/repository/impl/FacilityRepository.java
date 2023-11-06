package repository.impl;

import model.Facility;
import repository.IFacilityRepository;

import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {
    private static final LinkedHashMap<Facility, Integer> facilities = new LinkedHashMap<>();

    private void updateFromFile() {
    }

    private void writeToFile() {
    }

    @Override
    public Object getAll() {
        updateFromFile();
        return facilities;
    }

    @Override
    public Object findById(String id) {
        for (Facility e : facilities.keySet()) {
            if (id.equals(e.getId())) {
                return e;
            }
        }
        return null;
    }

    @Override
    public Object findByName(String name) {
        return null;
    }

    @Override
    public void addEntry(Object entry) {
        updateFromFile();
        facilities.put((Facility) entry, 0);
        writeToFile();
    }


    @Override
    public void removeByID(String id) {
    }

    @Override
    public void editEntry(String id, Object entry) {

    }
}
