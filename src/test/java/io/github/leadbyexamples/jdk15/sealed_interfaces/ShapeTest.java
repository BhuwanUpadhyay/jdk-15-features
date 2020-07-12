package io.github.leadbyexamples.jdk15.sealed_interfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapeTest {

    @Test
    void testCircleArea() {
        Circle circle = new Circle(5);

        assertEquals(79, circle.area());
    }

    @Test
    void testRectangleArea() {
        Rectangle rectangle = new Rectangle(5, 3);

        assertEquals(15, rectangle.area());
    }


    @Test
    void testSquareArea() {
        Square square = new Square(5);

        assertEquals(25, square.area());
    }
}