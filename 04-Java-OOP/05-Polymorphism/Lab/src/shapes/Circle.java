package shapes;

public class Circle implements Calculable {

    private Double radius;

    public Circle(Double radius) {
        setRadius(radius);
    }

    private void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        System.out.println(2 * Math.PI * this.radius);
    }

    @Override
    public void calculateArea() {
        System.out.println(Math.PI * Math.pow(this.radius, 2));
    }
}
