package services.impl;

import repository.Repository;
import repository.impl.FacilityRepository;
import services.IFacilityService;

public class FacilityService implements IFacilityService {
    Repository repository = new FacilityRepository();

    @Override
    public Object getAll() {
        return repository.getAll();
    }

    @Override
    public void addEntry(Object entry) {
        repository.addEntry(entry);
    }

    @Override
    public void editEntry(String id, Object editedEmployee) {

    }

    @Override
    public void removeEntry(String id) {

    }

    @Override
    public Object findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Object findByName(String name) {
        return null;
    }
}
