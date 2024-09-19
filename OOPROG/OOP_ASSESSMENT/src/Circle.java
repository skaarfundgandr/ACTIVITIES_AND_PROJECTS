public class Circle implements Shape {
    private final double PI = Math.PI;
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        double area = PI * (radius * radius);

        return area;
    }
}
