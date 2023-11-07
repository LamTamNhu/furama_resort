package utils;

import controller.*;
import model.human.Customer;
import model.human.Employee;
import model.human.Person;

import java.util.Scanner;

public class PersonInputHandler {
    private static final Scanner scanner = new Scanner(System.in);
    private static String input;

    public static Customer inputCustomerInfo() {
        PersonController customerController = new CustomerController();

        Customer customer = new Customer();
        inputBasicPersonalInfo(customer);
        customer.setCustomerId(inputPersonDatabaseIdNotInList(customerController));
        customer.setCustomerTier(inputCustomerTier());
        customer.setAddress(inputAddress());

        return customer;
    }

    private static String inputAddress() {
        System.out.print("Enter address: ");
        return scanner.nextLine();
    }

    private static Customer.CustomerTier inputCustomerTier() {
        int inputNum;
        do {
            System.out.println("Choose customer tier:\n" +
                               "1. DIAMOND\n" +
                               "2. PLATINUM\n" +
                               "3. GOLD\n" +
                               "4. SILVER\n" +
                               "5. MEMBER");
            inputNum = MenuInputHandler.inputNumForMenu(scanner.nextLine());
            switch (inputNum) {
                case 1:
                    return Customer.CustomerTier.DIAMOND;
                case 2:
                    return Customer.CustomerTier.PLATINUM;
                case 3:
                    return Customer.CustomerTier.GOLD;
                case 4:
                    return Customer.CustomerTier.SILVER;
                case 5:
                    return Customer.CustomerTier.MEMBER;
                default:
                    System.out.println("Invalid choice, please try again!");
            }
        } while (true);
    }

    public static Employee inputEmployeeInfo() {
        PersonController employeeController = new EmployeeController();
        Employee employee = new Employee();
        inputBasicPersonalInfo(employee);
        employee.setEmployeeId(inputPersonDatabaseIdNotInList(employeeController));
        employee.setQualification(inputQualification());
        employee.setPosition(inputPosition());
        employee.setSalary(inputSalary());
        return employee;
    }

    private static Double inputSalary() {
        Double salary;
        do {
            System.out.print("Enter salary: ");
            try {
                salary = Double.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format");
                continue;
            }
            if (InputValidator.checkSalary(salary)) {
                return salary;
            } else {
                System.out.println("Salary need to be more than 0, try again!");
            }
        } while (true);
    }

    private static Employee.Position inputPosition() {
        int inputNum;
        do {
            System.out.println("Choose position:\n" +
                               "1. RECEPTIONIST,\n" +
                               "2. SERVER,\n" +
                               "3. EXPERT,\n" +
                               "4. SUPERVISOR,\n" +
                               "5. MANAGER,\n" +
                               "6. DIRECTOR");
            inputNum = MenuInputHandler.inputNumForMenu(scanner.nextLine());
            switch (inputNum) {
                case 1:
                    return Employee.Position.RECEPTIONIST;
                case 2:
                    return Employee.Position.SERVER;
                case 3:
                    return Employee.Position.EXPERT;
                case 4:
                    return Employee.Position.SUPERVISOR;
                case 5:
                    return Employee.Position.MANAGER;
                case 6:
                    return Employee.Position.DIRECTOR;
                default:
                    System.out.println("Invalid choice, please try again!");
            }
        } while (true);
    }

    private static Employee.Qualification inputQualification() {
        int inputNum;
        do {
            System.out.println("Choose qualification:\n" +
                               "1. INTERMEDIATE,\n" +
                               "2. COLLEGE,\n" +
                               "3. UNIVERSITY,\n" +
                               "4. POST GRADUATE");
            inputNum = MenuInputHandler.inputNumForMenu(scanner.nextLine());
            switch (inputNum) {
                case 1:
                    return Employee.Qualification.INTERMEDIATE;
                case 2:
                    return Employee.Qualification.COLLEGE;
                case 3:
                    return Employee.Qualification.UNIVERSITY;
                case 4:
                    return Employee.Qualification.POSTGRADUATE;
                default:
                    System.out.println("Invalid choice, please try again!");
            }
        } while (true);
    }

    private static String inputPersonDatabaseIdNotInList(PersonController controller) {
        do {
            if (controller instanceof EmployeeController) {
                System.out.print("Enter employee ID (NV-YYYY): ");
            } else if (controller instanceof CustomerController) {
                System.out.print("Enter customer ID (KH-YYYY): ");
            }
            input = scanner.nextLine().toUpperCase();
            if (InputValidator.checkDatabaseId(input)) {
                if (controller.findById(input) != null) {
                    System.out.println("This ID already exist, please try again!");
                } else {
                    return input;
                }
            } else {
                System.out.println("Invalid ID format, please try again!");
            }
        } while (true);
    }

    public static void inputBasicPersonalInfo(Person basicInfo) {
        basicInfo.setName(nameInput());
        basicInfo.setBirthDate(birthdateInput());
        basicInfo.setGender(genderInput());
        basicInfo.setIdNumber(idNumberInput());
        basicInfo.setPhoneNumber(phoneNumberInput());
        basicInfo.setEmail(emailInput());
    }

    private static String emailInput() {
        do {
            System.out.print("Enter email (Exp: example@exam.ple): ");
            input = scanner.nextLine();
            if (InputValidator.checkEmail(input)) {
                return input;
            } else {
                System.out.println("Invalid email format, try again!");
            }
        } while (true);
    }

    private static String phoneNumberInput() {
        do {
            System.out.print("Enter phone number (Example: 0123456789): ");
            input = scanner.nextLine();
            if (InputValidator.checkPhoneNumber(input)) {
                return input;
            } else {
                System.out.println("Phone number should start with 0 and have 10 digits, try again!");
            }
        } while (true);
    }

    private static String idNumberInput() {
        do {
            System.out.print("Enter identification number (9-12 numbers): ");
            input = scanner.nextLine();
            if (InputValidator.checkId(input)) {
                return input;
            } else {
                System.out.println("Id number needs to have 9 to 12 digits.");
            }
        } while (true);
    }

    private static String birthdateInput() {
        do {
            System.out.print("Enter day of birth (DD-MM-YY): ");
            input = scanner.nextLine();
            if (InputValidator.checkDayMonthYear(input)) {
                if (InputValidator.checkAgeRequirement(input)) {
                    return input;
                } else {
                    System.out.println("Age need to be over 18!");
                }
            } else {
                System.out.println("Wrong date format!");
            }
        } while (true);
    }

    private static Person.Gender genderInput() {
        do {
            System.out.print("Enter gender (M/F): ");
            input = scanner.nextLine().toUpperCase();
            if (input.equals("M")) {
                input = "MALE";
            }
            if (input.equals("F")) {
                input = "FEMALE";
            }
            try {
                return Person.Gender.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid gender input, try again!");
            }
        } while (true);
    }

    public static String nameInput() {
        do {
            System.out.print("Enter name: ");
            input = scanner.nextLine();
            if (InputValidator.checkName(input)) {
                return input;
            } else {
                System.out.println("Name should only be words with proper capitalization, please try again!");
            }
        } while (true);
    }

    public static String inputPersonDatabaseIdAlreadyInList(PersonController controller) {
        do {
            System.out.print("Enter entry ID: ");
            input = scanner.nextLine().toUpperCase();
            if (InputValidator.checkDatabaseId(input)) {
                if (controller.findById(input) != null) {
                    return input;
                } else {
                    System.out.println("Can't find any entry with this ID, try again!");
                }
            } else {
                System.out.println("Invalid ID format, please try again!");
            }
        } while (true);
    }

}
