package bai_tap_them.b6_quanly_tai_lieu.commons;

public interface Chung {
    String PATH = "src/bai_tap_them/b6_quanly_tai_lieu/data/";
    String FILE_NAME = " .csv";
    String FILE_NAME1 = " .csv";
    String NAME_VN = "^([A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễỬỮỰỲỴÝỶỸ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*)(\\s[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễỬỮỰỲỴÝỶỸ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*)*$";
    String NAME_E = "^[A-Z]([a-z]*)+([0-9]*)$";     //      Khanh12
    String DAY = "\\d{2}[-|/]\\d{2}[-|/]\\d{4}";    //      dd/mm/yyyy hoặc dd-mm-yyyy
    String GENDER = "^(Male)$|^(Female)$|^(Other)$";
    String NUMBER = "^[0-9]+$";             //      int >= 0

}
