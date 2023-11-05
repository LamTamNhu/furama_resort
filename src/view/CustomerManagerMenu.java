package view;

import controller.EmployeeController;
import model.Employee;
import utils.InputInformation;

import java.util.List;
import java.util.Scanner;

import static utils.MenuInput.inputNumForMenu;

public class CustomerManagerMenu {
    private static final CustomerController employeeController = new EmployeeController();
    private final Scanner scanner = new Scanner(System.in);

    public void displayEmployeeMenu() {
        final String CUSTOMER_MENU = "--------Customer Menu--------\n" +
                "1\tDisplay list employees\n" +
                "2\tAdd new employee\n" +
                "3\tEdit employee\n" +
                "4\tDelete employee\n" +
                "5\tSearch by name employee\n" +
                "6\tReturn main menu\n";
        Integer menuInput;
        boolean isExit = false;
        do {
            System.out.println(CUSTOMER_MENU);
            menuInput = inputNumForMenu(scanner.nextLine());
            switch (menuInput) {
                case 1:
                    List<Employee> displayList = (List<Employee>) employeeController.getAll();
                    for (Employee e : displayList) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    Employee employeeToAdd = InputInformation.inputEmployeeInfo();
                    employeeController.addEmployee(employeeToAdd);
                    System.out.println("Adding employee succeed!");
                    break;
                case 3:
                    String idToEdit = InputInformation.inputEmployeeIdAlreadyInList();
                    Employee editedEmployee = InputInformation.inputEmployeeInfo();
                    employeeController.editEmployee(idToEdit, editedEmployee);
                    System.out.println("Edit succeed.");
                    break;
                case 4:
                    String idToDelete = InputInformation.inputEmployeeIdAlreadyInList();
                    employeeController.removeEmployee(idToDelete);
                    break;
                case 5:
                    String nameToSearch = InputInformation.nameInput();
                    List<Employee> searchResult = (List<Employee>) employeeController.findByName(nameToSearch);
                    int length = searchResult.size();
                    if (length == 0) {
                        System.out.println("No match found!");
                        break;
                    }
                    System.out.println("Found: " + length + " employees match the name.");
                    for (Employee e : searchResult) {
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
