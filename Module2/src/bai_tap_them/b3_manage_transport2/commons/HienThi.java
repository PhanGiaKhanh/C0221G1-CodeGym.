package bai_tap_them.b3_manage_transport2.commons;

import bai_tap_them.b3_manage_transport2.models.PhuongTien;
import bai_tap_them.b3_manage_transport2.models.XeTai;

import java.util.ArrayList;
import java.util.List;

public class HienThi {
    public static void xeTai(){
        for (String xe : TapTin.doc()){
            if (xe.split(",").length == 5){
                if (xe.split(",")[0].contains("C")) {
                    XeTai xeTai = new XeTai(xe.split(","));
                    xeTai.showInfo();
                }
            }
        }
    }
    public static void oto(){
//        System.out.println(TapTin.doc());
        for (String xe : TapTin.doc()){
            if (xe.split(",").length == 6){
                System.out.println(xe);
                XeTai oto = new XeTai(xe.split(","));
                oto.showInfo();
            }
        }
    }
    public static void xeMay(){
        for (String xe : TapTin.doc()){
            if (xe.split(",").length == 5){
                if (!xe.split(",")[0].contains("C")) {
                    XeTai xeMay = new XeTai(xe.split(","));
                    xeMay.showInfo();
                }
            }
        }
    }
}
