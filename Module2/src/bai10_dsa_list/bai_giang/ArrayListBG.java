package bai10_dsa_list.bai_giang;

import java.util.ArrayList;
import java.util.List;

public class ArrayListBG {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.remove(1); // xóa 2
        System.out.println(arrayList.size()); // số phần tử
        System.out.println(arrayList.isEmpty());// kiểm trả rỗng boolean
        System.out.println(arrayList);
    }
}
