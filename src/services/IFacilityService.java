package services;

import model.facilities.Facility;

import java.util.LinkedHashMap;
import java.util.List;

public interface IFacilityService extends Service {
    LinkedHashMap<Facility, Integer> getMaintenance();
}
