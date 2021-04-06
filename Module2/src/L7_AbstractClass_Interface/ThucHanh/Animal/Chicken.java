package L7_AbstractClass_Interface.ThucHanh.Animal;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-click";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
