package bai19_string_regex.bai_tap.validate_phone_number;

public class Main {
    public static void main(String[] args) {
        String[] strings = new String[]{"(84)-(0978489648)", "(a8)-(22222222)",
                "(a)-(22222222)", "(12)-(12345678)", "(12)-(123456789",
                "(12-(123456789)", "12)-(123456789)", "(12)-(123456789)"};
        ValidatePhoneNumber phoneNumber = new ValidatePhoneNumber();
        for (String str : strings) {
//            System.out.println(str + "---- isValidate: " + phoneNumber.isValidate(str));
            if (phoneNumber.isValidate(str)){
                System.out.println(str + "---- isValidate: OK");
            }else {
                System.out.println(str + "---- Not is phone number");
            }
        }

    }
}
