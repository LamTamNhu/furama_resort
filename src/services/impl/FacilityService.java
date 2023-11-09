package services.impl;

import model.facilities.Facility;
import repository.Repository;
import repository.impl.FacilityRepository;
import services.IFacilityService;

import java.util.LinkedHashMap;
import java.util.List;

public class FacilityService implements IFacilityService {
    private final Repository repository = new FacilityRepository();

    @Override
    public Object getAll() {
        return repository.getAll();
    }

    @Override
    public boolean addEntry(Object entry) {
        repository.addEntry(entry);
        return false;
    }

    @Override
    public void editEntry(String id, Object editedEmployee) {

    }

    @Override
    public boolean removeEntry(String id) {
        return repository.removeByID(id);
    }

    @Override
    public Object findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Object findByName(String name) {
        return null;
    }

    @Override
    public void writeToFile() {
        repository.writeToFile();
    }

    @Override
    public LinkedHashMap<Facility, Integer> getMaintenance() {
        FacilityRepository temp = (FacilityRepository) repository;
        return temp.getMaintenance();
    }
}
