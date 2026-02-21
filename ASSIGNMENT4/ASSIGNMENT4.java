package HelloWorld;

abstract class Shape {
    public abstract double area();

    public void displayArea() {
        System.out.println(getClass().getSimpleName() + " Area: " + area());
    }
}

class Circle extends Shape {
    private double radius;

    public Circle() {
        this(1.0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle() {
        this(1.0, 1.0);
    }

    public Rectangle(double side) {
        this(side, side);
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle() {
        this(1.0, 1.0);
    }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

class AreaCalculator {
    public double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    public double calculateArea(double length, double width) {
        return length * width;
    }

    public double calculateArea(double base, double height, boolean isTriangle) {
        if (isTriangle) {
            return 0.5 * base * height;
        }
        return base * height;
    }
}

public class ASSIGNMENT4 {
    public static void main(String[] args) {
        System.out.println("*** ASSIGNMENT 4: POLYMORPHISM WITH SHAPES ***\n");

        Shape[] shapes = {
            new Circle(7),
            new Rectangle(10, 5),
            new Triangle(8, 6),
            new Rectangle(4)
        };

        System.out.println("Runtime Polymorphism:");
        for (Shape shape : shapes) {
            shape.displayArea();
        }

        AreaCalculator calculator = new AreaCalculator();
        System.out.println("\nMethod Overloading:");
        System.out.println("Circle Area (r=5): " + calculator.calculateArea(5));
        System.out.println("Rectangle Area (l=6, w=3): " + calculator.calculateArea(6, 3));
        System.out.println("Triangle Area (b=10, h=4): " + calculator.calculateArea(10, 4, true));
    }
}
