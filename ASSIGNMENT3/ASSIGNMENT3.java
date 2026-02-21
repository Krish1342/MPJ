package HelloWorld;

class Calculator {
    public int add(int first, int second) {
        return first + second;
    }

    public int add(int first, int second, int third) {
        return first + second + third;
    }

    public double add(double first, double second) {
        return first + second;
    }
}

class Vehicle {
    public void startEngine() {
        System.out.println("Vehicle engine starts in a generic way.");
    }
}

class Car extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Car engine starts with push-button ignition.");
    }
}

class Bike extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Bike engine starts with self-start/kick.");
    }
}

public class ASSIGNMENT3 {
    public static void main(String[] args) {
        System.out.println("*** ASSIGNMENT 3: METHOD OVERLOADING AND METHOD OVERRIDING ***\n");

        Calculator calculator = new Calculator();
        System.out.println("Method Overloading:");
        System.out.println("add(int, int): " + calculator.add(10, 20));
        System.out.println("add(int, int, int): " + calculator.add(10, 20, 30));
        System.out.println("add(double, double): " + calculator.add(10.5, 20.25));

        System.out.println("\nMethod Overriding:");
        Vehicle vehicle1 = new Car();
        Vehicle vehicle2 = new Bike();

        vehicle1.startEngine();
        vehicle2.startEngine();
    }
}
