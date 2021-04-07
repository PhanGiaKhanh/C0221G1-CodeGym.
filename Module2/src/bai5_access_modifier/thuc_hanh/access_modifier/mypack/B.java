package bai5_access_modifier.thuc_hanh.access_modifier.mypack;

import bai5_access_modifier.thuc_hanh.access_modifier.pack.A;

public class B extends A {
    public static void main(String[] args) {
        A obj = new A();
        obj.msg();
        A.msg();
    }
}
