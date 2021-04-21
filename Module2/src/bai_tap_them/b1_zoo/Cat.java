package bai_tap_them.b1_zoo;

public class Cat extends Animal {
    @Override
    void showSound() {
        System.out.println("Mew mew.........");
    }
    public Cat(){}
    public Cat(String name, int age, String description){
        super(name, age, description);
    }
}
