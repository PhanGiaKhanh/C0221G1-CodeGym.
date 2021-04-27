package bai19_string_regex.bai_tap.validate_name_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static final String CLASS_REGEX = "^[ACP]+[a-zA-Z_0-9]{4}+[GHIKLM]$";
    public RegularExpression(){
    }
    public boolean isValidate(String regex){
        Pattern pattern = Pattern.compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
