import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ShapeDescriberTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @AfterEach
    void restoreSystemOut() {
        System.setOut(System.out);
    }

    @Test
    void testDescribeRectangle() {
        Color color = new Color(0, 255, 0, 255);
        Rectangle rectangle = new Rectangle(3.0, 2.0, color);
        ShapeDescriber describer = new ShapeDescriber();

        System.setOut(new PrintStream(outputStream));
        describer.describe(rectangle);

        String expectedOutput = "Area: 6.0" + System.lineSeparator() +
                "Perimeter: 10.0" + System.lineSeparator() +
                "Color: Red: 0, Green: 255, Blue: 0, Alpha: 255" + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testDescribeTriangle() {
        Color color = new Color(255, 0, 0, 128);
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, color);
        ShapeDescriber describer = new ShapeDescriber();

        System.setOut(new PrintStream(outputStream));
        describer.describe(triangle);

        String expectedOutput = "Area: 6.0" + System.lineSeparator() +
                "Perimeter: 12.0" + System.lineSeparator() +
                "Color: Red: 255, Green: 0, Blue: 0, Alpha: 128" + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testDescribeComplexColorShapes() {
        ShapeDescriber describer = new ShapeDescriber();

        Rectangle rectangle = new Rectangle(2.5, 3.5, new Color(10, 20, 30, 255));
        Triangle triangle = new Triangle(5.0, 12.0, 13.0, new Color(128, 128, 128, 128));


        System.setOut(new PrintStream(outputStream));
        describer.describe(rectangle);

        String rectangleExpectedOutput = "Area: 8.75" + System.lineSeparator() +
                "Perimeter: 12.0" + System.lineSeparator() +
                "Color: Red: 10, Green: 20, Blue: 30, Alpha: 255" + System.lineSeparator();
        assertEquals(rectangleExpectedOutput, outputStream.toString());

        outputStream.reset();


        describer.describe(triangle);

        String triangleExpectedOutput = "Area: 30.0" + System.lineSeparator() +
                "Perimeter: 30.0" + System.lineSeparator() +
                "Color: Red: 128, Green: 128, Blue: 128, Alpha: 128" + System.lineSeparator();
        assertEquals(triangleExpectedOutput, outputStream.toString());
    }
}
