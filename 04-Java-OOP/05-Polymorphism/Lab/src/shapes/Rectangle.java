package shapes;

public class Rectangle implements Calculable {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        setHeight(height);
        setWidth(width);
    }

    private void setHeight(Double height) {
        checkSideLength(height);
        this.height = height;
    }

    private void setWidth(Double width) {
        checkSideLength(width);
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        System.out.println(2 * (this.height + this.width));
    }

    @Override
    public void calculateArea() {
        System.out.println(this.height * this.width);
    }

    private void checkSideLength(Double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("The value must be positive!");
        }
    }
}
