package bai7_abstract_class_interface.thuc_hanh.animal;

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
