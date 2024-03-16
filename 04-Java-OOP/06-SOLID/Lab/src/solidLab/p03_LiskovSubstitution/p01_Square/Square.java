package solidLab.p03_LiskovSubstitution.p01_Square;

public class Square extends Rectangle {

    public Square(double width) {
        super(width, 1);
    }

    @Override
    public double getArea() {
        return super.getArea();
    }
}
