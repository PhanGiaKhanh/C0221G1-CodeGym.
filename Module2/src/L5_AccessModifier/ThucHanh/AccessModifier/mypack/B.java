package L5_AccessModifier.ThucHanh.AccessModifier.mypack;

import L5_AccessModifier.ThucHanh.AccessModifier.pack.A;

public class B extends A {
    public static void main(String[] args) {
        A obj = new A();
        obj.msg();
        A.msg();
    }
}
