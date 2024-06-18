package org.example.Parttenmatching;


import static org.example.Parttenmatching.Shape.getPerimeter;

public class Test {
    public static void main(String[] args) {
        // Create instances of Rectangle and Circle
        Shape rectangle = new Rectangle(5.0, 3.0);
        Shape circle = new Circle(4.0);

        // Calculate the perimeter of the shapes
        try {
            double rectanglePerimeter = getPerimeter(rectangle);
            double circlePerimeter = getPerimeter(circle);

            System.out.println("Rectangle Perimeter: " + rectanglePerimeter);
            System.out.println("Circle Perimeter: " + circlePerimeter);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
