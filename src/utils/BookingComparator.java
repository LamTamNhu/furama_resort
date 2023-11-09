package utils;

import model.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        if (o1.getBookingId().equals(o2.getBookingId())) {
            return 0;
        }
        if (o1.getServiceId().equals(o2.getServiceId())) {
            if (!(o1.getStartDate().isBefore(o2.getStartDate()) || o1.getStartDate().isAfter(o2.getEndDate()))) {
                return 0;
            }
        }
        if (o1.getStartDate().isAfter(o2.getStartDate())) {
            return 1;
        } else if (o1.getStartDate().isBefore(o2.getStartDate())) {
            return -1;
        } else {
            if (o1.getEndDate().isAfter(o2.getEndDate())) {
                return 1;
            } else if (o1.getEndDate().isBefore(o2.getEndDate())) {
                return -1;
            }
        }
        return 1;
    }
}
