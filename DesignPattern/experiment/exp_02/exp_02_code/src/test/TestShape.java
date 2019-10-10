package test;

import shape.AbstractShape;
import shape.Rectangle;
import shape.Square;

public class TestShape {
    public static void main(String[] args) {
        AbstractShape shape;
        //正方形
        shape = new Square(2);
        System.out.println("Square: area-"+shape.getArea()+" circumference-"+shape.getCircumference());

        //长方形
        shape = new Rectangle(2, 3);
        System.out.println("Rectangle: area-"+shape.getArea()+" circumference-"+shape.getCircumference());
    }
}
