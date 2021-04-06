package L4_Class_ObjectInArray.BaiTap.Fan;

public class Execute {
    public static void main(String[] args) {
        Fan fan = new Fan();
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();

        fan1.setRadius(10);
        fan1.setSpeed(10);
        fan1.setOn(true);
        fan1.setColor("yellow");

        fan2.setRadius(5);
        fan2.setSpeed(5);
        fan2.setOn(false);
        fan2.setColor("blue");

        System.out.println(fan.toString());
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
