package view;


import java.util.Scanner;

import static utils.MenuInput.inputNumForMenu;

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

    private static final String CUSTOMER_MENU = "--------Customer Menu--------\n" +
            "1\tDisplay list employees\n" +
            "2\tAdd new employee\n" +
            "3\tEdit employee\n" +
            "4\tDelete employee\n" +
            "5\tSearch by name employee\n" +
            "6\tReturn main menu\n";
    private static final String FACILITY_MENU = "--------Facility Menu--------\n" +
            "1\tDisplay list facility\n" +
            "2\tAdd new facility\n" +
            "3\tDisplay list facility maintenance\n" +
            "4\tDelete facility\n" +
            "5\tReturn main menu\n";
    private static final String BOOKING_MENU = "--------Booking Menu--------\n" +
            "1.\tAdd new booking\n" +
            "2.\tDisplay list booking\n" +
            "3.\tCreate new contracts\n" +
            "4.\tDisplay list contracts\n" +
            "5.\tEdit contracts\n" +
            "6.\tReturn main menu\n";
    private static final String PROMOTION_MENU = "--------Promotion Menu--------\n" +
            "1.\tDisplay list customers use service\n" +
            "2.\tDisplay list customers get voucher\n" +
            "3.\tReturn main menu\n";

    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        EmployeeManagerMenu employeeManagerMenu = new EmployeeManagerMenu();
        Integer menuInput;
        do {
            System.out.print(MAIN_MENU);
            menuInput = inputNumForMenu(scanner.nextLine());
            if (menuInput == INVALID_INPUT) {
                continue;
            }
            switch (menuInput) {
                case 1:
                    employeeManagerMenu.displayEmployeeMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Invalid input, please choose a number from menu!");
            }
        } while (true);
    }


}
