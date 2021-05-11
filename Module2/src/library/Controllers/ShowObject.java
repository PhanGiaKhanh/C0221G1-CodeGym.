package library.Controllers;

import case_study.commons.Common;
import case_study.models.House;
import case_study.models.Service;
import library.commons.FileUtils;
import library.commons.Regex;
import library.models.Oto;
import library.models.PhuongTien;

import java.util.*;

public class ShowObject {
    public static void allOto(){
        List<PhuongTien> lists = FileUtils.readList(" ");
        for (PhuongTien list : lists){
            if (list instanceof Oto) {
                list.showInfo();
            }
        }
    }

    public static void allNameOto(){
        List<PhuongTien> lists = FileUtils.readList(" ");
        for (int i = 0; i< lists.size(); i++){
            if (lists.get(i) instanceof Oto) {
                System.out.println(((Oto) lists.get(i)).getName());;
            }
        }
    }

    public static void allNameOtoSort() {
        List<PhuongTien> listOto = new ArrayList<>();
        List<PhuongTien> lists = FileUtils.readList(" ");
        for (PhuongTien list : lists){
            if (list instanceof Oto) {
                listOto.add(list);
            }
        }
        listOto.sort(Comparator.comparing(PhuongTien :: getName));
        listOto.forEach(e->e.showInfo());
    }

    private static void allNameOtoTreeSet() {
        List<PhuongTien> listOto = new ArrayList<>();
        List<PhuongTien> lists = FileUtils.readList(" ");
        for (PhuongTien list : lists){
            if (list instanceof Oto) {
                if (!listOto.contains(list)) {
                    listOto.add(list);
                }
            }
        }
        listOto.sort(Comparator.comparing(PhuongTien :: getName));
        listOto.forEach(e->e.showInfo());
    }
}
