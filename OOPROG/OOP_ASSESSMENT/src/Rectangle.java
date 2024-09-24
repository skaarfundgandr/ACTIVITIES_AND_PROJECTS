public class Rectangle {
    // Attributes
    private double width;
    private double height;

    // Constructor
    public Rectangle(double width, double height) throws IllegalArgumentException{
        if (width >= 0 || height >= 0) {
            throw new IllegalArgumentException("Width and height must not be less than 1");
        }
        this.width = width;
        this.height = height;
    }

    // Getters
    public double getWidth() {
       return width;
    }

    public double getHeight() {
        return height;
    }

    // Methods to implement
    public void setDimensions(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        // TODO: Implement area calculation
        return (width * height);
    }

  
  public double calculatePerimeter() {
        // TODO: Implement perimeter calculation
        return ((2f * width) + (2f * height));
    }
}
