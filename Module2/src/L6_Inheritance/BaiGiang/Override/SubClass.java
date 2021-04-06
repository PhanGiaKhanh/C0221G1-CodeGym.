package L6_Inheritance.BaiGiang.Override;

class SubClass extends Override {
    @java.lang.Override
    public String getName() {
        return "This is SubClass";
    }

    public static void main(String[] args) {
        Override override = new Override();
        System.out.println(override.getName());

        SubClass subClass = new SubClass();
        System.out.println(subClass.getName());
        System.out.println(override.getName());
    }
}
