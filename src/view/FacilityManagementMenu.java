package view;

import controller.FacilityController;
import model.facilities.Facility;
import utils.FacilityInputHandler;
import utils.MenuInputHandler;

import java.util.LinkedHashMap;
import java.util.Scanner;

import static utils.MenuInputHandler.confirmDelete;

public class FacilityManagementMenu {
    private final FacilityController controller = new FacilityController();
    private final Scanner scanner = new Scanner(System.in);
    private int menuInput;
    private final String INVALID_INPUT = "Invalid input, please choose a number from the menu!";


    private void addNewFacilityMenu() {
        final String ADD_NEW_MENU = "1.\tAdd New Villa\n" +
                                    "2.\tAdd New House\n" +
                                    "3.\tAdd New Room\n" +
                                    "4.\tBack to menu\n" +
                                    "Enter a number from menu: ";
        Facility entryToAdd;
        do {
            System.out.print(ADD_NEW_MENU);
            menuInput = MenuInputHandler.inputNumForMenu(scanner.nextLine());
            switch (menuInput) {
                case 1:
                    entryToAdd = FacilityInputHandler.inputVillaInfo();
                    controller.addEntry(entryToAdd);
                    break;
                case 2:
                    entryToAdd = FacilityInputHandler.inputHouseInfo();
                    controller.addEntry(entryToAdd);
                case 3:
                    entryToAdd = FacilityInputHandler.inputRoomInfo();
                    controller.addEntry(entryToAdd);
                    break;
                case 4:
                    return;
                default:
                    System.out.println(INVALID_INPUT);
            }
        } while (true);
    }

    public void displayMenu() {
        final String FACILITY_MENU = "--------Facility Menu--------\n" +
                                     "1\tDisplay list facility\n" +
                                     "2\tAdd new facility\n" +
                                     "3\tDisplay list facility maintenance\n" +
                                     "4\tDelete facility\n" +
                                     "5\tReturn main menu\n" +
                                     "Enter a number: ";

        boolean isExit = false;
        do {
            System.out.print(FACILITY_MENU);
            menuInput = MenuInputHandler.inputNumForMenu(scanner.nextLine());
            switch (menuInput) {
                case 1:
                    LinkedHashMap<Facility, Integer> facilities = (LinkedHashMap<Facility, Integer>) controller.getAll();
                    if (facilities != null) {
                        for (Facility e : facilities.keySet()) {
                            System.out.print(e);
                            System.out.println(" | Times used in month: " + facilities.get(e));
                        }
                    } else {
                        System.out.println("List is empty!");
                    }
                    break;
                case 2:
                    addNewFacilityMenu();
                    break;
                case 3:
                    LinkedHashMap<Facility, Integer> maintenanceList = controller.getMaintenance();
                    System.out.println("Facilities need maintenance: ");
                    if (maintenanceList.isEmpty()) {
                        System.out.println("None at the moment.");
                    } else {
                        for (Facility e : maintenanceList.keySet()) {
                            System.out.print(e);
                            System.out.println(" | Times used in month: " + maintenanceList.get(e));
                        }
                    }
                    break;
                case 4:
                    String idToRemove = FacilityInputHandler.inputFacilityIdAlreadyInList();
                    if (confirmDelete(idToRemove)) {
                        if (controller.remove(idToRemove)) {
                            System.out.println("Delete succeed!");
                        } else {
                            System.out.println("Entry no longer exist!");
                        }

                    } else {
                        System.out.println("Delete canceled!");
                    }
                    break;
                case 5:
                    isExit = true;
                    break;
                default:
                    System.out.println(INVALID_INPUT);
            }
        } while (!isExit);
    }
}
