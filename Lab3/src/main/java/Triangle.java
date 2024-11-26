public class Triangle extends Shape {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c, Color color) {
        super(color);
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Boki trójkąta muszą spełniać nierówność trójkąta.");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }
}
