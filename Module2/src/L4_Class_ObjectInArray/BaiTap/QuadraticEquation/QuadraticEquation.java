package L4_Class_ObjectInArray.BaiTap.QuadraticEquation;

public class QuadraticEquation {
    double a;
    double b;
    double c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getDelta() {
        return this.b * 2 - 4 * this.a * this.c;
    }

    public String getResult() {
        if (this.getDelta() < 0) {
            return "The equation has no roots";
        } else if (this.getDelta() == 0) {
            return "Root 1 = Root 2 = " + (-this.b / (2 * this.a));
        } else {
            return "Root 1 = " + (-this.b + Math.sqrt(Math.pow(this.b, 2) - (4 * this.a * this.b))) / (2 * this.a)
                    + "\nRoot 2 = " + (-this.b - Math.sqrt(Math.pow(this.b, 2) - (4 * this.a * this.b))) / (2 * this.a);
        }
    }
}