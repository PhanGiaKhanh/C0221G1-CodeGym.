package bai_tap_them.b4_manage_invoice_electric.commons;

import bai_tap_them.b3_manage_transport3.commons.VehicleValidate;

public class NgoaiLe extends Exception {
    public NgoaiLe(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "VehicleValidate";
    }

    public static void check(String thuocTinh, String nhap, String regex) throws VehicleValidate {
        if (!nhap.matches(regex)){
            throw new VehicleValidate("Lỗi định dạng "+ thuocTinh +": " + regex);
        }
    }
}

