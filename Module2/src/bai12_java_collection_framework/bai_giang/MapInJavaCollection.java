package bai12_java_collection_framework.bai_giang;

import java.util.HashMap;
import java.util.Set;

public class MapInJavaCollection {
    public static void main(String[] args) {
        HashMap<String, Integer> customers = new HashMap<>();
        customers.put("John", 30);
        customers.put("Mike", 28);
        customers.put("Bill", 32);
        customers.put("Maria", 27);

        Set<String> keys = customers.keySet();
        for (String key: keys){
            System.out.println("Key: " + key + ": " + customers.get(key));
        }
    }
//    Key: Mike: 28
//    Key: John: 30 ??? sao ko ở đầu
//    Key: Bill: 32
//    Key: Maria: 27
}
