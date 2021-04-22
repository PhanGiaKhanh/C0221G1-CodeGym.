package bai_hoc_them.class_collections;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        int x =5;
//        String str = "" + x;
//        String[] strings = {"'Dojo'",str};
//        System.out.println(strings.toString());
//        for (String i: strings
//             ) {
//            System.out.print(i);
//        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>(){
        };
        Map hashMap = new HashMap();
        hashMap.put(5,"a");
        hashMap.put(2,"b");
        hashMap.put(3,"c");
        hashMap.put(4,"d");
        hashMap.put(1,"e");
        System.out.println(hashMap.values());
        ArrayList strings = (ArrayList) hashMap.values();
       strings.forEach(e-> System.out.println(e));
    }
}
