import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    @Test
    void testValidColorCreation() {
        Color color = new Color(255, 100, 50, 128);
        assertEquals(255, color.red());
        assertEquals(100, color.green());
        assertEquals(50, color.blue());
        assertEquals(128, color.alpha());
    }

    @Test
    void testDefaultAlphaConstructor() {
        Color color = new Color(255, 100, 50);
        assertEquals(255, color.red());
        assertEquals(100, color.green());
        assertEquals(50, color.blue());
        assertEquals(255, color.alpha());
    }

    @Test
    void testInvalidColorThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Color(-1, 255, 255, 255));
        assertThrows(IllegalArgumentException.class, () -> new Color(256, 255, 255, 255));
        assertThrows(IllegalArgumentException.class, () -> new Color(255, -1, 255, 255));
        assertThrows(IllegalArgumentException.class, () -> new Color(255, 255, -1, 255));
        assertThrows(IllegalArgumentException.class, () -> new Color(255, 255, 255, -1));
        assertThrows(IllegalArgumentException.class, () -> new Color(255, 255, 255, 256));
    }

    @Test
    void testToString() {
        Color color = new Color(255, 0, 0, 128);
        assertEquals("Color[red=255, green=0, blue=0, alpha=128]", color.toString());
    }

    @Test
    void testExtremeColorValues() {
        Color black = new Color(0, 0, 0, 0);
        assertEquals(0, black.red());
        assertEquals(0, black.green());
        assertEquals(0, black.blue());
        assertEquals(0, black.alpha());

        Color white = new Color(255, 255, 255, 255);
        assertEquals(255, white.red());
        assertEquals(255, white.green());
        assertEquals(255, white.blue());
        assertEquals(255, white.alpha());
    }

    @Test
    void testEqualColors() {
        Color color1 = new Color(100, 150, 200, 255);
        Color color2 = new Color(100, 150, 200, 255);
        assertEquals(color1, color2);
        assertEquals(color1.hashCode(), color2.hashCode());
    }

    @Test
    void testNotEqualColors() {
        Color color1 = new Color(100, 150, 200, 255);
        Color color2 = new Color(100, 150, 200, 128);
        assertNotEquals(color1, color2);
    }

    @Test
    void testAlphaImpactOnEquality() {
        Color color1 = new Color(100, 150, 200, 255);
        Color color2 = new Color(100, 150, 200, 128);
        assertNotEquals(color1, color2);
    }

    @Test
    void testHashCodeDifference() {
        Color color1 = new Color(100, 150, 200, 255);
        Color color2 = new Color(100, 150, 200, 128);
        assertNotEquals(color1.hashCode(), color2.hashCode());
    }

    @Test
    void testCloneColor() {
        Color original = new Color(50, 100, 150, 200);
        Color clone = new Color(original.red(), original.green(), original.blue(), original.alpha());
        assertEquals(original, clone);
        assertNotSame(original, clone);
    }

    @Test
    void testBoundaryValues() {
        assertDoesNotThrow(() -> new Color(0, 0, 0, 0));
        assertDoesNotThrow(() -> new Color(255, 255, 255, 255));
        assertThrows(IllegalArgumentException.class, () -> new Color(-1, 0, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Color(256, 255, 255, 255));
    }

    @Test
    void testConstructorCoverage() {
        Color color = new Color(255, 100, 50);
        assertEquals(255, color.red());
        assertEquals(100, color.green());
        assertEquals(50, color.blue());
        assertEquals(255, color.alpha());
    }
    @Test
    void testRandomValidColors() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) { // Generating 100 random valid colors
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            int a = random.nextInt(256);
            Color color = new Color(r, g, b, a);
            assertEquals(r, color.red());
            assertEquals(g, color.green());
            assertEquals(b, color.blue());
            assertEquals(a, color.alpha());
        }
    }

    @Test
    void testRandomInvalidColors() {
        Random random = new Random();
        for (int i = 0; i < 50; i++) { // Random invalid test cases
            int r = random.nextInt(300) - 50;
            int g = random.nextInt(300) - 50;
            int b = random.nextInt(300) - 50;
            int a = random.nextInt(300) - 50;

            if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255 || a < 0 || a > 255) {
                assertThrows(IllegalArgumentException.class, () -> new Color(r, g, b, a));
            }
        }
    }


}
