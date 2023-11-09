package controller;

import model.Booking;
import model.Contract;
import services.impl.BookingService;

import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BookingController {
    BookingService service = new BookingService();

    public boolean addBooking(Booking booking) {
        return service.addEntry(booking);
    }

    public Set<Booking> getAllBooking() {
        return (Set<Booking>) service.getAll();
    }

    public boolean addContract(Contract contract) {
        return service.addContract(contract);
    }

    public Queue<Booking> getBookingListForContract() {
        return service.getBookingListForContract();
    }

    public List<Contract> getAllContract() {
        return service.getAllContract();
    }
}
