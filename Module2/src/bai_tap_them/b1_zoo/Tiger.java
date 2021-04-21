package bai_tap_them.b1_zoo;

public class Tiger extends Animal {
    @Override
    void showSound() {
        System.out.println("Gru gru........");
    }

    public Tiger() {
    }

    public Tiger(String name, int age, String description) {
        super(name, age, description);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
