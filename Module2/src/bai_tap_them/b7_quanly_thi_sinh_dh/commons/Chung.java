package bai_tap_them.b7_quanly_thi_sinh_dh.commons;

public interface Chung {
    String PATH = "src/bai_tap_them/b7_quanly_thi_sinh_dh/data/";
    String FILE_NAME = "thiSinh.csv";
    String FILE_NAME1 = " .csv";
    String NAME_VN = "^([A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễỬỮỰỲỴÝỶỸ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*)(\\s[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễỬỮỰỲỴÝỶỸ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*)*$";
    String NAME_E = "^[A-Z]([a-z]*)+([0-9]*)$";     //      Khanh12
    String DAY = "\\d{2}[-|/]\\d{2}[-|/]\\d{4}";    //      dd/mm/yyyy hoặc dd-mm-yyyy
    String GENDER = "^(Male)$|^(Female)$|^(Other)$";
    String CAPACITY = "(^[1-9]$)|(^[1][0-9]$)|(^20$)";        //      1-20   -- "^[0-9]{2}$" / 0-99
    String EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    String YEAR18 = "^19[0-9][0-9]$|^200[0-3]$";                 //      từ năm 1900 > 2013   cách năm 2021 18 năm
    String INTEGER = "^-?[0-9]+$";          //      int >= 0 && int < 0
    String NUMBER = "^[0-9]+$";             //      int >= 0
    String DOUBLE = "^[0-9]+(\\.[0-9]+)?$";   //      double(Ex: 1, 1.2)
    String UU_TIEN = "^(Dân tộc thiểu số)$|^(Gia đình có công cách mạng)$";
    String DIEM = "^[0-9](\\.[0-9]{1,2})?$|^10$";
}
