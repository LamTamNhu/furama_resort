package utils;

import controller.*;
import model.human.Customer;
import model.human.Employee;
import model.human.Person;
import model.facilities.Facility;
import model.facilities.Villa;

import java.util.Scanner;

public class InputInformationHandler {
    private static final Scanner scanner = new Scanner(System.in);
    private static String input;

    public static Customer inputCustomerInfo() {
        PersonController customerController = new CustomerController();
        final String ID_REGEX = "^KH-\\d{4}$";

        Customer customer = new Customer();
        inputBasicPersonalInfo(customer);
        customer.setCustomerId(inputPersonDatabaseIdNotInList(customerController, ID_REGEX));
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
                               "                    1. DIAMOND\n" +
                               "                    2. PLATINUM\n" +
                               "                    3. GOLD\n" +
                               "                    4. SILVER\n" +
                               "                    5. MEMBER");
            inputNum = InputMenuChoiceHandler.inputNumForMenu(scanner.nextLine());
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
        final String ID_REGEX = "^NV-\\d{4}$";
        Employee employee = new Employee();
        inputBasicPersonalInfo(employee);
        employee.setEmployeeId(inputPersonDatabaseIdNotInList(employeeController, ID_REGEX));
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
                               "                    1. RECEPTIONIST,\n" +
                               "                    2. SERVER,\n" +
                               "                    3. EXPERT,\n" +
                               "                    4. SUPERVISOR,\n" +
                               "                    5. MANAGER,\n" +
                               "                    6. DIRECTOR");
            inputNum = InputMenuChoiceHandler.inputNumForMenu(scanner.nextLine());
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
            inputNum = InputMenuChoiceHandler.inputNumForMenu(scanner.nextLine());
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

    private static String inputPersonDatabaseIdNotInList(PersonController controller, String REGEX) {
        do {
            System.out.print("Enter entry ID: ");
            input = scanner.nextLine().toUpperCase();
            if (InputValidator.checkDatabaseId(input, REGEX)) {
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
            System.out.print("Enter email: ");
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
            System.out.print("Enter phone number: ");
            input = scanner.nextLine();
            if (InputValidator.checkPhoneNumber(input)) {
                return input;
            } else {
                System.out.println("Phone number should have 10 digits, try again!");
            }
        } while (true);
    }

    private static String idNumberInput() {
        do {
            System.out.print("Enter identification number: ");
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

    public static String inputPersonDatabaseIdAlreadyInList(PersonController controller, String REGEX) {
        do {
            System.out.print("Enter entry ID: ");
            input = scanner.nextLine().toUpperCase();
            if (InputValidator.checkDatabaseId(input, REGEX)) {
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

    public static Facility inputVillaInfo() {
        Villa villa = new Villa();
        FacilityController controller = new VillaController();
        final String ID_REGEX = "^SVVL-\\d{4}$";
        inputBasicFacilityInfo(villa);
        villa.setId(inputFacilityIdNotInList(controller, ID_REGEX));
        villa.setType(inputVillaType());
        villa.setPoolArea(inputVillaPoolArea());
        villa.setFloorCount(inputVillaFloorCount());

        return villa;
    }

    private static Integer inputVillaFloorCount() {
        int floorCount;
        do {
            System.out.print("Enter villa's number of floor: ");
            input = scanner.nextLine();
            try {
                floorCount = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format, try again!");
                continue;
            }
            if (floorCount <= 0) {
                System.out.println("Floor have to be more than 0!");
            }
            return floorCount;
        } while (true);
    }

    private static Double inputVillaPoolArea() {
        do {
            System.out.print("Enter villa pool area size: ");
            input = scanner.nextLine();
            if (InputValidator.checkArea(input)) {
                return Double.valueOf(input);
            } else {
                System.out.println("Invalid pool area input, please try again!");
            }
        } while (true);
    }

    private static Villa.Type inputVillaType() {
        int inputNum;
        do {
            System.out.println("Choose villa type:\n" +
                               "1. One star.\n" +
                               "2. Two stars.\n" +
                               "3. Three stars.");
            inputNum = InputMenuChoiceHandler.inputNumForMenu(scanner.nextLine());
            switch (inputNum) {
                case 1:
                    return Villa.Type.ONE_STAR;
                case 2:
                    return Villa.Type.TWO_STARS;
                case 3:
                    return Villa.Type.THREE_STARS;
                default:
                    System.out.println("Invalid choice, please pick one from the menu!");
            }
        } while (true);
    }

    private static String inputFacilityIdNotInList(FacilityController controller, String idRegex) {
        do {
            System.out.print("Enter ID: ");
            input = scanner.nextLine().toUpperCase();
            if (InputValidator.checkFacilityId(input, idRegex)) {
                if (controller.findById(input) == null) {
                    return input;
                } else {
                    System.out.println("ID already exist in list, please try again!");
                }
            } else {
                System.out.println("Invalid ID format, please try again!");
            }
        } while (true);
    }

    private static void inputBasicFacilityInfo(Facility facility) {
        facility.setName(inputFacilityName());
        facility.setArea(inputFacilityArea());
        facility.setFee(inputFacilityFee());
        facility.setMaxCapacity(inputFacilityMaxCapacity());
        facility.setRentType(inputFacilityRentType());
    }

    private static Facility.RentType inputFacilityRentType() {
        int inputNum;
        do {
            System.out.println("Choose renting type:\n" +
                               "1. Year.\n" +
                               "2. Month.\n" +
                               "3. Day.\n" +
                               "4. Hour");
            inputNum = InputMenuChoiceHandler.inputNumForMenu(scanner.nextLine());
            switch (inputNum) {
                case 1:
                    return Facility.RentType.YEAR;
                case 2:
                    return Facility.RentType.MONTH;
                case 3:
                    return Facility.RentType.DAY;
                case 4:
                    return Facility.RentType.HOUR;
                default:
                    System.out.println("Invalid choice, please pick one from the menu!");
            }
        } while (true);
    }

    private static int inputFacilityMaxCapacity() {
        do {
            System.out.print("Enter max capacity: ");
            input = scanner.nextLine();
            if (InputValidator.checkMaxCapacity(input)) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Invalid capacity input, please try again!");
            }
        } while (true);
    }

    private static Double inputFacilityFee() {
        do {
            System.out.print("Enter service's fee: ");
            input = scanner.nextLine();
            if (InputValidator.checkFee(input)) {
                return Double.valueOf(input);
            } else {
                System.out.println("Invalid fee input, please try again!");
            }

        } while (true);
    }

    private static Double inputFacilityArea() {
        do {
            System.out.print("Enter area size: ");
            input = scanner.nextLine();
            if (InputValidator.checkArea(input)) {
                return Double.valueOf(input);
            } else {
                System.out.println("Area size must be more than 30.");
            }
        } while (true);
    }

    private static String inputFacilityName() {
        do {
            System.out.print("Enter name: ");
            input = scanner.nextLine();
            if (InputValidator.checkFacilityName(input)) {
                return input;
            } else {
                System.out.println("Invalid name input, try again!");
            }
        } while (true);

    }
}
