package services.impl;

import controller.FacilityController;
import model.Booking;
import model.Contract;
import model.facilities.Facility;
import repository.IBookingRepository;
import repository.impl.BookingRepository;
import services.IBookingService;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Queue;

public class BookingService implements IBookingService {
    IBookingRepository repository = new BookingRepository();

    @Override
    public Object getAll() {
        return repository.getAll();
    }

    @Override
    public boolean addEntry(Object entry) {
        FacilityController facilityController = new FacilityController();
        LinkedHashMap<Facility, Integer> facilities = (LinkedHashMap<Facility, Integer>) facilityController.getAll();
        Booking bookingEntry = (Booking) entry;
        boolean isAdded = repository.addEntry(entry);
        String serviceId = bookingEntry.getServiceId();
        if (isAdded) {
            if (bookingEntry.getStartDate().getMonth() == LocalDate.now().getMonth()) {
                for (Facility e : facilities.keySet()) {
                    if (e.getId().equals(serviceId)) {
                        int updatedValue = facilities.get(e) + 1;
                        facilities.put(e,updatedValue);
                        facilityController.writeToFile();
                        break;
                    }
                }
            }
        }
        return isAdded;
    }

    @Override
    public void editEntry(String id, Object editedEmployee) {

    }

    @Override
    public boolean removeEntry(String id) {
        return repository.removeByID(id);
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

    @Override
    public boolean addContract(Contract contract) {
        return repository.addContract(contract);
    }

    @Override
    public Queue<Booking> getBookingListForContract() {
        return repository.getBookingListForContract();
    }

    @Override
    public List<Contract> getAllContract() {
        return repository.getAllContract();
    }
}
