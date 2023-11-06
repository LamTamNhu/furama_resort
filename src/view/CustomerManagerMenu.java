package view;

import controller.CustomerController;
import controller.EmployeeController;
import model.Customer;
import model.Employee;
import utils.InputInformation;

import java.util.List;
import java.util.Scanner;

import static utils.MenuInput.inputNumForMenu;

public class CustomerManagerMenu {
    private static final CustomerController customerController = new CustomerController();
    private final Scanner scanner = new Scanner(System.in);

    public void displayCustomerMenu() {
        final String CUSTOMER_MENU = "--------Customer Menu--------\n" +
                "1.\tDisplay list customers\n" +
                "2.\tAdd new customer\n" +
                "3.\tEdit customer\n" +
                "4.\tDelete customer\n" +
                "5.\tSearch by name customer\n" +
                "6.\tReturn main menu\n";
        Integer menuInput;
        boolean isExit = false;
        do {
            System.out.println(CUSTOMER_MENU);
            menuInput = inputNumForMenu(scanner.nextLine());
            switch (menuInput) {
                case 1:
                    List<Customer> displayList = (List<Customer>) customerController.getAll();
                    for (Customer e : displayList) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    Customer customerToAdd = InputInformation.inputCustomerInfo();
                    customerController.addEntry(customerToAdd);
                    System.out.println("Adding customer succeed!");
                    break;
                case 3:
                    String idToEdit = InputInformation.inputDatabaseIdAlreadyInList(customerController,"^KH-\\d{4}$");
                    Customer editedCustomer = InputInformation.inputCustomerInfo();
                    customerController.editEntry(idToEdit, editedCustomer);
                    System.out.println("Edit succeed.");
                    break;
                case 4:
                    String idToDelete = InputInformation.inputDatabaseIdAlreadyInList(customerController,"^KH-\\d{4}$");
                    customerController.removeEntry(idToDelete);
                    break;
                case 5:
                    String nameToSearch = InputInformation.nameInput();
                    List<Customer> searchResult = (List<Customer>) customerController.findByName(nameToSearch);
                    int length = searchResult.size();
                    if (length == 0) {
                        System.out.println("No match found!");
                        break;
                    }
                    System.out.println("Found: " + length + " match the name:");
                    for (Customer e : searchResult) {
                        System.out.println(e);
                    }
                    break;
                case 6:
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid input, please choose a number from menu!");
            }
        } while (!isExit);
    }
}
