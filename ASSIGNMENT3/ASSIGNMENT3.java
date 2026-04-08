// package HelloWorld;

class Shapes {
    private double radius;
    private double length;
    private double breadth;
    private double base;
    private double height;

    public Shapes() {
        this.radius = 1.0;
    }

    public Shapes(double radius) {
        this.radius = radius;
    }

    public Shapes(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public Shapes(double base, double height, boolean isTriangle) {
        if (isTriangle) {
            this.base = base;
            this.height = height;
        } else {
            this.length = base;
            this.breadth = height;
        }
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double area(double l, double b) {
        return l * b;
    }

    public double area(double b, double h, boolean isTriangle) {
        if (isTriangle) {
            return 0.5 * b * h;
        }
        return b * h;
    }
}

class Hillstations {
    public void famousfood() {
        System.out.println("Hill stations are known for local cuisines.");
    }

    public void famousfor() {
        System.out.println("Hill stations are famous for pleasant climate and scenic beauty.");
    }
}

class Manali extends Hillstations {
    @Override
    public void famousfood() {
        System.out.println("Manali famous food: Siddu and Trout Fish.");
    }

    @Override
    public void famousfor() {
        System.out.println("Manali is famous for Solang Valley and snow activities.");
    }
}

class Mussoorie extends Hillstations {
    @Override
    public void famousfood() {
        System.out.println("Mussoorie famous food: Momos and Aloo ke Gutke.");
    }

    @Override
    public void famousfor() {
        System.out.println("Mussoorie is famous for Kempty Falls and beautiful viewpoints.");
    }
}

class Gulmarg extends Hillstations {
    @Override
    public void famousfood() {
        System.out.println("Gulmarg famous food: Rogan Josh and Kashmiri Kahwa.");
    }

    @Override
    public void famousfor() {
        System.out.println("Gulmarg is famous for skiing and green meadows.");
    }
}

public class ASSIGNMENT3 {
    private static void displayStation(Hillstations station, String stationName) {
        System.out.println("\n" + stationName + ":");
        station.famousfood();
        station.famousfor();
    }

    public static void main(String[] args) {
        System.out.println("ASSIGNMENT 3\n");

        System.out.println("1) Shapes - Constructor Overloading and Method Overloading");
        Shapes circle = new Shapes(7.0);
        Shapes rectangle = new Shapes(10.0, 5.0);
        Shapes triangle = new Shapes(8.0, 6.0, true);

        System.out.printf("Area of Circle (r=7): %.2f%n", circle.area());
        System.out.printf("Area of Rectangle (10 x 5): %.2f%n", rectangle.area(10.0, 5.0));
        System.out.printf("Area of Triangle (8 x 6): %.2f%n", triangle.area(8.0, 6.0, true));

        System.out.println("\n2) Hillstations - Method Overriding with Parent Class Reference");
        Hillstations station;

        station = new Manali();
        displayStation(station, "Manali");

        station = new Mussoorie();
        displayStation(station, "Mussoorie");

        station = new Gulmarg();
        displayStation(station, "Gulmarg");
    }
}
