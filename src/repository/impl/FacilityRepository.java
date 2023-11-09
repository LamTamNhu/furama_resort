package repository.impl;

import model.facilities.Facility;
import model.facilities.House;
import model.facilities.Room;
import model.facilities.Villa;
import repository.IFacilityRepository;
import utils.file_io.CsvFileReader;
import utils.file_io.CsvFileWriter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class FacilityRepository implements IFacilityRepository {
    private static final LinkedHashMap<Facility, Integer> facilities = new LinkedHashMap<>();
    private static final String PATH = "src/data/facility.csv";
    private static final String SEPARATOR = ",";

    private void updateFromFile() {
        List<String> listToRead = CsvFileReader.readObjectFromFile(PATH);
        if (listToRead == null) {
            System.out.println("List is empty!");
            return;
        }
        facilities.clear();
        Facility keyToAdd = null;
        String[] attributesList;
        String id;
        Villa.Type villaType;
        double poolArea;
        int floorCount;
        House.HouseType houseType;
        String complimentary;
        int value = 0;

        for (String line : listToRead) {
            attributesList = line.split(SEPARATOR);
            id = attributesList[0];

            if (id.contains("SVVL")) {
                villaType = Villa.Type.valueOf(attributesList[6]);
                poolArea = Double.parseDouble(attributesList[7]);
                floorCount = Integer.parseInt(attributesList[8]);
                value = Integer.parseInt(attributesList[9]);
                keyToAdd = new Villa(villaType, poolArea, floorCount);
            } else if (id.contains("SVHO")) {
                houseType = House.HouseType.valueOf(attributesList[6]);
                floorCount = Integer.parseInt(attributesList[7]);
                value = Integer.parseInt(attributesList[8]);
                keyToAdd = new House(houseType, floorCount);
            } else if (id.contains("SVRO")) {
                complimentary = attributesList[6];
                value = Integer.parseInt(attributesList[7]);
                keyToAdd = new Room(complimentary);
            }
            fillFacilityAttributes(attributesList, keyToAdd);
            facilities.put(keyToAdd, value);
        }
    }

    private void fillFacilityAttributes(String[] attributesList, Facility facility) {
        String id = attributesList[0];
        String name = attributesList[1];
        double area = Double.parseDouble(attributesList[2]);
        double fee = Double.parseDouble(attributesList[3]);
        int maxCapacity = Integer.parseInt(attributesList[4]);
        Facility.RentType rentType = Facility.RentType.valueOf(attributesList[5]);
        facility.setId(id);
        facility.setName(name);
        facility.setArea(area);
        facility.setFee(fee);
        facility.setMaxCapacity(maxCapacity);
        facility.setRentType(rentType);
    }

    @Override
    public void writeToFile() {
        if (facilities.isEmpty()) {
            System.out.println("Writing an empty list!");
            return;
        }
        Set<Facility> keys = facilities.keySet();
        List<String> listToWrite = new ArrayList<>();
        StringBuilder line;
        for (Facility e : keys) {
            line = new StringBuilder(e.getId() + SEPARATOR + e.getName() + SEPARATOR + e.getArea() + SEPARATOR +
                                     e.getFee() + SEPARATOR + e.getMaxCapacity() + SEPARATOR + e.getRentType() +
                                     SEPARATOR);
            if (e instanceof Villa) {
                Villa temp = (Villa) e;
                line.append(temp.getType()).append(SEPARATOR).append(temp.getPoolArea()).
                        append(SEPARATOR).append(temp.getFloorCount());
            } else if (e instanceof House) {
                House temp = (House) e;
                line.append(temp.getHouseType()).append(SEPARATOR).append(temp.getFloorCount());
            } else {
                Room temp = (Room) e;
                line.append(temp.getComplimentary());
            }
            line.append(SEPARATOR).append(facilities.get(e));
            listToWrite.add(String.valueOf(line));
        }
        CsvFileWriter.writeObjectToFile(listToWrite, PATH);
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
    public boolean addEntry(Object entry) {
        updateFromFile();
        facilities.put((Facility) entry, 0);
        writeToFile();
        return true;
    }


    @Override
    public boolean removeByID(String id) {
        updateFromFile();
        Facility entryToRemove = (Facility) findById(id);
        if (facilities.remove(entryToRemove) != null) {
            writeToFile();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void editEntry(String id, Object entry) {

    }

    @Override
    public LinkedHashMap<Facility, Integer> getMaintenance() {
        updateFromFile();
        LinkedHashMap<Facility, Integer> maintenanceList = new LinkedHashMap<>();
        Integer value;
        for (Facility e : facilities.keySet()) {
            value = facilities.get(e);
            if (value >= 5) {
                maintenanceList.put(e, value);
            }
        }
        return maintenanceList;
    }
}
