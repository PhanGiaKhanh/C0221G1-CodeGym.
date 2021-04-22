package bai_hoc_them.class_collections;

import java.util.*;

public class CollectionsAddAll {
    public static void main(String a[]) {
        // create list
        List<String> list = new ArrayList<String>();
        // add elements to list
        list.add("C++");
        list.add("Java");
        list.add("PHP");
        // print list
        System.out.println(list);

        // add elements to list
        Collections.addAll(list, "Servlet", "JSP");
        // print list
        System.out.println(list);

        // create array of String
        String[] strArr = { "C#", ".Net" };
        // add elements to list
        Collections.addAll(list, strArr);
        // print list
        System.out.println(list);
        long start = System.currentTimeMillis();
//        System.out.println("Max: "+Collections.max(list));
        long end = System.currentTimeMillis();
        System.out.println("Thời gian: " + (end - start));
//        start = System.currentTimeMillis();
//        String max = list.get(0);
//        for (int i = 0; i < list.size()-1; i++) {
//            if (max.compareTo(list.get(i)) < -1){
//                max = list.get(i);
//            }
//        }
//        System.out.println(max + "2");
//        end = System.currentTimeMillis();
//        System.out.println("Thời gian: " + (end - start));

//

        start = System.currentTimeMillis();
        Arrays.sort(list.toArray());
        System.out.println(list.get(list.size()-1) + "4");
        end = System.currentTimeMillis();
        System.out.println("Thời gian: " + (end - start));
        System.out.println("Min: "+Collections.min(list));
    }
}

