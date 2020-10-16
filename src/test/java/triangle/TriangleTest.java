package triangle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    Point a = new Point(1,2);
    Point b = new Point(2,3);
    Point c = new Point(3,2);
    Point[] pointArray = {a,b,c};
    Triangle isoTriangle = new Triangle(a, b, c);

    Point a2 = new Point(1,2);
    Point b2 = new Point(2,3);
    Point c2 = new Point(4,4);
    Triangle scaTriangle = new Triangle(a2,b2,c2);

    Triangle eqiTriangle = new Triangle(2,2,2);
    @DisplayName("Given an isosicles triangle, isIsosicles should return true.")
    @Test
    void triangleIsIsosiclesShouldReturnTrue() {

        assertTrue(isoTriangle.isIsosceles());
        assertFalse(isoTriangle.isScalene());
        assertFalse(isoTriangle.isEquilateral());
    }

    @DisplayName("Given a scalene triangle only isScalene should return true")
    @Test
    void triangleIsScalene(){
        assertTrue(scaTriangle.isScalene());
        assertFalse(scaTriangle.isIsosceles());
        assertFalse(scaTriangle.isEquilateral());
    }

    @DisplayName("Creating two triangles with different constructors test")
    @Test
    void create_Triangle_with_doubleArray_or_doubles_should_be_equal(){
        double[] doubleArray = {23, 24, 25};

        Triangle t1 = new Triangle(doubleArray);
        Triangle t2 = new Triangle(23,24,25);
        assertEquals(t1.sides.length, t2.sides.length);
    }

    @Test
    void create_Triangle_with_PointArray_or_points_should_be_equal(){
        Triangle t1 = new Triangle(pointArray);
        Triangle t2 = new Triangle(a,b,c);
        assertEquals(t1.sides.length, t2.sides.length);

    }

    @DisplayName("Given an Equilateral Triangle, only isEquilateral returns true")
    @Test
    void isEquilateral_is_the_only_method_that_should_return_true(){
        assertTrue(eqiTriangle.isEquilateral());
        assertFalse(eqiTriangle.isScalene());
        assertFalse(eqiTriangle.isIsosceles());
    }
}