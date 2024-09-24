public class Circle implements Shape {
    private final double PI = Math.PI;
    double radius;

    public Circle(double radius) throws IllegalArgumentException{
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must not be less than 1");
        }
        this.radius = radius;

    }

    public double area() {
        double area = PI * (radius * radius);

        return area;
    }
}
