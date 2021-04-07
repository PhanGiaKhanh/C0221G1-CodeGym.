package bai5_access_modifier.thuc_hanh.static_property;

public class TestStaticProperty {
    public static void main(String[] args) {
        int count = Car.numberOfCars;
        System.out.println(count);
        Car car1 = new Car("Mazda 3", "Skyactiv 3");
        System.out.println(Car.numberOfCars);
//        System.out.println(car1.name);
        Car car2 = new Car("Mazda 6", "Skyactiv 6");
        System.out.println(Car.numberOfCars);
//        System.out.println(car2.engine);
    }
}
