package utils;

import controller.EmployeeController;
import controller.PersonController;
import model.Customer;
import model.Employee;
import model.Person;

import java.util.Scanner;

public class InputInformation {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PersonController employeeController = new EmployeeController();

    public static Customer inputCustomerInfo() {
        Person basicPersonalInfo=inputBasicPersonalInfo();
        String customerId;
        Customer.CustomerTier customerTier;
        String address;

        return new Customer(basicPersonalInfo,customerId,customerTier,address);
    }

    public static Employee inputEmployeeInfo() {
        Person basicPersonalInfo = inputBasicPersonalInfo();
        String employeeId = inputEmployeeIdNotInList();
        Employee.Qualification qualification = qualificationInput();
        Employee.Position position = positionInput();
        Double salary = salaryInput();
        return new Employee(basicPersonalInfo, employeeId, qualification, position, salary);
    }

    private static Double salaryInput() {
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

    private static Employee.Position positionInput() {
        int inputNum;
        do {
            System.out.println("Choose position:\n" +
                    "1. RECEPTIONIST,\n" +
                    "2. SERVER,\n" +
                    "3. EXPERT,\n" +
                    "4. SUPERVISOR,\n" +
                    "5. MANAGER,\n" +
                    "6. DIRECTOR");
            inputNum = MenuInput.inputNumForMenu(scanner.nextLine());
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

    private static Employee.Qualification qualificationInput() {
        int inputNum;
        do {
            System.out.println("Choose qualification:\n" +
                    "1. INTERMEDIATE,\n" +
                    "2. COLLEGE,\n" +
                    "3. UNIVERSITY,\n" +
                    "4. POST GRADUATE");
            inputNum = MenuInput.inputNumForMenu(scanner.nextLine());
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

    private static String inputEmployeeIdNotInList() {
        String employeeId;
        do {
            System.out.print("Enter employee ID (NV-YYYY): ");
            employeeId = scanner.nextLine().toUpperCase();
            if (InputValidator.checkEmployeeId(employeeId)) {
                if (employeeController.findById(employeeId) != null) {
                    System.out.println("This ID already exist, try again!");
                } else {
                    return employeeId;
                }
            } else {
                System.out.println("Invalid ID format, please try again!");
            }
        } while (true);
    }

    public static Person inputBasicPersonalInfo() {
        String name = nameInput();
        String birthdate = birthdateInput();
        Person.Gender gender = genderInput();
        String idNumber = idNumberInput();
        String phoneNumber = phoneNumberInput();
        String email = emailInput();
        return new Person(name, birthdate, gender, idNumber, phoneNumber, email);
    }

    private static String emailInput() {
        String email;
        do {
            System.out.print("Enter email: ");
            email = scanner.nextLine();
            if (InputValidator.checkEmail(email)) {
                return email;
            } else {
                System.out.println("Invalid email format, try again!");
            }
        } while (true);
    }

    private static String phoneNumberInput() {
        String phoneNumber;
        do {
            System.out.print("Enter phone number: ");
            phoneNumber = scanner.nextLine();
            if (InputValidator.checkPhoneNumber(phoneNumber)) {
                return phoneNumber;
            } else {
                System.out.println("Phone number should have 10 digits, try again!");
            }
        } while (true);
    }

    private static String idNumberInput() {
        String idNumber;
        do {
            System.out.print("Enter identification number: ");
            idNumber = scanner.nextLine();
            if (InputValidator.checkId(idNumber)) {
                return idNumber;
            } else {
                System.out.println("Id number needs to have 9 to 12 digits.");
            }
        } while (true);
    }

    private static String birthdateInput() {
        String birthdate;
        do {
            System.out.print("Enter day of birth (DD-MM-YY): ");
            birthdate = scanner.nextLine();
            if (InputValidator.checkDayMonthYear(birthdate)) {
                if (InputValidator.checkAgeRequirement(birthdate)) {
                    return birthdate;
                } else {
                    System.out.println("Age need to be over 18!");
                }
            } else {
                System.out.println("Wrong date format!");
            }
        } while (true);
    }

    private static Person.Gender genderInput() {
        String gender;
        do {
            System.out.print("Enter gender (M/F): ");
            gender = scanner.nextLine().toUpperCase();
            if (gender.equals("M")) {
                gender = "MALE";
            }
            if (gender.equals("F")) {
                gender = "FEMALE";
            }
            try {
                return Person.Gender.valueOf(gender);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid gender input, try again!");
            }
        } while (true);
    }

    public static String nameInput() {
        String name;
        do {
            System.out.print("Enter name: ");
            name = scanner.nextLine();
            if (InputValidator.checkName(name)) {
                return name;
            } else {
                System.out.println("Name should only be words with proper capitalization, please try again!");
            }
        } while (true);
    }

    public static String inputEmployeeIdAlreadyInList() {
        String employeeId;
        do {
            System.out.print("Enter employee ID (NV-YYYY): ");
            employeeId = scanner.nextLine().toUpperCase();
            if (InputValidator.checkEmployeeId(employeeId)) {
                if (employeeController.findById(employeeId) != null) {
                    return employeeId;
                } else {
                    System.out.println("Can't find any employee with this ID, try again!");
                }
            } else {
                System.out.println("Invalid ID format, please try again!");
            }
        } while (true);
    }


}
