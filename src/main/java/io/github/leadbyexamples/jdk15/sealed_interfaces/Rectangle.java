package io.github.leadbyexamples.jdk15.sealed_interfaces;

non-sealed class Rectangle implements Shape {

    private final int length;
    private final int width;

    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public long area() {
        return length * width;
    }

}
