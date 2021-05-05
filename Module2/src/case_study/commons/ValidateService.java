package case_study.commons;

import bai_tap_them.b3_manage_transport3.commons.VehicleValidate;

public class ValidateService extends Exception {
    public ValidateService(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "VehicleValidate";
    }

    public static void checkFormat(String property, String input, String regex) throws VehicleValidate {
        if (!input.matches(regex)){
            throw new VehicleValidate("Lỗi định dạng "+ property +": " + regex);
        }
    }
}
