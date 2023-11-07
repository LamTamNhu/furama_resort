package utils;

import java.util.Scanner;

public class MenuInputHandler {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Integer INVALID_INPUT = -1;

    public static Integer inputNumForMenu(String inputString) {
        try {
            return Integer.valueOf(inputString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input, please try again!");
            return INVALID_INPUT;
        } catch (Exception e) {
            e.printStackTrace();
            return INVALID_INPUT;
        }
    }

    public static boolean confirmDelete(String idToDelete) {
        Integer confirm;
        do {
            System.out.println("Entry with id: " + idToDelete + " found, delete?\n" +
                               "1. Yes\n" +
                               "2. No");
            confirm = inputNumForMenu(scanner.nextLine());
            switch (confirm) {
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    System.out.println("Please choose yes or no!");
            }
        } while (true);
    }
}
