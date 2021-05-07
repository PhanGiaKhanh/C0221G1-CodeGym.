package library.Controllers;

import library.commons.MessageException;
import library.commons.Regex;

import java.util.Scanner;

public class CheckDayOfBirth {
    public static void main(String[] args) {
        CheckDayOfBirth.addDayOfBirth();
    }
    private static Scanner scanner = new Scanner(System.in);
    public static String addDayOfBirth()  {
        System.out.println("Enter day of birth: ");
        String dayOfBirth = null;
        String[] array;
        while (true) {
            try {
                if (!dayOfBirth.matches(Regex.REGEX_DAY)) {
                    // String REGEX_DAY_FORMAT = "^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
                    throw new MessageException("Day is not normal. Request: dd/mm/yyyy or dd-mm-yyyy");
                }
                array = dayOfBirth.split("[-|/]");
                if (!array[array.length-1].matches(Regex.YEAR18)) {
                    // String YEAR18 = "^19[0-9][0-9]$|^200[0-3]$";
                    throw new MessageException("1900 < year < 2003");
                }
                return dayOfBirth;
            } catch (MessageException e) {
                e.printStackTrace();
            }
        }
    }
}
