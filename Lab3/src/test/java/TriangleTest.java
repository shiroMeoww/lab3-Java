import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

class TriangleTest {

    @Test
    void testZeroSides() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(0, 4, 5, new Color(255, 0, 0)));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(3, 0, 5, new Color(0, 255, 0)));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(3, 4, 0, new Color(0, 0, 255)));
    }

    @Test
    void testInvalidTriangle() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 3, new Color(255, 255, 0)));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(10, 5, 2, new Color(128, 128, 128)));
    }

    @Test
    void testValidTriangles() {
        Triangle triangle1 = new Triangle(3, 4, 5, new Color(255, 0, 0));
        assertEquals(6.0, triangle1.getArea(), 0.001);
        assertEquals(12.0, triangle1.getPerimeter());

        Triangle triangle2 = new Triangle(6, 8, 10, new Color(0, 255, 0));
        assertEquals(24.0, triangle2.getArea(), 0.001);
        assertEquals(24.0, triangle2.getPerimeter());

        Triangle triangle3 = new Triangle(7, 24, 25, new Color(0, 0, 255));
        assertEquals(84.0, triangle3.getArea(), 0.001);
        assertEquals(56.0, triangle3.getPerimeter());
    }

    @Test
    void testColorAssignment() {
        Color color = new Color(255, 255, 255);
        Triangle triangle = new Triangle(5, 12, 13, color);
        assertEquals(color, triangle.getColor());
    }

    @Test
    void testColorDescription() {
        Triangle triangle = new Triangle(3, 4, 5, new Color(100, 150, 200));
        String expectedDescription = "Red: 100, Green: 150, Blue: 200, Alpha: 255";
        assertEquals(expectedDescription, triangle.getColorDescription());
    }

    @Test
    void testLargeTriangle() {
        Triangle largeTriangle = new Triangle(1000, 1000, 1000, new Color(50, 50, 50));
        assertEquals(433012.701, largeTriangle.getArea(), 0.001);
        assertEquals(3000.0, largeTriangle.getPerimeter());
        assertEquals("Red: 50, Green: 50, Blue: 50, Alpha: 255", largeTriangle.getColorDescription());
    }

    @Test
    void testEdgeCase() {
        Triangle triangle = new Triangle(1, 1, 1.9999999, new Color(255, 0, 0));
        assertEquals(0.0, triangle.getArea(), 0.001); // Bardzo mały obszar
        assertEquals(3.9999999, triangle.getPerimeter(), 0.0000001);
    }

    @Test
    void testToStringMock() {
        Triangle triangle = new Triangle(3, 4, 5, new Color(100, 150, 200));
        String mockString = "Triangle[a=3.0, b=4.0, c=5.0, color=Red: 100, Green: 150, Blue: 200, Alpha: 255]";
        assertNotNull(triangle.toString());
        assertNotEquals(mockString, triangle.toString());
    }
    @Test
    void testRandomValidTriangles() {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            double a = 1 + random.nextDouble() * 100;
            double b = 1 + random.nextDouble() * 100;
            double c = 1 + random.nextDouble() * 100;
            if (a + b > c && a + c > b && b + c > a) {
                Triangle triangle = new Triangle(a, b, c, new Color(255, 255, 255));
                assertTrue(triangle.getArea() > 0);
                assertTrue(triangle.getPerimeter() > 0);
            }
        }
    }

    @Test
    void testBoundaryConditions() {
        Triangle minTriangle = new Triangle(1, 1, 1, new Color(0, 0, 0));
        assertEquals(0.433, minTriangle.getArea(), 0.001);
        assertEquals(3.0, minTriangle.getPerimeter(), 0.001);

        Triangle largeTriangle = new Triangle(1000, 1000, 1000, new Color(255, 255, 255));
        assertTrue(largeTriangle.getArea() > 0);
        assertEquals(3000.0, largeTriangle.getPerimeter(), 0.001);
    }
}
