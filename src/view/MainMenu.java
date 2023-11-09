package view;


import java.util.Scanner;

import static utils.MenuInputHandler.inputNumForMenu;

public class MainMenu {

    private final static int INVALID_INPUT = -1;
    private static final Scanner scanner = new Scanner(System.in);
    private static final String MAIN_MENU = "--------Main Menu--------\n" +
                                            "1.\tEmployee Management\n" +
                                            "2.\tCustomer Management\n" +
                                            "3.\tFacility Management \n" +
                                            "4.\tBooking Management\n" +
                                            "5.\tPromotion Management\n" +
                                            "6.\tExit\n" +
                                            "Enter a number: ";


//
//    private static final String PROMOTION_MENU = "--------Promotion Menu--------\n" +
//            "1.\tDisplay list customers use service\n" +
//            "2.\tDisplay list customers get voucher\n" +
//            "3.\tReturn main menu\n";

    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        EmployeeManagementMenu employeeManagementMenu = new EmployeeManagementMenu();
        CustomerManagementMenu customerManagementMenu = new CustomerManagementMenu();
        FacilityManagementMenu facilityManagementMenu = new FacilityManagementMenu();
        BookingManagementMenu bookingManagementMenu = new BookingManagementMenu();
        Integer menuInput;
        do {
            System.out.print(MAIN_MENU);
            menuInput = inputNumForMenu(scanner.nextLine());
            if (menuInput == INVALID_INPUT) {
                continue;
            }
            switch (menuInput) {
                case 1:
                    employeeManagementMenu.displayMenu();
                    break;
                case 2:
                    customerManagementMenu.displayMenu();
                    break;
                case 3:
                    facilityManagementMenu.displayMenu();
                    break;
                case 4:
                    bookingManagementMenu.displayMenu();
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Invalid input, please choose a number from the menu!");
            }
        } while (true);
    }
}
