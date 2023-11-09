package controller;

import model.Booking;
import services.Service;
import services.impl.BookingService;

import java.util.Set;

public class BookingController {
    Service service = new BookingService();

    public boolean addBooking(Booking booking) {
        return service.addEntry(booking);
    }

    public Set<Booking> getAllBooking() {
        return (Set<Booking>) service.getAll();
    }
}
