package controller;

import model.facilities.Facility;
import services.IFacilityService;
import services.Service;
import services.impl.FacilityService;

import java.util.LinkedHashMap;

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

    public boolean remove(String idToRemove) {
        return facilityService.removeEntry(idToRemove);
    }

    public void writeToFile() {
        facilityService.writeToFile();
    }

    public LinkedHashMap<Facility, Integer> getMaintenance() {
        IFacilityService temp = (IFacilityService) facilityService;
        return temp.getMaintenance();
    }
}
