package bai11_dsa_stack_queue.bai_tap.count_char_in_string;

import java.util.*;

public class CountCharInString {
    public static void main(String[] args) {
        String[] strings = "hello1 hello2 xinChao1".split("");
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (String string : strings) {
            string = string.toLowerCase();
            if (treeMap.get(string) == null) {
                treeMap.put(string, 1);
            } else {
                treeMap.put(string, treeMap.get(string) + 1);
            }
        }
        Iterator<Map.Entry<String, Integer>> iterator = treeMap.entrySet().iterator();

        while (iterator.hasNext()) {
            System.out.print("\"" + iterator.next() + "\" ");
        }


//                List<Integer> value = new ArrayList<>(treeMap.values());
//                Iterator<String> iterator = treeMap.keySet().iterator();
//                while (iterator.hasNext()) {
//                    System.out.print("\"" +iterator.next() +"\" " );
//                }
//                System.out.println();
//                System.out.println("Values = " + value);
    }
}
