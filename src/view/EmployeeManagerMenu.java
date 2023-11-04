package view;

import controller.EmployeeController;
import model.Employee;
import utils.InputInformation;

import java.util.Scanner;

import static utils.MenuInput.inputNumForMenu;

public class EmployeeManagerMenu {
    private static final EmployeeController employeeController = new EmployeeController();
    private final Scanner scanner = new Scanner(System.in);

    public void displayEmployeeMenu() {
        final String EMPLOYEE_MENU = "--------Employee Menu--------\n" +
                "1\tDisplay list employees\n" +
                "2\tAdd new employee\n" +
                "3\tEdit employee\n" +
                "4\tDelete employee\n" +
                "5\tSearch by name employee\n" +
                "6\tReturn main menu\n";
        Integer menuInput;
        do {
            System.out.println(EMPLOYEE_MENU);
            menuInput = inputNumForMenu(scanner.nextLine());
            switch (menuInput) {
                case 1:
                    System.out.println(employeeController.getAll());
                    break;
                case 2:
                    Employee employeeToAdd = InputInformation.inputEmployeeInfo();
                    employeeController.addEmployee(employeeToAdd);
                    employeeController.getAll();

                    break;
                default:
                    System.out.println("Invalid input, please choose a number from menu!");
            }
        } while (true);
    }
}
