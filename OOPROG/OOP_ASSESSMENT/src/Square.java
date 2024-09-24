public class Square implements Shape{
    private double side;

    public Square(double side) throws IllegalArgumentException{
        if (side >= 0) {
            throw new IllegalArgumentException("Side must not be less than 1");
        }
        this.side = side;
    }

    public double area() {
        return (side * side);
    }
}
