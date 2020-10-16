package triangle;

import java.util.stream.DoubleStream;


public class Triangle {

    double[] sides;

    public Triangle(double a, double b, double c) {
        sides = new double[]{a, b, c};
    }

    public Triangle(double[] s) {
        this(s[0], s[1], s[2]);
    }

    public Triangle(Point a, Point b, Point c) {
        sides = new double[3];

        sides[0] = sqrtPow2((b.x - a.x), (b.y - a.y));
        sides[1] = sqrtPow2((b.x - c.x), (b.y - a.y));
        sides[2] = sqrtPow2((c.x - a.x), (c.y - a.y));
    }

    private double sqrtPow2(int i, int j) {
        return Math.sqrt(Math.pow((double) (i), 2.0) + Math.pow((double) (j), 2.0));
    }

    public Triangle(Point[] s) {
        this(s[0], s[1], s[2]);
    }

    private int uniqueSides() {
        return (int) DoubleStream.of(sides).distinct().count();
    }

    public boolean isScalene() {
        return uniqueSides() == 3;
    }

    public boolean isEquilateral() {
        return uniqueSides() == 1;
    }

    public boolean isIsosceles() {
        return uniqueSides() == 2;
    }
}
