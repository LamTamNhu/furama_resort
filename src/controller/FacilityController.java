package controller;

import model.facilities.Facility;
import services.Service;
import services.impl.FacilityService;

public class FacilityController {
    private final Service facilityService = new FacilityService();

    public Object getAll() {
        return facilityService.getAll();
    }

    public Object findById(String id) {
        return facilityService.findById(id);
    }

    public void addEntry(Facility entryToAdd) {
        facilityService.addEntry(entryToAdd);
    }
}
