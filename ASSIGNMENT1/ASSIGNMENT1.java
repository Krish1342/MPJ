package HelloWorld;

public class ASSIGNMENT1 {

    // Student class with private fields
    private String name;
    private int rollNo;
    private double[] marks; // marks for 5 subjects

    // Constructor to initialize student data
    public ASSIGNMENT1(String name, int rollNo, double[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    // Method to calculate average marks
    public double calculateAverage() {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    // Method to determine grade based on average
    public char getGrade(double average) {
        if (average >= 80) {
            return 'A';
        } else if (average >= 60) {
            return 'B';
        } else {
            return 'C';
        }
    }

    // Method to display student information
    public void displayStudentInfo() {
        System.out.println("========== STUDENT REPORT ==========");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks for 5 subjects:");

        for (int i = 0; i < marks.length; i++) {
            System.out.println("  Subject " + (i + 1) + ": " + marks[i]);
        }

        double average = calculateAverage();
        char grade = getGrade(average);

        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("====================================");
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public double[] getMarks() {
        return marks;
    }

    // Static method to calculate and display average marks for each subject
    public static void displaySubjectWiseAverages(ASSIGNMENT1[] students) {
        if (students == null || students.length == 0) {
            return;
        }

        int numSubjects = students[0].marks.length;
        double[] subjectTotals = new double[numSubjects];

        // Calculate total marks for each subject
        for (ASSIGNMENT1 student : students) {
            for (int i = 0; i < numSubjects; i++) {
                subjectTotals[i] += student.marks[i];
            }
        }

        // Display average marks for each subject
        System.out.println("\n===== SUBJECT-WISE AVERAGE MARKS =====");
        for (int i = 0; i < numSubjects; i++) {
            double average = subjectTotals[i] / students.length;
            System.out.println("Subject " + (i + 1) + " Average: " + average);
        }
        System.out.println("=======================================");
    }

    // Main method to test the program
    public static void main(String[] args) {
        // Create student objects with sample data
        double[] marks1 = { 85, 90, 78, 88, 92 };
        ASSIGNMENT1 student1 = new ASSIGNMENT1("Rahul Kumar", 101, marks1);
        student1.displayStudentInfo();

        System.out.println();

        double[] marks2 = { 65, 70, 68, 72, 75 };
        ASSIGNMENT1 student2 = new ASSIGNMENT1("Priya Singh", 102, marks2);
        student2.displayStudentInfo();

        System.out.println();

        double[] marks3 = { 55, 58, 60, 52, 48 };
        ASSIGNMENT1 student3 = new ASSIGNMENT1("Amit Patel", 103, marks3);
        student3.displayStudentInfo();

        System.out.println();

        double[] marks4 = { 92, 88, 95, 90, 87 };
        ASSIGNMENT1 student4 = new ASSIGNMENT1("Neha Verma", 104, marks4);
        student4.displayStudentInfo();

        System.out.println();

        double[] marks5 = { 72, 75, 70, 78, 68 };
        ASSIGNMENT1 student5 = new ASSIGNMENT1("Vikram Singh", 105, marks5);
        student5.displayStudentInfo();

        // Calculate and display subject-wise averages
        ASSIGNMENT1[] allStudents = { student1, student2, student3, student4, student5 };
        displaySubjectWiseAverages(allStudents);
    }
}
