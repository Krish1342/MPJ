package HelloWorld;

//ASSIGNMENT NO: 02
//PROBLEM STATEMENT: Hierarchical Inheritance with Employee base class
//OBJECTIVES: 
//1. To study Inheritance in Java
//2. To study why to use Inheritance
//3. To study types of Inheritance (Hierarchical)

//Base class - Employee
class Employee {
 // Protected fields - accessible to derived classes
 protected String name;
 protected int employeeId;
 protected double baseSalary;

 // Constructor
 public Employee(String name, int employeeId, double baseSalary) {
     this.name = name;
     this.employeeId = employeeId;
     this.baseSalary = baseSalary;
 }

 // Method to display salary information
 public void DisplaySalary(String employeeType) {
     System.out.println("========== " + employeeType + " DETAILS ==========");
     System.out.println("Name: " + name);
     System.out.println("Employee ID: " + employeeId);
     System.out.println("Base Salary: Rs. " + baseSalary);
 }
}

//Derived class 1 - FullTimeEmployee (50% hike)
class FullTimeEmployee extends Employee {
 private double hikedSalary;
 private static final double HIKE_PERCENTAGE = 0.50; // 50% hike

 // Constructor
 public FullTimeEmployee(String name, int employeeId, double baseSalary) {
     super(name, employeeId, baseSalary); // Call parent constructor
     CalculateSalary();
 }

 // Method to calculate salary with 50% hike
 public void CalculateSalary() {
     hikedSalary = baseSalary + (baseSalary * HIKE_PERCENTAGE);
 }

 // Overriding DisplaySalary to show full details
 public void DisplayFullDetails() {
     DisplaySalary("FULL-TIME EMPLOYEE");
     System.out.println("Hike Percentage: " + (HIKE_PERCENTAGE * 100) + "%");
     System.out.println("Salary After Hike: Rs. " + hikedSalary);
     System.out.println("Increment Amount: Rs. " + (hikedSalary - baseSalary));
     System.out.println("==========================================");
 }
}

//Derived class 2 - InternEmployee (25% hike)
class InternEmployee extends Employee {
 private double hikedSalary;
 private static final double HIKE_PERCENTAGE = 0.25; // 25% hike

 // Constructor
 public InternEmployee(String name, int employeeId, double baseSalary) {
     super(name, employeeId, baseSalary); // Call parent constructor
     CalculateSalary();
 }

 // Method to calculate salary with 25% hike
 public void CalculateSalary() {
     hikedSalary = baseSalary + (baseSalary * HIKE_PERCENTAGE);
 }

 // Overriding DisplaySalary to show full details
 public void DisplayFullDetails() {
     DisplaySalary("INTERN EMPLOYEE");
     System.out.println("Hike Percentage: " + (HIKE_PERCENTAGE * 100) + "%");
     System.out.println("Salary After Hike: Rs. " + hikedSalary);
     System.out.println("Increment Amount: Rs. " + (hikedSalary - baseSalary));
     System.out.println("==========================================");
 }
}

//Main class
public class ASSIGNMENT2 {
 public static void main(String[] args) {
     System.out.println("\n*** EMPLOYEE SALARY MANAGEMENT SYSTEM ***\n");
     System.out.println("Demonstrating Hierarchical Inheritance\n");

     // Create FullTimeEmployee objects
     System.out.println("=== FULL-TIME EMPLOYEES ===\n");

     FullTimeEmployee ftEmp1 = new FullTimeEmployee("Rajesh Sharma", 1001, 50000);
     ftEmp1.DisplayFullDetails();

     System.out.println();

     FullTimeEmployee ftEmp2 = new FullTimeEmployee("Sneha Gupta", 1002, 60000);
     ftEmp2.DisplayFullDetails();

     // Create InternEmployee objects
     System.out.println("\n=== INTERN EMPLOYEES ===\n");

     InternEmployee intEmp1 = new InternEmployee("Arjun Patel", 2001, 20000);
     intEmp1.DisplayFullDetails();

     System.out.println();

     InternEmployee intEmp2 = new InternEmployee("Kavya Reddy", 2002, 18000);
     intEmp2.DisplayFullDetails();

     // Demonstrating polymorphism (optional)
     System.out.println("\n=== DEMONSTRATING POLYMORPHISM ===\n");
     Employee emp1 = new FullTimeEmployee("Vikram Singh", 1003, 55000);
     Employee emp2 = new InternEmployee("Meera Joshi", 2003, 22000);

     emp1.DisplaySalary("EMPLOYEE (Full-Time)");
     System.out.println();
     emp2.DisplaySalary("EMPLOYEE (Intern)");
     System.out.println();
 }
}
