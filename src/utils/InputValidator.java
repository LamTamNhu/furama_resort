package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public static Boolean checkEmail(String email) {
        final String REGEX = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(REGEX);
    }

    public static Boolean checkSalary(Double salary) {
        return salary > 0;
    }

    public static Boolean checkPhoneNumber(String phoneNumber) {
        final String REGEX = "^0\\d{9}$";
        return phoneNumber.matches(REGEX);
    }

    public static Boolean checkId(String id) {
        final String REGEX = "^\\d{9,10}$";
        return id.matches(REGEX);
    }

    public static Boolean checkDatabaseId(String id, String REGEX) {
        return id.matches(REGEX);
    }

    public static Boolean checkName(String name) {
        final String REGEX = "\\b[^A-Z\\s]";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(name);
        return !matcher.find();
    }

    public static Boolean checkDayMonthYear(String dayMonthYear) {
        final String REGEX = "^([0-2][0-9]|(3)[0-1])([/-])(((0)[0-9])|((1)[0-2]))([/-])\\d{4}$";
        return dayMonthYear.matches(REGEX);
    }

    public static Boolean checkAgeRequirement(String birthdayString) {
        final int AGE_REQUIREMENT = 18;
        String[] formattedBirthday;
        formattedBirthday = birthdayString.split("[/-]");
        int day = Integer.parseInt(formattedBirthday[0]);
        int month = Integer.parseInt(formattedBirthday[1]);
        int year = Integer.parseInt(formattedBirthday[2]);
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();

        return Period.between(birthday, currentDate).getYears() >= AGE_REQUIREMENT;
    }

    public static boolean checkFacilityName(String name) {
        final String FACILITY_NAME_REGEX = "^[A-Z]";
        return name.matches(FACILITY_NAME_REGEX);
    }

    public static boolean checkArea(String input) {
        final byte AREA_LIMIT = 30;
        double area;
        try {
            area = Double.parseDouble(input);
            if (area <= AREA_LIMIT) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean checkFee(String input) {
        double fee;
        try {
            fee = Double.parseDouble(input);
            if (fee <= 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean checkMaxCapacity(String input) {
        int max;
        try {
            max = Integer.parseInt(input);
            if (max <= 0 || max >= 20) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean checkFacilityId(String input, String idRegex) {
        return input.matches(idRegex);
    }
}
