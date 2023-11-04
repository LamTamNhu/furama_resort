package utils;

public class MenuInput {
    private static final Integer INVALID_INPUT = -1;
    private static final String invalidInput = "Invalid input, please try again!";

    public static Integer inputNumForMenu(String inputString) {
        try {
            return Integer.valueOf(inputString);
        } catch (NumberFormatException e) {
            System.out.println(invalidInput);
            return INVALID_INPUT;
        }
    }
}
