import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    // Klasa testowa pomocnicza dla Shape (Shape jest klasą abstrakcyjną)
    static class TestShape extends Shape {
        public TestShape(Color color) {
            super(color);
        }

        @Override
        public double getArea() {
            return 42.0;
        }

        @Override
        public double getPerimeter() {
            return 24.0;
        }
    }

    @Test
    void testConstructorValidColor() {
        Color color = new Color(100, 150, 200, 255);
        Shape shape = new TestShape(color);
        assertEquals(color, shape.getColor());
    }

    @Test
    void testConstructorNullColorThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new TestShape(null);
        });
        assertEquals("Color cannot be null.", exception.getMessage());
    }

    @Test
    void testGetColorDescription() {
        Color color = new Color(50, 75, 100, 200);
        Shape shape = new TestShape(color);
        assertEquals("Red: 50, Green: 75, Blue: 100, Alpha: 200", shape.getColorDescription());
    }

    @Test
    void testGetArea() {
        Color color = new Color(10, 20, 30, 40);
        Shape shape = new TestShape(color);
        assertEquals(42.0, shape.getArea());
    }

    @Test
    void testGetPerimeter() {
        Color color = new Color(15, 25, 35, 45);
        Shape shape = new TestShape(color);
        assertEquals(24.0, shape.getPerimeter());
    }

    @Test
    void testPrint() {
        Color color = new Color(255, 0, 0, 255);
        Shape shape = new TestShape(color);

        // Testujemy, czy metoda print() wypisuje poprawną wartość
        assertDoesNotThrow(shape::print); // Upewniamy się, że nie ma wyjątków
    }

    @Test
    void testMultipleColorsInShapes() {
        // Testowanie różnych kolorów przypisanych do instancji
        Shape redShape = new TestShape(new Color(255, 0, 0));
        Shape greenShape = new TestShape(new Color(0, 255, 0, 128));
        Shape blueShape = new TestShape(new Color(0, 0, 255));

        assertEquals("Red: 255, Green: 0, Blue: 0, Alpha: 255", redShape.getColorDescription());
        assertEquals("Red: 0, Green: 255, Blue: 0, Alpha: 128", greenShape.getColorDescription());
        assertEquals("Red: 0, Green: 0, Blue: 255, Alpha: 255", blueShape.getColorDescription());
    }

    @Test
    void testEdgeCaseAlphaZero() {
        Color transparentColor = new Color(0, 0, 0, 0);
        Shape shape = new TestShape(transparentColor);
        assertEquals("Red: 0, Green: 0, Blue: 0, Alpha: 0", shape.getColorDescription());
    }

    @Test
    void testNegativeCaseForToString() {
        // Tworzenie obiektu i testowanie "skrajnego" przypadku
        Color color = new Color(255, 255, 255, 255);
        Shape shape = new TestShape(color);
        assertNotNull(shape.toString());
    }

    @Test
    void testExtremeColors() {
        // Testowanie skrajnych wartości kolorów
        Shape blackShape = new TestShape(new Color(0, 0, 0));
        Shape whiteShape = new TestShape(new Color(255, 255, 255));
        Shape semiTransparentShape = new TestShape(new Color(100, 100, 100, 50));

        assertEquals("Red: 0, Green: 0, Blue: 0, Alpha: 255", blackShape.getColorDescription());
        assertEquals("Red: 255, Green: 255, Blue: 255, Alpha: 255", whiteShape.getColorDescription());
        assertEquals("Red: 100, Green: 100, Blue: 100, Alpha: 50", semiTransparentShape.getColorDescription());
    }

    @Test
    void testExtremeAlphaValues() {
        // Testowanie wartości alfa na krawędziach
        Shape transparentShape = new TestShape(new Color(200, 200, 200, 0));
        Shape opaqueShape = new TestShape(new Color(200, 200, 200, 255));

        assertEquals("Red: 200, Green: 200, Blue: 200, Alpha: 0", transparentShape.getColorDescription());
        assertEquals("Red: 200, Green: 200, Blue: 200, Alpha: 255", opaqueShape.getColorDescription());
    }

    @Test
    void testDifferentColorObjectIdentity() {
        // Testowanie, czy różne instancje koloru są poprawnie przechowywane w klasie
        Color color1 = new Color(255, 0, 0);
        Color color2 = new Color(0, 255, 0);
        Shape shape1 = new TestShape(color1);
        Shape shape2 = new TestShape(color2);

        assertNotSame(shape1.getColor(), shape2.getColor());
    }
    @Test
    void testMultipleCallsToGetColor() {
        // Upewnij się, że wielokrotne wywołanie getColor zwraca ten sam obiekt
        Color color = new Color(128, 64, 32, 255);
        Shape shape = new TestShape(color);

        assertSame(color, shape.getColor());
        assertSame(color, shape.getColor()); // Ponowne wywołanie
    }

    @Test
    void testPrintDoesNotModifyState() {
        // Upewnij się, że wywołanie print() nie modyfikuje stanu obiektu
        Color color = new Color(100, 200, 50, 255);
        Shape shape = new TestShape(color);

        String colorBefore = shape.getColorDescription();
        shape.print();
        String colorAfter = shape.getColorDescription();

        assertEquals(colorBefore, colorAfter);
    }

    @Test
    void testColorEqualityForShapes() {

        Color color1 = new Color(10, 20, 30, 255);
        Color color2 = new Color(10, 20, 30, 255);
        Shape shape1 = new TestShape(color1);
        Shape shape2 = new TestShape(color2);

        assertEquals(shape1.getColorDescription(), shape2.getColorDescription());
        assertEquals(shape1.getColor(), shape2.getColor());
    }

    @Test
    void testGetColorDoesNotChangeInternalState() {

        Color color = new Color(50, 100, 150, 200);
        Shape shape = new TestShape(color);

        assertEquals("Red: 50, Green: 100, Blue: 150, Alpha: 200", shape.getColorDescription());
        shape.getColor(); // Wywołanie getColor()
        assertEquals("Red: 50, Green: 100, Blue: 150, Alpha: 200", shape.getColorDescription()); // Stan nie powinien się zmienić
    }



}
