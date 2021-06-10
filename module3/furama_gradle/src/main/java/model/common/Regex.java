package model.common;

public class Regex {

    //1.	Mã Khách hàng có định dạng là KH-XXXX (X là số từ 0-9)
    static final String CUSTOMER_ID = "^KH-[0-9]{4}$";
    //2.	Mã Dịch vụ có định dạng là DV-XXXX (X là số 0-9)
    static final String SERVICE_ID = "^DV-[0-9]{4}$";
    //3.	Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx
    static final String PHONE = "^090[0-9]{7}$|^091[0-9]{7}$|^\\(84\\)\\+90[0-9]{7}$|^\\(84\\)\\+91[0-9]{7}$";
    //4.	Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)
    static final String ID_CARD = "^[0-9]{9}$";
    //5.	Địa chỉ email phải đúng định dạng email
    static final String EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    //6.	Ngày sinh, Ngày làm hợp đồng, Ngày kết thúc sử dụng datepicker để người dùng có thể chọn ngày thuận tiện. Phải validate xem ngày giờ có hợp lệ hay không (đúng định dạng ngày giờ theo format DD/MM/YYYY).
//7.	Số lượng, Số tầng phải là số nguyên dương
    static final String INTEGER = "^[0-9]*$";
//8.	Lương, Giá, Tiền đặt cọc, Tổng tiền phải là số dương
    static final String DOUBLE = "^[0-9]+\\.?[0-9]*$";
//9.	Tính tổng tiền sử dụng dịch vụ (trong màn hình 9) dựa vào các dữ liệu cố định (là các dữ liệu giả định của học viên, đang để cố định trên trang HTML, không liên quan đến server).
//10.	Khi click vào nút xóa (hoặc biểu tượng xóa) trên các dòng ở các màn hình liệt kê thì phải hiển thị thông báo confirm việc người dùng có chắc chắn muốn xóa dữ liệu hay không. Nếu người dùng chọn Yes thì xóa dữ liệu ở dòng đó (Ở đây, chúng ta chỉ giả lập thao tác xóa dữ liệu ở phía client, tức là xóa dữ liệu cứng mà học viên đang để cố định trên trang HTML, không liên quan đến dữ liệu phía server).
    static final String NAME = "[a-zA-Z\\s]+";
    static final String DAY_YYYY_MM_DD = "^(19[0-9]{2}|20[0-9]{2})-[01][0-9]-[0123][0-9]$";
}
