package view;

import controller.FacilityController;
import model.facilities.Facility;
import utils.EntryInputHandler;
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
                                    "Enter a number: ";
        Facility entryToAdd;
        do {
            System.out.print(ADD_NEW_MENU);
            menuInput = MenuInputHandler.inputNumForMenu(scanner.nextLine());
            switch (menuInput) {
                case 1:
                    entryToAdd = EntryInputHandler.inputVillaInfo();
                    controller.addEntry(entryToAdd);
                    break;
                case 2:
                    entryToAdd = EntryInputHandler.inputHouseInfo();
                    controller.addEntry(entryToAdd);
                case 3:
                    entryToAdd = EntryInputHandler.inputRoomInfo();
                    controller.addEntry(entryToAdd);
                    break;
                case 4:
                    return;
                default:
                    System.out.println(INVALID_INPUT);
            }
        } while (true);
    }

    public void displayFacilityMenu() {


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
                            System.out.println(e);
                        }
                    } else {
                        System.out.println("List is empty!");
                    }
                    break;
                case 2:
                    addNewFacilityMenu();
                    break;
//                case 3:
//                    controller.getMaintenance();
//                    break;
                case 4:
                    String idToRemove = EntryInputHandler.inputFacilityIdAlreadyInList();
                    if (confirmDelete(idToRemove)) {
                        controller.remove(idToRemove);
                        System.out.println("Delete succeed!");
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
