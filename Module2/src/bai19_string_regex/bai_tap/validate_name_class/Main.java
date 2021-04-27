package bai19_string_regex.bai_tap.validate_name_class;

public class Main {
    public static void main(String[] args) {
        String[] strings = new String[]{"C0318G","M0318G","P0323A"};
        RegularExpression regular = new RegularExpression();
        for( String str : strings){
            System.out.println(regular.isValidate(str));
        }

    }
}
