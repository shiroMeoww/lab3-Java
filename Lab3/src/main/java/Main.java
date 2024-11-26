public class Main {
    public static void main(String[] args) {

        Color redColor = new Color(255, 0, 0);
        Color blueColor = new Color(0, 0, 255, 128);
        Color greenColor = new Color(0, 255, 0);


        Shape rectangle = new Rectangle(5, 10, redColor);
        Shape triangle = new Triangle(3, 4, 5, blueColor);

        ShapeDescriber describer = new ShapeDescriber();

        System.out.println("Rectangle:");
        describer.describe(rectangle);

        System.out.println("\nTriangle:");
        describer.describe(triangle);


        Shape greenRectangle = new Rectangle(7, 8, greenColor);
        System.out.println("\nGreen Rectangle:");
        describer.describe(greenRectangle);
    }
}
