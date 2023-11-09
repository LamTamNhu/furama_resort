package repository;

import model.facilities.Facility;

import java.util.LinkedHashMap;

public interface IFacilityRepository extends Repository {
    LinkedHashMap<Facility, Integer> getMaintenance();
}
