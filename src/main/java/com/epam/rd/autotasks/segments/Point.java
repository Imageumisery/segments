package com.epam.rd.autotasks.segments;

import java.util.Objects;

class Point {
    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Point point) {
        if (this == point) return true;
        if (!(point instanceof Point)) return false;

        double delta = 0.000001D;

        return ((getX() - point.getX()) <= delta) && (delta >= (getY() - point.getY()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
