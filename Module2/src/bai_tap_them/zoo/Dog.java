package bai_tap_them.zoo;

public class Dog extends Animal {
    @Override
    void showSound() {
        System.out.println("Gau Gau.......");
    }
    public Dog(){}
    public Dog(String name, int age, String description){
        super(name, age, description);
    }
}
