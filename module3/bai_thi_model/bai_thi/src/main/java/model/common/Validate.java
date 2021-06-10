package model.common;

import model.bean.StudentDemo;

import java.util.HashMap;
import java.util.Map;

public class Validate {
    static final String NAME_VN = "^([A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễỬỮỰỲỴÝỶỸ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*)(\\s[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễỬỮỰỲỴÝỶỸ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*)*$";
    static final String CUSTOMER_ID = "^KH-[0-9]{4}$";
    static final String SERVICE_ID = "^DV-[0-9]{4}$";
    static final String PHONE = "^090[0-9]{7}$|^091[0-9]{7}$|^\\(84\\)\\+90[0-9]{7}$|^\\(84\\)\\+91[0-9]{7}$";
    static final String ID_CARD = "^[0-9]{9}$";
    static final String EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    static final String INTEGER = "^[0-9]*$";
    static final String DOUBLE = "^[0-9]+\\.?[0-9]*$";
    static final String DOUBLE_2_NUM = "^[0-9](.[0-9]{1})?$|^10$|^10.0$";
    static final String NAME = "[a-zA-Z\\s]+";
    static final String DAY_YYYY_MM_DD = "^(19[0-9]{2}|20[0-9]{2})-[01][0-9]-[0123][0-9]$";
    static final String YEAR18 = "^19[0-9][0-9]$|^200[0-3]$";
    public static final String NAM_NHUAN = "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
            + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
            + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
            + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$";



//    public static final String NAME="^[\\p{L} .'-]+$"; Tên tiếng việt ( phải 2 chữ trở lên) 1 chữ lỗi



    public static String checkName(String name){
        String string = "";
        if ("".equals(name)){
            string = "Please input name";
        }else if (!name.matches(NAME)) {
            string = "Invalid format name. Hint: Nguyen Van A";
        }
        return string;
    }

    public static String checkBirthday(String day){
        String string = "";
        if ("".equals(day)){
            string =  "Please input day";
        } else if (!day.matches(DAY_YYYY_MM_DD)){
            string = "Format Birthday YYYY-MM-DD";
        }
        return string;
    }

    public static String checkBirthday18(String day){
        String string = "";
        String year = day.split("-")[0];
        if ("".equals(day)){
            string =  "Please input day";
        } else if (!day.matches(DAY_YYYY_MM_DD)){
            string = "Format Birthday YYYY-MM-DD";
        } else if (!year.matches(YEAR18)){
            string = "Not enough 18 age";
        }
        return string;
    }


    public static String checkEmail(String email){
        String string = "";
        if ("".equals(email)){
            string = "Please input email";
        } else if (!email.matches(EMAIL)){
            string = "Format Email abc@gmail.com";
        }
        return string;
    }

    public static String checkPoint(String point){
        String string = "";
        if ("".equals(point)){
            string ="Please input point";
        } else if (!point.matches(DOUBLE_2_NUM)){
           string = "Format Email 0 <= point(9.1 or 9) <= 10";
        }
        return string;
    }

    public static String checkInteger(String integer){
        String string = "";
        if ("".equals(integer)){
            string = "Please input number";
        } else if (!integer.matches(INTEGER)){
            string = "Format number is integer";
        }
        return string;
    }

    public static String checkNameVN(String name){
        String string = "";
        if ("".equals(name)){
            string = "Please input name";
        } else if (!name.matches(NAME_VN)) {
            string = "Invalid format name. Hint: Nguyễn Văn A";
        }
        return string;
    }
}
