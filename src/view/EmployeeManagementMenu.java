package view;

import controller.EmployeeController;
import controller.PersonController;
import model.Employee;
import utils.InputInformationHandler;

import java.util.List;
import java.util.Scanner;

import static utils.InputMenuChoiceHandler.inputNumForMenu;

public class EmployeeManagementMenu {
    private static final PersonController employeeController = new EmployeeController();
    private final Scanner scanner = new Scanner(System.in);

    public void displayEmployeeMenu() {
        final String EMPLOYEE_MENU = "--------Employee Menu--------\n" +
                                     "1\tDisplay list employees\n" +
                                     "2\tAdd new employee\n" +
                                     "3\tEdit employee\n" +
                                     "4\tDelete employee\n" +
                                     "5\tSearch employee by name\n" +
                                     "6\tReturn main menu\n" +
                                     "Enter a number: ";
        Integer menuInput;
        boolean isExit = false;
        do {
            System.out.println(EMPLOYEE_MENU);
            menuInput = inputNumForMenu(scanner.nextLine());
            switch (menuInput) {
                case 1:
                    List<Employee> displayList = (List<Employee>) employeeController.getAll();
                    for (Employee e : displayList) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    Employee employeeToAdd = InputInformationHandler.inputEmployeeInfo();
                    employeeController.addEntry(employeeToAdd);
                    System.out.println("Adding employee succeed!");
                    break;
                case 3:
                    String idToEdit = InputInformationHandler.inputPersonDatabaseIdAlreadyInList(employeeController, "^NV-\\d{4}$");
                    Employee editedEmployee = InputInformationHandler.inputEmployeeInfo();
                    employeeController.editEntry(idToEdit, editedEmployee);
                    System.out.println("Edit succeed!");
                    break;
                case 4:
                    String idToDelete = InputInformationHandler.inputPersonDatabaseIdAlreadyInList(employeeController, "^NV-\\d{4}$");
                    employeeController.removeEntry(idToDelete);
                    System.out.println("Delete succeed!");
                    break;
                case 5:
                    String nameToSearch = InputInformationHandler.nameInput();
                    List<Employee> searchResult = (List<Employee>) employeeController.findByName(nameToSearch);
                    int length = searchResult.size();
                    if (length == 0) {
                        System.out.println("No match found!");
                        break;
                    }
                    System.out.println("Found: " + length + " match the name:");
                    for (Employee e : searchResult) {
                        System.out.println(e);
                    }
                    break;
                case 6:
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid input, please choose a number from the menu!");
            }
        } while (!isExit);
    }
}