package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.SplittableRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    public static Boolean checkEmail(String email) {
        if (email.length() >= 70) {
            System.out.println("Email can't be more than 70 characters!");
            return false;
        }
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
        final String REGEX = "^\\d{9,12}$";
        return id.matches(REGEX);
    }

    public static Boolean checkDatabaseId(String id) {
        final String VILLA_ID_REGEX = "^SVVL-\\d{4}$";
        final String HOUSE_ID_REGEX = "^SVHO-\\d{4}$";
        final String ROOM_ID_REGEX = "^SVRO-\\d{4}$";
        final String CUSTOMER_ID_REGEX = "^KH-\\d{4}$";
        final String EMPLOYEE_ID_REGEX = "^NV-\\d{4}$";

        if (id.contains("SVVL")) {
            return id.matches(VILLA_ID_REGEX);
        } else if (id.contains("SVHO")) {
            return id.matches(HOUSE_ID_REGEX);
        } else if (id.contains("SVRO")) {
            return id.matches(ROOM_ID_REGEX);
        } else if (id.contains("KH")) {
            return id.matches(CUSTOMER_ID_REGEX);
        } else if (id.contains("NV")) {
            return id.matches(EMPLOYEE_ID_REGEX);
        } else {
            System.out.println("Database ID Validator check error!");
            return false;
        }
    }

    public static Boolean checkName(String name) {
        if (name.length() >= 70) {
            System.out.println("Name can't be more than 70 characters!");
            return false;
        }
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
        LocalDate birthday = convertStringToLocalDate(birthdayString);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthday, currentDate).getYears() >= AGE_REQUIREMENT;
    }

    public static LocalDate convertStringToLocalDate(String dateString) {
        final String REGEX = "[/-]";
        String[] formattedDay = dateString.split(REGEX);
        int day = Integer.parseInt(formattedDay[0]);
        int month = Integer.parseInt(formattedDay[1]);
        int year = Integer.parseInt(formattedDay[2]);
        return LocalDate.of(year, month, day);
    }

    public static boolean checkFacilityName(String name) {
        if (name.length() >= 70) {
            System.out.println("Name can't be more than 70 characters!");
            return false;
        }
        final String FACILITY_NAME_REGEX = "^[\\w\\s\\d]";
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
        } catch (Exception e) {
            e.printStackTrace();
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
        } catch (Exception e) {
            e.printStackTrace();
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
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
