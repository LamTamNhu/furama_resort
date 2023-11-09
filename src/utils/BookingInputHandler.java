package utils;

import controller.BookingController;
import controller.CustomerController;
import controller.FacilityController;
import model.Booking;
import model.facilities.Facility;
import model.human.Customer;

import java.time.LocalDate;
import java.util.*;

public class BookingInputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static Booking inputBookingInfo() {
        String customerId = inputCustomerId();
        if (customerId == null) {
            return null;
        }
        String facilityId = inputFacilityId();
        if (facilityId == null) {
            return null;
        }
        Set<Booking> bookingListInTheSameService = displayBookedTimeInTheSameService(facilityId);
        LocalDate startDate = inputBookingDate(LocalDate.now(), bookingListInTheSameService);
        LocalDate endDate = inputBookingDate(startDate, bookingListInTheSameService);
        return new Booking(startDate, endDate, customerId, facilityId);
    }

    private static Set<Booking> displayBookedTimeInTheSameService(String facilityId) {
        BookingComparator comparator = new BookingComparator();
        BookingController controller = new BookingController();
        Set<Booking> bookings = controller.getAllBooking();
        Set<Booking> bookingListOfService = new TreeSet<>(comparator);
        System.out.println("Booked time of service " + facilityId + ":");
        for (Booking e : bookings) {
            if (e.getServiceId().equals(facilityId)) {
                System.out.println(e);
                bookingListOfService.add(e);
            }
        }
        if (bookingListOfService.isEmpty()) {
            System.out.println("This service currently have no booking yet.");
        }
        return bookingListOfService;
    }

    private static String inputFacilityId() {
        FacilityController facilityController = new FacilityController();
        LinkedHashMap<Facility, Integer> facilities = (LinkedHashMap<Facility, Integer>) facilityController.getAll();
        if (facilities != null) {
            for (Facility e : facilities.keySet()) {
                System.out.println(e);
            }
            System.out.println("Choose a service id from list.");
        } else {
            System.out.println("List is empty!");
            return null;
        }
        return FacilityInputHandler.inputFacilityIdAlreadyInList();
    }

    private static String inputCustomerId() {
        CustomerController customerController = new CustomerController();
        List<Customer> displayList = (List<Customer>) customerController.getAll();
        if (displayList != null) {
            for (Customer e : displayList) {
                System.out.println(e);
            }
            System.out.println("Choose a customer id from list.");
        } else {
            System.out.println("Customer list empty");
            return null;
        }
        return PersonInputHandler.inputPersonDatabaseIdAlreadyInList(customerController);
    }

    private static LocalDate inputBookingDate(LocalDate compareDate, Set<Booking> bookingListInTheSameService) {
        boolean isBookingStart = compareDate.equals(LocalDate.now());
        String input;
        LocalDate bookingDate;
        do {
            if (isBookingStart) {
                System.out.print("Enter booking start date (DD-MM-YY): ");
            } else {
                System.out.print("Enter booking end date (DD-MM-YY): ");
            }

            input = scanner.nextLine();
            if (InputValidator.checkDayMonthYear(input)) {
                bookingDate = InputValidator.convertStringToLocalDate(input);
                if (!bookingDate.isBefore(compareDate)) {
                    if (bookingListInTheSameService.isEmpty()) {
                        return bookingDate;
                    }
                    for (Booking e : bookingListInTheSameService) {
                        if (!(bookingDate.isBefore(e.getStartDate()) || bookingDate.isAfter(e.getEndDate()))) {
                            System.out.println("Date is conflict with booked list, please choose a different date!");
                            break;
                        } else {
                            return bookingDate;
                        }
                    }
                } else {
                    if (isBookingStart) {
                        System.out.println("Booking start day needs to be from " + compareDate);
                    } else {
                        System.out.println("Booking end day needs to be from " + compareDate);
                    }
                }
            } else {
                System.out.println("Wrong date format, please try again!");
            }
        } while (true);
    }
}
