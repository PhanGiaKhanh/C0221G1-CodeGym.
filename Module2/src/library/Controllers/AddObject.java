package library.Controllers;

import library.commons.MessageException;

import java.util.Scanner;

public class AddObject {
    private static Scanner scanner = new Scanner(System.in);

    public static String add(String property, String regex) {
        String input = null;
        do {
            try {
                System.out.println("Nhập " + property + ": " + regex);
                input = scanner.nextLine();
                if (!input.matches(regex)) {
                    throw new MessageException("Lỗi định dạng " + property + ": " + regex);
                }
                break;
            } catch (MessageException v) {
                System.err.println(v.getMessage());
            }
        } while (true);
        return input;
    }

    public static String add(String property, String regex, String message) {
        String input = null;
        do {
            try {
                System.out.println("Nhập " + property + ": " + message);
                input = scanner.nextLine();
                if (!input.matches(regex)) {
                    throw new MessageException("Lỗi định dạng " + property + ": " + regex);
                }
                break;
            } catch (MessageException v) {
                System.err.println(v.getMessage());
            }
        } while (true);
        return input;
    }

}
