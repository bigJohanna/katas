package triangle;

import java.util.stream.DoubleStream;


public class Triangle {

    double[] sides;

    public Triangle(double a, double b, double c) {
        sides = new double[]{a, b, c};
    }

    public Triangle(double[] s) {
        this(s[0],s[1],s[2]);
    }

    public Triangle(Point a, Point b, Point c) {
        sides = new double[3];
        sides[0] = Math.sqrt(Math.pow((double) (b.x - a.x), 2.0) + Math.pow((double) (b.y - a.y), 2.0));
        sides[1] = Math.sqrt(Math.pow((double) (b.x - c.x), 2.0) + Math.pow((double) (b.y - a.y), 2.0));
        sides[2] = Math.sqrt(Math.pow((double) (c.x - a.x), 2.0) + Math.pow((double) (c.y - a.y), 2.0));
    }

    public Triangle(Point[] s) {
        this(s[0],s[1],s[2]);
    }

    private int uniqueSides() {
        return (int)DoubleStream.of(sides).distinct().count();
    }

    public boolean isScalene() {
        if (uniqueSides() == 3) {
            return true;
        }
        return false;
    }

    public boolean isEquilateral() {
        if (uniqueSides() == 1) {
            return true;
        }
        return false;
    }

    public boolean isIsosceles() {
        if (uniqueSides() == 2) {
            return true;
        }
        return false;
    }
}
