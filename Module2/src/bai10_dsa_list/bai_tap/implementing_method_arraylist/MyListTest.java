package bai10_dsa_list.bai_tap.implementing_method_arraylist;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> lists = new MyList<>();
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);
        lists.add(2,4);

        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
        System.out.println();
        System.out.println(lists.get(1));

        lists.remove(2);
        System.out.println();
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
        System.out.println();
        System.out.println(lists.indexOf(1));
        System.out.println(lists.indexOf(3));

        System.out.println(lists.contains(2));
        System.out.println(lists.contains(1));
        lists.clear();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        for (int i = 0; i < lists.length(); i++) {
            System.out.println(lists.get(i));
        }
    }
}
