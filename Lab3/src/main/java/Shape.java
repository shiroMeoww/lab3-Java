public abstract class Shape {
    private final Color color;

    public Shape(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Color cannot be null.");
        }
        this.color = color;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public void print() {
        System.out.println("Shape");
    }

    public Color getColor() {
        return color;
    }

    public String getColorDescription() {
        return "Red: " + color.red() + ", Green: " + color.green() +
                ", Blue: " + color.blue() + ", Alpha: " + color.alpha();
    }
}
