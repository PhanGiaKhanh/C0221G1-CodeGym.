package model.common;

import model.bean.customer.Customer;
import model.service.CustomerService;
import model.service.impl.CustomerServiceImpl;

public class Validate {
    static Regex regex = new Regex();
    static CustomerService customerService = new CustomerServiceImpl();
    public static String checkCustomerId (String customer_code){
        String checkCustomerId = "";
        boolean check = customer_code.matches(regex.CUSTOMER_ID);
        if (!check) {
            checkCustomerId = "KH-XXXX (X is number from 0-9)";
        }
        Customer checkExist = customerService.findByCode(customer_code);
        if (checkExist != null) {
            checkCustomerId = "Customer Code is already exist!!!";
        }
        return checkCustomerId;
    }

    public static String checkPhoneNumber(String PhoneNumber) {
        boolean check = PhoneNumber.matches(regex.PHONE);
        String checkPhoneNumber = "";
        if (!check) {
            checkPhoneNumber = "090xxxxxxx | 091xxxxxxx | (84)+90xxxxxxx | (84)+91xxxxxxx)";
        }
        return checkPhoneNumber;
    }
    public static String checkIdCard(String idCard) {
        boolean check = idCard.matches(regex.ID_CARD);
        String checkIdCard = "";
        if (!check) {
            checkIdCard = "The ID number must is 9 number";
        }
        return checkIdCard;
    }
    public static String checkEmail(String email) {
        boolean check = email.matches(regex.EMAIL);
        String checkEmail = "";
        if (!check) {
            checkEmail = "Email must be in the correct format abc@abc.abc";
        }
        return checkEmail;
    }
    public static String checkDay(String day) {
        boolean check = day.matches(regex.DAY_YYYY_MM_DD);
        String checkDay = "";
        if (!check) {
            checkDay = "date and time format in the format DD / MM / YYYY";
        }
        return checkDay;
    }
    public static String checkNumberInteger(String number) {
        boolean check = number.matches(regex.INTEGER);
        String checkNumberInterger = "";
        if (!check) {
            checkNumberInterger = "enter a positive integer";
        }
        return checkNumberInterger;
    }
    public static String checkNumberDouble(String number) {
        boolean check = number.matches(regex.DOUBLE);
        String checkNumberDouble = "";
        if (!check) {
            checkNumberDouble = "enter positive real numbers";
        }
        return checkNumberDouble;
    }
    public static String checkName(String name) {
        boolean check = name.matches(regex.NAME);
        String checkName = "";
        if (!check) {
            checkName ="Name invalid";
        }
        return checkName;
    }
    public static String checkNull(String string) {
        String newString= "";
        if ( string.equals("") ) {
            newString= "you have not selected a type";
        }
        return newString;
    }
}
