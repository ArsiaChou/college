package shape;

public class Square extends AbstractShape{
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public Square() {
        this(0.00);
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getCircumference() {
        return sideLength * 4;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }
}
