package library.Controllers;

import case_study.commons.Common;
import case_study.commons.FileUtils;
import case_study.models.Room;
import case_study.models.Service;

import java.util.ArrayList;
import java.util.List;

public class ID_Auto {

    public static String id_SVRO_0001(){
        String ma = "SVRO-";
        String regex = "^SVRO-[0-9]{4}$";
        List<Service> lists = FileUtils.read(Common.DATA_SERVICE);
        List<Service> objects = new ArrayList<>();
        for (Service list : lists){
            if (list instanceof Room){
                objects.add(list);
            }
        }
        String id = "";
        while (true){
            id = ma + (objects.size() +1);
            if (id.matches(regex)){
                break;
            }
            ma += 0;
            id = "";
        }
        return id;
    }
    public static String id_0001(){
        String regex = "^[0-9]{4}$";
        List<Service> lists = FileUtils.read(Common.DATA_SERVICE);
        List<Service> objects = new ArrayList<>();
        for (Service list : lists){
            if (list instanceof Room){
                objects.add(list);
            }
        }
        String temp = "";
        String id = "";
        while (true){
            id = id+(objects.size() +1);
            if (id.matches(regex)){
                break;
            }
            id = "";
            temp += 0;
            id = temp;
        }
        return id;  
    }
}
