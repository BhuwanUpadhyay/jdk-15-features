package io.github.leadbyexamples.jdk15.sealed_interfaces;

final class Circle implements Shape {

    private final int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public long area() {
        return Math.round(3.14 * radius * radius);
    }

}
