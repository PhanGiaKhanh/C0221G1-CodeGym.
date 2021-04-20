package bai15_exception_debug.bai_giang;

import java.util.LinkedHashMap;
import java.util.Set;

public class Test {
    public static void main(String args[]) {
        // init linkedHashMap
        LinkedHashMap<Integer, String> linkedHashMap
                = new LinkedHashMap<Integer, String>();
        // add elements to linkedHashMap
        linkedHashMap.put(1, "Java");
        linkedHashMap.put(3, "C++");
        linkedHashMap.put(2, "PHP");
        linkedHashMap.put(4, "Python");
        // show linkedHashMap before remove
        System.out.println("Before remove:");
        show(linkedHashMap);
        // remove element
        linkedHashMap.remove(2);
        // show linkedHashMap after remove
        System.out.println("After remove:");
        // show hashMap
        show(linkedHashMap);
    }

    /**
     * show HashMap
     *
     * @param viettuts.vn
     */
    public static void show(LinkedHashMap<Integer, String> linkedHashMap) {
        Set<Integer> keySet = linkedHashMap.keySet();
        for (int key : keySet) {
            System.out.println(key + " " + linkedHashMap.get(key));
        }
    }
}
