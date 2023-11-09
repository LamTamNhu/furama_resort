package view;

import controller.BookingController;
import model.Booking;
import utils.BookingInputHandler;
import utils.MenuInputHandler;

import java.util.Scanner;
import java.util.Set;

public class BookingManagementMenu {
    private final BookingController controller = new BookingController();
    private final Scanner scanner = new Scanner(System.in);
    private int menuInput;

    public void displayMenu() {
        final String BOOKING_MENU = "--------Booking Menu--------\n" +
                                    "1.\tAdd new booking\n" +
                                    "2.\tDisplay list booking\n" +
                                    "3.\tCreate new contracts\n" +
                                    "4.\tDisplay list contracts\n" +
                                    "5.\tEdit contracts\n" +
                                    "6.\tReturn main menu\n" +
                                    "Enter a number from menu: ";
        boolean isDone = false;

        do {
            System.out.print(BOOKING_MENU);
            menuInput = MenuInputHandler.inputNumForMenu(scanner.nextLine());
            switch (menuInput) {
                case 1:
                    Booking bookingToAdd = BookingInputHandler.inputBookingInfo();
                    if (controller.addBooking(bookingToAdd)){
                        System.out.println("Add success!");
                    }else {
                        System.out.println("Booking problem occurred!");
                    }
                    break;
                case 2:
                    Set<Booking> list = controller.getAllBooking();
                    for (Booking e : list) {
                        System.out.println(e);
                    }
                    break;
//                case 3:
//                    controller.addContract();
//                    break;
//                case 4:
//                    controller.getAllContract();
//                    break;
//                case 5:
//                    controller.editContract();
                case 6:
                    isDone = true;
                default:
                    System.out.println("Please pick a number from the menu!");
            }
        } while (!isDone);
    }
}
