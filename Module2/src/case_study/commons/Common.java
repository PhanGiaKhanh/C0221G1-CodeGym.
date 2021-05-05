package case_study.commons;

public interface Common {
    String DATA = "service.csv";
    String VILLA = "Villa";
    String HOUSE = "HOUSE";
    String ROOM = "ROOM";
    String ID = "^SV+(VL|HO|RO)-[0-9]{3}$";
    String DATA_SERVICE = "service.csv";
    String DATA_CUSTOMER = "customer.csv";
    String Id_VILLA = "SVVL-[0-9]{4}";
    String Id_HOUSE= "SVHO-[0-9]{4}";
    String Id_ROOM = "SVRO-[0-9]{4}";
    String NAME = "^([A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễỬỮỰỲỴÝỶỸ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*)(\\s[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễỬỮỰỲỴÝỶỸ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*)*$";
    String NUMBER = "^[1-9]|([1-9][0-9]*)$";
    String AREA = "^[3-9][0-9]*$";
    String PRICE = "^[1-9]|([1-9][0-9]*)$";
    String CAPACITY = "(^[1-9]$)|(^[1][0-9]{1}$)|(^20$)";
    String TYPE_RENT = "^(năm)|(tháng)|(ngày)|(giờ)$";
    String STANDARD = "^[\\*]{1,5}$";
    String FLOORS = "^[1-9]$";
    String DAY = "\\d{2}[-|/]\\d{2}[-|/]\\d{4}";    //      dd/mm/yyyy hoặc dd-mm-yyyy
    String GENDER = "^(male)$|^(female)$|^(other)$";
    String CMND = "^[0-9]{5}$";
    String EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
}
