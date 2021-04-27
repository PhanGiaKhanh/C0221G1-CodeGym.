package bai19_string_regex.bai_tap.validate_phone_number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
//    public static String PHONE_NUMBER_REGEX = "^[(]+[0-9]{2}+[)]+[-]+[(]+[0]+[0-9]{9}$";
    public static String PHONE_NUMBER_REGEX = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
    public ValidatePhoneNumber(){}
    public boolean isValidate(String regex){
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
