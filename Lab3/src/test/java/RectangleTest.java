import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void testValidRectangle() {

        Color color = new Color(0, 255, 0);
        Rectangle rectangle = new Rectangle(5.0, 10.0, color);
        assertEquals(50.0, rectangle.getArea());
        assertEquals(30.0, rectangle.getPerimeter());
        assertEquals(5.0, rectangle.getWidth());
        assertEquals(10.0, rectangle.getHeight());
        assertEquals(color, rectangle.getColor());
    }

    @Test
    void testZeroDimensionsThrowsException() {

        Color color = new Color(255, 255, 255);
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0, 10, color));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(5, 0, color));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0, 0, color));
    }

    @Test
    void testNegativeDimensionsThrowsException() {

        Color color = new Color(255, 255, 255);
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-5, 10, color));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(5, -10, color));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-5, -10, color));
    }

    @Test
    void testColorDescription() {

        Color color = new Color(100, 150, 200, 255);
        Rectangle rectangle = new Rectangle(5.0, 10.0, color);
        assertEquals("Red: 100, Green: 150, Blue: 200, Alpha: 255", rectangle.getColorDescription());
    }

    @Test
    void testToString() {

        Color color = new Color(255, 0, 0, 128);
        Rectangle rectangle = new Rectangle(5.0, 10.0, color);
        assertEquals("Rectangle[width=5.0, height=10.0, color=Red: 255, Green: 0, Blue: 0, Alpha: 128]", rectangle.toString());
    }

    @Test
    void testEdgeCases() {

        Color color = new Color(0, 0, 0, 0);
        Rectangle rectangle = new Rectangle(0.1, 0.1, color);
        assertEquals(0.01, rectangle.getArea(), 0.0001);
        assertEquals(0.4, rectangle.getPerimeter(), 0.0001);


        Rectangle largeRectangle = new Rectangle(1e6, 1e6, color);
        assertEquals(1e12, largeRectangle.getArea());
        assertEquals(4e6, largeRectangle.getPerimeter());
    }

    @Test
    void testNullColorThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> new Rectangle(5.0, 10.0, null));
    }

    @Test
    void testGetters() {

        Color color = new Color(50, 100, 150);
        Rectangle rectangle = new Rectangle(15.0, 25.0, color);
        assertEquals(15.0, rectangle.getWidth());
        assertEquals(25.0, rectangle.getHeight());
        assertEquals(color, rectangle.getColor());
    }
}
