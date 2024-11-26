class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height, Color color) {
        super(color);
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be greater than 0.");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Rectangle[width=" + width + ", height=" + height + ", color=" + getColorDescription() + "]";
    }
}
