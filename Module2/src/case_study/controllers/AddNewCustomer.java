package case_study.controllers;

import bai_tap_them.b3_manage_transport3.commons.VehicleValidate;
import case_study.Exception.*;
import case_study.commons.Common;
import case_study.commons.FileUtils;
import case_study.commons.ValidateService;
import case_study.models.Customer;
import library.commons.MessageException;
import library.commons.Regex;

import java.util.Scanner;

public class AddNewCustomer {
    private static Scanner scanner = new Scanner(System.in);
    public static void addNew(){
         String customerName = add("customer name", Common.NAME,new NameException());
         String dayOfBirth = addDayOfBirth();
         String gender = add("gender", Common.GENDER, new GenderException()) ;
         String numberCMND = add("number CMND",Common.CMND, new IdCardException());
         String numberPhone = add("number phone",Common.CMND);
         String email = add("email",Common.EMAIL, new EmailException());
         String customerType = add("customer type",Common.NAME);
         String address = add("address",Common.NAME);

        Customer customer = new Customer(customerName,dayOfBirth,gender,numberCMND,numberPhone,email,customerType,address);
        FileUtils.writeString(Common.DATA_CUSTOMER,customer.toString(), true);
    }
    public static String add(String property, String regex, Exception exception ){
        String input = null;
        do {
            try{
                System.out.println("Nhập " + property + ": " +regex);
                input = scanner.nextLine();
                if (!input.matches(regex)){
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.err.println(exception.getMessage());
                e.printStackTrace();
            }
        }while (true);
        return input;
    }
    public static String add(String property, String regex){
        String input = null;
        do {
            try{
                System.out.println("Nhập " + property + ": " +regex);
                input = scanner.nextLine();
                ValidateService.checkFormat(property, input, regex);
                break;
            } catch (VehicleValidate v) {
                System.err.println(v.getMessage());
            }
        }while (true);
        return input;
    }
    public static String addDayOfBirth()  {
        System.out.println("Enter day of birth: ");
        String dayOfBirth = null;
        String[] array;
        while (true) {
            try {
                dayOfBirth = scanner.nextLine();
                if (!dayOfBirth.matches(Regex.DAY)) {
                    // String DAY = "\\d{2}[-|/]\\d{2}[-|/]\\d{4}";
                    throw new MessageException("Not is day of birth. Request: dd/mm/yyyy or dd-mm-yyyy");
                }
                if (!dayOfBirth.matches(Regex.REGEX_DAY)) {
                    // String REGEX_DAY_FORMAT = "^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
                    throw new MessageException("Day of birth is not normal");
                }
                array = dayOfBirth.split("[-|/]");
                if (!array[array.length-1].matches(Regex.YEAR18)) {
                    // String YEAR18 = "^19[0-9][0-9]$|^200[0-3]$";
                    throw new MessageException("1900 < year < 2003");
                }
                break;
            } catch (MessageException e) {
                e.printStackTrace();
            }
        }
        return dayOfBirth;
    }
}
