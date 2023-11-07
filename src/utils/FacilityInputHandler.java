package utils;

import controller.FacilityController;
import controller.HouseController;
import controller.RoomController;
import controller.VillaController;
import model.facilities.Facility;
import model.facilities.House;
import model.facilities.Room;
import model.facilities.Villa;

import java.util.Scanner;

public class FacilityInputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static Facility inputVillaInfo() {
        Villa villa = new Villa();
        FacilityController controller = new VillaController();
        villa.setId(inputFacilityIdNotInList(controller));
        inputBasicFacilityInfo(villa);
        villa.setType(inputVillaType());
        villa.setPoolArea(inputVillaPoolArea());
        villa.setFloorCount(inputFloorCount());

        return villa;
    }

    private static Integer inputFloorCount() {
        String input;
        int floorCount;
        do {
            System.out.print("Enter number of floor: ");
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
        String input;
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
            inputNum = MenuInputHandler.inputNumForMenu(scanner.nextLine());
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

    private static String inputFacilityIdNotInList(FacilityController controller) {
        String input;
        do {
            if (controller instanceof VillaController) {
                System.out.print("Enter ID (SVVL-YYYY | Example: SVVL-0001): ");
            } else if (controller instanceof HouseController) {
                System.out.println("Enter ID (SVHO-YYYY | Example: SVHO-0001): ");
            } else {
                System.out.println("Enter ID (SVRO-YYYY | Example: SVRO-0001): ");
            }

            input = scanner.nextLine().toUpperCase();
            if (InputValidator.checkDatabaseId(input)) {
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
            inputNum = MenuInputHandler.inputNumForMenu(scanner.nextLine());
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
        String input;
        do {
            System.out.print("Enter max capacity (maximum 20): ");
            input = scanner.nextLine();
            if (InputValidator.checkMaxCapacity(input)) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Invalid capacity input, please try again!");
            }
        } while (true);
    }

    private static Double inputFacilityFee() {
        String input;
        do {
            System.out.print("Enter service's fee: ");
            input = scanner.nextLine();
            if (InputValidator.checkFee(input)) {
                return Double.valueOf(input);
            } else {
                System.out.println("Invalid number input. Need to be more than 1, please try again!");
            }
        } while (true);
    }

    private static Double inputFacilityArea() {
        String input;
        do {
            System.out.print("Enter area size (minimum 30): ");
            input = scanner.nextLine();
            if (InputValidator.checkArea(input)) {
                return Double.valueOf(input);
            } else {
                System.out.println("Area size must be more than 30.");
            }
        } while (true);
    }

    private static String inputFacilityName() {
        String input;
        do {
            System.out.print("Enter name: ");
            input = scanner.nextLine();
            if (input != null) {
                input = input.substring(0, 1).toUpperCase() + input.substring(1);
            }
            if (InputValidator.checkFacilityName(input)) {
                return input;
            } else {
                System.out.println("Invalid name input. No special character and maximum 70 characters, try again!");
            }
        } while (true);

    }

    public static Facility inputHouseInfo() {
        FacilityController controller = new HouseController();
        House house = new House();
        house.setId(inputFacilityIdNotInList(controller));
        inputBasicFacilityInfo(house);
        house.setHouseType(inputHouseType());
        house.setFloorCount(inputFloorCount());
        return house;
    }

    private static House.HouseType inputHouseType() {
        int inputNum;
        do {
            System.out.println("Choose house type:\n" +
                               "1. SUITE,\n" +
                               "2. STUDIO,\n" +
                               "3. EXECUTIVE,\n" +
                               "4. PRESIDENTIAL");
            inputNum = MenuInputHandler.inputNumForMenu(scanner.nextLine());
            switch (inputNum) {
                case 1:
                    return House.HouseType.SUITE;
                case 2:
                    return House.HouseType.STUDIO;
                case 3:
                    return House.HouseType.EXECUTIVE;
                case 4:
                    return House.HouseType.PRESIDENTIAL;
                default:
                    System.out.println("Invalid choice, please pick one from the menu!");
            }
        } while (true);
    }

    public static Facility inputRoomInfo() {
        FacilityController controller = new RoomController();
        Room room = new Room();
        room.setId(inputFacilityIdNotInList(controller));
        inputBasicFacilityInfo(room);
        room.setComplimentary(inputRoomComplimentary());
        return room;
    }

    private static String inputRoomComplimentary() {
        System.out.print("Enter room's complimentary: ");
        return scanner.nextLine();
    }

    public static String inputFacilityIdAlreadyInList() {
        String input;
        FacilityController controller = new FacilityController();
        do {
            System.out.print("Enter ID (SVXX-YYYY): ");
            input = scanner.nextLine().toUpperCase();
            if (InputValidator.checkDatabaseId(input)) {
                if (controller.findById(input) != null) {
                    return input;
                } else {
                    System.out.println("Can't find this ID, please try again!");
                }
            } else {
                System.out.println("Invalid ID format, please try again!");
            }
        } while (true);
    }
}
